package com.dartmedia.dmss.mapper;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.TAccount;

import java.util.List;

/**
 * Mybatis에 사용
 * IMapper에 기본적으로 설정된 함수를 사용하며
 * IMapper에 없는 추가적으로 필요한 조회,수정기능이 필요한 경우 여기에 추가
 * Mybatis에서 resources/mapper/AccountMapper.xml 이랑 매핑하여 DB 동작을 자동으로 구현해줌
 */
@MapperInterface
public interface TAccountMapper extends IMapper<TAccount>{
    public List<TAccount> findAccountsByIdNo(String idNo) throws Exception;

    public List<TAccount> findAccountByIdNoAndAccountNm(String accountInfo) throws Exception;
    public void updateAccountNm (TAccount taccount) throws Exception;
    public void updateAccountId (TAccount taccount) throws Exception;
    public void updateEmail (TAccount taccount) throws Exception;
    public TAccount findAccountByEmail(String email) throws Exception;
    public void updatePassword(TAccount taccount) throws Exception;
    public List<TAccount> findAccountByIdNoAndAccountNmWithAppoint(String accountInfo) throws Exception;
}
