package org.cm.pro.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CustomerInteractEntity {

    private Long customerInteractId;

    private Long companyId;

    private String customerInteractType;

    private String customerStatus;

    private String customerInteractStatus;

    private String customerInteractDirection;

    private String customerInteractChannel;

    private String srcBiztypeCustomerInteract;

    private String sourceBusinessId;

    private Long relatedCustomerFollowupId;

    private String mgSuperId;

    private String customerName;

    private Date customerInteractTime;

    private String customerInteractProcess;

    private Long relatedCallRecordId;

    private Long relatedCustinfoGatheringId;

    private Integer customerInteractDuration;

    private String customerInteractResult;

    private Long followupByEmpId;

    private String followupByEmpName;

    private Long followupByPositionId;

    private String followupByPositionName;

    private Long followupByDeptId;

    private String followupByDeptName;

    private Long followupByUnitId;

    private String followupByUnitName;

    private Long followupByLoginId;

    private String remark;

    private String toBusinessId;

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