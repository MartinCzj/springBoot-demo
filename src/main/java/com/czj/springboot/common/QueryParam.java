package com.czj.springboot.common;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;


@Data
@Builder
public class QueryParam {
  private String id;
  private String name;
  private int currentPage = 1;
  private int pageSize = 10;
  private Date startDate;
  private Date endDate;
  /**
   * 默认值为true
   */
  private boolean isPage = true;

  public boolean hasName(){
    return StringUtils.isNotEmpty(name);
  }

}
