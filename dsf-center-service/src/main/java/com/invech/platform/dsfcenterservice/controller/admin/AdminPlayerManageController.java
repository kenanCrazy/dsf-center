package com.invech.platform.dsfcenterservice.controller.admin;

import com.invech.platform.dsfcenterdata.constants.ApiConstants;
import com.invech.platform.dsfcenterdata.response.R;
import com.invech.platform.dsfcenterservice.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 玩家行为管控
 */
@Api(value = "Agmin-Players", description = "玩家管理")
@RequestMapping("/admin")
@Controller
public class AdminPlayerManageController extends BaseController {

  /**
   * 玩家转账
   * @return
   */
  @PutMapping("playerTransfer")
  @ApiOperation(tags = {"Admin"}, value = "给玩家转账")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R playerTransfer(){
    return R.ok();
  }

  /**
   * 玩家全部金额转到中心
   * @return
   */
  @PutMapping("playerAllBalanceTransferToCenter")
  @ApiOperation(tags = {"Admin"}, value = "玩家余额回归中心")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R playerAllBalanceTransferToCenter(){
    return R.ok();
  }

  /**
   * 冻结玩家
   * @return
   */
  @PutMapping("freezePLayer")
  @ApiOperation(tags = {"Admin"}, value = "冻结玩家")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R freezePLayer(){
    return R.ok();
  }

  /**
   * 冻结玩家某个平台不能玩
   * @return
   */
  @PutMapping("freezePLayerGamePLatform")
  @ApiOperation(tags = {"Admin"}, value = "冻结玩家某个平台不能玩")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R freezePLayerGamePLatform(){
    return R.ok();
  }

  /**
   * 查看玩家第三方余额
   * @return
   */
  @GetMapping("playerBalance")
  @ApiOperation(tags = {"Admin"}, value = "查看玩家第三方余额")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R playerBalance(){
    return R.ok();
  }
}
