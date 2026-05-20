package com.oddno.lovelive.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.oddno.lovelive.dto.response.FollowLiveChatGroupListResponse;

@Service
public class FollowService {

	public FollowLiveChatGroupListResponse liveChatGroupList() {
		return FollowLiveChatGroupListResponse.builder().groupX(new ArrayList<>()).groupY(new ArrayList<>()).build();
	}
}
