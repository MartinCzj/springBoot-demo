package com.czj.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础模型
 *
 * @author Louis
 * @date Sep 13, 2018
 */
@Data
public class BaseModel implements Serializable {

    private String id;


    private String createBy;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDateTime;

    private String modifiedBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifiedDateTime;

}
