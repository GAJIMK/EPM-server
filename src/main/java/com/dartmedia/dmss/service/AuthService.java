package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.dartmedia.dmss.dto.Account;
import com.dartmedia.dmss.dto.Auth;
import com.dartmedia.dmss.mapper.AuthMapper;

@Repository
public class AuthService implements AuthMapper {
  @Resource(name = "authMapper")
  AuthMapper mapper;

  @Override
  public Auth login(String accountId, String password) throws Exception {
    return mapper.login(accountId, password);
  }

  @Override
  public String isExist(String accountId) throws Exception {
    return mapper.isExist(accountId);
  }

  @Override
  public List<Account> findById(String accountId) throws Exception {
    // TODO Auto-generated method stub
    return mapper.findById(accountId);
  }
}
