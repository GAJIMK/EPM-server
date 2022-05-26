package com.dartmedia.dmss.mapper;

import java.util.List;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.Board;

@MapperInterface
public interface BoardMapper extends IMapper<Board> {
  public void deleteById(short id) throws Exception;

  public List<Board> findByAccountId(String accountId, String date) throws Exception;

  public Board readById(int id) throws Exception;

  public void updateStateById(int id);
}
