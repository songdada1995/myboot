package com.spbt.service.db1.impl;

import com.spbt.mapper.db1.Db1UserMapper;
import com.spbt.service.db1.IDb1UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author songbo
 * @Date 2019/12/10 17:51
 * @Version 1.0
 */
@Service
public class Db1UserServiceImpl implements IDb1UserService {

    @Autowired
    private Db1UserMapper db1UserMapper;

    public String getUserName(Integer id) throws Exception {
        return db1UserMapper.getUserNameById(id);
    }
}
