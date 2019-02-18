package com.invech.platform.dsfcenterservice.controller.superadmin;

import com.invech.platform.dsfcenterdata.constants.ApiConstants;
import com.invech.platform.dsfcenterdata.response.R;
import com.invech.platform.dsfcenterservice.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/su-admin")
@Api(value = "su-admin", description = "站点有关")
public class SuperAdminController extends BaseController {

  @PostMapping("addDsfGamePLatform")
  @ApiOperation(tags = {"su-admin"}, value = "增加某个游戏平台")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R addDsfGamePLatform(){
    return R.ok();
  }

  @PostMapping("addDsfGamePlatformLine")
  @ApiOperation(tags = {"su-admin"}, value = "增加某个游戏平台的某一条线路")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R addDsfGamePlatformLine(){
    return R.ok();
  }

  @PostMapping("addSite")
  @ApiOperation(tags = {"su-admin"}, value = "增加一个包网站点")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R addSite(){
    return R.ok();
  }

  @PutMapping("enableSite")
  @ApiOperation(tags = {"su-admin"}, value = "冻结某个站点")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R enableSite(){
    return R.ok();
  }

  @GetMapping("siteStatements")
  @ApiOperation(tags = {"su-admin"}, value = "获取站点的运营报表")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R siteStatements(){
    return R.ok();
  }
}
