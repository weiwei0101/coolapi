package com.wei.apiinterface.controller;

import com.wei.apiclientsdk.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * 模拟接口
 * 名称 API
 *
 * @author wei
 */
@RestController
@RequestMapping("/name")
public class NameController {

	@GetMapping("/get")
	public String getNameByGet(String name, HttpServletRequest request){
		System.out.println(request.getHeader("yupi"));
		return "GET 你的名字是：" + name;
	}

	@PostMapping("/post")
	public String getNameByPost(@RequestParam String name){
		return "POST 你的名字是：" + name;
	}

	@PostMapping("/user")
	public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
//		String accessKey = request.getHeader("accessKey");
//		String nonce = request.getHeader("nonce");
//		String timestamp = request.getHeader("timestamp");
//		String sign = request.getHeader("sign");
//		// 防止中文乱码
//		String body = request.getHeader("body");
//		// TODO 实际情况应该是去数据库查询是否已分配的用户
//		if (!accessKey.equals("wei")){
//			throw new RuntimeException("无权限");
//		}
//		if (Long.parseLong(nonce) > 10000){
//			throw new RuntimeException("无权限");
//		}
		// TODO 时间和当前时间不能超过五分钟
//		if (System.currentTimeMillis() - Long.parseLong(timestamp) > 5 * 60 * 1000){
//			throw new RuntimeException("无权限");
//		}
		// TODO 实际情况是从数据库中查出 secretKey
//		String serverSign = SignUtil.genSign(body, "abcdefgh");
//		if (!sign.equals(serverSign)){
//			throw new RuntimeException("无权限");
//		}
		// TODO 调用成功后 次数 + 1 invokeCount
		String result = "POST 用户名是：" + user.getUsername();
		return result;
	}

}
