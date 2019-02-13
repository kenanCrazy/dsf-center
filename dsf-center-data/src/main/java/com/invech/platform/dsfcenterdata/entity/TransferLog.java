package com.invech.platform.dsfcenterdata.entity;

import com.invech.platform.dsfcenterdata.enums.FailReason;
import com.invech.platform.dsfcenterdata.enums.GamePlatform;
import com.invech.platform.dsfcenterdata.enums.TransferState;
import com.invech.platform.dsfcenterdata.enums.TransferType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "TransferLog", description = "转账记录")
@Table(name = "transfer_log")
public class TransferLog {

  @Id
  @ApiModelProperty(value = "transactionId")
  private String transactionId;          // 订单编号

  @ApiModelProperty(value = "accountId")
  private Long accountId;  // accountId

  @ApiModelProperty(value = "玩家昵称")
  private String nickname;               // 玩家昵称

  @ApiModelProperty(value = "站点名")
  private String siteCode;                  // 站点名

  @ApiModelProperty(value = "玩家帐号")
  private String dsfPlayerId ;               // 玩家帐号

  @ApiModelProperty(value = "游戏平台")
  private GamePlatform gamePlatform;     // 游戏平台

  @ApiModelProperty(value = "转账类型(充值 or 取款)")
  private TransferType type ;             // 转账类型(充值 or 取款)

  @ApiModelProperty(value = "转账状态")
  private TransferState state ;           // 转账状态

  @ApiModelProperty(value = "失败原因 当state == failed 时 该状态有值")
  private FailReason failReason;        // 失败原因 当state == failed 时 该状态有值

  @ApiModelProperty(value = "第三方订单Id")
  private String dsfTransactionId;      // 第三方订单Id

  @ApiModelProperty(value = "转账金额")
  private BigDecimal amount;             // 转账金额

  @ApiModelProperty(value = "余额变更事件Id")
  private Long balanceChangedId;        // 余额变更事件Id

  @ApiModelProperty(value = "创建时间")
  private LocalDateTime createTime;      // 创建时间

  @ApiModelProperty(value = "完成时间")
  private LocalDateTime completeTime;   // 完成时间

  @ApiModelProperty(value = "版本号")
  private Integer version = 1   ;             // 版本号

  @ApiModelProperty(value = "转账请求线路名称")
  private String apiName;
}
