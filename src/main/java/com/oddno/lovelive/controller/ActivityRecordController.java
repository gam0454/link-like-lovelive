package com.oddno.lovelive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oddno.lovelive.dto.request.PlayAdvDataRequest;
import com.oddno.lovelive.dto.response.GetTopResponse;
import com.oddno.lovelive.dto.response.PlayAdvDataResponse;
import com.oddno.lovelive.service.ActivityRecordService;

@RestController
@RequestMapping("/v1/activity_record")
public class ActivityRecordController {

	@Autowired
	private ActivityRecordService service;

	@PostMapping("/get_top")
	public GetTopResponse getTop() {
		return service.getTop();
	}

	@PostMapping("/play_adv_data")
	public PlayAdvDataResponse playAdvData(@RequestBody PlayAdvDataRequest request) {
		return service.playAdvData(request);
	}
}
