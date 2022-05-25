package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.ImageCode.ImageVerificationCode;
import com.example.demo.dao.entity.User;
import com.example.demo.responseData.ResponseData;
import com.example.demo.responseData.ResponseDataUtil;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 注册功能
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/register")
	public ResponseData<String> insertUser(@RequestBody User user) {
		String msg = this.userService.insertOne(user);
		if (msg.equals("创建成功")) {
			return ResponseDataUtil.buildSuccess("200", msg, null);
		} else {
			return ResponseDataUtil.buildSuccess("400", msg, null);
		}

	}

	/**
	 * 更新用户信息
	 * @param userId
	 * @param email
	 * @param phone
	 * @param userState
	 * @return
	 */
	@PostMapping("/updateUser")
	public ResponseData<String> updateUser(@RequestParam("userId") int userId, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("userState") int userState) {
		User user=new User();
		user.setUserId(userId);
		user.setUserState(userState);
		user.setEmail(email);
		user.setPhone(phone);
		return ResponseDataUtil.buildSuccess(this.userService.updateUser(user));
	}

	/**
	 * 获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/getUserByUserId")
	public ResponseData<User> getUserByUserId(@RequestParam("userId") int userId) {
		return ResponseDataUtil.buildSuccess("200", "成功", this.userService.getUserByUserId(userId));
	}

	/**
	 * 生成验证码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("/getVerifiCode")
	public void getVerifiCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * 1.生成验证码 2.把验证码上的文本存在session中 3.把验证码图片发送给客户端
		 */
		ImageVerificationCode ivc = new ImageVerificationCode(); // 用我们的验证码类，生成验证码类对象
		BufferedImage image = ivc.getImage(); // 获取验证码
		request.getSession().setAttribute("text", ivc.getText()); // 将验证码的文本存在session中
		ImageVerificationCode.output(image, response.getOutputStream());// 将验证码图片响应给客户端
	}

	/**
	 * 判断验证码
	 * 
	 * @param request
	 * @param imageCode
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/checkCode")
	public ResponseData<String> checkCode(HttpServletRequest request, @RequestParam("imageCode") String imageCode)
			throws IOException {
		String code = (String) request.getSession().getAttribute("text");
		if (code != null && code.equals(imageCode))
			return ResponseDataUtil.buildSuccess("成功");
		else
			return ResponseDataUtil.buildError("失败");
	}
}
