package com.rockset.jdbc;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RocksetResultSetPaginationParams {
  private final RocksetConnection connection;
  private final String lastQueryId;
  private String currentCursor;
  private int fetchSize;
}
