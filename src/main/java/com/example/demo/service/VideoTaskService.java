package com.example.demo.service;



import org.springframework.boot.configurationprocessor.json.JSONException;

import com.example.demo.dao.PageResult;
import com.example.demo.dao.entity.VideoTask;

public interface VideoTaskService {
	/**
	 * 添加任务
	 * @param task
	 * @return
	 */
	public String insertTask(VideoTask task);
	
	/**
	 * 将任务信息上传到服务器
	 * @param task
	 * @return
	 */
	public String uploadTask(VideoTask task) throws JSONException;
	
	public VideoTask getTaskByTaskId(int taskId);
	
	/**
	 * 获取用户所有任务
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult<?> getTaskByUserId(int userId,int pageNum,int pageSize,int radio,String taskName,Boolean[] checked);
	
	/**
	 * 获取用户未完成任务
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult<?> getNotOverTaskByUserId(int userId,int pageNum,int pageSize,int radio,String taskName,Boolean[] checked);
	
	/**
	 * 获取用户已完成的任务
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult<?> getOverTaskByUserId(int userId,int pageNum,int pageSize,int radio,String taskName,Boolean[] checked);
	
	/**
	 * 更新任务进度/图片
	 * @param taskId
	 * @param taskState
	 * @return
	 */
	public String updateTaskState(int taskId,int taskState,String imgPath);
	
	/**
	 * 更新任务结果
	 * @param taskId
	 * @param filePath
	 * @param top1
	 * @return
	 */
	public String updateTaskResult(int taskId,String filePath,String top1);
	/**
	 * 管理员获取全部任务
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult<?> getAllTask(int pageNum,int pageSize);
	
	/**
	 * 管理员获取错误视频
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult<?> getAllVideo(int pageNum,int pageSize);
	public String updateTask(VideoTask task);

}
