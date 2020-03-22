package org.cm.pro.entity;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@ApiModel("中台客户信息所有字段")
public class MgCustomerEntity implements Serializable {

    private String leadsId;

    private String superId;

    private String companyId;

    private Date fileDate;

    private String customerStatus;

    private String customeType;

    private String sourceBusinessTypeCustomer;

    private String sourceBusinessId;

    private String customerName;

    private String cellphone;

    private String gender;

    private String guno;

    private String createByEmpId;

    private String createByDeptId;

    private String createByUnitId;

    private String createByLoginId;

    private Date createDate;

    private String updateByEmpId;

    private String updateByLoginId;

    private Date updateDate;

    private Integer updateVersion;

    private String deleteByLoginId;

    private Date deleteDate;

    private String deleteRemark;

    private String age;

    private String locationProvince;

    private String locationCity;

    private String communicationAttitude;

    private String concerns;

    private String concernsRemark;
}
