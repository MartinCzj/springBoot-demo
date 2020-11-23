package com.czj.springboot.controller;

import com.czj.springboot.common.PageResult;
import com.czj.springboot.common.QueryParam;
import com.czj.springboot.model.Customer;
import com.czj.springboot.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public PageResult<Customer> findCustomer( @RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
                                    @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,String customerTagId) {
        QueryParam param = QueryParam.builder().currentPage(currentPage).pageSize(pageSize).build();
        PageResult<Customer> customer = customerService.findCustomer(param, customerTagId);
        return customer;
    }
}
