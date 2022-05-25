package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.entity.ActionResult;
import com.example.demo.responseData.ResponseData;
import com.example.demo.responseData.ResponseDataUtil;
import com.example.demo.service.ActionResultService;

@RestController
public class ActionResultController {
	@Autowired
	private ActionResultService actionResultSevice;
	
//	/**
//	 * 创建结果
//	 * @param actionResult
//	 * @return
//	 */
//	@PostMapping("/insertResult")
//	public ResponseData<String> insertResult(@RequestParam("top") String top,@RequestParam("taskId") int taskId) {
//		return ResponseDataUtil.buildSuccess(this.actionResultSevice.insertResult(top,taskId));
//	}
	
	
	/**
	 * 通过主键获取结果
	 * @param resultId
	 * @return
	 */
	@GetMapping("/getResultByResultId")
	public ResponseData<ActionResult> getResultByResultId(@RequestParam("resultId") int resultId) {
		return ResponseDataUtil.buildSuccess("200","成功",this.actionResultSevice.getResultByResultId(resultId));
	}
	
	
	/**
	 * 
	 * @param actionResult
	 * @return
	 */
	@PostMapping("/updateResult")
	public ResponseData<String> updateResult(@RequestBody ActionResult actionResult) {
		return ResponseDataUtil.buildSuccess(this.actionResultSevice.updateResult(actionResult));
	}
	
	/**
	 * 通过任务获取结果
	 * @param taskId
	 * @return
	 */
	@GetMapping("/getResultByTaskId")
	public ResponseData<ActionResult> getResultByTaskId(@RequestParam("taskId") int taskId) {
		return ResponseDataUtil.buildSuccess("200","成功",this.actionResultSevice.getResultByTaskId(taskId));
	}
}
