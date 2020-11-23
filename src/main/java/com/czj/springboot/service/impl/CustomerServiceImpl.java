package com.czj.springboot.service.impl;

import com.czj.springboot.common.PageResult;
import com.czj.springboot.common.QueryParam;
import com.czj.springboot.dao.CustomerMapper;
import com.czj.springboot.model.Customer;
import com.czj.springboot.service.CustomerService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;



    @Override
    public PageResult<Customer> findCustomer(QueryParam param, String customerTagId) {
        List<Customer> customer = customerMapper.findCustomer(param,customerTagId);
        return new PageResult(customer);
    }

}
