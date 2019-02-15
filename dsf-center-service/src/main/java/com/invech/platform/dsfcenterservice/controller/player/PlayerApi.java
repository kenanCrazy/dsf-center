package com.invech.platform.dsfcenterservice.controller.player;

import com.invech.platform.dsfcenterdata.constants.ApiConstants;
import com.invech.platform.dsfcenterdata.enums.GamePlatform;
import com.invech.platform.dsfcenterdata.enums.TransferType;
import com.invech.platform.dsfcenterdata.response.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface PlayerApi {

  @ApiOperation(tags = {"player"}, value = "转账")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R transfer(@RequestHeader("gamePlatform") GamePlatform gamePlatform, @RequestBody TransferType transferType);

  @ApiOperation(tags = {"player"}, value = "一键回归余额")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R allBalanceTransferToCenter(@RequestHeader("gamePlatform") GamePlatform gamePlatform);

  @ApiOperation(tags = {"player"}, value = "开始游戏")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R startGame(@RequestHeader("gamePlatform") GamePlatform gamePlatform);


}
