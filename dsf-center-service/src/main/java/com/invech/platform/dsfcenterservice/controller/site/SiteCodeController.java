package com.invech.platform.dsfcenterservice.controller.site;

import com.invech.platform.dsfcenterdao.service.TSiteService;
import com.invech.platform.dsfcenterdao.utlis.DomainUtil;
import com.invech.platform.dsfcenterdata.entity.TSite;
import com.invech.platform.dsfcenterdata.utils.AESUtil;
import com.invech.platform.dsfcenterdata.response.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dsf-center/site")
@Api(value = "SiteCode", description = "站点有关")
public class SiteCodeController {

  @Autowired
  private TSiteService tSiteService;

  @GetMapping("/getSchemaName")
  @ApiOperation(value = "获取当前站点对应的数据库加密信息", notes = "获取当前站点对应的数据库加密信息")
//  @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token头部，随便填数字", required = true, dataType = "Integer", paramType = "header") })
  @ResponseBody
  public R getSchemaName(@RequestParam("webDomain") String webDomain){
    // 域名对应多个站点,获取站点,再通过站点获取数据库前缀
    TSite site=tSiteService.querySiteByDomain(DomainUtil.getDomainForUrl(webDomain));
    String schemaName = site.getSchemaName();
    try {
      return R.ok().put("Site", AESUtil.encrypt(schemaName));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return R.ok();
  }
}
