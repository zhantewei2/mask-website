package org.cm.pro.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hht
 * @description 登陆信息
 * @date 2019/12/11
 */
@Getter
@Setter
@ToString
public class UserEntity {

    private String sessionId;

    private Long companyId;

    private String loginPlatform;

    private String empName;

    private Long empId;

    private String cellphone;

    private Long orgId;

    private String orgName;

    private String orgCode;

    private String orgFullName;

    private Long positionId;

    private String positionCode;

    private String positionName;

    private Long dealerId;

    private String dealerCode;

    private String dealerName;

    private Long orgUnitId;

    private String orgPosEmpMapId;

    private Long accountId;

    private String account;

    private Long loginId;

    private Long dealerOrgId;

    private String empNo;
}
