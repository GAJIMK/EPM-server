package com.dartmedia.dmss.mapper;

import java.util.List;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.UserFeeList;

@MapperInterface
public interface UserFeeListMapper extends IMapper<UserFeeList> {
  public void deleteById(int id) throws Exception;

  public List<UserFeeList> findByAccountId(String accountId, String date) throws Exception;

  public UserFeeList readById(int id) throws Exception;

  public void updateUnstable(int id);

  public void updateStable(int id);

  public List<UserFeeList> findAll(String accountId) throws Exception;

  public List<UserFeeList> findByPartId(String accountId, String date, short part) throws Exception;
}
