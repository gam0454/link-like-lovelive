package com.oddno.lovelive.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class GlobalFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request, 1024 * 1024);
		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

		try {
			String clientVersion = requestWrapper.getHeader("x-client-version");
			
			responseWrapper.setHeader("server", "Google Frontend");

			if (clientVersion.equals("2.4.50"))
				responseWrapper.setHeader("x-res-version", "R2503400@ECHJFDbTeckkEeJ87vNcYZCeQA==");
			else
				responseWrapper.setHeader("x-res-version", "R2605003@3D4SGiaPEFErqNIto7oqleD6YA==");

			String serverDate = java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME
					.format(java.time.ZonedDateTime.now(java.time.ZoneId.of("GMT")));
			responseWrapper.setHeader("x-server-date", serverDate);

			responseWrapper.setHeader("launcher_info",
					"""
							{"quest_live_status":1,"archive_status":1,"activity_status":1,"gacha_status":1,"mission_status":1,"present_box_status":1,"shop_status":1,"sisca_store_status":1,"collection_status":1,"sticker_status":1,"comic_status":1,"circle_status":0,"information_status":1,"friend_status":1,"train_status":1,"deck_status":1,"school_idol_show_status":1}""");

			responseWrapper.setHeader("user_stamina", """
					{"stamina_now":100,"stamina_max":100,"stamina_recovery_time":"2026-04-07T17:43:52.923171026Z"}""");

			responseWrapper.setHeader("name", "44Gd44KI");
			responseWrapper.setHeader("fan_level", "1111");
			responseWrapper.setHeader("jewel_free", "111111111");
			responseWrapper.setHeader("jewel_paid_apple", "111111111");
			responseWrapper.setHeader("jewel_paid_google", "111111111");
			responseWrapper.setHeader("presentbox_count", "999");
			responseWrapper.setHeader("latest_chat_order_id", "0");
			responseWrapper.setHeader("new_gacha_unreadable_type", "0");

			responseWrapper.setHeader("exists_circle_approval_pending_from_user", "false");
			responseWrapper.setHeader("is_already_read_friend_request", "false");
			responseWrapper.setHeader("is_already_read_item_store_new_arrival", "false");
			responseWrapper.setHeader("is_already_read_membership_new_arrival", "false");
			responseWrapper.setHeader("is_already_read_petal_exchange_new_arrival", "false");
			responseWrapper.setHeader("is_already_read_shop_new_arrival", "false");
			responseWrapper.setHeader("is_already_read_sisca_shop_new_arrival", "false");
			responseWrapper.setHeader("is_circle_approve_user", "false");
			responseWrapper.setHeader("is_circle_dissolution_user", "false");
			responseWrapper.setHeader("is_circle_invite_user", "false");
			responseWrapper.setHeader("is_grand_prix_open", "false");
			responseWrapper.setHeader("is_party_gacha_underway", "false");
			responseWrapper.setHeader("is_term_update", "false");
			responseWrapper.setHeader("is_tutorial", "false");

			filterChain.doFilter(requestWrapper, responseWrapper);
		} finally {
			logRequestAndResponse(requestWrapper, responseWrapper);

			responseWrapper.copyBodyToResponse();
		}
	}

	private void logRequestAndResponse(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response) {
		if (request.getContentAsByteArray().length == 0) {
			try {
				request.getInputStream().readAllBytes();
			} catch (IOException e) {
			}
		}

		String requestBody = new String(request.getContentAsByteArray(), StandardCharsets.UTF_8);
		String responseBody = new String(response.getContentAsByteArray(), StandardCharsets.UTF_8);

		System.out.println("==================== [API LOG] ====================");
		System.out.println(">>> [REQ] " + request.getMethod() + " " + request.getRequestURI());
		System.out.println(">>> [BODY] " + (requestBody.isEmpty() ? "(Empty)" : requestBody));
		System.out.println("<<< [RES] " + (responseBody.isEmpty() ? "(Empty)" : responseBody));
		System.out.println("====================================================");
	}
}