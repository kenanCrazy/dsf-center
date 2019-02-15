package com.invech.platform.dsfcenterdata.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {

  SuperAdmin("系统超级管理员"),Admin("管理员"),Agent("代理"),Player("玩家");

  public String role;
}
