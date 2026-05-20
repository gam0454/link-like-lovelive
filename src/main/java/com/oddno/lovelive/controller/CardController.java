package com.oddno.lovelive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oddno.lovelive.dto.request.CardGetListRequest;
import com.oddno.lovelive.dto.response.CardGetListResponse;
import com.oddno.lovelive.service.CardService;

@RestController
@RequestMapping("/v1/user/card")
public class CardController {

	@Autowired
	private CardService service;
	
	@PostMapping("/get_list")
	public CardGetListResponse getList(@RequestBody CardGetListRequest request) {
		return service.getList(request);
	}
}
