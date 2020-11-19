package com.czj.springboot.model;


import lombok.Data;
import java.util.Date;

@Data
public class Customer extends BaseModel{
    private String customerCode;
    private String customerTagId;
    private Integer storeId;
    private String storeCode;
    private String storeName;
    private Integer expiredPoints;
    private Date expiryDate;
}
