package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.Board;
import com.dartmedia.dmss.mapper.BoardMapper;

import org.springframework.stereotype.Repository;

@Repository
public class BoardService implements BoardMapper {
  @Resource(name = "BoardMapper")
  BoardMapper mapper;

  @Override
  public void create(Board t) throws Exception {
    mapper.create(t);

  }

  @Override
  public List<Board> findAll() throws Exception {

    return null;
  }

  @Override
  public Board read(String id) throws Exception {

    return null;
  }

  @Override
  public Board readById(int id) throws Exception {
    return mapper.readById(id);
  }

  @Override
  public void update(Board t) throws Exception {
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
  public void updateStateById(int id) {
    mapper.updateStateById(id);
  }

  public List<Board> findByAccountId(String accountId, String date) throws Exception {
    return mapper.findByAccountId(accountId, date);
  }

}
