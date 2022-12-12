package com.example.travelator.actiontocalculation.version3;

import java.time.ZonedDateTime;

public class TimeUtils {
	public static ZonedDateTime zonedDateTime(String s) {
		return ZonedDateTime.parse(s);
	}
}