package com.invech.platform.dsfcenterdata.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TransferStateType {
  COMPLETED("成功"), FAILED("失败"), HANDLING("处理中");

  public String message;
}
