package com.example.demo.exception;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

import org.quartz.SchedulerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 当发现BizException之时，系统会同意处理，给出合适异常提示。
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BizException.class)
	public ResponseEntity<String> handleBizException(BizException e) {
		log.info("catch the bizException:" + e.getMessage() + "," + e.getErrorCode());
		return new ResponseEntity<>("请检查后重试! (" + e.getMessage() + "/" + e.getErrorCode() + ")", HttpStatus.OK);
	}
	
// 	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleInteralError(Exception e) {
//		log.info("catch exception:" + e.getMessage() );
//		return new ResponseEntity<>("订单操作异常，请检查后重试! (" + e.getMessage() + ")", HttpStatus.OK);
//	} 
	
	/**
	 * 空指针错误异常处理
	 * @param e
	 * @return 返回json数据
	 */
 	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Map<String,String>> handleInteralError(Exception e) {
		log.info("catch exception:" + e.getMessage() );
		Map<String,String> map=new HashMap<String,String>();
		map.put("msg", "订单操作异常");
		map.put("error", e.getMessage());
		return new ResponseEntity<>(map, HttpStatus.OK);
	} 
 	
 	/**
 	 * 数据库错误异常
 	 * @param e
 	 * @return
 	 */
 	@ExceptionHandler(BadSqlGrammarException.class)
	public ResponseEntity<String> handleSQLError(Exception e) {
		log.info("catch exception:" + e.getMessage() );
		return new ResponseEntity<>("数据库异常 (" + e.getMessage() + ")", HttpStatus.OK);
	} 
 	
 	/**
 	 * 定时任务异常
 	 * @param e
 	 * @return
 	 */
 	@ExceptionHandler(SchedulerException.class)
	public ResponseEntity<String> handleJobError(Exception e) {
		log.info("catch exception:" + e.getMessage() );
		return new ResponseEntity<>("定时任务异常 (" + e.getMessage() + ")", HttpStatus.OK);
	} 
 	
 	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<String> handleConnectError(Exception e) {
		log.info("catch exception:" + e.getMessage() );
		return new ResponseEntity<>("连接 (" + e.getMessage() + ")", HttpStatus.OK);
	} 
}
