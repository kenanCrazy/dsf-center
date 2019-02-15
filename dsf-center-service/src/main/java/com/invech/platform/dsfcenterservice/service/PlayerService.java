package com.invech.platform.dsfcenterservice.service;

import com.invech.platform.dsfcenterdata.entity.User;
import com.invech.platform.dsfcenterdata.enums.Available;
import com.invech.platform.dsfcenterdata.enums.GamePlatform;
import com.invech.platform.dsfcenterdata.enums.UserRole;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

  //TODO accessToken 获取当前用户的信息,暂时写死
  public User userDetails(String accessToken) {
    return new User(111111111,"test_rmi","rmi", GamePlatform.Agin,"test4546413345486", UserRole.Player,
        Available.Available, LocalDateTime.now());
  }
}
