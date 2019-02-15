package com.invech.platform.dsfcenterservice.config;


import com.invech.platform.dsfcenterdao.service.TSiteService;
import com.invech.platform.dsfcenterdao.utlis.DomainUtil;
import com.invech.platform.dsfcenterdata.entity.User;
import com.invech.platform.dsfcenterdata.enums.Available;
import com.invech.platform.dsfcenterdata.response.RRException;
import com.invech.platform.dsfcenterservice.service.PlayerService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.invech.platform.dsfcenterdata.constants.ApiConstants;
import com.invech.platform.dsfcenterdata.entity.TSite;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Slf4j
@Component
public class AuthTokenFilter extends HandlerInterceptorAdapter {

  @Autowired
  TSiteService tSiteService;

  @Autowired
  PlayerService playerService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws RRException {
    log.info("AuthTokenFilter");
    String siteCode = DomainUtil.getSiteCode();  // 解密获取对应的 数据库后缀
    if (siteCode == null) {
      return false;
    }
    TSite site = tSiteService.queryPreOneCond(siteCode);
    if (!site.getAvailable().equals(ApiConstants.SiteAvilable.AVILABLE)) {
      log.info("站点过期 site = {}" ,siteCode);
      throw new RRException("站点过期 site = " +siteCode);
    }
    log.info(siteCode);
    String accessToken = request.getHeader(ApiConstants.PLAYER_LOGGIN_KEY);
    User user=playerService.userDetails(accessToken);
    if (user.getAvilable() == Available.NotAvailable) {
      log.info(" 玩家冻结");
      throw new RRException("玩家冻结 user = " +user.toString());
    }
    log.info("玩家冻结 user = " +user.toString());
    return true;
  }
}
