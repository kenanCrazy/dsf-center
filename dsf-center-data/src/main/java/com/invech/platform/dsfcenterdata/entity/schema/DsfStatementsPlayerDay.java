package com.invech.platform.dsfcenterdata.entity.schema;

import com.invech.platform.dsfcenterdata.enums.GamePlatform;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "DsfStatementsPlayerDay", description = "站点玩家按日汇总数据")

//TODO 此处按月分表,在MybatisInterceptor处理
@Table(name = "dsf_statements_day")
public class DsfStatementsPlayerDay {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "id")
  private Integer id ;

  @ApiModelProperty(value = "玩家ID")
  private Integer accountId;

  @ApiModelProperty(value = "站点代缩写代码")
  private String siteCode;

  @ApiModelProperty(value = "游戏平台")
  private GamePlatform gamePlatform;

  @ApiModelProperty(value = "日期")
  private String day;

  @ApiModelProperty(value = "总收入(有效投注)")
  private BigDecimal totalBet;

  @ApiModelProperty(value = "注单量")
  private Integer betCount;

  @ApiModelProperty(value = "总赢得(包含本金)")
  private BigDecimal totalWin;

  @ApiModelProperty(value = "未结算(只有日报表有数据)")
  private BigDecimal totalNotsettled;

  @ApiModelProperty(value = "第三方玩家Id")
  private String dsfPlayerId;

  @ApiModelProperty(value = "玩家名称")
  private String nickname;

  @ApiModelProperty(value = "游戏类型")
  private String categoryName;

  @ApiModelProperty(value = "总输赢")
  private BigDecimal result;

  @ApiModelProperty(value = "更新时间")
  private LocalDateTime updateTime;

  @ApiModelProperty(value = "开始时间")
  private LocalDateTime createTime;

  @ApiModelProperty(value = "玩家实际投注")
  private BigDecimal total_member_exposure;

}
