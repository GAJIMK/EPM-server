package com.dartmedia.dmss.mapper;

import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.ManagerInfo;

import java.util.List;

import com.dartmedia.dmss.core.IMapper;
@MapperInterface
public interface ManagerInfoMapper extends IMapper<ManagerInfo>{
  public List<ManagerInfo> findManager (String master) throws Exception;
  public ManagerInfo findManagerByFuncId(String master, String funcId) throws Exception;
}
