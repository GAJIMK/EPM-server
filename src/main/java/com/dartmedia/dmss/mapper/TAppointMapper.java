package com.dartmedia.dmss.mapper;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.TAppoint;

import java.util.Date;
import java.util.List;
@MapperInterface
public interface TAppointMapper extends IMapper<TAppoint> {
    public List<TAppoint> findById(String idNo) throws Exception;
    public List<TAppoint> findByPublishDay(Date date) throws Exception;
    public List<TAppoint> findByTeamNo(short TeamNo) throws Exception;
    public List<TAppoint> findByTpPosition(short tpPosition) throws Exception;
    public List<TAppoint> findByAuthority() throws Exception;

}
