package com.czj.springboot.model;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private String id;
    private String name;
    private Date lastUpDate;
}