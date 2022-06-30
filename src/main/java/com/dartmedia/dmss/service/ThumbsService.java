package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.Thumbs;
import com.dartmedia.dmss.mapper.ThumbsMapper;

import org.springframework.stereotype.Repository;

@Repository
public class ThumbsService implements ThumbsMapper {
  @Resource(name = "thumbsMapper")
  ThumbsMapper mapper;

  @Override
  public void create(Thumbs t) throws Exception {
    mapper.create(t);

  }

  @Override
  public List<Thumbs> findAll() throws Exception {
    return mapper.findAll();
  }

  @Override
  public Thumbs read(String id) throws Exception {
    return null;
  }

  @Override
  public Thumbs readById(short id) throws Exception {
    return mapper.readById(id);
  }

  @Override
  public void update(Thumbs t) throws Exception {
    mapper.update(t);
  }

  @Override
  public void delete(String id) throws Exception {

  }

  @Override
  public void deleteById(short id) throws Exception {
    mapper.deleteById(id);
  }

  @Override
  public List<Thumbs> countById(int id) throws Exception {
    // TODO Auto-generated method stub
    return mapper.countById(id);
  }

}
