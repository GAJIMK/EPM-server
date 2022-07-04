package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.dartmedia.dmss.dto.CommonCode;
import com.dartmedia.dmss.mapper.CommonCodeMapper;

@Repository
public class CommonCodeService implements CommonCodeMapper {
  @Resource(name = "commonCodeMapper")
  CommonCodeMapper mapper;

  @Override
  public void create(CommonCode t) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public List<CommonCode> findAll() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CommonCode read(String id) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(CommonCode t) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(String id) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public List<CommonCode> findPosition() throws Exception {
    return mapper.findPosition();
  }

}