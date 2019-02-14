package com.invech.platform.dsfcenterservice.config;


import com.invech.platform.dsfcenterdao.service.TSiteService;
import com.invech.platform.dsfcenterdao.utlis.DomainUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.invech.platform.dsfcenterdata.constants.ApiConstants;
import com.invech.platform.dsfcenterdata.entity.TSite;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Slf4j
@Component
public class AuthTokenFilter extends HandlerInterceptorAdapter {

    @Autowired
    TSiteService tSiteService;


  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
      log.info("AuthTokenFilter");
      String siteCode  = DomainUtil.getSiteCode();  // 解密获取对应的 数据库后缀
      if(siteCode == null ){
          return false;
      }
      TSite site =tSiteService.queryPreOneCond(siteCode);
      if(!site.getAvailable().equals(ApiConstants.SiteAvilable.AVILABLE)) {

          return false ;
      }
      log.info(siteCode);
      // TODO 此处增加用户是否登录的判断,用户登录数据要注入到controller里面
    return true;
  }
}
