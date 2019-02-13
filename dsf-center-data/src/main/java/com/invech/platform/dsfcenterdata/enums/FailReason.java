package com.invech.platform.dsfcenterdata.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum FailReason {

  InitBalanceFailed("初始化balance失败"),

  GoBackBalance("回退到中心余额"),

  InitDsfFailed("初始化第三方失败"),

  //GoBackDsf(""),

  ManualFailed("人工处理"),

  ManualSuccess("人工处理");

  public String message;
}
