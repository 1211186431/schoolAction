package com.example.demo.orderJob;

import java.util.HashMap;
import java.util.Map;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.demo.util.TestPing;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JobTest {
	@Autowired
	QuartzConfig quartz;
	
	@Autowired
	TestPing testPing;
	@Bean
	public void MyJob() throws InterruptedException, SchedulerException, JSONException {
		Map<String,Object> map1=new HashMap<String,Object>();
		Map<String,Object> map2=new HashMap<String,Object>();
		Map<String,Object> map3=new HashMap<String,Object>();
		if(testPing.TestConfiguration().equals("suss")){
			quartz.task(new updateTaskResultJob(), map3, "updateTaskResultJob",60);
			quartz.task(new updateTaskStateJob(), map1, "updateTaskStateJob",60); //30s
			quartz.task(new insertResultJob(), map2, "insertResultJob",60);
			
		}else {
			log.info("服务器未开启");
		}

	}

}
