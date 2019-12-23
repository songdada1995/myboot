package com.spbt.service.db2.impl;

import com.spbt.mapper.db2.Db2UserMapper;
import com.spbt.service.db2.IDb2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author songbo
 * @Date 2019/12/10 17:53
 * @Version 1.0
 */
@Service
public class Db2UserServiceImpl implements IDb2UserService {

    @Autowired
    private Db2UserMapper db2UserMapper;

    /**
     * 获取用户名
     * @param id
     * @return
     * @throws Exception
     */
    public String getUserName(Integer id) throws Exception {
        return db2UserMapper.getUserNameById(id);
    }
}
