package com.dartmedia.dmss.mapper;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.Manager;

import java.util.List;


@MapperInterface
public interface ManagerMapper extends IMapper<Manager> {
    public List<Manager> getManagerListWithEmail() throws Exception;
    public void updateManager(Manager manager) throws Exception;
    public List<Manager> getManagerListByFuncIdWithEmail(int funcId) throws Exception;
}
