package com.invech.platform.dsfcenterdata.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TransferState {

  Init(TransferStateType.HANDLING, "初始化"),


  // 未知
  // 1. 充值： 调用dsf进行校验
  // 2. 取款：调用balance进行校验
  UnKnow(TransferStateType.HANDLING, "未知"),

  // 成功
  Successful(TransferStateType.COMPLETED, "成功"),

  // 充值失败 回退
  TopUpFailedBack(TransferStateType.HANDLING,  "充值回退中"),

  // 取款失败 回退 TODO 暂时无该暂时 不支持回退到dsf
  //WithdrawFailedBack(clientState = TransferStateType.HANDLING, message = "取款回退中"),

  // 失败
  Failed(TransferStateType.FAILED, "失败");



  // 客户端显示状态
  public TransferStateType clientState;

  // 中文显示
  public String message;

}
