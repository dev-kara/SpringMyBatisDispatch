package com.example.utils;

public class DbContext {

	static private ThreadLocal<Boolean> isWrite = new ThreadLocal<Boolean>();

	static public String getDbName() {
		if (isWrite.get() != null) {
			return (false == isWrite.get()) ? "db_r" : "db_w";
		}
		return "db_r";
	}

	static public void writeOn() {
		isWrite.set(true);
	}

	static public void writeOff() {
		isWrite.set(false);
	}

}
