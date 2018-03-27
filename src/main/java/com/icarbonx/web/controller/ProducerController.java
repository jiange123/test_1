package com.icarbonx.web.controller;

import com.icarbonx.web.service.ProducerService;
import com.icarbonx.web.service.ReportGeneratedV1MQMessageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(value = "/swagger",description = "接口说明")
@RequestMapping(value = "/swagger")
@Controller
public class ProducerController  {

    @ApiOperation(value = "函数说明",notes = "注意事项")
    @ResponseBody
    @RequestMapping(value = "test/hello" , method = {RequestMethod.GET ,RequestMethod.POST })
    public String test(@RequestParam @ApiParam("传入参数") String param){
        return param;
    }

    @Autowired
    private ProducerService producer;

    /**
     * @Description: 消息队列
     * @Author:
     * @CreateTime:
     */
    @ApiOperation(value = "消息队列",notes = "注意事项1")
    @ResponseBody
    @RequestMapping(value = "/sendQueue"  , method = {RequestMethod.GET ,RequestMethod.POST })
    public String testQueue(@RequestBody @ApiParam("消息内容") ReportGeneratedV1MQMessageVo reportGeneratedV1MQMessageVo) {
        try {
            /*Map<String, Object> map = new HashMap();
            map.put("data", data);*/
            // 注意：第二个属性是 Queue 与 交换机绑定的路由
            System.out.println(reportGeneratedV1MQMessageVo);
            producer.sendQueue( "icx.growth.test.topic.exchange", "icx.growth.routing", reportGeneratedV1MQMessageVo);
            return "消息发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "消息发送失败";
        }
    }



}
