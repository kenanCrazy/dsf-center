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
@ApiModel(value = "站点信息", description = "站点信息")
@Table(name = "t_site")
public class TCpSite implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "id")
	private Integer id;

	@ApiModelProperty(value = "站点代缩写代码")
	private String siteCode;

	@ApiModelProperty(value = "站点名称")
	private String siteName;

	@ApiModelProperty(value = "分片名数据库")
	private String schemaName;

	@ApiModelProperty(value = "商户名称 ID")
	private Integer companyId;

	@ApiModelProperty(value = "开始时间")
	private String startDate;

	@ApiModelProperty(value = "结束时间")
	private String endDate;

	@ApiModelProperty(value = "状态　1开启，0禁用")
	private Byte available;

	@ApiModelProperty(value="交站时间")
	private String useTime;
	
	@ApiModelProperty(value="备注")
	private String memo;
	
	@ApiModelProperty(value="创建人")
	private String createUser;
	
	@ApiModelProperty(value="创建时间")
	private String createTime;
	
	@ApiModelProperty(value="最后一次修改时间")
	private String modifyTime;
	
	@ApiModelProperty(value="币种")
	private String currency;
	
	@Transient
	@ApiModelProperty(value="站点URL")
	private String siteUrl;

	@ApiModelProperty(value="0：包网，1：API")
	private Byte isapi;

}