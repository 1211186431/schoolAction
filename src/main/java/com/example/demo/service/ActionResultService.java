package com.example.demo.service;

import com.example.demo.dao.entity.ActionResult;

public interface ActionResultService {
	/**
	 * 创建结果
	 * @param top
	 * @param taskId
	 * @return
	 */
	public String insertResult(String top,int taskId);
	
	public String updateResult(ActionResult actionResult);
	
	/**
	 * 通过主键获取结果
	 * @param resultId
	 * @return
	 */
	public ActionResult getResultByResultId(int resultId);
	
	
	/**
	 * 通过任务获取结果
	 * @param taskId
	 * @return
	 */
	public ActionResult getResultByTaskId(int taskId);
}
