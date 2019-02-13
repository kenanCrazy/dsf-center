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
@ApiModel(value = "TGmCat", description = "游戏类别")
@Table(name = "t_gm_category")
public class TGmCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "id")
	private Integer id;

	@Transient
	@ApiModelProperty(value = "自增长")
	private String categoryCode;

	@ApiModelProperty(value = "类别名称")
	private String categoryName;

	@ApiModelProperty(value = "排序号")
	private Integer sortId;

	@ApiModelProperty(value = "1开启，0禁用")
	private Byte available;

	@ApiModelProperty(value = "备注")
	private String memo;

	@ApiModelProperty(value = "创建人")
	private String createUser;

	@ApiModelProperty(value = "创建时间")
	private String createTime;

	@ApiModelProperty(value = "最后一次修改人的账号")
	private String modifyUser;

	@ApiModelProperty(value = "最后一次修改时间")
	private String modifyTime;

	@ApiModelProperty(value = "父类型ID")
	private Integer parentId;

	@ApiModelProperty(value = "树形结构ID(4X10)")
	private String treeId;

	@Transient
	@ApiModelProperty(value = "游戏数量")
	private Integer gameCount;

	@Transient
	@ApiModelProperty(value = "过去一个月该类游戏玩家数")
	private Integer tMonthPer;

	@Transient
	@ApiModelProperty(value = "昨天该类游戏玩家数")
	private Integer tLastdayPer;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TGmCategory) {
			TGmCategory tGmCategory = (TGmCategory) obj;
			return this.id == tGmCategory.getId();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

}