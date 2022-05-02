package com.dartmedia.dmss.service;

import com.dartmedia.dmss.dto.CommonCode;
import org.springframework.stereotype.Repository;

import com.dartmedia.dmss.mapper.CommonCodeMapper;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CommonCodeService implements CommonCodeMapper {

    @Resource(name="commonCodeMapper")
    CommonCodeMapper mapper;

    @Override
    public void create(CommonCode t) throws Exception {
        mapper.create(t);
    }

    @Override
    public List<CommonCode> findAll() throws Exception {
        //listAll()의 메소드명과 mapper.xml과 id는 동일해야한다.
        return mapper.findAll();
    }

    @Override
    public CommonCode read(String CommonName) throws Exception {
        return mapper.read(CommonName);
    }

    @Override
    public void update(CommonCode t) throws Exception {
        mapper.update(t);
    }

    @Override
    public void delete(String CommonName) throws Exception {
        mapper.delete(CommonName);
    }

    @Override
    public List<CommonCode> readByClassCode(String keyword) throws Exception {
        return mapper.readByClassCode(keyword);
    }
    @Override
    public List<CommonCode> readOptionData() throws Exception {
        return mapper.readOptionData();
    }
}
