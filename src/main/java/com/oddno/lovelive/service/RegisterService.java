package com.oddno.lovelive.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.oddno.lovelive.dto.request.RegisterApproveTermsRequest;
import com.oddno.lovelive.dto.request.RegisterSetNewUserRequest;
import com.oddno.lovelive.dto.request.RegisterSetUserDataRequest;
import com.oddno.lovelive.dto.response.RegisterApproveTermsResponse;
import com.oddno.lovelive.dto.response.RegisterSetNewUserResponse;
import com.oddno.lovelive.dto.response.RegisterSetUserDataResponse;
import com.oddno.lovelive.enums.ApproveTermsType;

@Service
public class RegisterService {

	public RegisterSetNewUserResponse setNewUser(RegisterSetNewUserRequest request) {
		return RegisterSetNewUserResponse.builder()
				.playerId("AAAAAAAAA")
				.deviceSpecificId(UUID.randomUUID().toString())
				.sessionToken(UUID.randomUUID().toString())
				.build();
	}

	public RegisterApproveTermsResponse approveTerms(RegisterApproveTermsRequest request) {
		return RegisterApproveTermsResponse.builder()
				.type(ApproveTermsType.APPROVE_TERMS_TYPE_CERTIFICATION_REGISTRATION)
				.playerId("AAAAAAAAA")
				.deviceSpecificId(UUID.randomUUID().toString())
				.sessionToken(UUID.randomUUID().toString())
				.build();
	}

	public RegisterSetUserDataResponse setUserData(RegisterSetUserDataRequest request) {
		return RegisterSetUserDataResponse.builder().result(true).build();
	}
}
