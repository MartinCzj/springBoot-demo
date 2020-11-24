package com.czj.springboot.controller;

import com.czj.springboot.common.PageResult;
import com.czj.springboot.common.QueryParam;
import com.czj.springboot.config.DataSource;
import com.czj.springboot.config.DynamicDataSourceContextHolder;
import com.czj.springboot.model.Customer;
import com.czj.springboot.service.CustomerService;
import com.github.pagehelper.PageInfo;
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

    @DataSource(value = "master")
    @ApiOperation("寻找客户")
    @PostMapping(value = "/findCustomer")
    public PageResult findCustomer( @RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
                                    @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                    @RequestParam(value = "customerTagId",required = false) String customerTagId) {
        QueryParam param = QueryParam.builder().currentPage(currentPage).pageSize(pageSize).id(customerTagId).build();
        PageResult customer = customerService.findCustomer(param);
        return customer;
    }

    @ApiOperation("测试多数据源")
    @PostMapping(value = "/findCategory")
    @DataSource(value = "slave")
    public List testDataSource(){
        DynamicDataSourceContextHolder.setDataSourceKey("slave");
        List category = customerService.findCategory();
        return category;
    }
}
