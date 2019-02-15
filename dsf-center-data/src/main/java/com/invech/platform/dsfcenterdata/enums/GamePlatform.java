package com.invech.platform.dsfcenterdata.enums;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  GamePlatform {

  Agin("Ag", PlatformType.aginPLatformTypes(),"Agin");

  public String gamePLatform;

  public List<PlatformType> platformType;

  public String name;

}
