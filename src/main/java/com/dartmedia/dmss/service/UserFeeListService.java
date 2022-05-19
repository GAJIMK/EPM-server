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
  public List<UserFeeList> findAll() throws Exception {

    return null;
  }

  @Override
  public UserFeeList read(String id) throws Exception {

    return null;
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
  public void updateStateById(int id, short state) {
    mapper.updateStateById(id, state);
  }

  @Override
  public List<UserFeeList> findById(String accountId, String date) throws Exception {
    return mapper.findById(accountId, date);
  }

}
