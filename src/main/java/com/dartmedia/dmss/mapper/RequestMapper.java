package com.dartmedia.dmss.mapper;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.Request;

@MapperInterface
public interface RequestMapper extends IMapper<Request>{
  public void deleteByRequestId(int requestId) throws Exception;
  public Request readByRequestId(int requestId) throws Exception;
}
