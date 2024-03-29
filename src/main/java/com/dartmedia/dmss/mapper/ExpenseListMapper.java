package com.dartmedia.dmss.mapper;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.ExpenseList;

@MapperInterface
public interface ExpenseListMapper extends IMapper<ExpenseList> {
  public ExpenseList readById(Short summCode) throws Exception;

  public ExpenseList read(Short id) throws Exception;
}