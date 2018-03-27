package com.icarbonx.web.service;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Person implements Serializable {

    private String id;

    private Long personId;

    private boolean isMenber; //会员

    private Date createTime;

    private Date updateTime;


}
