package com.invech.platform.dsfcenterdao.dao;


import com.invech.platform.dsfcenterdata.utils.entity.SsysConfig;
import com.invech.platform.dsfcenterdata.utils.entity.TCpSite;
import com.invech.platform.dsfcenterdata.utils.entity.TGmApi;
import com.invech.platform.dsfcenterdata.utils.entity.TGmApiprefix;
import com.invech.platform.dsfcenterdata.utils.entity.Tschema;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysMapper {

  TCpSite findCpSiteOne(@Param("siteUrl") String siteUrl);

  List<TCpSite> findCpSite();

  TGmApi findGmApiOne(@Param("depotId") Integer depotId, @Param("siteCode") String siteCode);

  Integer updateSchema(@Param("id") Integer id, @Param("siteCode") String siteCode);

  Tschema selectTschemaOne();

  List<SsysConfig> listSysConfig(@Param("groups") String groups);

  String getCpSiteCode(@Param("siteCode") String siteCode);

  int updateTschemaSiteCode(Tschema tschema);


  int insertApiPrefix(TGmApiprefix tGmApiprefix);

  List<TGmApiprefix> selectApiPrefixByModel();
}
