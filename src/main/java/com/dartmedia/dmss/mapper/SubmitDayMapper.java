package com.dartmedia.dmss.mapper;

import java.util.List;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.SubmitDay;

@MapperInterface
public interface SubmitDayMapper extends IMapper<SubmitDayMapper> {

  public void create(SubmitDay t) throws Exception;
 

}
