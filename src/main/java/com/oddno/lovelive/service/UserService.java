package com.oddno.lovelive.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.oddno.lovelive.dto.request.UserLoginRequest;
import com.oddno.lovelive.dto.request.UserPushDevicesPostRequest;
import com.oddno.lovelive.dto.response.UserLoginResponse;
import com.oddno.lovelive.enums.UserType;

@Service
public class UserService {

	public UserLoginResponse login(UserLoginRequest request) {
		if (request.getPlayerId() != null && request.getPlayerId().length() > 0) {
			return UserLoginResponse.builder()
					.type(UserType.USER_TYPE_REGISTERD)
					.sessionToken(UUID.randomUUID().toString())
					.isTutorial(true)
					.isTermUpdate(false)
					.isLoginBonusReceive(true)
					.pushDeviceToken(
							"cZTwflXiTGCvgB-oRXDBxC:APA91bGxZDnsXgvZ4xCfAQOMFeCqxligWKiGUNoxo0vARHDxwvQPfmvIDh_ROqXCOWL63k04n6AvVjCSECCTzub7eeNT3wiP1NQxoDdRLz4cfV26TkocLyI")
					.siscaProductIdList(new ArrayList<>())
					.membershipProductIdList(new ArrayList<>())
					.itemStoreProductIdList(new ArrayList<>())
					.tutorialsStatusList(new ArrayList<>())
					.build();
		}
		return UserLoginResponse.builder()
				.type(UserType.USER_TYPE_TEMPORARY)
				.sessionToken("")
				.isTutorial(true)
				.isTermUpdate(true)
				.isLoginBonusReceive(false)
				.pushDeviceToken("")
				.siscaProductIdList(new ArrayList<>())
				.membershipProductIdList(new ArrayList<>())
				.itemStoreProductIdList(new ArrayList<>())
				.tutorialsStatusList(new ArrayList<>())
				.build();
	}

	public String pushDevices(UserPushDevicesPostRequest request) {
		return "null";
	}
}
