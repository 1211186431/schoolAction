package com.example.demo.orderJob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.entity.VideoTask;
import com.example.demo.service.VideoTaskService;

import lombok.extern.slf4j.Slf4j;

/**
 * 更新任务图片和状态
 * @author dy-xx
 *
 */
@Component
@Slf4j
public class updateTaskStateJob extends QuartzJobBean {
	VideoTask v;

	public VideoTask getv() {
		return v;
	}

	public void setO(VideoTask v) {
		this.v = v;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		VideoTaskService videoTaskService=ApplicationContextUtil.getApplicationContext().getBean(VideoTaskService.class);
		RestTemplate restTemplate = new RestTemplate();
		//String url = "http://localhost:8081/uploadTask";
		String url = "http://59.64.78.254:16224/job1";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		JSONObject jsonObj = new JSONObject();
		HttpEntity<String> entity = new HttpEntity<>(jsonObj.toString(), headers);
		ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		//JSONObject j=JSONObject.fromObject();
		String jobData=exchange.getBody();
		log.info(jobData);
		if(!jobData.equals("none")) {
			String[] taskData=jobData.split(",");
			int taskState=Integer.parseInt(taskData[1]);  
			int taskId=Integer.parseInt(taskData[0]);
			String imgPath=taskData[2];
			videoTaskService.updateTaskState(taskId, taskState,imgPath);
		}
		log.info("任务完成");
	}
}
