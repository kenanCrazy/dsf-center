package com.invech.platform.dsfcenterdao.service;


import com.invech.platform.dsfcenterdao.dao.SysMapper;
import com.invech.platform.dsfcenterdao.mapper.TSiteMapper;
import com.invech.platform.dsfcenterdao.mapper.TSiteUrlMapper;
import com.invech.platform.dsfcenterdata.utils.entity.TSite;
import com.invech.platform.dsfcenterdata.utils.entity.TGmApiPrefix;
import com.invech.platform.dsfcenterdata.utils.entity.TSiteurl;
import com.invech.platform.dsfcenterdata.utils.entity.TSchema;
import com.invech.platform.dsfcenterdata.utils.response.R;
import com.invech.platform.dsfcenterdata.utils.response.RRException;
import com.invech.platform.dsfcenterdata.utils.utils.DateUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class TCpSiteService extends BaseService<TSiteMapper, TSite> {

  public static Map<String, String> schemaName;

  @Autowired
  TSiteUrlMapper tSiteUrlMapper;

  @Autowired
  TschemaService tschemaService;

  @Autowired
  SysMapper sysMapper;


  //@Cacheable(cacheNames = ApiConstants.REDIS_GAME_SITECODE_CACHE_KEY, key = "#siteCode")
  // @CacheDuration(duration = 6)
  public TSite queryPreOneCond(String siteCode) {
    TSite cpSite = new TSite();
    cpSite.setSiteCode(siteCode);
    return super.queryObjectCond(cpSite);
  }


  @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
  public void saveCpSite(TSite tSite) {
    TSchema TSchema = sysMapper.selectTschemaOne();
    if (StringUtils.isEmpty(TSchema)) {
      throw new RRException("没有可用的资料库,请管理员新增资料库!");
    }
    if (sysMapper.updateSchema(TSchema.getId(), tSite.getSiteCode()) > 0) {
      super.save(tSite);
      tSiteUrlMapper.insertUseGeneratedKeys(getTcpSiteurl(tSite));
    } else {
      throw new RRException("更新资料库失败，请稍后再试!");
    }

  }

  //	@Cacheable(cacheNames = ApiConstants.SITE_CODE, key = "#SchemaName")
  public String getSiteCode(String SchemaName) {
    TSite cpSite = new TSite();
    cpSite.setSchemaName(SchemaName);
    cpSite = super.queryObjectCond(cpSite);
    return cpSite.getSiteCode();
  }

  //	@Cacheable(cacheNames = ApiConstants.SCHEMA_NAME, key = "#siteCode")
  public String getSchemaName(String siteCode) {
    TSite cpSite = new TSite();
    cpSite.setSiteCode(siteCode);
    cpSite = super.queryObjectCond(cpSite);
    return cpSite.getSchemaName();
  }


  @Bean
  public Map<String, String> initSchemaName() {
    List<TSite> tSites = sysMapper.findCpSite();
    Map<String, String> schemaName = new HashMap<>();
    schemaName.clear();
    for (TSite tSite : tSites) {
      schemaName.put(tSite.getSchemaName(), tSite.getSiteCode());
    }
    this.schemaName = schemaName;
    return schemaName;
  }


  private TSiteurl getTcpSiteurl(TSite tSite) {
    TSiteurl tSiteurl = new TSiteurl();
    tSiteurl.setSiteId(tSite.getId());
    tSiteurl.setSiteCode(tSite.getSiteCode());
    tSiteurl.setSiteUrl(tSite.getSiteUrl());
    return tSiteurl;
  }

  /**
   * 添加SiteCode
   *
   * @param url xxx.xxx.com
   */
  @Transactional
  public R addSiteCode(String siteCode, String url, String siteName
      , String startTime, String endTime
      , String currency, Integer compantId, String userName) {
    if (siteCode.length() > 3) {
      return R.ok().put("2000", "站点前缀过长");
    }
    TSchema TSchema = sysMapper.selectTschemaOne();
    if (TSchema == null) {
      return R.ok().put("2000", "已无预备站点，请联系客服");
    }
    TSchema.setSiteCode(siteCode);
    TSchema.setIsUsed(new Byte("1"));
    int i = tschemaService.updateTschemaSiteCode(TSchema);
    if (i == 0) {
      return R.ok().put("2000", "站点前缀已被使用");
    }
    /*插入sitecode 和 schemaName 的对应关系*/
    TSite tSite = new TSite();
    tSite.setSiteCode(siteCode);
    tSite.setSchemaName(TSchema.getSimpleName());
    tSite.setIsapi(new Byte("0"));
    tSite.setAvailable(new Byte("1"));
    String currentDate = DateUtil.getCurrentDate(DateUtil.FORMAT_18_DATE_TIME);
    tSite.setCreateTime(currentDate);
    tSite.setMemo(siteName);
    tSite.setCurrency(currency);
    tSite.setSiteName(siteName);
    tSite.setCreateUser(userName);
    tSite.setModifyTime(currentDate);
    tSite.setStartDate(startTime);
    tSite.setEndDate(endTime);
    tSite.setCompanyId(compantId);
    super.save(tSite);
    /*插入siteCode 和域名的对应关系*/
    TSiteurl tSiteurl = new TSiteurl();
    tSiteurl.setSiteCode(siteCode);
    tSiteurl.setSiteUrl(url);
    tSiteurl.setSiteId(tSite.getId());
    tSiteUrlMapper.insertUseGeneratedKeys(tSiteurl);
    /*插入apiPrefix 和siteCode 的对应关系*/
    List<TGmApiPrefix> models = sysMapper.selectApiPrefixByModel();
    models.forEach(model -> {
      sysMapper.insertApiPrefix(
          new TGmApiPrefix(model.getApiId(), model.getPrefix().replace("model", siteCode),
              tSite.getId(), new Byte("1"), userName, userName));
    });
    this.schemaName.put(tSite.getSchemaName(), tSite.getSiteCode());
    return R.ok().put("域名设置成功");
  }
}
