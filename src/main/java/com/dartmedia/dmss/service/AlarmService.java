package com.dartmedia.dmss.service;

import com.dartmedia.dmss.dto.Alarm;
import com.dartmedia.dmss.mapper.AlarmMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class AlarmService implements AlarmMapper {

    @Resource(name="alarmMapper")
    AlarmMapper mapper;

    @Override
    public void create(Alarm alarm) throws Exception {
        mapper.create(alarm);
    }

    @Override
    public List<Alarm> findAll() throws Exception {
        //listAll()의 메소드명과 mapper.xml과 id는 동일해야한다.
        return mapper.findAll();
    }

    @Override
    public Alarm read(String funcId) throws Exception {
        return mapper.read(funcId);
    }

    @Override
    public void update(Alarm alarm) throws Exception {
        mapper.update(alarm);
    }

    @Override
    public void delete(String id) throws Exception {

    }

    @Override
    public void delete(int funcId) throws Exception {
        mapper.delete(funcId);
    }
    @Override
    public List<Alarm> findAddAccountAlarm() throws Exception {
        return mapper.findAddAccountAlarm();
    }

    @Override
    public Alarm readByFuncId(int funcId) throws Exception {
        return mapper.readByFuncId(funcId);
    }
}
