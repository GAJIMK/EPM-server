package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.UserFeeList;
import com.dartmedia.dmss.mapper.UserFeeListMapper;

import org.springframework.stereotype.Repository;

@Repository
public class UserFeeListService implements UserFeeListMapper {
  @Resource(name = "userFeeListMapper")
  UserFeeListMapper mapper;

  @Override
  public void create(UserFeeList t) throws Exception {
    mapper.create(t);

  }

  @Override
  public UserFeeList read(String id) throws Exception {

    return null;
  }

  @Override
  public UserFeeList readById(int id) throws Exception {
    return mapper.readById(id);
  }

  @Override
  public void update(UserFeeList t) throws Exception {
    mapper.update(t);
  }

  @Override
  public void delete(String id) throws Exception {

  }

  @Override
  public void deleteById(short id) throws Exception {
    mapper.deleteById(id);
  }

  @Override
  public void updateUnstable(int id) {
    mapper.updateUnstable(id);
  }

  public List<UserFeeList> findByAccountId(String accountId, String date) throws Exception {
    return mapper.findByAccountId(accountId, date);
  }

  @Override
  public List<UserFeeList> findAll(String accountId) throws Exception {
    // TODO Auto-generated method stub
    return mapper.findAll(accountId);
  }

  @Override
  public List<UserFeeList> findAll() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UserFeeList> findByPartId(String accountId, String date, short part) throws Exception {
    return mapper.findByPartId(accountId, date, part);
  }

}
