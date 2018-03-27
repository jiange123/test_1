package com.icarbonx.web.controller;

import com.icarbonx.web.service.ActiveStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/mongo")
@Controller
@Api(value = "/mongo",description = "芒果测试")
public class ActiveStatusController {

    @Autowired
    private ActiveStatusService activeStatusService;


    @ApiOperation(value = "插入学生数据",notes = "芒果测试")
    @ResponseBody
    @RequestMapping(value="/saveStudent", method = RequestMethod.POST )
    public void saveStudent( @RequestParam @ApiParam("班级id") Long classId ){
        activeStatusService.saveStudent(classId);
    }

    @ApiOperation(value = "使用mongoTemplate插入学生数据",notes = "芒果测试")
    @ResponseBody
    @RequestMapping(value="/mongoTemplate/saveStudent", method = RequestMethod.POST )
    public void saveStudentByMongoTemplate( @RequestParam @ApiParam("班级id") Long classId ){
        activeStatusService.saveStudentByMongoTemplate(classId);
    }

    @ApiOperation(value = "使用mongoTemplate修改学生数据",notes = "芒果测试")
    @ResponseBody
    @RequestMapping(value="/mongoTemplate/updateStudent", method = RequestMethod.POST )
    public void updateStudentByMongoTemplate( @RequestParam @ApiParam("班级id") Long classId ){
        activeStatusService.updateStudentByMongoTemplate(classId);
    }

    @ApiOperation(value = "使用mongoTemplate删除学生数据",notes = "芒果测试")
    @ResponseBody
    @RequestMapping(value="/mongoTemplate/deleteStudent", method = RequestMethod.POST )
    public void deleteStudentByMongoTemplate( @RequestParam @ApiParam("班级id") String id ){
        activeStatusService.deleteStudentByMongoTemplate(id);
    }

    @ApiOperation(value = "使用mongoTemplate获取单条学生数据",notes = "芒果测试")
    @ResponseBody
    @RequestMapping(value="/mongoTemplate/getStudent", method = RequestMethod.POST )
    public void getStudentByMongoTemplate( @RequestParam @ApiParam("班级id") String name ){
        activeStatusService.getStudentByMongoTemplate(name);
    }

    @ApiOperation(value = "使用mongoTemplate获取批量学生数据",notes = "芒果测试")
    @ResponseBody
    @RequestMapping(value="/mongoTemplate/getAllStudent", method = RequestMethod.POST )
    public void getAllStudentByMongoTemplate( @RequestParam @ApiParam("班级id") Long classId ){
        activeStatusService.getAllStudentByMongoTemplate(classId);
    }


}
