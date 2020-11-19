package com.czj.springboot.service.impl;

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
    public List<String> filterStore() {
        return customerMapper.filterStore();
    }

    @Override
    public boolean updateKeyValueBatch(Collection<Customer> entityList, int batchSize) {
//        try (SqlSession batchSqlSession = sqlSessionBatch()) {
//            int i = 0;
//            CustomerMapper userMapper = batchSqlSession.getMapper(CustomerMapper.class);
//            for (Customer customer : entityList) {
//                userMapper.updateCustomer(customer);
//                if (i >= 1 && i % batchSize == 0) {
//                    batchSqlSession.flushStatements();
//                }
//                i++;
//            }
//            batchSqlSession.flushStatements();
//        }
        return true;
    }

    @Override
    public List<Customer> findCustomer(String customerTagId) {
        return customerMapper.findCustomer(customerTagId);
    }

    @Override
    public int saveStore(String customerTagId) {
        return customerMapper.saveStore(customerTagId);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public int deleteCustomer(String customerTagId) {
        return customerMapper.deleteCustomer(customerTagId);
    }
}
