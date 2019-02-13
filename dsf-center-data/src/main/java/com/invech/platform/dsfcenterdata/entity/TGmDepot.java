package com.invech.platform.dsfcenterdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(value = "TGmDepot", description = "")
@Table(name = "t_gm_depot")
public class TGmDepot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "自增长字段")
    private String depotCode;

    @ApiModelProperty(value = "平台名称")
    private String depotName;

    @ApiModelProperty(value = "1开启，0禁用")
    private Byte available;

    @ApiModelProperty(value = "")
    private String memo;

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "最后一次修改人的账号")
    private String modifyUser;

    @ApiModelProperty(value = "最后一次修改时间")
    private String modifyTime;

    @ApiModelProperty(value = "游戏开始时间")
    private String startDate;

    @ApiModelProperty(value = "游戏结束时间")
    private String endDate;

    @ApiModelProperty(value = "排序号")
    private Integer sortId;

}