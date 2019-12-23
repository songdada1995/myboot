package com.spbt.mapper.db1;

import com.spbt.entity.db1.GuestComment;
import com.spbt.query.db1.GuestCommentQuery;

import java.util.List;

public interface GuestCommentMapper {

    /**
     * 查询列表
     * @param query
     * @return
     * @throws Exception
     */
    List<GuestComment> selectList(GuestCommentQuery query) throws Exception;
}
