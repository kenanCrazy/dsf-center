package com.invech.platform.dsfcenterservice.controller.player;

import com.invech.platform.dsfcenterdata.constants.ApiConstants;
import com.invech.platform.dsfcenterdata.enums.GamePlatform;
import com.invech.platform.dsfcenterdata.enums.TransferType;
import com.invech.platform.dsfcenterdata.enums.WinLossStatus;
import com.invech.platform.dsfcenterdata.response.R;
import com.invech.platform.dsfcenterservice.controller.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerApi extends BaseController{

  //TODO 转账考虑独立出来 ,方便看日志

  @ApiOperation(tags = {"player"}, value = "转账")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R transfer(@RequestParam("gamePlatform") GamePlatform gamePlatform, @RequestBody TransferType transferType){
    return R.ok();
  }

  @ApiOperation(tags = {"player"}, value = "一键回归余额")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R allBalanceTransferToCenter(@RequestParam("gamePlatform") GamePlatform gamePlatform){
    return R.ok();
  }

  @ApiOperation(tags = {"player"}, value = "开始游戏")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R startGame(@RequestParam("gamePlatform") GamePlatform gamePlatform){
    return R.ok();
  }

  @ApiOperation(tags = {"player"}, value = "获得第三方余额")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R getDsfBalance(@RequestParam("gamePlatform") GamePlatform gamePlatform){
    return R.ok();
  }

  @ApiOperation(tags = {"player"}, value = "获得所有第三方平台余额")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R getDsfAllBalance(){
    return R.ok();
  }

  @ApiOperation(tags = {"player"}, value = "下注记录")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R getBetLog(@RequestParam("gamePlatform") GamePlatform gamePlatform,
      @RequestParam("startTime") String startTime,
      @RequestParam("endTime") String endTime,
      @RequestParam("category") String category,
      @RequestParam(value = "winLossStatus" ,required = false) WinLossStatus winLossStatus){
    return R.ok();
  }

  @ApiOperation(tags = {"player"}, value = "下注记录")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R getPlayerStatement(@RequestParam("gamePlatform") GamePlatform gamePlatform,
      @RequestParam("startTime") String startTime,
      @RequestParam("endTime") String endTime,
      @RequestParam("category") String category){
    return R.ok();
  }
}
