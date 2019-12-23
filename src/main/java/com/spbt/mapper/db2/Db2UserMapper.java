package com.spbt.mapper.db2;

import com.spbt.entity.db2.Db2User;
import com.spbt.core.BaseMapper;

/**
 * @Author songbo
 * @Date 2019/12/10 17:53
 * @Version 1.0
 */
public interface Db2UserMapper extends BaseMapper<Db2User> {

	/**
	 * 根据id获取用户名
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String getUserNameById(Integer id) throws Exception;
}
