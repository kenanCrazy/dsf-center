package com.invech.platform.dsfcenterdata.enums;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PlatformType {

  Sport("体育博彩"),         // 体育
  VideoGame("真人视讯"),     // 视讯
  ComputerGame("电子游戏"),  // 电子游戏
  Fishing("捕鱼"),          // 捕鱼
  Lottery("彩票");          //彩票

  public String title;

  public static List<PlatformType> aginPLatformTypes(){
    List<PlatformType> types = new ArrayList<>();
    types.add(PlatformType.Sport);
    types.add(PlatformType.VideoGame);
    types.add(PlatformType.ComputerGame);
    types.add(PlatformType.Fishing);
    return types ;
  }
}
