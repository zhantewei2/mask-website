package org.cm.pro.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@ApiModel("日常工作记录表")
public class DaliyWorkEntity {

    private Long dailyWorkId;

    private Long companyId;

    private String dailyWorkType;

    private String dailyWorkStatus;

    private String srcBiztypeDailyWork;

    private String sourceBusinessId;

    private Long doByEmpId;

    private String doByEmpName;

    private Long doByPositionId;

    private String doByPositionName;

    private Long doByDeptId;

    private String doByDeptName;

    private Long doByUnitId;

    private String doByUnitName;

    private Long doByLoginId;

    private Long relatedCustomerFollowupId;

    private String mgSuperId;

    private String customerName;

    private Date dailyWorkDate;

    private String dailyWorkProcess;

    private Long relatedCallRecordId;

    private Long relatedCustinfoGatheringId;

    private Integer dailyWorkDuration;

    private String dailyWorktResult;

    private String toBusinessId;

    private String remark;

    private Date fileDate;

    private Long createByEmpId;

    private Long createByDeptId;

    private Long createByUnitId;

    private Long createByLoginId;

    private Date createDate;

    private Long updateByEmpId;

    private Long updateByLoginId;

    private Date updateDate;

    private Integer updateVersion;

    private String isDelete;

    private Long deleteByLoginId;

    private Date deleteDate;

    private String deleteRemark;
}
