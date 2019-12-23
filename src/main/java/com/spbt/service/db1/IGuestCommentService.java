package com.spbt.service.db1;

import com.spbt.entity.db1.GuestComment;
import com.spbt.query.db1.GuestCommentQuery;

import java.util.List;

public interface IGuestCommentService {
    /**
     * 列表查询
     * @param query
     * @return
     * @throws Exception
     */
    List<GuestComment> serach(GuestCommentQuery query) throws Exception;
}
