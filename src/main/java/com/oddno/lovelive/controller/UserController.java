package com.oddno.lovelive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oddno.lovelive.dto.request.UserLoginRequest;
import com.oddno.lovelive.dto.request.UserPushDevicesPostRequest;
import com.oddno.lovelive.dto.response.UserLoginResponse;
import com.oddno.lovelive.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/login")
	public UserLoginResponse login(@RequestBody UserLoginRequest request) {
		return service.login(request);
	}
	
	@PutMapping("/push/device")
	public String pushDevices(@RequestBody String a) {
		return null;
	}
	
	@PostMapping("/push/devices")
	public String pushDevices(@RequestBody UserPushDevicesPostRequest request) {
		return service.pushDevices(request);
	}
}
