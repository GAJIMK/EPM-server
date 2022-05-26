package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.UserFeeState;
import com.dartmedia.dmss.mapper.UserFeeStateMapper;

import org.springframework.stereotype.Repository;

@Repository
public class UserFeeStateService implements UserFeeStateMapper {
  @Resource(name = "userFeeStateMapper")
  UserFeeStateMapper mapper;

  @Override
  public void create(UserFeeState t) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public List<UserFeeState> findAll() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public UserFeeState read(String id) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(UserFeeState t) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(String id) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public List<UserFeeState> findAllByDate(String date) throws Exception {
    // TODO Auto-generated method stub
    return mapper.findAllByDate(date);
  }

  @Override
  public List<UserFeeState> findAllByUser(String accountId) throws Exception {
    // TODO Auto-generated method stub
    return mapper.findAllByUser(accountId);
  }

}
