package com.dartmedia.dmss.mapper;

import com.dartmedia.dmss.core.IMapper;
import com.dartmedia.dmss.core.MapperInterface;
import com.dartmedia.dmss.dto.CommonCode;

import java.util.List;

@MapperInterface
public interface CommonCodeMapper extends IMapper<CommonCode>{
    public List<CommonCode> readByClassCode(String keyword) throws Exception;
    public List<CommonCode> readOptionData() throws Exception;
}
