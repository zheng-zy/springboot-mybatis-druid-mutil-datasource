package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.master.User;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Resource
	private UserService userService;

	@Test
	public void contextLoads() {
		User user = userService.find(1);
		System.out.println("user = " + JSON.toJSONString(user));
	}

}
