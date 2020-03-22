package org.cm.pro.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author hht
 * @description 文件记录Params
 * @date 2019/12/11
 */
@Getter
@Setter
@ToString
@ApiModel("文件记录")
public class FileRecordParams {

    @ApiModelProperty("文件记录id")
    @JsonIgnore
    private Long fileRecordId;

    @ApiModelProperty("文件类型")
    private String fileType;

    @ApiModelProperty("文件状态，同有效状态")
    @JsonIgnore
    private String fileStatus;

    @ApiModelProperty("来源业务类型(文件)")
    private String srcBiztypeFile;

    @ApiModelProperty("来源业务id，记录来源业务的主键id")
    @NotNull
    private String sourceBusinessId;

    @ApiModelProperty("文件名称")
    @NotNull
    private String fileName;

    @ApiModelProperty("文件地址")
    @NotNull
    private String fileUrl;

    @JsonIgnore
    private Long companyId;

    @JsonIgnore
    private Date fileDate;

    @JsonIgnore
    private Long createByEmpId;

    @JsonIgnore
    private Long createByDeptId;

    @JsonIgnore
    private Long createByUnitId;

    @JsonIgnore
    private Long createByLoginId;

    @JsonIgnore
    private Date createDate;

    @JsonIgnore
    private Long updateByEmpId;

    @JsonIgnore
    private Long updateByLoginId;

    @JsonIgnore
    private Date updateDate;

    @JsonIgnore
    private Integer updateVersion;

    @JsonIgnore
    private Long deleteByLoginId;

    @JsonIgnore
    private Date deleteDate;

    @JsonIgnore
    private String deleteRemark;
}
