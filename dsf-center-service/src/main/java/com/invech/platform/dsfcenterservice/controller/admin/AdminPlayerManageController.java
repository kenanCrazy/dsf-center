package com.invech.platform.dsfcenterservice.controller.admin;

import com.invech.platform.dsfcenterdata.response.R;
import com.invech.platform.dsfcenterservice.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 玩家行为管控
 */
@RequestMapping("/admin")
@Controller
public class AdminPlayerManageController extends BaseController {

  /**
   * 玩家转账
   * @return
   */
  public R playerTransfer(){
    return R.ok();
  }

  /**
   * 玩家全部金额转到中心
   * @return
   */
  public R playerAllBalanceTransferToCenter(){
    return R.ok();
  }

  /**
   * 冻结玩家
   * @return
   */
  public R freezePLayer(){
    return R.ok();
  }

  /**
   * 冻结玩家某个平台不能玩
   * @return
   */
  public R freezePLayerGamePLatform(){
    return R.ok();
  }

  /**
   * 查看玩家第三方余额
   * @return
   */
  public R playerBalance(){
    return R.ok();
  }
}
