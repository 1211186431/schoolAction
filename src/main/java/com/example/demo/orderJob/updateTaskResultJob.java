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
 * 更新任务视频和结果
 * @author dy-xx
 *
 */
@Component
@Slf4j
public class updateTaskResultJob extends QuartzJobBean {
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
		String url = "http://59.64.78.254:16224/job3";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		JSONObject jsonObj = new JSONObject();
		HttpEntity<String> entity = new HttpEntity<>(jsonObj.toString(), headers);
		ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		//JSONObject j=JSONObject.fromObject();
		String jobData=exchange.getBody();
		if(!jobData.equals("none")) {
			String[] taskData=jobData.split(","); 
			int taskId=Integer.parseInt(taskData[0]);
			String filePath=taskData[1];
			String top1=taskData[2];
			videoTaskService.updateTaskResult(taskId, filePath, top1);
		}
		log.info("任务完成3");
	}
}
