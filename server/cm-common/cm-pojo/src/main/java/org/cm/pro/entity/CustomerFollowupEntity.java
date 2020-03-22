package org.cm.pro.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 创建者: GQ
 * 创建时间:2019/12/23 3:05 PM
 */
@Getter
@Setter
@ToString
@ApiModel("用户跟进全部字段")
public class CustomerFollowupEntity {

    private Long customerFollowupId;

    private Long companyId;

    private String customerStatus;

    private String followupStatusCustomer;

    private String followupTypeCustomer;

    private String sourceChannelClass;

    private String sourceChannelType;

    private String sourceChannelSubtype;

    private String sourceActivityType;

    private String sourceActivityCode;

    private String srcBiztypeCustomerFollowup;

    private String sourceBusinessId;

    private String mgSuperId;

    private String customerName;

    private String cellphone;

    private String isStartFollowupDealer;

    private Long followupDealerId;

    private Long followupDealerOrgId;

    private String followupDealerCode;

    private Date followupBeginDateDealer;

    private Date followupEndDateDealer;

    private String isStartFollowupSa;

    private Long followupDeptOrgId;

    private Long followupSaEmpId;

    private String followupSaEmpNo;

    private String followupSaEmpName;

    private Date followupBeginDateSa;

    private Date followupEndDateSa;

    private String isLatestFollowup;

    private String isReassign;

    private String isAssistFollowup;

    private Long assistFollowupSaEmpId;

    private String assistFollowupSaEmpNo;

    private String assistFollowupSaEmpName;

    private Date assistFollowupBeginDate;

    private Date assistFollowupEndDate;

    private String followupResultCustomer;

    private String isTurnIntoLeads;

    private Long turnByEmpIdLeads;

    private Date turnDateLeads;

    private String relatedLeadsId;

    private String leadsStatus;

    private String isTurnIntoOpportunity;

    private Long turnIntoByEmpId;

    private Date turnIntoDate;

    private String relatedOpportunityId;

    private String opportunityStatus;

    private String isTurntoTestdrive;

    private Long turnByEmpIdTestdrive;

    private Date turnDateTestdrive;

    private Long relatedTestdriveId;

    private String testdriveStatus;

    private String isTurnIntoPreorder;

    private Long turnByEmpIdPreorder;

    private Date turnDatePreorder;

    private String preorderStatus;

    private String relatedPreorderId;

    private String isTurnIntoSalesorder;

    private Long turnByEmpIdSalesorder;

    private Date turnDateSalesorder;

    private String relatedSalesorderId;

    private String salesorderStatus;

    private String isFinishFollowup;

    private Long finishFollowupEmpId;

    private Date finishFollowupDate;

    private String isStopFollowup;

    private Long stopFollowupEmpId;

    private Date stopFollowupDate;

    private String stopFollowupReasonCustomer;

    private String stopFollowupReasonDesc;

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

    private String isAssistFollowupEnd;
}
