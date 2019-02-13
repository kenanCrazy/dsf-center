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
@ApiModel(value = "TGmGame", description = "平台游戏列表")
@Table(name = "t_gm_game")
public class TGmGame implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "游戏类别代码")
    private Integer categoryId;

    @ApiModelProperty(value = "平台代码")
    private Integer depotId;

    @ApiModelProperty(value = "游戏代码,不区分默认")
    private String gameCode;
    
    @ApiModelProperty(value = "手机游戏代码")
    private String h5GameCode;
    
    @ApiModelProperty(value = "安卓游戏代码")
    private String adriodGameCode;
    
    @ApiModelProperty(value = "桌面应用游戏代码")
    private String pcGameCode;
    
    @ApiModelProperty(value = "游戏名称")
    private String gameName;

    @ApiModelProperty(value = "游戏简单描述")
    private String gameTag;

    @ApiModelProperty(value = "游戏链接URL")
    private String gameParam;

    @ApiModelProperty(value = "1开启，0禁用")
    private Byte available;

    @ApiModelProperty(value = "PC个性化图片")
    private String pcLogo;

    @ApiModelProperty(value = "手机个性化图片")
    private String phoneLogo;

    @ApiModelProperty(value = "开启PC端 1->开启，0－>禁用")
    private Byte enablePc;

    @ApiModelProperty(value = "开启移动端 1->开启，0－>禁用")
    private Byte enableMobile;

    @ApiModelProperty(value = "开启测试账号 1->开启，0－>禁用")
    private Byte enableTest;

    @ApiModelProperty(value = "热门游戏")
    private Byte enableHot;

    @ApiModelProperty(value = "最新游戏")
    private Byte ebableNew;

    @ApiModelProperty(value = "开启奖金池 1->开启，0－>禁用")
    private Byte enablePool;

    @ApiModelProperty(value = "详细备注")
    private String memo;

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "最后一次修改人的账号")
    private String modifyUser;

    @ApiModelProperty(value = "最后一次修改时间")
    private String modifyTime;

    @ApiModelProperty(value = "游戏名称(英文)")
    private String gameNameEn;

    @ApiModelProperty(value = "游戏ID")
    private String gameId;


    @ApiModelProperty(value = "排序")
    private Integer sortId;

    @ApiModelProperty(value = "点击量")
    private Integer clickNum;
  

    @ApiModelProperty(value = "好评度")
    private Integer goodNum;
    
    @ApiModelProperty(value = "过去一个月这个游戏玩家数")
    private Integer monthPer;

    @ApiModelProperty(value = "昨天该游戏玩家数")
    private Integer lastdayPer;

    @Transient
    @ApiModelProperty(value = "游戏类别名称")
    private String catName;

    @Transient
    @ApiModelProperty(value = "游戏平台名称")
    private String depotName;
    
    @Transient
    @ApiModelProperty(value = "分类统计游戏总数")
    private Integer gameCount;
    
    @Transient
    @ApiModelProperty(value = "分类统计玩家数量（30天）")
    private Integer tMonthPer;
    
    @Transient
    @ApiModelProperty(value = "分类统计玩家数量（昨天）")
    private Integer tLastDayPer;
    
    
}