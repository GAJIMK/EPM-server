package com.dartmedia.dmss.service;

import com.dartmedia.dmss.dto.TAccount;
import com.dartmedia.dmss.mapper.TAccountMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Mybatis에 사용
 * AccountMapper를 구현
 * Mybatis가 자동으로 매핑한 AccountMapper의 
 */
@Repository
public class TAccountService implements TAccountMapper {

    @Resource(name="TAccountMapper")
    TAccountMapper mapper;
    
    @Override
    public void create(TAccount t) throws Exception {
        mapper.create(t);
    }

    @Override
    public List<TAccount> findAll() throws Exception {
        //listAll()의 메소드명과 mapper.xml과 id는 동일해야한다.
        return mapper.findAll();
    }

    @Override
    public TAccount read(String id) throws Exception {
        return mapper.read(id);
    }

    @Override
    public void update(TAccount t) throws Exception {
        mapper.update(t);
    }

    @Override
    public void updateAccountNm(TAccount taccount) throws Exception {
        mapper.updateAccountNm(taccount);
    }

    @Override
    public void updateAccountId(TAccount taccount) throws Exception {
        mapper.updateAccountId(taccount);
    }

    @Override
    public void updateEmail(TAccount taccount) throws Exception {
        mapper.updateEmail(taccount);
    }

    @Override
    public void updatePassword(TAccount taccount) throws Exception {
        mapper.updatePassword(taccount);
    }

    @Override
    public void delete(String id) throws Exception {
        mapper.delete(id);
    }
    @Override
    public List<TAccount> findAccountsByIdNo(String idNo) throws Exception{
        return mapper.findAccountsByIdNo(idNo);
    }
    @Override
    public TAccount findAccountByEmail(String email) throws Exception{
        return mapper.findAccountByEmail(email);
    }
    
    @Override
    public List<TAccount> findAccountByIdNoAndAccountNm(String accountInfo) throws Exception{
        return mapper.findAccountByIdNoAndAccountNm(accountInfo);
    }

    @Override
    public List<TAccount> findAccountByIdNoAndAccountNmWithAppoint(String accountInfo) throws Exception {
        return mapper.findAccountByIdNoAndAccountNmWithAppoint(accountInfo);
    }
}
