package com.dartmedia.dmss.mapper;

import java.util.List;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.PositionFeeMapper;

@MapperInterface
public interface PositionFeeMapperMapper extends IMapper<PositionFeeMapper> {
  public PositionFeeMapper readByCode(short positionCode, short feeCode) throws Exception;

  public List<PositionFeeMapper> readByPosition(short positionCode) throws Exception;
}
