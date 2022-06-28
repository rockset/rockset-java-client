package com.rockset.client.api;

import static org.testng.Assert.assertEquals;

import com.rockset.client.ApiClient;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.testng.annotations.Test;

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

    // java.time
    document.put("timestamp", Instant.ofEpochSecond(10));
    document.put("datetime", LocalDateTime.of(2022, 6, 20, 12, 0, 0));
    document.put("date", LocalDate.of(2022, 6, 21));
    document.put("time", LocalTime.of(16, 0, 0));

    // java.sql
    document.put("sql_timestamp", new Timestamp(1656417600000L));
    document.put("sql_date", new Date(1656417600000L));
    document.put("sql_time", new Time(1656417600000L));

    List list = new ArrayList<Object>();
    list.add("abc");
    list.add(Instant.ofEpochSecond(10));
    document.put("list", list);

    Set set = new HashSet<Object>();
    set.add("def");
    set.add(Instant.ofEpochSecond(10));
    document.put("set", set);

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

    Map<String, Object> sqlTimestamp = (Map) document.get("sql_timestamp");
    assertEquals(sqlTimestamp.get(CustomDocumentsApi.ROCKSET_TYPE), "datetime");
    assertEquals((String) sqlTimestamp.get(CustomDocumentsApi.ROCKSET_VALUE), "2022-06-28T05:00");

    Map<String, Object> sqlDate = (Map) document.get("sql_date");
    assertEquals(sqlDate.get(CustomDocumentsApi.ROCKSET_TYPE), "date");
    assertEquals(sqlDate.get(CustomDocumentsApi.ROCKSET_VALUE), "2022-06-28");

    Map<String, Object> sqlTime = (Map) document.get("sql_time");
    assertEquals(sqlTime.get(CustomDocumentsApi.ROCKSET_TYPE), "time");
    assertEquals(sqlTime.get(CustomDocumentsApi.ROCKSET_VALUE), "05:00:00");

    List<Object> resList = (List) document.get("list");
    assertEquals(resList.size(), 2);
    assertEquals(resList.get(0), "abc");
    timestamp = (Map) resList.get(1);
    assertEquals(timestamp.get(CustomDocumentsApi.ROCKSET_TYPE), "timestamp");
    assertEquals((long) timestamp.get(CustomDocumentsApi.ROCKSET_VALUE), 10000000);

    Set<Object> resSet = (Set<Object>) document.get("set");
    assertEquals(resSet.size(), 2);
    for (Object element : resSet) {
      if (element instanceof String) {
        assertEquals((String) element, "def");
      } else if (element instanceof Map) {
        Map<String, Object> setTimestamp = (Map) element;
        assertEquals(setTimestamp.get(CustomDocumentsApi.ROCKSET_TYPE), "timestamp");
        assertEquals((long) setTimestamp.get(CustomDocumentsApi.ROCKSET_VALUE), 10000000);

      } else {
        throw new IllegalStateException("unexpected type: " + element.getClass());
      }
    }
  }
}
