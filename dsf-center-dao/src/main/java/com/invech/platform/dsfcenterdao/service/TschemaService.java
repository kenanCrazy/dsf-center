package com.invech.platform.dsfcenterdao.service;

import com.invech.platform.dsfcenterdao.dao.SysMapper;
import com.invech.platform.dsfcenterdao.mapper.TSchemaMapper;
import com.invech.platform.dsfcenterdata.entity.TSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TschemaService  extends BaseService<TSchemaMapper, TSchema> {

    @Autowired
    TSchemaMapper TSchemaMapper;

    @Autowired
    SysMapper sysMapper;

    public void insertTschema(TSchema TSchema){
        super.save(TSchema);
    }

    public void updateTschema(TSchema TSchema){
        super.update(TSchema);
    }

    public TSchema selectOne(TSchema TSchema){
        return TSchemaMapper.selectOne(TSchema);
    }

    public int selectCount(TSchema TSchema){
        return super.selectCount(TSchema);
    }

    public int updateTschemaSiteCode(TSchema TSchema) {
        return sysMapper.updateTschemaSiteCode(TSchema);
    }
}
