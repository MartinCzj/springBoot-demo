package com.czj.springboot.service;

import com.czj.springboot.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @author Kay.Chen
 */
public interface CustomerService  {
    /**
     * 批量更新主要列
     *
     * @param entityList 更新对象
     * @param batchSize  大小
     * @return 结果
     */
    boolean updateKeyValueBatch(Collection<Customer> entityList, int batchSize);

    /**
     * 明细里的客户表
     *
     * @param customerTagId 客户标签ID
     * @return 客户集合
     */
    List<Customer> findCustomer(@Param("customerTagId") String customerTagId);

    /**
     * 保存店铺信息
     *
     * @param customerTagId 客户标签ID
     * @return 影响条数
     */
    int saveStore(@Param("customerTagId") String customerTagId);

    /**
     * 导入时，客户已存在则更新
     *
     * @param customer 客户
     * @return 影响条数
     */
    int updateCustomer(@Param("customer") Customer customer);

    /**
     * 根据客户标签ID删除客户
     *
     * @param customerTagId 客户标签ID
     * @return 影响条数
     */
    int deleteCustomer(@Param("customerTagId") String customerTagId);

    /**
     * 查找是否有storeName为空的店铺
     * @return 店铺集合
     */
    List<String> filterStore();
}

