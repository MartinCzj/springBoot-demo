package com.czj.springboot.service;

import com.czj.springboot.common.PageResult;
import com.czj.springboot.common.QueryParam;
import com.czj.springboot.model.Customer;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @author Kay.Chen
 */
public interface CustomerService  {

    /**
     * 明细里的客户表
     *
     * @return 客户集合
     */
    PageResult findCustomer(QueryParam param);

    List findCategory();

}

