package com.dartmedia.dmss.service;

import java.util.List;

import javax.annotation.Resource;

import com.dartmedia.dmss.dto.AccountPoint;
import com.dartmedia.dmss.mapper.AccountPointMapper;

import org.springframework.stereotype.Repository;

@Repository
public class AccountPointService implements AccountPointMapper {
	@Resource(name = "accountPointMapper")
	AccountPointMapper mapper;

	@Override
	public void create(AccountPoint t) throws Exception {

	}

	@Override
	public List<AccountPoint> findAll() throws Exception {
		return mapper.findAll();
	}

	@Override
	public AccountPoint read(String id) throws Exception {
		return null;
	}

	@Override
	public void update(AccountPoint t) throws Exception {

	}

	@Override
	public void delete(String id) throws Exception {

	}
}
