package com.czj.springboot.service;

import com.czj.springboot.common.PageResult;
import com.czj.springboot.common.QueryParam;
import com.czj.springboot.model.Customer;
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
     * @param customerTagId 客户标签ID
     * @return 客户集合
     */
    PageResult<Customer> findCustomer(QueryParam param, String customerTagId);


}

