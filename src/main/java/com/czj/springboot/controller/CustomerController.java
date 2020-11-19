package com.czj.springboot.controller;

import com.czj.springboot.model.Customer;
import com.czj.springboot.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("客户模块")
@RestController
@RequestMapping(value = "/customer")
@Transactional(rollbackFor = Exception.class)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation("寻找客户")
    @PostMapping(value = "/findCustomer")
    public List<Customer> findCustomer(String customerTagId) {
        List<Customer> customer = customerService.findCustomer(customerTagId);
        return customer;
    }
}
