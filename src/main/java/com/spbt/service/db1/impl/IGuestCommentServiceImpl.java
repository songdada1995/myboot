package com.spbt.service.db1.impl;

import com.spbt.entity.db1.GuestComment;
import com.spbt.mapper.db1.GuestCommentMapper;
import com.spbt.query.db1.GuestCommentQuery;
import com.spbt.service.db1.IGuestCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IGuestCommentServiceImpl implements IGuestCommentService {

    @Autowired
    private GuestCommentMapper guestCommentMapper;

    @Override
    public List<GuestComment> serach(GuestCommentQuery query) throws Exception {
        return guestCommentMapper.selectList(query);
    }
}
