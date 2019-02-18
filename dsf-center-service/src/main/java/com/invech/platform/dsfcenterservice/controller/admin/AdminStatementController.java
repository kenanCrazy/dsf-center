package com.invech.platform.dsfcenterservice.controller.admin;

import com.invech.platform.dsfcenterservice.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 报表查询
 */
@RequestMapping("/admin")
@Controller
@Api(value = "Agmin-Statement", description = "运营数据管理")
public class AdminStatementController extends BaseController {

}
