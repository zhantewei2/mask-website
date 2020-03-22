package org.cm.pro.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author hht
 * @description 证件信息扫描params
 * @date 2019/12/16
 */
@Getter
@Setter
@ToString
@ApiModel("证件扫描信息")
public class OcrScanParams {

    @ApiModelProperty("OCR识别id")
    private Long ocrScanId;

    @ApiModelProperty("OCR识别类型")
    private String ocrScanType;

    @ApiModelProperty("OCR识别状态，暂不使用")
    @JsonIgnore
    private String ocrScanStatus;

    @ApiModelProperty("来源业务id，记录来源业务的主键id")
    private String sourceBusinessId;

    @ApiModelProperty("来源业务类型(OCR识别)，参见字典")
    private String srcBiztypeOcrScan;

    @ApiModelProperty("证件号码")
    private String certificateNo;

    @ApiModelProperty("国籍")
    private String nationality;

    @ApiModelProperty("民族")
    private String nation;

    @ApiModelProperty("工作单位")
    private String workUnit;

    @ApiModelProperty("客户姓名")
    private String customerName;

    @ApiModelProperty("客户职务")
    private String customerPosition;

    @ApiModelProperty("客户性别")
    private String customerGender;

    @ApiModelProperty("手机号")
    private String cellphone;

    @ApiModelProperty("工作电话")
    private String workPhone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("出生日期")
    private String birthDate;

    @ApiModelProperty("网址")
    private String website;

    @ApiModelProperty("签发机关")
    private String issueOrganization;

    @ApiModelProperty("准驾车型")
    private String permittedCarModel;

    @ApiModelProperty("有效期至")
    private String validUntil;

    @ApiModelProperty("车牌号")
    private String license;

    @ApiModelProperty("车主姓名")
    private String vehicleOwnerName;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("车辆类型")
    private String scanVehicleType;

    @ApiModelProperty("使用性质")
    private String scanUseCharacter;

    @ApiModelProperty("扫描品牌型号")
    private String scanModel;

    @ApiModelProperty("扫描车辆识别代号")
    private String scanVin;

    @ApiModelProperty("扫描发动机号码")
    private String scanEigineNo;

    @ApiModelProperty("扫描注册日期")
    private String scanRegisterDate;

    @ApiModelProperty("扫描发证日期")
    private String scanIssueDate;

    @ApiModelProperty("是否经理批示")
    private String isManuallyKeyin;

    @ApiModelProperty("扫描人")
    private Long scanByEmpId;

    @ApiModelProperty("扫描时间")
    private Date scanTime;

    @JsonIgnore
    private Date fileDate;
}
