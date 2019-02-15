package com.invech.platform.dsfcenterdata.entity;

import com.invech.platform.dsfcenterdata.enums.Available;
import com.invech.platform.dsfcenterdata.enums.GamePlatform;
import com.invech.platform.dsfcenterdata.enums.UserRole;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

  private Integer userId;

  private String userName;

  private String nickName;

  private GamePlatform gamePlatform;

  private String dsfAccountId;

  private UserRole userRole;

  private Available avilable;

  private LocalDateTime createTime;

}
