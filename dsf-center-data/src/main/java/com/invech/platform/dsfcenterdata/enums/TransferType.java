package com.invech.platform.dsfcenterdata.enums;


import lombok.Getter;

@Getter
public enum  TransferType {

  TopUp("中心到第三方",1), Withdraw("第三方到中心",2);

  private String name;
  private Integer code;

  // 构造方法
  private TransferType(String name, int code) {
    this.name = name;
    this.code = code;
  }

  // 普通方法
  public static String getName(int code) {
    for (TransferType c : TransferType.values()) {
      if (c.getCode() == code) {
        return c.name;
      }
    }
    return null;
  }

  public static Integer getCode(String name) {
    for (TransferType c : TransferType.values()) {
      if (c.getName().equals(name)) {
        return c.code;
      }
    }
    return null;
  }
}
