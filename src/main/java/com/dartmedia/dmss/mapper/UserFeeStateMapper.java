package com.dartmedia.dmss.mapper;

import java.util.Date;
import java.util.List;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.UserFeeState;

@MapperInterface
public interface UserFeeStateMapper extends IMapper<UserFeeState> {
  public List<UserFeeState> findAllByDate(String date) throws Exception;

  public List<UserFeeState> findAllByDateAndManager(String date) throws Exception;

  public List<UserFeeState> findAllByUser(String accountId) throws Exception;

  public UserFeeState readByDate(String accountId, Date date) throws Exception;

  public List<UserFeeState> findAllByLvAndDate(int acceptLv, String date) throws Exception;

  public void changeState(String accountId, Date date, int State) throws Exception;

}
