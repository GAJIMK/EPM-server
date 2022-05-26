package com.dartmedia.dmss.mapper;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.Board;

@MapperInterface
public interface BoardMapper extends IMapper<Board> {
  public void deleteById(short id) throws Exception;

  public Board readById(short id) throws Exception;

}
