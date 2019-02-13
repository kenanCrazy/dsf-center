package com.invech.platform.dsfcenterdao.mapper;


import com.invech.platform.dsfcenterdao.config.MybatisAutoMapper;
import com.invech.platform.dsfcenterdata.utils.entity.TCpSite;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface TCpSiteMapper extends MybatisAutoMapper<TCpSite> {



}