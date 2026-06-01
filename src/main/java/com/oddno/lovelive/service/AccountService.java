package com.oddno.lovelive.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.oddno.lovelive.dto.request.ConnectRequest;
import com.oddno.lovelive.dto.response.ConnectResponse;

@Service
public class AccountService {

	public ConnectResponse connect(ConnectRequest request) {
		return ConnectResponse.builder()
				.playerId("AAAAAAAAA")
				.deviceSpecificId(UUID.randomUUID().toString())
				.sessionToken(UUID.randomUUID().toString())
				.playerName("ソヨ")
				.playerLevel(1111)
				.build();
		//		return ErrorResponseError.builder()
		//				.errorCode("02008_300201")
		//				.message("LinkLikeID가 잘못되었습니다.")
		//				.title("유저 정보 취득 에러")
		//				.build();
		//		return ErrorResponseError.builder()
		//				.errorCode("02008_300201")
		//				.message("LinkLikeIDが間違っています。")
		//				.title("ユーザー情報取得エラー")
		//				.build();
	}
}
