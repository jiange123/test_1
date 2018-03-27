package com.icarbonx.web.service;

import lombok.Data;

import java.util.Date;

@Data
public class ReportGeneratedV1MQMessageVo {

    private String reportDataId;
    private Long personalId;
    private Long personId;
    private Long examinationId;
    private String productId;
    private String reportType;
    private Date sampleDate;
    private Date reportDate;
    private String version;
    private String publicTime;
    private String reason;
    private Long surveyId;
    private Integer reportSurveyVersion;

}
