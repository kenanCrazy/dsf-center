package com.invech.platform.dsfcenterdao.config;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MybatisAutoMapper<T> extends MySqlMapper<T>,IdsMapper<T>,BaseMapper<T> {

}