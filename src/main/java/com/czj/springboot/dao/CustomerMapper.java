package com.czj.springboot.dao;

import com.czj.springboot.common.QueryParam;
import com.czj.springboot.model.Category;
import com.czj.springboot.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerMapper {

    //明细里的客户表
    List<Customer> findCustomer(@Param("param") QueryParam param);

    List<Category> selectAll();
}