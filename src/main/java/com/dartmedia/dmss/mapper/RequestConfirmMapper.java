package com.dartmedia.dmss.mapper;

import java.util.List;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.RequestConfirm;

@MapperInterface
public interface RequestConfirmMapper extends IMapper<RequestConfirm>{

  public List<RequestConfirm> findRequestConfirmByIdNo(String idNo);
  public RequestConfirm readRequestConfirm(String receiverId, int requestId);
  
}
