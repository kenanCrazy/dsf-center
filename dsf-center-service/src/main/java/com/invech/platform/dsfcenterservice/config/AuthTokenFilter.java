package com.invech.platform.dsfcenterservice.config;


import com.invech.platform.dsfcenterdao.utlis.DomainUtil;
import com.invech.platform.dsfcenterdata.constants.ApiConstants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Slf4j
public class AuthTokenFilter extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
      log.info("AuthTokenFilter");
      String schemaName  = DomainUtil.getSchemaName();
      // 解密获取对应的 数据库后缀
      log.info(schemaName);
    return true;
  }
}
