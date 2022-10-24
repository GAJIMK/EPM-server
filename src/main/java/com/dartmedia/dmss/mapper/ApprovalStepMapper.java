package com.dartmedia.dmss.mapper;

import java.util.List;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.ApprovalStep;

@MapperInterface
public interface ApprovalStepMapper extends IMapper<ApprovalStep> {
  public List<ApprovalStep> readByTeamNo(short teamNo) throws Exception;
}
