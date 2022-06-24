package com.rockset.client.api;

import com.rockset.client.ApiClient;
import com.rockset.client.model.AddDocumentsRequest;
import com.rockset.client.model.AddDocumentsResponse;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CustomDocumentsApi extends DocumentsApi {
    static final String ROCKSET_TYPE = "__rockset_type";
    static final String ROCKSET_VALUE = "value";

    public CustomDocumentsApi(ApiClient apiClient) {
        super(apiClient);
    }

    @Override
    public AddDocumentsResponse add(String workspace, String collection, AddDocumentsRequest body) throws Exception {
        for (Object doc : body.getData()) {
            if (!(doc instanceof Map)) {
                throw new IllegalArgumentException("Document is not a valid Map Object");
            }
            buildRocksetObject(doc);
        }

        return super.add(workspace, collection, body);
    }

    Object buildRocksetObject(Object doc) {
        if (doc instanceof Map) {
            final Map<String, Object> map = (Map) doc;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = buildRocksetObject(entry.getValue());
                map.put(entry.getKey(), value);
            }
            return map;
        } else if (doc instanceof List) {
            final List<Object> list = (List) doc;
            for (int i = 0; i < list.size(); i++) {
                list.set(i, buildRocksetObject(list.get(i)));
            }
            return list;
        } else if (doc instanceof Instant) {
            Map<String, Object> timestamp = new HashMap<>();
            timestamp.put(ROCKSET_TYPE, "timestamp");
            timestamp.put(ROCKSET_VALUE, instantToTimestamp((Instant) doc));
            return timestamp;
        } else if (doc instanceof LocalDateTime) {
           Map<String, Object> datetime = new HashMap<>();
           datetime.put(ROCKSET_TYPE, "datetime");
           // toString outputs in ISO-8601 format:
            // uuuu-MM-dd'T'HH:mm
            // uuuu-MM-dd'T'HH:mm:ss
            // uuuu-MM-dd'T'HH:mm:ss.SSS
            // uuuu-MM-dd'T'HH:mm:ss.SSSSSS
            // uuuu-MM-dd'T'HH:mm:ss.SSSSSSSSS
            datetime.put(ROCKSET_VALUE, ((LocalDateTime) doc).toString());
           return datetime;
        } else if (doc instanceof LocalDate) {
            Map<String, Object> date = new HashMap<>();
            date.put(ROCKSET_TYPE, "date");
            // toString outputs in ISO-8601 format uuuu-MM-dd
            date.put(ROCKSET_VALUE, ((LocalDate) doc).toString());
            return date;
        } else if (doc instanceof LocalTime) {
            Map<String, Object> time = new HashMap<>();
            time.put(ROCKSET_TYPE, "time");
            // toString outputs in ISO-8601 format:
            // HH:mm
            // HH:mm:ss
            // HH:mm:ss.SSS
            // HH:mm:ss.SSSSSS
            // HH:mm:ss.SSSSSSSSS
            time.put(ROCKSET_VALUE, ((LocalTime) doc).toString());
            return time;
        }

        return doc;
    }

    private long instantToTimestamp(Instant instant) {
        return TimeUnit.SECONDS.toMicros(instant.getEpochSecond())
                + TimeUnit.NANOSECONDS.toMicros(instant.getNano());
    }
}
