package com.dartmedia.dmss.mapper;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.AccountPoint;

@MapperInterface
public interface AccountPointMapper extends IMapper<AccountPoint> {
  public AccountPoint findTeamNo(String accountId) throws Exception;

  public AccountPoint findTeamNm(String accountId) throws Exception;
}
