package com.example.demo.service;


import java.util.Map;

import com.example.demo.dao.PageResult;
import com.example.demo.dao.entity.ResultEvaluate;

public interface ResultEvaluateService {
	/**
	 * 插入评价，更新
	 * @param resultEvaluate
	 * @return
	 */
	public String insertEvaluate(ResultEvaluate resultEvaluate);
	
	public String updateEvaluate(ResultEvaluate resultEvaluate);
	
	/**
	 * 获取评价
	 * @param evaluateId
	 * @return
	 */
	public ResultEvaluate getEvaluateByEvaluateId(int evaluateId);
	
	public ResultEvaluate getEvaluateByResultId(int resultId);
	
	/**
	 * 通过taskId获取所有
	 * @param taskId
	 * @return
	 */
	public Map<String,Object> getEvaluateByTaskId(int taskId);
	
	/**
	 * 获取用户的所有评价
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult<?> getEvaluateByUserId(int userId,int pageNum, int pageSize,int radio,String name);
	
	/**
	 * 获取全部的评价
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult<?> getAllEvaluate(int pageNum, int pageSize);

}
