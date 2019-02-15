package com.invech.platform.dsfcenterservice.controller;

import com.invech.platform.dsfcenterdata.constants.ApiConstants;
import com.invech.platform.dsfcenterdata.entity.User;
import com.invech.platform.dsfcenterservice.service.PlayerService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public abstract class BaseController {

  @Autowired
  PlayerService playerService;

  User userDetails(){
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    String accessToken = request.getHeader(ApiConstants.PLAYER_LOGGIN_KEY);
    return playerService.userDetails(accessToken);
  }
}
