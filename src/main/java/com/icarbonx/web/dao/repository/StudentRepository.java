package com.icarbonx.web.dao.repository;

import com.icarbonx.web.service.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
Student:db对应的po类
ObjectId:mongo专有的id类型,也可用String
* */
public interface StudentRepository extends MongoRepository<Student,ObjectId> {
}
