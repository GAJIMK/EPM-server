package com.dartmedia.dmss.service;

import com.dartmedia.dmss.dto.TAccount;
import com.dartmedia.dmss.dto.TAppoint;
import com.dartmedia.dmss.mapper.TAppointMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Repository
public class TAppointService implements TAppointMapper {
    @Resource(name="TAppointMapper")
    TAppointMapper mapper;

    @Override
    public void create(TAppoint t) throws Exception {
        mapper.create(t);
    }

    @Override
    public TAppoint read(String idNo) throws Exception{
        return mapper.read(idNo);
    }

    @Override
    public void update(TAppoint t) throws Exception {
        mapper.update(t);
    }

    @Override
    public void delete(String id) throws Exception {
        mapper.delete(id);
    }

    @Override
    public List<TAppoint> findAll() throws Exception {
        //listAll()의 메소드명과 mapper.xml과 id는 동일해야한다.
        return mapper.findAll();
    }
    @Override
    public List<TAppoint> findById(String idNo) throws Exception{
        return mapper.findById(idNo);
    }
    @Override
    public List<TAppoint> findByPublishDay(Date date) throws Exception {
        //listAll()의 메소드명과 mapper.xml과 id는 동일해야한다.
        return mapper.findByPublishDay(date);
    }
    @Override
    public List<TAppoint> findByTeamNo(short TeamNo) throws Exception {
        //listAll()의 메소드명과 mapper.xml과 id는 동일해야한다.
        return mapper.findByTeamNo(TeamNo);
    }
    @Override
    public List<TAppoint> findByTpPosition(short tpPosition) throws Exception {
        //listAll()의 메소드명과 mapper.xml과 id는 동일해야한다.
        return mapper.findByTpPosition(tpPosition);
    }
    @Override
    public List<TAppoint> findByAuthority() throws Exception {
        //listAll()의 메소드명과 mapper.xml과 id는 동일해야한다.
        return mapper.findByAuthority();
    }


}
