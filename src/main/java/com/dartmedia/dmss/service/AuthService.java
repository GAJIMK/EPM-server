package com.dartmedia.dmss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

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

}
