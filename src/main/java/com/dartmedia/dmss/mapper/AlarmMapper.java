package com.dartmedia.dmss.mapper;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.Alarm;

import java.util.List;

@MapperInterface
public interface AlarmMapper extends IMapper<Alarm> {
    public List<Alarm> findAddAccountAlarm() throws Exception;
    public Alarm readByFuncId(int funcId) throws Exception;
    public void delete(int funcId) throws Exception;
}
