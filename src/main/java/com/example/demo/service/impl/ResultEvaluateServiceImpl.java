package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.PageResult;
import com.example.demo.dao.entity.ActionResult;
import com.example.demo.dao.entity.ActionResultExample;
import com.example.demo.dao.entity.ResultEvaluate;
import com.example.demo.dao.entity.ResultEvaluateExample;
import com.example.demo.dao.entity.VideoTask;
import com.example.demo.dao.mapper.ActionResultMapper;
import com.example.demo.dao.mapper.ResultEvaluateMapper;
import com.example.demo.dao.mapper.VideoTaskMapper;
import com.example.demo.service.ResultEvaluateService;
import com.example.demo.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ResultEvaluateServiceImpl implements ResultEvaluateService {
	@Autowired
	private ResultEvaluateMapper resultEvaluateMapper;

	@Autowired
	private VideoTaskMapper videoTaskMapper;

	@Autowired
	private ActionResultMapper actionResultMapper;

	@Override
	public String insertEvaluate(ResultEvaluate resultEvaluate) {
		// TODO Auto-generated method stub
		this.resultEvaluateMapper.insert(resultEvaluate);
		this.videoTaskMapper.updateIsRight(resultEvaluate.getTaskId(), resultEvaluate.getIsTrue());
		this.actionResultMapper.updateIsRight(resultEvaluate.getResultId(), resultEvaluate.getIsTrue());
		return "创建成功";
	}

	@Override
	public String updateEvaluate(ResultEvaluate resultEvaluate) {
		// TODO Auto-generated method stub
		this.resultEvaluateMapper.updateByPrimaryKey(resultEvaluate);
		this.videoTaskMapper.updateIsRight(resultEvaluate.getTaskId(), resultEvaluate.getIsTrue());
		return "更新成功";
	}

	@Override
	public ResultEvaluate getEvaluateByEvaluateId(int evaluateId) {
		// TODO Auto-generated method stub
		return this.resultEvaluateMapper.selectByPrimaryKey(evaluateId);
	}

	@Override
	public ResultEvaluate getEvaluateByResultId(int resultId) {
		// TODO Auto-generated method stub
		ResultEvaluateExample example = new ResultEvaluateExample();
		ResultEvaluateExample.Criteria criteria = example.createCriteria();
		criteria.andResultIdEqualTo(resultId);
		return this.resultEvaluateMapper.selectByExample(example).get(0);
	}

	@Override
	public Map<String, Object> getEvaluateByTaskId(int taskId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();

		ResultEvaluateExample example = new ResultEvaluateExample();
		ResultEvaluateExample.Criteria criteria = example.createCriteria();
		criteria.andTaskIdEqualTo(taskId);
		List<ResultEvaluate> r = this.resultEvaluateMapper.selectByExample(example);
        if(r.size()==0) {
        	map.put("haveEval", -1);
        }
        else {
        	map.put("haveEval", 1);
        	map.put("ResultEvaluate", r.get(0));
        }
  
		VideoTask v = this.videoTaskMapper.selectByPrimaryKey(taskId);
		map.put("VideoTask", v);

		ActionResultExample example2 = new ActionResultExample();
		ActionResultExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andTaskIdEqualTo(taskId);
		ActionResult a = this.actionResultMapper.selectByExample(example2).get(0);
		map.put("ActionResult", a);
		return map;
	}

	@Override
	public PageResult<?> getEvaluateByUserId(int userId, int pageNum, int pageSize,int radio,String taskName) {
		// TODO Auto-generated method stub
		ResultEvaluateExample example = new ResultEvaluateExample();
		ResultEvaluateExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andTaskNameLike("%"+taskName+"%");
		if(radio==1)
			example.setOrderByClause("create_date DESC");
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<ResultEvaluate> pageInfos = new PageInfo<>(this.resultEvaluateMapper.selectByExample(example));
		return PageUtils.getPageResult(pageInfos);
	}

	@Override
	public PageResult<?> getAllEvaluate(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		ResultEvaluateExample example = new ResultEvaluateExample();
		ResultEvaluateExample.Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo(1);
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<ResultEvaluate> pageInfos = new PageInfo<>(this.resultEvaluateMapper.selectByExample(example));
		return PageUtils.getPageResult(pageInfos);
	}

}
