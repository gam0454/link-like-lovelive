package com.oddno.lovelive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oddno.lovelive.dto.request.GetCharacterInfoRequest;
import com.oddno.lovelive.dto.response.GetCharacterInfoResponse;
import com.oddno.lovelive.dto.response.GetGallaryListResponse;
import com.oddno.lovelive.dto.response.GetStickerListResponse;
import com.oddno.lovelive.service.CollectionService;

@RestController
@RequestMapping("/v1/collection")
public class CollectionController {

	@Autowired
	private CollectionService service;

	@PostMapping("/get_sticker_list")
	public GetStickerListResponse getStickerList() {
		return service.getStickerList();
	}

	@PostMapping("/get_gallary_list")
	public GetGallaryListResponse getGallaryList() {
		return service.getGallaryList();
	}

	@PostMapping("/get_character_info")
	public GetCharacterInfoResponse getCharacterInfo(@RequestBody GetCharacterInfoRequest request) {
		return service.getCharacterInfo(request);
	}
}
