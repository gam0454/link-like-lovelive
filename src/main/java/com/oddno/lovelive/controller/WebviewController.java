package com.oddno.lovelive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/webview")
public class WebviewController {

	@GetMapping("/school_idol_connect_post/get_theme_list")
	public List<?> getThemeList() {
		return new ArrayList<>();
	}

}
