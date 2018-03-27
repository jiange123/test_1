package com.icarbonx.web.service;


import com.icarbonx.web.dao.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ActiveStatusService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;



    public void saveStudent(Long classId) {
        //添加一条学生数据
        Student student = new Student();
        student.setClassId(classId);
        student.setName("小王");
        student.setCreateTime(new Date());
        student.setUpdateTime(student.getCreateTime());
        //图片保存

        studentRepository.insert(student);
    }

    public void saveStudentByMongoTemplate(Long classId) {
        //添加一条学生数据
        Student student = new Student();
        student.setClassId(classId);
        student.setName("小李");
        student.setCreateTime(new Date());
        student.setUpdateTime(student.getCreateTime());
        mongoTemplate.insert(student);
    }

    public void updateStudentByMongoTemplate(Long classId) {
        //修改一条学生数据:将{classId}班叫"小李"的学生改名为"小芳"
        Query query = new Query();
        query.addCriteria(Criteria.where("classId").is(classId));  //条件
        query.addCriteria(Criteria.where("name").is("小李"));  //条件
        Update update = new Update();
        update.set("name", "小芳");            //修改后的值
        update.set("updateTime", new Date());  //修改后的值
        mongoTemplate.updateFirst(query, update, Student.class);
    }

    public void deleteStudentByMongoTemplate(String id) {
        //根据id删除一条学生数据
        Student student = new Student();
        student.setId(id);
        mongoTemplate.remove(student);
    }

    public void getStudentByMongoTemplate(String name) {
        //获取一条学生数据
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));  //条件
        Student student = mongoTemplate.findOne(query, Student.class);
        System.out.println(student);
    }

    public void getAllStudentByMongoTemplate(Long classId) {
        //获取批量学生数据
        Query query = new Query();
        query.addCriteria(Criteria.where("classId").is(classId));  //条件
        List<Student> students = mongoTemplate.find(query, Student.class);
        System.out.println(students);
    }


}
