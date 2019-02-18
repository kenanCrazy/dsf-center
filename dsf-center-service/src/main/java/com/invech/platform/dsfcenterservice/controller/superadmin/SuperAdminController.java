package com.invech.platform.dsfcenterservice.controller.superadmin;

import com.invech.platform.dsfcenterdata.response.R;
import com.invech.platform.dsfcenterservice.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/su-admin")
@Api(value = "su-admin", description = "站点有关")
public class SuperAdminController extends BaseController {

  @PostMapping("addDsfGamePLatform")
  public R addDsfGamePLatform(){
    return R.ok();
  }

  @PostMapping("addDsfGamePlatformLine")
  public R addDsfGamePlatformLine(){
    return R.ok();
  }

}
