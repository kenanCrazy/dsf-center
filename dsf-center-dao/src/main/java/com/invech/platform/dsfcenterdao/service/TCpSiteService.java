package com.invech.platform.dsfcenterdao.service;


import com.invech.platform.dsfcenterdao.dao.SysMapper;
import com.invech.platform.dsfcenterdao.mapper.TCpSiteMapper;
import com.invech.platform.dsfcenterdao.mapper.TcpSiteurlMapper;
import com.invech.platform.dsfcenterdata.utils.entity.TCpSite;
import com.invech.platform.dsfcenterdata.utils.entity.TGmApiprefix;
import com.invech.platform.dsfcenterdata.utils.entity.TcpSiteurl;
import com.invech.platform.dsfcenterdata.utils.entity.Tschema;
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
public class TCpSiteService extends BaseService<TCpSiteMapper, TCpSite> {

  public static Map<String, String> schemaName;

  @Autowired
  TcpSiteurlMapper tcpSiteurlMapper;

  @Autowired
  TschemaService tschemaService;

  @Autowired
  SysMapper sysMapper;


  //@Cacheable(cacheNames = ApiConstants.REDIS_GAME_SITECODE_CACHE_KEY, key = "#siteCode")
  // @CacheDuration(duration = 6)
  public TCpSite queryPreOneCond(String siteCode) {
    TCpSite cpSite = new TCpSite();
    cpSite.setSiteCode(siteCode);
    return super.queryObjectCond(cpSite);
  }


  @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
  public void saveCpSite(TCpSite tCpSite) {
    Tschema tschema = sysMapper.selectTschemaOne();
    if (StringUtils.isEmpty(tschema)) {
      throw new RRException("没有可用的资料库,请管理员新增资料库!");
    }
    if (sysMapper.updateSchema(tschema.getId(), tCpSite.getSiteCode()) > 0) {
      super.save(tCpSite);
      tcpSiteurlMapper.insertUseGeneratedKeys(getTcpSiteurl(tCpSite));
    } else {
      throw new RRException("更新资料库失败，请稍后再试!");
    }

  }

  //	@Cacheable(cacheNames = ApiConstants.SITE_CODE, key = "#SchemaName")
  public String getSiteCode(String SchemaName) {
    TCpSite cpSite = new TCpSite();
    cpSite.setSchemaName(SchemaName);
    cpSite = super.queryObjectCond(cpSite);
    return cpSite.getSiteCode();
  }

  //	@Cacheable(cacheNames = ApiConstants.SCHEMA_NAME, key = "#siteCode")
  public String getSchemaName(String siteCode) {
    TCpSite cpSite = new TCpSite();
    cpSite.setSiteCode(siteCode);
    cpSite = super.queryObjectCond(cpSite);
    return cpSite.getSchemaName();
  }


  @Bean
  public Map<String, String> initSchemaName() {
    List<TCpSite> tCpSites = sysMapper.findCpSite();
    Map<String, String> schemaName = new HashMap<>();
    schemaName.clear();
    for (TCpSite tCpSite : tCpSites) {
      schemaName.put(tCpSite.getSchemaName(), tCpSite.getSiteCode());
    }
    this.schemaName = schemaName;
    return schemaName;
  }


  private TcpSiteurl getTcpSiteurl(TCpSite tCpSite) {
    TcpSiteurl tcpSiteurl = new TcpSiteurl();
    tcpSiteurl.setSiteId(tCpSite.getId());
    tcpSiteurl.setSiteCode(tCpSite.getSiteCode());
    tcpSiteurl.setSiteUrl(tCpSite.getSiteUrl());
    return tcpSiteurl;
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
    Tschema tschema = sysMapper.selectTschemaOne();
    if (tschema == null) {
      return R.ok().put("2000", "已无预备站点，请联系客服");
    }
    tschema.setSiteCode(siteCode);
    tschema.setIsUsed(new Byte("1"));
    int i = tschemaService.updateTschemaSiteCode(tschema);
    if (i == 0) {
      return R.ok().put("2000", "站点前缀已被使用");
    }
    /*插入sitecode 和 schemaName 的对应关系*/
    TCpSite tCpSite = new TCpSite();
    tCpSite.setSiteCode(siteCode);
    tCpSite.setSchemaName(tschema.getSimpleName());
    tCpSite.setIsapi(new Byte("0"));
    tCpSite.setAvailable(new Byte("1"));
    String currentDate = DateUtil.getCurrentDate(DateUtil.FORMAT_18_DATE_TIME);
    tCpSite.setCreateTime(currentDate);
    tCpSite.setMemo(siteName);
    tCpSite.setCurrency(currency);
    tCpSite.setSiteName(siteName);
    tCpSite.setCreateUser(userName);
    tCpSite.setModifyTime(currentDate);
    tCpSite.setStartDate(startTime);
    tCpSite.setEndDate(endTime);
    tCpSite.setCompanyId(compantId);
    super.save(tCpSite);
    /*插入siteCode 和域名的对应关系*/
    TcpSiteurl tcpSiteurl = new TcpSiteurl();
    tcpSiteurl.setSiteCode(siteCode);
    tcpSiteurl.setSiteUrl(url);
    tcpSiteurl.setSiteId(tCpSite.getId());
    tcpSiteurlMapper.insertUseGeneratedKeys(tcpSiteurl);
    /*插入apiPrefix 和siteCode 的对应关系*/
    List<TGmApiprefix> models = sysMapper.selectApiPrefixByModel();
    models.forEach(model -> {
      sysMapper.insertApiPrefix(
          new TGmApiprefix(model.getApiId(), model.getPrefix().replace("model", siteCode),
              tCpSite.getId(), new Byte("1"), userName, userName));
    });
    this.schemaName.put(tCpSite.getSchemaName(), tCpSite.getSiteCode());
    return R.ok().put("域名设置成功");
  }
}
