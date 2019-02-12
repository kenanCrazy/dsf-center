package com.invech.platform.dsfcenterdata.utils.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "代理属性设置")
public class ProxyProperty {
	@ApiModelProperty(value = "代理方式")
	private String proxyType;
	@ApiModelProperty(value = "代理ip")
	private String ip;
	@ApiModelProperty(value = "代理端口")
	private Integer port;
}
