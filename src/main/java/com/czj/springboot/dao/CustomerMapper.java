package com.czj.springboot.dao;

import com.czj.springboot.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerMapper {

    //明细里的客户表
    List<Customer> findCustomer(@Param("customerTagId") String customerTagId);

    //保存店铺信息
    int saveStore(@Param("customerTagId") String customerTagId);

    //导入时，客户已存在则更新
    int updateCustomer(@Param("customer") Customer customer);

    int deleteCustomer(@Param("customerTagId") String customerTagId);

    List<String> filterStore();

}