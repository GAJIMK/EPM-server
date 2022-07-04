package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.dartmedia.dmss.dto.PositionFeeMapper;
import com.dartmedia.dmss.mapper.PositionFeeMapperMapper;

@Repository
public class PositionFeeMapperService implements PositionFeeMapperMapper {
  @Resource(name = "positionFeeMapperMapper")
  PositionFeeMapperMapper mapper;

  @Override
  public void create(PositionFeeMapper t) throws Exception {
    mapper.create(t);

  }

  @Override
  public List<PositionFeeMapper> findAll() throws Exception {
    return mapper.findAll();
  }

  @Override
  public PositionFeeMapper read(String id) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(PositionFeeMapper t) throws Exception {
    mapper.update(t);

  }

  @Override
  public void delete(String id) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public PositionFeeMapper readByCode(short positionCode, short feeCode) throws Exception {
    // TODO Auto-generated method stub
    return mapper.readByCode(positionCode, feeCode);
  }
}
