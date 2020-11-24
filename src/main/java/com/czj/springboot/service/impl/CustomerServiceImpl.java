package com.czj.springboot.service.impl;

import com.czj.springboot.common.PageResult;
import com.czj.springboot.common.QueryParam;
import com.czj.springboot.dao.CustomerMapper;
import com.czj.springboot.model.Customer;
import com.czj.springboot.service.CustomerService;
import com.czj.springboot.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageResult findCustomer(QueryParam param) {
        PageHelper.startPage(param.getCurrentPage(),param.getPageSize());
        List<Customer> customer = customerMapper.findCustomer(param);

        PageInfo<Customer> customerPageInfo = new PageInfo<>(customer);

        return PageUtil.getPageResult(customerPageInfo);
    }

    @Override
    public List findCategory() {
        return customerMapper.selectAll();
    }

}
