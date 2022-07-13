package com.dartmedia.dmss.mapper;

import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.Auth;

@MapperInterface
public interface AuthMapper {
  public Auth login(String accountId, String password) throws Exception;

}