package com.spbt.core;

import java.util.List;
import java.util.Map;

/**
 * 
 * BaseDAO
 * @param <T>
 */
public interface BaseMapper <T> {

	/**
	 * 新增
	 * @param t
	 * @return 影响记录条数 
	 */
	int add(T t) throws Exception;
	
	/**
	 * 修改
	 * @param t
	 * @return 影响记录条数 
	 */
	int update(T t)throws Exception;
	
	/**
	 * 根据主键删除
	 * @param  id
	 * @return 影响记录条数
	 */
	int delete(String id)throws Exception;
	
	/**
	 * 根据主键删除
	 * @param id
	 * @return 影响记录条数
	 */
	int delete(int id)throws Exception;
	
	/**
	 * 删除
	 * @param t
	 * @return 影响记录条数 
	 */
	int delete(T t)throws Exception;
	
	/**
	 * 删除
	 * @param param
	 * @return 影响记录条数 
	 */
	@SuppressWarnings("rawtypes")
	int deleteParam(Map param)throws Exception;
	
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return 实体
	 */
	T findById(String id)throws Exception;
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return 实体
	 */
	T findById(int id)throws Exception;
	
	/**
	 * 根据名称查询
	 * @param name
	 * @return 实体
	 */
	T findByName(String name)throws Exception;
	
	/**
	 * 根据参数查询
	 * @param param
	 * @return 实体
	 */
	@SuppressWarnings("rawtypes")
	T findByParam(Map param)throws Exception;
	
	/**
	 * 根据参数查询
	 * @param t
	 * @return 实体
	 */
	T findByParam(T t)throws Exception;
	
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll()throws Exception;
	
	/**
	 * 查询所有
	 * @param t
	 * @return T
	 */
	List<T> findAll(T t)throws Exception;
	
	/**
	 * 查询记录数
	 * @param t
	 * @return
	 */
	int findRecordSize(T t)throws Exception;
	
	/**
	 * 查询所有
	 * @param param
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<T> findAll(Map param)throws Exception;
	
	/**  
     * 批量插入  
     * @param list  
     * @return
     */    
    int insertBatch(List<T> list)throws Exception;    
        
    /**  
     * 批量修改  
     * @param list  
     * @return
     */    
     int updateBatch(List<T> list)throws Exception;    
        
    /**  
     * 批量删除  
     * @param ids
     * @return
     */    
     int deleteBatch(int[] ids)throws Exception; 
	
     /**  
      * 批量删除  
      * @param ids
      * @return
      */    
      int deleteBatch(String[] ids)throws Exception; 
	
}
