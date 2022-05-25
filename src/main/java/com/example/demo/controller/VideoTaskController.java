package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.PageResult;
import com.example.demo.dao.entity.VideoTask;
import com.example.demo.responseData.ResponseData;
import com.example.demo.responseData.ResponseDataUtil;
import com.example.demo.service.VideoTaskService;

@RestController
public class VideoTaskController {
	@Autowired
	private VideoTaskService videoTaskService;

	/**
	 * 添加任务
	 * 
	 * @param videoTask
	 * @return
	 * @throws JSONException
	 */
	@PostMapping("/insertTask")
	public ResponseData<String> insertTask(@RequestBody VideoTask videoTask) throws JSONException {
		String t = this.videoTaskService.insertTask(videoTask);
		String t2 = this.videoTaskService.uploadTask(videoTask);
		if (t.equals("创建成功")) {
			if (t2.equals("suss")) {
				return ResponseDataUtil.buildSuccess("200", "创建成功", null);
			}
		}
		return ResponseDataUtil.buildError("401", "错误请重试", null);

	}

	/**
	 * 通过任务id获取结果
	 * 
	 * @param taskId
	 * @return
	 */
	@GetMapping("/getTaskByTaskId")
	public ResponseData<VideoTask> getTaskByTaskId(@RequestParam("taskId") int taskId) {
		return ResponseDataUtil.buildSuccess("200", "返回成功", this.videoTaskService.getTaskByTaskId(taskId));
	}

	/**
	 * 获取用户全部任务,分页返回
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/getTaskByUserId")
	public ResponseData<PageResult<?>> getTaskByUserId(@RequestParam("userId") int userId,
			@RequestParam(value = "pageNum", required = false, defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
			@RequestParam("radio") int radio, @RequestParam("taskName") String taskName,
			@RequestParam("checked1") Boolean checked1, @RequestParam("checked2") Boolean checked2,
			@RequestParam("checked3") Boolean checked3, @RequestParam("checked4") Boolean checked4) {
		Boolean[] checked = { checked1, checked2, checked3, checked4 };
		return ResponseDataUtil.buildSuccess("200", "返回成功",
				this.videoTaskService.getTaskByUserId(userId, pageNum, pageSize, radio, taskName, checked));
	}

	/**
	 * 获取未完成任务,分页返回
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/getNotOverTaskByUserId")
	public ResponseData<PageResult<?>> getNotOverTaskByUserId(@RequestParam("userId") int userId,
			@RequestParam(value = "pageNum", required = false, defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
			@RequestParam("radio") int radio, @RequestParam("taskName") String taskName,
			@RequestParam("checked1") Boolean checked1, @RequestParam("checked2") Boolean checked2,
			@RequestParam("checked3") Boolean checked3, @RequestParam("checked4") Boolean checked4) {
		Boolean[] checked = { checked1, checked2, checked3, checked4 };
		return ResponseDataUtil.buildSuccess("200", "返回成功",
				this.videoTaskService.getNotOverTaskByUserId(userId, pageNum, pageSize, radio, taskName, checked));
	}

	/**
	 * 获取已完成任务,分页返回
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/getOverTaskByUserId")
	public ResponseData<PageResult<?>> getOverTaskByUserId(@RequestParam("userId") int userId,
			@RequestParam(value = "pageNum", required = false, defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
			@RequestParam("radio") int radio, @RequestParam("taskName") String taskName,
			@RequestParam("checked1") Boolean checked1, @RequestParam("checked2") Boolean checked2,
			@RequestParam("checked3") Boolean checked3, @RequestParam("checked4") Boolean checked4) {
		Boolean[] checked = { checked1, checked2, checked3, checked4 };
		return ResponseDataUtil.buildSuccess("200", "返回成功",
				this.videoTaskService.getOverTaskByUserId(userId, pageNum, pageSize, radio, taskName, checked));
	}

	/**
	 * 管理员获取全部任务
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/admin/getAllTask")
	public ResponseData<PageResult<?>> getgetAllTask(
			@RequestParam(value = "pageNum", required = false, defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize) {
		return ResponseDataUtil.buildSuccess("200", "返回成功", this.videoTaskService.getAllTask(pageNum, pageSize));
	}

	/**
	 * 管理员获取全部任务
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/admin/getAllVideo")
	public ResponseData<PageResult<?>> getgetAllVideo(
			@RequestParam(value = "pageNum", required = false, defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize) {
		return ResponseDataUtil.buildSuccess("200", "返回成功", this.videoTaskService.getAllVideo(pageNum, pageSize));
	}
//	/**
//	 * 更新任务结果
//	 * @param videoTask
//	 * @return
//	 */
//	@PostMapping("/updateTaskResult")
//	public ResponseData<String> updateTaskResult(@RequestParam("taskId")int taskId, @RequestParam("filePath")String filePath,@RequestParam("top1") String top1) {
//		return ResponseDataUtil.buildSuccess(this.videoTaskService.updateTaskResult(taskId, filePath, top1));
//	}
//	
	/**
	 * 将任务状态更新/图片
	 * 
	 * @param taskId
	 * @return
	 */
//	@PostMapping("/updateTaskState")
//	public ResponseData<String> updateTaskState(@RequestParam("taskId")int taskId,@RequestParam("taskState")int taskState,@RequestParam("imgPath")String imgPath) {
//		return ResponseDataUtil.buildSuccess(this.videoTaskService.updateTaskState(taskId, taskState,imgPath));
//	}

}
