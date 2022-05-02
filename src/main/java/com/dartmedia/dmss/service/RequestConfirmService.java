package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.RequestConfirm;
import com.dartmedia.dmss.mapper.RequestConfirmMapper;

import org.springframework.stereotype.Repository;

@Repository
public class RequestConfirmService implements RequestConfirmMapper {
  @Resource(name = "requestConfirmMapper")
  RequestConfirmMapper mapper;

  @Override
  public void create(RequestConfirm t) throws Exception {
    mapper.create(t);
  }

  @Override
  public List<RequestConfirm> findAll() throws Exception {
    return null;
  }

  @Override
  public RequestConfirm read(String id) throws Exception {
    return mapper.read(id);
  }

  @Override
  public void update(RequestConfirm t) throws Exception {
    mapper.update(t);

  }

  @Override
  public void delete(String id) throws Exception {

  }

  public List<RequestConfirm> findRequestConfirmByIdNo(String idNo) {
    return mapper.findRequestConfirmByIdNo(idNo);
  }

  @Override
  public RequestConfirm readRequestConfirm(String receiverId, int requestId) {
    return mapper.readRequestConfirm(receiverId, requestId);
  }

}
