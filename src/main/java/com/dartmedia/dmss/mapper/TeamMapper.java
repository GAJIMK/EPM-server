package com.dartmedia.dmss.mapper;

import java.util.List;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.Team;

@MapperInterface
public interface TeamMapper extends IMapper<Team>{
    public void deleteByTeamNo (short teamNo) throws Exception;
    public Team readByTeamNo (short teamNo) throws Exception;
    public List<Team> find() throws Exception;


}
