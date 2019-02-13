package com.invech.platform.dsfcenterdao.service;

import com.invech.platform.dsfcenterdao.config.MybatisAutoMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<D extends MybatisAutoMapper<T>, T>  {

  @Autowired
  protected D mapper;


  public int save(T entity) {
    return mapper.insert(entity);
  }

  public int delete(T entity) {
    return mapper.delete(entity);
  }

  /**
   * 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
   *
   * @param ids 如 "1,2,3,4"
   * @return
   */
  public int deleteById(String ids) {
    return mapper.deleteByIds(ids);
  }

  public int update(T entity) {
    return mapper.updateByPrimaryKeySelective(entity);
  }

  public T queryObject(Integer key) {
    return mapper.selectByPrimaryKey(key);
  }

  public T queryObjectCond(T entity) {
    return mapper.selectOne(entity);
  }

  public List<T> queryList() {
    return mapper.selectAll();
  }

  public List<T> queryListCond(T entity) {
    return mapper.select(entity);
  }

  public int selectCount(T entity)
  {
    return mapper.selectCount(entity);
  }

}
