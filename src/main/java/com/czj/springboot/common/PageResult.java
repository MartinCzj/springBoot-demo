package com.czj.springboot.common;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;



@Data
public class PageResult<T> {

  public static <T1> PageResult<T1> of(QueryParam param) {
    PageResult<T1> p = new PageResult<>(param.getCurrentPage());
    p.setPageSize(param.getPageSize());
    return p;
  }

  public static <T1> PageResult<T1> of(int currentPage) {
    return new PageResult<>(currentPage);
  }

  public static <T1> PageResult<T1> of(List<T1> d, int currentPage, int total, int pageSize) {
    return new PageResult<>(d, currentPage, total, pageSize);
  }

  public PageResult() {

  }

  public PageResult(List<T> d, int currentPage, int total, int pageSize) {
    if (d != null) {
      this.data = d;
    } else {
      this.data = new ArrayList<>();
    }
    this.currentPage = currentPage;
    this.total = total;
    this.pageSize = pageSize;
  }

  /**
   * 包装Page对象
   *
   * @param list page结果
   */
  public PageResult(List<T> list) {
    if (list != null) {
      if (list instanceof Page) {
        Page<T> page = (Page<T>) list;
        this.currentPage = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.total = page.getTotal();
        this.data = list;
      } else {
        this.data = list;
        this.currentPage = 1;
        this.total = list.size();
        this.pageSize = list.size();
      }
      return;
    }
    this.data = new ArrayList<>();
    this.currentPage = 1;
    this.total = 0;
  }

  /**
   * 将类型T的PageResult转化为类型R的PageResult，同时保留分页信息
   *
   * @param function
   * @return PageResult<R>
   * @author longhuihy
   * @date 2020/02/28 10:09
   */
  public <R> PageResult<R> transfer(Function<T, R> function) {
    Page<R> page = new Page<>();
    page.addAll(this.data.stream().map(o ->
        function.apply(o)
    ).collect(Collectors.toList()));
    page.setPageNum(this.currentPage);
    page.setPageSize(this.pageSize);
    page.setTotal(this.total);
    return new PageResult<>(page);
  }

  public PageResult(int currentPage) {
    this.data = new ArrayList<>();
    this.currentPage = currentPage;
    this.total = 0;
  }

  private List<T> data = new ArrayList<>();
  private Integer currentPage = 1;
  private long total = 0;
  private Integer pageSize = 10;

}
