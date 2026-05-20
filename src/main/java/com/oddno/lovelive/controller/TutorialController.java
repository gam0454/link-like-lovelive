package com.oddno.lovelive.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oddno.lovelive.dto.request.TutorialSetStepRequest;
import com.oddno.lovelive.dto.response.TutorialSetStepResponse;

@RestController
@RequestMapping("/v1/tutorial")
public class TutorialController {

	@PostMapping("/set_step")
	public TutorialSetStepResponse setStep(@RequestBody TutorialSetStepRequest request) {
		return TutorialSetStepResponse.builder().result(true).build();
	}
}
