package com.invech.platform.dsfcenterservice.controller.admin;

import com.invech.platform.dsfcenterdata.entity.TGmGame;
import com.invech.platform.dsfcenterdata.enums.GamePlatform;
import com.invech.platform.dsfcenterdata.response.R;
import com.invech.platform.dsfcenterservice.controller.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
public class AdminManageGames extends BaseController {

  @ApiOperation(tags = {"Admin"}, value = "获取游戏列表")
  public R gamesMap(@RequestParam("gamePlatform") GamePlatform gamePlatform){
    return R.ok();
  }

  @ApiOperation(tags = {"Admin"}, value = "开启游戏")
  public R enableGame(@RequestParam("gamePlatform") GamePlatform gamePlatform,@RequestParam("gameId") String gameId,@RequestParam("anable") boolean anable){
    return R.ok();
  }

  @ApiOperation(tags = {"Admin"}, value = "新增游戏")
  public R addGame(@RequestParam("gamePlatform") GamePlatform gamePlatform,@RequestBody TGmGame tGmGame){
    return R.ok();
  }

  @ApiOperation(tags = {"Admin"}, value = "改变游戏图片")
  public R changeGamePicture(@RequestParam("gamePlatform") GamePlatform gamePlatform,@RequestParam("gameId") String gameId , @RequestParam("pictureUrl") String pictureUrl){
    return R.ok();
  }
}
