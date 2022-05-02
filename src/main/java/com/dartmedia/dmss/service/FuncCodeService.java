package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.FuncCode;
import com.dartmedia.dmss.mapper.FuncCodeMapper;

import org.springframework.stereotype.Repository;

@Repository
public class FuncCodeService implements FuncCodeMapper {

  @Resource(name="funcCodeMapper")
  FuncCodeMapper mapper;

  @Override
  public void create(FuncCode t) throws Exception {
    mapper.create(t);    
  }

  @Override
  public List<FuncCode> findAll() throws Exception {      
    return mapper.findAll();
  }

  @Override
  public FuncCode read(String id) throws Exception {
    return mapper.read(id);
  }

  @Override
  public void update(FuncCode t) throws Exception {
    mapper.update(t);
    
  }

  @Override
  public void delete(String id) throws Exception {
    
  }
  
  @Override
  public void deleteByFuncId(short funcId) throws Exception {
    mapper.deleteByFuncId(funcId);
    
  }

  @Override
  public FuncCode readByFuncId(short funcId) throws Exception {
    return mapper.readByFuncId(funcId);
  }
}
