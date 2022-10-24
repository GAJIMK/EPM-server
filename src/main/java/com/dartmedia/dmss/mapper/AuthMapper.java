package com.dartmedia.dmss.mapper;

import java.util.List;

import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.Account;
import com.dartmedia.dmss.dto.Auth;

@MapperInterface
public interface AuthMapper {
  public Auth login(String accountId, String password) throws Exception;

  public String isExist(String accountId) throws Exception;

  public List<Account> findById(String accountId) throws Exception;

}