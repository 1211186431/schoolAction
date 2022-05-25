package com.example.demo.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.entity.ActionResult;
import com.example.demo.dao.entity.ActionResultExample;
import com.example.demo.dao.mapper.ActionResultMapper;
import com.example.demo.service.ActionResultService;
@Service
public class ActionResultServiceImpl implements ActionResultService {
	@Autowired
	private ActionResultMapper actionResultMapper;

	@Override
	public String updateResult(ActionResult actionResult) {
		// TODO Auto-generated method stub
		this.actionResultMapper.updateByPrimaryKey(actionResult);
		return "更新成功";
	}

	@Override
	public ActionResult getResultByResultId(int resultId) {
		// TODO Auto-generated method stub
		return this.actionResultMapper.selectByPrimaryKey(resultId);
	}

	@Override
	public ActionResult getResultByTaskId(int taskId) {
		// TODO Auto-generated method stub
		ActionResultExample example=new ActionResultExample();
		ActionResultExample.Criteria criteria=example.createCriteria();
		criteria.andTaskIdEqualTo(taskId);
		return this.actionResultMapper.selectByExample(example).get(0);
	}

	@Override
	public String insertResult(String top, int taskId) {
		// TODO Auto-generated method stub
		ActionResult result=new ActionResult();
		result.setTaskId(taskId);
		result.setIsRight(0);
		String[] topResult=top.split(";");  //action,0.9;action,0.9;action,0.9
		String top1Acc=topResult[0].split(",")[1];
		if(Float.parseFloat(top1Acc)>0.8){  //通过top1的acc判断是否危险
			result.setIsDanger(1);
		}else
			result.setIsDanger(-1);
		result.setResultDate(new Date());
		result.setState(1);
		result.setTop1(topResult[0]);
		result.setTop2(topResult[1]);
		result.setTop3(topResult[2]);
		result.setTop4(topResult[3]);
		result.setTop5(topResult[4]);
		this.actionResultMapper.insert(result);
		return "创建成功";
	}

}
