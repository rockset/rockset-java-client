package com.rockset.client.api;

import static org.testng.Assert.assertEquals;

import com.rockset.client.ApiClient;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCustomDocumentsApi {
    @Test
    public void testConversionToRocksetObject() {
        Map<String, Object> document = new HashMap<>();
        document.put("bool", true);
        document.put("int", 1);
        document.put("long", 1L);
        document.put("double", 1.0);
        document.put("string", "abc");
        document.put("null", null);
        String s = "hello";
        document.put("bytes", s.getBytes(StandardCharsets.UTF_8));
        document.put("timestamp", Instant.ofEpochSecond(10));
        document.put("datetime", LocalDateTime.of(2022, 6, 20, 12, 0, 0));
        document.put("date", LocalDate.of(2022, 6, 21));
        document.put("time", LocalTime.of(16, 0, 0));

        List list = new ArrayList<Object>();
        list.add("abc");
        list.add(Instant.ofEpochSecond(10));
        document.put("list", list);

        CustomDocumentsApi documentsApi = new CustomDocumentsApi(new ApiClient());
        documentsApi.buildRocksetObject(document);

        assertEquals(document.get("bool"), true);
        assertEquals(document.get("int"), 1);
        assertEquals(document.get("long"), 1L);
        assertEquals(document.get("double"), 1.0);
        assertEquals(document.get("string"), "abc");
        assertEquals(document.get("null"), null);
        assertEquals(document.get("bytes"), s.getBytes(StandardCharsets.UTF_8));

        Map<String, Object> timestamp = (Map) document.get("timestamp");
        assertEquals(timestamp.get(CustomDocumentsApi.ROCKSET_TYPE), "timestamp");
        assertEquals((long) timestamp.get(CustomDocumentsApi.ROCKSET_VALUE), 10000000);

        Map<String, Object> datetime = (Map) document.get("datetime");
        assertEquals(datetime.get(CustomDocumentsApi.ROCKSET_TYPE), "datetime");
        assertEquals(datetime.get(CustomDocumentsApi.ROCKSET_VALUE), "2022-06-20T12:00");

        Map<String, Object> date = (Map) document.get("date");
        assertEquals(date.get(CustomDocumentsApi.ROCKSET_TYPE), "date");
        assertEquals(date.get(CustomDocumentsApi.ROCKSET_VALUE), "2022-06-21");

        Map<String, Object> time = (Map) document.get("time");
        assertEquals(time.get(CustomDocumentsApi.ROCKSET_TYPE), "time");
        assertEquals(time.get(CustomDocumentsApi.ROCKSET_VALUE), "16:00");

        List<Object> resList = (List) document.get("list");
        assertEquals(resList.get(0), "abc");
        timestamp = (Map) resList.get(1);
        assertEquals(timestamp.get(CustomDocumentsApi.ROCKSET_TYPE), "timestamp");
        assertEquals((long) timestamp.get(CustomDocumentsApi.ROCKSET_VALUE), 10000000);
    }
}
