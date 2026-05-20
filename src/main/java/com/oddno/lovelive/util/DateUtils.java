package com.oddno.lovelive.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

	private static final DateTimeFormatter ISO_UTC_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

	public static String formatToUtcString(LocalDateTime dateTime) {
		if (dateTime == null) {
			return null;
		}
		return dateTime.format(ISO_UTC_FORMATTER);
	}

	public static LocalDateTime convertUnixToLocal(long unixTime) {
		return LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTime), ZoneId.of("UTC"));
	}
}
