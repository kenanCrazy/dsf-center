package com.invech.platform.dsfcenterdata.entity;

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
@ApiModel(value = "DsfStatementsMonth", description = "站点按月汇总数据")
@Table(name = "dsf_statements_month")
public class DsfStatementsMonth {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "id")
  private Integer id ;

  @ApiModelProperty(value = "站点代缩写代码")
  private String siteCode;

  @ApiModelProperty(value = "游戏平台")
  private GamePlatform gamePlatform;

  @ApiModelProperty(value = "更新时间")
  private LocalDateTime updateTime;

  @ApiModelProperty(value = "开始时间")
  private LocalDateTime createTime;

  @ApiModelProperty(value = "总收入(有效投注)")
  private BigDecimal totalBet;

  @ApiModelProperty(value = "注单量")
  private Integer betCount;

  @ApiModelProperty(value = "总赢得(包含本金)")
  private BigDecimal totalWin;

  @ApiModelProperty(value = "输赢后结果(纯利润)")
  private BigDecimal playerResult;

  @ApiModelProperty(value = "月份")
  private String mon;

}
