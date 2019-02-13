package com.invech.platform.dsfcenterdao.service;

import com.invech.platform.dsfcenterdao.dao.SysMapper;
import com.invech.platform.dsfcenterdao.mapper.TschemaMapper;
import com.invech.platform.dsfcenterdata.utils.entity.Tschema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TschemaService  extends BaseService<TschemaMapper, Tschema> {

    @Autowired
    TschemaMapper tschemaMapper;

    @Autowired
    SysMapper sysMapper;

    public void insertTschema(Tschema tschema){
        super.save(tschema);
    }

    public void updateTschema(Tschema tschema){
        super.update(tschema);
    }

    public Tschema selectOne(Tschema tschema){
        return tschemaMapper.selectOne(tschema);
    }

    public int selectCount(Tschema tschema){
        return super.selectCount(tschema);
    }

    public int updateTschemaSiteCode(Tschema tschema) {
        return sysMapper.updateTschemaSiteCode(tschema);
    }
}
