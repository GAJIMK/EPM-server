package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.ExpenseList;
import com.dartmedia.dmss.mapper.ExpenseListMapper;

import org.springframework.stereotype.Repository;

@Repository
public class ExpenseListService implements ExpenseListMapper {

  @Resource(name = "expenseListMapper")
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
  public ExpenseList read(Short id) throws Exception {
    return mapper.read(id);
  }

  @Override
  public ExpenseList readById(Short summCode) throws Exception {
    return mapper.readById(summCode);
  }

  @Override
  public void update(ExpenseList t) throws Exception {
    mapper.update(t);
  }

  @Override
  public void delete(String id) throws Exception {

  }

  @Override
  public ExpenseList read(String id) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

}
