package com.subterranean_security.crimson.core.util;

public class Native {
	public static native String getActiveWindow();

	public static native long getSystemUptime();

	public static native long getCpuTemp();
}