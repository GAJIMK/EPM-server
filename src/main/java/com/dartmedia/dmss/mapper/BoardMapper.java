package com.dartmedia.dmss.mapper;

import java.util.List;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.Board;

@MapperInterface
public interface BoardMapper extends IMapper<Board> {
  public void deleteById(short id) throws Exception;

  public Board readById(short id) throws Exception;

  public List<Board> findById(int id) throws Exception;

  public List<Board> findBypage(int page) throws Exception;

}
