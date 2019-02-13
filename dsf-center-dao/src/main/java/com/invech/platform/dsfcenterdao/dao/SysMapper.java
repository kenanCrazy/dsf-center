package com.invech.platform.dsfcenterdao.dao;


import com.invech.platform.dsfcenterdata.utils.entity.TSysConfig;
import com.invech.platform.dsfcenterdata.utils.entity.TSite;
import com.invech.platform.dsfcenterdata.utils.entity.TGmApi;
import com.invech.platform.dsfcenterdata.utils.entity.TGmApiPrefix;
import com.invech.platform.dsfcenterdata.utils.entity.TSchema;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysMapper {

  TSite findCpSiteOne(@Param("siteUrl") String siteUrl);

  List<TSite> findCpSite();

  TGmApi findGmApiOne(@Param("depotId") Integer depotId, @Param("siteCode") String siteCode);

  Integer updateSchema(@Param("id") Integer id, @Param("siteCode") String siteCode);

  TSchema selectTschemaOne();

  List<TSysConfig> listSysConfig(@Param("groups") String groups);

  String getCpSiteCode(@Param("siteCode") String siteCode);

  int updateTschemaSiteCode(TSchema TSchema);


  int insertApiPrefix(TGmApiPrefix tGmApiPrefix);

  List<TGmApiPrefix> selectApiPrefixByModel();
}
