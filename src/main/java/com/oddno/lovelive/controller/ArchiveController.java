package com.oddno.lovelive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oddno.lovelive.dto.request.GetArchiveListRequest;
import com.oddno.lovelive.dto.request.GetFesArchiveDataRequest;
import com.oddno.lovelive.dto.request.GetWithArchiveDataRequest;
import com.oddno.lovelive.dto.request.SetFesCameraRequest;
import com.oddno.lovelive.dto.response.ArchiveWithliveInfoResponse;
import com.oddno.lovelive.dto.response.GetArchiveListResponse;
import com.oddno.lovelive.dto.response.GetFesArchiveDataResponse;
import com.oddno.lovelive.dto.response.GetFesTimelineDataResponse;
import com.oddno.lovelive.dto.response.GetHomeResponse;
import com.oddno.lovelive.dto.response.GetWithArchiveDataResponse;
import com.oddno.lovelive.dto.response.SetFesCameraResponse;
import com.oddno.lovelive.service.ArchiveService;

@RestController
@RequestMapping("/v1/archive")
public class ArchiveController {

	@Autowired
	private ArchiveService service;

	@PostMapping("/get_home")
	public GetHomeResponse getHome() {
		return service.getHome();
	}

	@PostMapping("/get_archive_list")
	public GetArchiveListResponse getArchiveList(@RequestBody GetArchiveListRequest request) {
		return service.getArchiveList(request);
	}

	@PostMapping("/get_with_archive_data")
	public GetWithArchiveDataResponse getWithArchiveData(@RequestBody GetWithArchiveDataRequest request) {
		return service.getWithArchiveData(request);
	}

	@GetMapping("/withlive_info")
	public ArchiveWithliveInfoResponse withliveInfo() {
		return service.withliveInfo();
	}

	@PostMapping("/get_fes_archive_data")
	public GetFesArchiveDataResponse getFesArchiveData(@RequestBody GetFesArchiveDataRequest request) {
		return service.getFesArchiveData(request);
	}

	@PostMapping("/get_fes_timeline_data")
	public GetFesTimelineDataResponse getFesTimelineData() {
		return service.getFesTimelineData();
	}

	@PostMapping("/set_fes_camera")
	public SetFesCameraResponse setFesCamera(@RequestBody SetFesCameraRequest request) {
		return service.setFesCamera(request);
	}

}
