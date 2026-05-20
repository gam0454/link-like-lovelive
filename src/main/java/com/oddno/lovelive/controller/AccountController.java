package com.oddno.lovelive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oddno.lovelive.dto.request.ConnectRequest;
import com.oddno.lovelive.dto.response.ErrorResponseError;
import com.oddno.lovelive.service.AccountService;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

	@Autowired
	private AccountService service;

	@PostMapping("/connect")
	public ResponseEntity<ErrorResponseError> connect(@RequestBody ConnectRequest request) {
		return ResponseEntity.badRequest().body(service.connect(request));
	}

}
