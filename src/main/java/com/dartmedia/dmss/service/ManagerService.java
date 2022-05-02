package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.Manager;
import com.dartmedia.dmss.mapper.ManagerMapper;

import org.springframework.stereotype.Repository;

@Repository
public class ManagerService implements ManagerMapper{
  @Resource(name="managerMapper")
  ManagerMapper mapper;


  @Override
  public void create(Manager manager) throws Exception {
    mapper.create(manager);
  }

  @Override
  public List<Manager> findAll() throws Exception {
    return mapper.findAll();
  }

  @Override
  public Manager read(String id) throws Exception {
    return mapper.read(id);
  }

  @Override
  public void update(Manager manager) throws Exception {
    mapper.update(manager);
  }

  @Override
  public void delete(String id) throws Exception {
    mapper.delete(id);
  }

  @Override
  public List<Manager> getManagerListWithEmail() throws Exception {
    return mapper.getManagerListWithEmail();
  }

  @Override
  public void updateManager(Manager manager) throws Exception {
    mapper.updateManager(manager);
  }

  @Override
  public List<Manager> getManagerListByFuncIdWithEmail(int funcId) throws Exception {
    return mapper.getManagerListByFuncIdWithEmail(funcId);
  }
}
