package com.dartmedia.dmss.mapper;

import java.util.List;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.UserFeeList;

@MapperInterface
public interface UserFeeListMapper extends IMapper<UserFeeList> {
  public void deleteById(short id) throws Exception;

  public List<UserFeeList> findByAccountId(String accountId, String date) throws Exception;

  public UserFeeList readById(int id) throws Exception;

  public void updateStateById(int id);

<<<<<<< HEAD
=======
  public List<UserFeeList> findAll(String accountId) throws Exception;
>>>>>>> 3973a477d1fdbb946d574dcc99074c74d0d5aaef
}
