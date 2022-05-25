package com.example.demo.controller;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PageResult;
import com.example.demo.dao.entity.ResultEvaluate;
import com.example.demo.responseData.ResponseData;
import com.example.demo.responseData.ResponseDataUtil;
import com.example.demo.service.ResultEvaluateService;

@RestController
public class ResultEvaluateController {
	@Autowired
	private ResultEvaluateService resultEvaluateService;
	
	@PostMapping("/insertEvaluate")
	public ResponseData<String> insertEvaluate(@RequestBody ResultEvaluate resultEvaluate) {
		return ResponseDataUtil.buildSuccess(this.resultEvaluateService.insertEvaluate(resultEvaluate));
	}
	
	@PostMapping("/updateEvaluate")
	public ResponseData<String> updateEvaluate(@RequestBody ResultEvaluate resultEvaluate) {
		return ResponseDataUtil.buildSuccess(this.resultEvaluateService.updateEvaluate(resultEvaluate));
	}
	
	/**
	 * 获取评价信息
	 * @param evaluateId
	 * @return
	 */
	@GetMapping("/getEvaluateByEvaluateId")
	public ResponseData<ResultEvaluate> getEvaluateByEvaluateId(@RequestParam("evaluateId")int evaluateId) {
		return ResponseDataUtil.buildSuccess("200","成功",this.resultEvaluateService.getEvaluateByEvaluateId(evaluateId));
	}
	
    /**
     * 通过taskid获取所有
     * @param taskId
     * @return
     */
	@GetMapping("/getEvaluateByTaskId")
	public ResponseData<Map<String,Object>> getEvaluateByTaskId(@RequestParam("taskId")int taskId) {
		return ResponseDataUtil.buildSuccess("200","成功",this.resultEvaluateService.getEvaluateByTaskId(taskId));
	}
	
	/**
	 * 获取评价列表
	 * @param userId
	 * @return
	 */
	@GetMapping("/getEvaluateByUserId")
	public ResponseData<PageResult<?>> getEvaluateByUserId(@RequestParam("userId")int userId,@RequestParam(value = "pageNum", required = false, defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,@RequestParam("radio")int radio,@RequestParam("name")String name) {
		return ResponseDataUtil.buildSuccess("200","成功",this.resultEvaluateService.getEvaluateByUserId(userId, pageNum, pageSize,radio,name));
	}
	
	/**
	 * 获取全部的评价
	 * @param userId
	 * @return
	 */
	@GetMapping("/admin/getAllEvaluate")
	public ResponseData<PageResult<?>> getAllEvaluate(@RequestParam(value = "pageNum", required = false, defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize) {
		return ResponseDataUtil.buildSuccess("200","成功",this.resultEvaluateService.getAllEvaluate(pageNum, pageSize));
	}
}
