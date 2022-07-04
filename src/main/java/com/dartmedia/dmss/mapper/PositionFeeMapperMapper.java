package com.dartmedia.dmss.mapper;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.PositionFeeMapper;

@MapperInterface
public interface PositionFeeMapperMapper extends IMapper<PositionFeeMapper> {
  public PositionFeeMapper readByCode(int positionCode, int feeCode) throws Exception;
}
