package com.icarbonx.web.service;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = "g_student")  //表名
public class Student implements Serializable {
    @Id //指示id字段
    private String id;
    private Long classId;
    private String name;
    private String picture;
    private Date createTime;
    private Date updateTime;
}
