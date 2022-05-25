package com.example.demo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.PageResult;
import com.example.demo.dao.entity.VideoTask;
import com.example.demo.dao.entity.VideoTaskExample;
import com.example.demo.dao.mapper.VideoTaskMapper;
import com.example.demo.service.VideoTaskService;
import com.example.demo.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class VideoTaskServiceImpl implements VideoTaskService {
	@Autowired
	private VideoTaskMapper videoTaskMapper;

	@Override
	public String insertTask(VideoTask task) {
		// TODO Auto-generated method stub
		this.videoTaskMapper.insertTask(task);
		return "创建成功";
	}

	@Override
	public VideoTask getTaskByTaskId(int taskId) {
		// TODO Auto-generated method stub
		return this.videoTaskMapper.selectByPrimaryKey(taskId);
	}

	@Override
	public PageResult<?> getTaskByUserId(int userId, int pageNum, int pageSize, int radio, String taskName,
			Boolean[] checked) {
		// TODO Auto-generated method stub
		VideoTaskExample example = new VideoTaskExample();
		VideoTaskExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andTaskNameLike("%" + taskName + "%");
		this.setChecked(criteria, checked);
		if (radio == 1)
			example.setOrderByClause("create_date DESC");
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<VideoTask> pageInfos = new PageInfo<>(this.videoTaskMapper.selectByExample(example));
		return PageUtils.getPageResult(pageInfos);
	}

	@Override
	public String updateTask(VideoTask task) {
		// TODO Auto-generated method stub
		this.videoTaskMapper.updateByPrimaryKey(task);
		return "更新成功";
	}

	@Override
	public PageResult<?> getNotOverTaskByUserId(int userId, int pageNum, int pageSize, int radio, String taskName,Boolean[] checked) {
		// TODO Auto-generated method stub
		VideoTaskExample example = new VideoTaskExample();
		VideoTaskExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andTaskStateLessThan(3);
		criteria.andTaskNameLike("%" + taskName + "%");
		this.setChecked(criteria, checked);
		if (radio == 1)
			example.setOrderByClause("create_date DESC");
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<VideoTask> pageInfos = new PageInfo<>(this.videoTaskMapper.selectByExample(example));
		return PageUtils.getPageResult(pageInfos);
	}

	@Override
	public PageResult<?> getOverTaskByUserId(int userId, int pageNum, int pageSize, int radio, String taskName,Boolean[] checked) {
		// TODO Auto-generated method stub
		VideoTaskExample example = new VideoTaskExample();
		VideoTaskExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andTaskStateEqualTo(3);
		this.setChecked(criteria, checked);
		criteria.andTaskNameLike("%" + taskName + "%");
		if (radio == 1)
			example.setOrderByClause("create_date DESC");
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<VideoTask> pageInfos = new PageInfo<>(this.videoTaskMapper.selectByExample(example));
		return PageUtils.getPageResult(pageInfos);
	}

	@Override
	public String uploadTask(VideoTask task) throws JSONException {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		// String url = "http://localhost:8081/uploadTask";
		String url = "http://59.64.78.254:16224/uploadTask";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		JSONObject jsonObj = new JSONObject();
		// jsonObj.put("CreateDate", task.getCreateDate());
		jsonObj.put("FilePath", task.getFilePath());
		// jsonObj.put("IsDanger", task.getIsDanger());
		// jsonObj.put("IsRight", task.getIsRight());
		jsonObj.put("NeedDet", task.getNeedDet());
		jsonObj.put("NeedVideo", task.getNeedVideo());
		jsonObj.put("Priority", task.getPriority());
		jsonObj.put("ResultPath", task.getResultPath());
		// jsonObj.put("State", task.getState());
		jsonObj.put("TaskId", task.getTaskId());
		// jsonObj.put("TaskName", task.getTaskName());
		jsonObj.put("TaskState", task.getTaskState());
		// jsonObj.put("UpdateDate", task.getUpdateDate());
		jsonObj.put("UserId", task.getUserId());
		System.out.print(task.getTaskId());
		HttpEntity<String> entity = new HttpEntity<>(jsonObj.toString(), headers);
		ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		return exchange.getBody();
	}

	@Override
	public String updateTaskState(int taskId, int taskState, String imgPath) {
		// TODO Auto-generated method stub
		VideoTask task = this.getTaskByTaskId(taskId);
		if (task.getTaskState() != 3) {
			task.setTaskState(taskState);
		}
		task.setUpdateDate(new Date());
		task.setImgPath(imgPath);
		this.videoTaskMapper.updateByPrimaryKey(task);
		return "更新成功";
	}

	@Override
	public String updateTaskResult(int taskId, String filePath, String top1) {
		// TODO Auto-generated method stub
		VideoTask task = this.getTaskByTaskId(taskId);
		task.setUpdateDate(new Date());
		task.setTaskState(3);
		task.setResultPath(filePath);
		if (Float.parseFloat(top1) > 0.8) { // 通过top1的acc判断是否危险
			task.setIsDanger(1);
		} else
			task.setIsDanger(-1);
		this.videoTaskMapper.updateByPrimaryKey(task);
		return "更新成功";
	}

	@Override
	public PageResult<?> getAllTask(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		VideoTaskExample example = new VideoTaskExample();
		VideoTaskExample.Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo(1);
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<VideoTask> pageInfos = new PageInfo<>(this.videoTaskMapper.selectByExample(example));
		return PageUtils.getPageResult(pageInfos);
	}

	@Override
	public PageResult<?> getAllVideo(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		VideoTaskExample example = new VideoTaskExample();
		VideoTaskExample.Criteria criteria = example.createCriteria();
		criteria.andIsRightEqualTo(-1);
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<VideoTask> pageInfos = new PageInfo<>(this.videoTaskMapper.selectByExample(example));
		return PageUtils.getPageResult(pageInfos);
	}

	public void setChecked(VideoTaskExample.Criteria criteria, Boolean[] checked) {
		if (checked[0] == true && checked[1] == false) {
			criteria.andIsDangerEqualTo(1);
		}
		if (checked[1] == true && checked[0] == false) {
			criteria.andIsDangerEqualTo(-1);
		}
		if (checked[2] == true && checked[3] == false) {
			criteria.andIsRightNotEqualTo(0);
		}
		if (checked[3] == true && checked[2] == false) {
			criteria.andIsRightEqualTo(0);
		}
	}

}
