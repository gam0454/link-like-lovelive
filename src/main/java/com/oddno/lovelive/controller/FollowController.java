package com.oddno.lovelive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oddno.lovelive.dto.response.FollowLiveChatGroupListResponse;
import com.oddno.lovelive.service.FollowService;

@RestController
@RequestMapping("/v1/follow")
public class FollowController {

	@Autowired
	private FollowService service;

	@PostMapping("/live_chat_group_list")
	public FollowLiveChatGroupListResponse liveChatGroupList() {
		return service.liveChatGroupList();
	}

}
