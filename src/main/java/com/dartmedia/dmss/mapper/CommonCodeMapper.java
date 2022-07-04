package com.dartmedia.dmss.mapper;

import java.util.List;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.CommonCode;

@MapperInterface
public interface CommonCodeMapper extends IMapper<CommonCode> {
  public List<CommonCode> findPosition() throws Exception;
}
