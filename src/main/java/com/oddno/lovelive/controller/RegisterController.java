package com.oddno.lovelive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oddno.lovelive.dto.request.RegisterApproveTermsRequest;
import com.oddno.lovelive.dto.request.RegisterSetNewUserRequest;
import com.oddno.lovelive.dto.request.RegisterSetUserDataRequest;
import com.oddno.lovelive.dto.response.RegisterApproveTermsResponse;
import com.oddno.lovelive.dto.response.RegisterGetTermsResponse;
import com.oddno.lovelive.dto.response.RegisterSetNewUserResponse;
import com.oddno.lovelive.dto.response.RegisterSetUserDataResponse;
import com.oddno.lovelive.service.RegisterService;

@RestController
@RequestMapping("/v1/register")
public class RegisterController {

	@Autowired
	private RegisterService service;

	@PostMapping("/set_new_user")
	public RegisterSetNewUserResponse setNewUser(@RequestBody RegisterSetNewUserRequest request) {
		return service.setNewUser(request);
	}

	@PostMapping("/get_terms")
	public RegisterGetTermsResponse getTerms() {
		return RegisterGetTermsResponse.builder().terms("asdasd").build();
	}

	@PostMapping("/approve_terms")
	public RegisterApproveTermsResponse getTerms(@RequestBody RegisterApproveTermsRequest request) {
		return service.approveTerms(request);
	}

	@PostMapping("/set_user_data")
	public RegisterSetUserDataResponse setUserData(@RequestBody RegisterSetUserDataRequest request) {
		return service.setUserData(request);
	}
}
