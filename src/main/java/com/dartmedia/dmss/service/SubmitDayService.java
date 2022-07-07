package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.SubmitDay;
import com.dartmedia.dmss.mapper.SubmitDayMapper;

import org.springframework.stereotype.Repository;

@Repository
public class SubmitDayService implements SubmitDayMapper {
  @Resource(name = "submitDayMapper")
  SubmitDayMapper mapper;

  @Override
  public void create(SubmitDay t) throws Exception {
    mapper.create(t);

  }

@Override
public void create(SubmitDayMapper t) throws Exception {
    // TODO Auto-generated method stub
    
}

@Override
public List<SubmitDayMapper> findAll() throws Exception {
    // TODO Auto-generated method stub
    return mapper.findAll();
}

@Override
public SubmitDayMapper read(String id) throws Exception {
    // TODO Auto-generated method stub
    return null;
}

@Override
public void update(SubmitDayMapper t) throws Exception {
    // TODO Auto-generated method stub
    
}

@Override
public void delete(String id) throws Exception {
    // TODO Auto-generated method stub
    
}


}
