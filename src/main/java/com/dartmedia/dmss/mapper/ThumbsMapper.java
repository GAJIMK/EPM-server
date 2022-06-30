package com.dartmedia.dmss.mapper;

import java.util.List;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.Thumbs;

@MapperInterface
public interface ThumbsMapper extends IMapper<Thumbs> {
  public void deleteById(short id) throws Exception;

  public Thumbs readById(short id) throws Exception;

  public List<Thumbs> findById(int id) throws Exception;

}
