package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.ManagerInfo;
import com.dartmedia.dmss.mapper.ManagerInfoMapper;

import org.springframework.stereotype.Repository;

@Repository
public class ManagerInfoService implements ManagerInfoMapper{
  @Resource(name="managerInfoMapper")
  ManagerInfoMapper mapper;

  @Override
  public void create(ManagerInfo t) throws Exception {
    
  }

  @Override
  public List<ManagerInfo> findAll() throws Exception {
    return null;

  }

  @Override
  public ManagerInfo read(String id) throws Exception {
    return null;
  }

  @Override
  public void update(ManagerInfo t) throws Exception {
    
  }

  @Override
  public void delete(String id) throws Exception {
    
  }

	public List<ManagerInfo> findManager(String master) throws Exception {
		return mapper.findManager(master);
	}


  @Override
  public ManagerInfo findManagerByFuncId(String master, String funcId) throws Exception {
    return mapper.findManagerByFuncId(master, funcId);
  }

}
