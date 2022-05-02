package com.dartmedia.dmss.service;

import com.dartmedia.dmss.dto.Request;
import com.dartmedia.dmss.mapper.RequestMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class RequestService implements RequestMapper {

    @Resource(name="requestMapper")
    RequestMapper mapper;

    @Override
    public void create(Request request) throws Exception {
        mapper.create(request);
    }

    @Override
    public List<Request> findAll() throws Exception {
        return mapper.findAll();
    }

    @Override
    public Request read(String id) throws Exception {
        return mapper.read(id);
    }

    @Override
    public void update(Request request) throws Exception {

    }

    @Override
    public void delete(String id) throws Exception {

    }

    @Override
    public void deleteByRequestId(int requestId) throws Exception {
        mapper.deleteByRequestId(requestId);
    }

    @Override
    public Request readByRequestId(int requestId) throws Exception{
        return mapper.readByRequestId(requestId);
    }
}
