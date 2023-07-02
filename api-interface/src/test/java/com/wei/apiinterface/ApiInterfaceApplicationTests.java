package com.wei.apiinterface;

import com.wei.apiclientsdk.client.ApiClient;
import com.wei.apiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {

	@Resource
	private ApiClient apiClient;

	@Test
	void contextLoads() {
		String result = apiClient.getNameByGet("wei");
		User user = new User();
		user.setUsername("weiwei");
		String usernameByPost = apiClient.getUsernameByPost(user);
		System.out.println(result);
		System.out.println(usernameByPost);
	}

}
