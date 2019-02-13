package com.invech.platform.dsfcenterdata.utils.entity;


import com.invech.platform.dsfcenterdata.utils.utils.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "t_gm_api_prefix")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TGmApiPrefix {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @ApiModelProperty(name = "id")
    private Integer id;

    @ApiModelProperty(name = "线路id")
    private String apiId;
    @ApiModelProperty(name = "线路前缀")
    private String prefix;
    @ApiModelProperty(name = "站点id")
    private Integer siteId;
    @ApiModelProperty(name = "1开启，0禁用")
    private Byte available;
    @ApiModelProperty(name = "创建人")
    private String createUser;
    @ApiModelProperty(name = "创建时间")
    private String createTime;
    @ApiModelProperty(name = "修改人")
    private String modifyUser;
    @ApiModelProperty(name = "修改时间")
    private String modifyTime;


    public TGmApiPrefix(String apiId, String prefix, Integer siteId, Byte available, String createUser, String modifyUser) {
        this.apiId = apiId;
        this.prefix = prefix;
        this.siteId = siteId;
        this.available = available;
        this.createUser = createUser;
        this.createTime = DateUtil.getCurrentDate(DateUtil.FORMAT_18_DATE_TIME);
        this.modifyUser = modifyUser;
        this.modifyTime = DateUtil.getCurrentDate(DateUtil.FORMAT_18_DATE_TIME);
    }
}
