package com.invech.platform.dsfcenterservice.controller.admin;

import com.invech.platform.dsfcenterdata.constants.ApiConstants;
import com.invech.platform.dsfcenterdata.entity.TGmGame;
import com.invech.platform.dsfcenterdata.enums.GamePlatform;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
@Api(value = "Agmin-Games", description = "游戏管理")
public class AdminManageGames extends BaseController {

  @GetMapping("gameList")
  @ApiOperation(tags = {"Admin"}, value = "获取游戏列表")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R gameList(@RequestParam("gamePlatform") GamePlatform gamePlatform){
    return R.ok();
  }

  @PutMapping("enableGame")
  @ApiOperation(tags = {"Admin"}, value = "开启游戏")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R enableGame(@RequestParam("gamePlatform") GamePlatform gamePlatform,@RequestParam("gameId") String gameId,@RequestParam("anable") boolean anable){
    return R.ok();
  }

  @PostMapping("addGame")
  @ApiOperation(tags = {"Admin"}, value = "新增游戏")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R addGame(@RequestParam("gamePlatform") GamePlatform gamePlatform,@RequestBody TGmGame tGmGame){
    return R.ok();
  }

  @PutMapping("changeGamePicture")
  @ApiOperation(tags = {"Admin"}, value = "改变游戏图片")
  @ApiImplicitParams({
      @ApiImplicitParam(name = ApiConstants.SITE_SECURETY_KEY, value = "Site 站点对应加密串", required = true, dataType = "Integer", paramType = "header") ,
      @ApiImplicitParam(name = ApiConstants.PLAYER_LOGGIN_KEY, value = "玩家登陆后获取的Access_Token", required = true, dataType = "String", paramType = "header")})
  public R changeGamePicture(@RequestParam("gamePlatform") GamePlatform gamePlatform,@RequestParam("gameId") String gameId , @RequestParam("pictureUrl") String pictureUrl){
    return R.ok();
  }
}
