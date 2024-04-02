package com.rockset.client.api;

import com.rockset.client.ApiClient;
import com.rockset.client.model.AddDocumentsRequest;
import com.rockset.client.model.AddDocumentsResponse;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
 This class extends DocumentsApi which is auto-generated. This class
 adds functionality to convert Java objects to rockset types like timestamp,
 datetime, date and time.
*/
public class CustomDocumentsApi extends DocumentsApi {
  static final String ROCKSET_TYPE = "__rockset_type";
  static final String ROCKSET_VALUE = "value";

  public CustomDocumentsApi(ApiClient apiClient) {
    super(apiClient);
  }

  @Override
  public AddDocumentsResponse add(String workspace, String collection, AddDocumentsRequest body)
      throws Exception {
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
    } else if (doc instanceof Set) {
      // use hashset, order isn't doesn't matter here
      Set<Object> modifiedSet = new HashSet<>();
      for (Object element : (Set) doc) {
        modifiedSet.add(buildRocksetObject(element));
      }
      return modifiedSet;
    } else if (doc instanceof Instant) {
      return constructTimestamp((Instant) doc);
    } else if (doc instanceof LocalDateTime) {
      // toString outputs in ISO-8601 format:
      // uuuu-MM-dd'T'HH:mm
      // uuuu-MM-dd'T'HH:mm:ss
      // uuuu-MM-dd'T'HH:mm:ss.SSS
      // uuuu-MM-dd'T'HH:mm:ss.SSSSSS
      // uuuu-MM-dd'T'HH:mm:ss.SSSSSSSSS
      return constructDateTime(((LocalDateTime) doc).toString());
    } else if (doc instanceof LocalDate) {
      // toString outputs in ISO-8601 format uuuu-MM-dd
      return constructDate(((LocalDate) doc).toString());
    } else if (doc instanceof LocalTime) {
      // toString outputs in ISO-8601 format:
      // HH:mm
      // HH:mm:ss
      // HH:mm:ss.SSS
      // HH:mm:ss.SSSSSS
      // HH:mm:ss.SSSSSSSSS
      return constructTime(((LocalTime) doc).toString());
    } else if (doc instanceof Timestamp) {
      return constructTimestamp(((Timestamp) doc).toInstant());
    } else if (doc instanceof Date) {
      // Formats a date in the date escape format yyyy-mm-dd
      return constructDate(((Date) doc).toString());
    } else if (doc instanceof Time) {
      // Formats a String in hh:mm:ss format
      return constructTime(((Time) doc).toString());
    } else if (doc instanceof java.util.Date) {
      return constructTimestamp(((java.util.Date) doc).toInstant());
    }

    return doc;
  }

  private Map<String, Object> constructTimestamp(Instant instant) {
    Map<String, Object> timestamp = new HashMap<>();
    timestamp.put(ROCKSET_TYPE, "timestamp");
    timestamp.put(ROCKSET_VALUE, instantToTimestamp(instant));
    return timestamp;
  }

  private Map<String, Object> constructDateTime(String datetimeStr) {
    Map<String, Object> datetime = new HashMap<>();
    datetime.put(ROCKSET_TYPE, "datetime");
    datetime.put(ROCKSET_VALUE, datetimeStr);
    return datetime;
  }

  private Map<String, Object> constructDate(String dateStr) {
    Map<String, Object> date = new HashMap<>();
    date.put(ROCKSET_TYPE, "date");
    date.put(ROCKSET_VALUE, dateStr);
    return date;
  }

  private Map<String, Object> constructTime(String timeStr) {
    Map<String, Object> time = new HashMap<>();
    time.put(ROCKSET_TYPE, "time");
    time.put(ROCKSET_VALUE, timeStr);
    return time;
  }

  private long instantToTimestamp(Instant instant) {
    return TimeUnit.SECONDS.toMicros(instant.getEpochSecond())
        + TimeUnit.NANOSECONDS.toMicros(instant.getNano());
  }
}
