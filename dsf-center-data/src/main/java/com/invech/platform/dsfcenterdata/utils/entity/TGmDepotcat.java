package com.invech.platform.dsfcenterdata.utils.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@ApiModel(value = "根据游戏类别找出对应那些平台有这个类别的游戏", description = "")
@Table(name = "t_gm_depot_category")
public class TGmDepotcat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "平台Id")
    private Integer depotId;

    @ApiModelProperty(value = "类别Id")
    private Integer catId;

    @ApiModelProperty(value = "类别名称")
    @Transient
    private String catName;

    @ApiModelProperty(value = "平台名称")
    @Transient
    private String depotName;

    @ApiModelProperty(value = "图片")
    @Transient
    private String logo;
    @ApiModelProperty(value = "图片")
    @Transient
    private String logo2;
    @ApiModelProperty(value = "手机图片")
    @Transient
    private String mbPicUrl;
    
    @ApiModelProperty(value = "游戏文字说明")
    @Transient
    private String gameTag;
    @ApiModelProperty(value="体育未有登陆 URL链接")
    @Transient
    private String pcUrlTag;
}