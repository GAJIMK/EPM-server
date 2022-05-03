package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.ExpenseList;
import com.dartmedia.dmss.mapper.ExpenseListMapper;

import org.springframework.stereotype.Repository;

@Repository
public class ExpenseListService implements ExpenseListMapper {

  @Resource(name="expenseListMapper")
  ExpenseListMapper mapper;

  @Override
  public void create(ExpenseList t) throws Exception {
    mapper.create(t);    
  }

  @Override
  public List<ExpenseList> findAll() throws Exception {      
    return mapper.findAll();
  }

  @Override
  public ExpenseList read(String id) throws Exception {
    return mapper.read(id);
  }

  @Override
  public void update(ExpenseList t) throws Exception {
    mapper.update(t);
  }

  @Override
  public void delete(String id) throws Exception {
    
  }

}
