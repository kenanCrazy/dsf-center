package com.invech.platform.dsfcenterdata.entity;

import com.invech.platform.dsfcenterdata.enums.FailReason;
import com.invech.platform.dsfcenterdata.enums.GamePlatform;
import com.invech.platform.dsfcenterdata.enums.TransferState;
import com.invech.platform.dsfcenterdata.enums.TransferType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferLog {
  
  private Long accountId;  // accountId
  private String username;               // 玩家帐号
  private String siteCode;                  // 站点名
  private String dsfPlayerId ;               // 玩家帐号
  private GamePlatform gamePlatform;     // 游戏平台
  private TransferType type ;             // 转账类型(充值 or 取款)
  private TransferState state ;           // 转账状态
  private FailReason failReason;        // 失败原因 当state == failed 时 该状态有值
  private String transactionId;          // 订单编号
  private String dsfTransactionId;      // 第三方订单Id
  private BigDecimal amount;             // 转账金额
  private Long balanceChangedId;        // 余额变更事件Id
  private LocalDateTime createTime;      // 创建时间
  private LocalDateTime completeTime;   // 完成时间
  private Integer version = 1   ;             // 版本号
  private String apiName;
}
