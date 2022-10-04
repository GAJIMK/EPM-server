package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.ApprovalStep;
import com.dartmedia.dmss.mapper.ApprovalStepMapper;

import org.springframework.stereotype.Repository;

@Repository
public class ApprovalStepService implements ApprovalStepMapper {
  @Resource(name = "approvalStepMapper")
  ApprovalStepMapper mapper;

  @Override
  public void create(ApprovalStep t) throws Exception {

  }

  @Override
  public ApprovalStep read(String id) throws Exception {
    return null;
  }

  @Override
  public void update(ApprovalStep t) throws Exception {

  }

  @Override
  public List<ApprovalStep> readByTeamNo(short teamNo) throws Exception {
    return mapper.readByTeamNo(teamNo);
  }

  @Override
  public List<ApprovalStep> findAll() throws Exception {
    return null;
  }

  @Override
  public void delete(String id) throws Exception {

  }
}
