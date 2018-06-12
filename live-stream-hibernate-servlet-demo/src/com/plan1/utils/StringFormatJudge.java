package com.plan1.utils;

public class StringFormatJudge {
	public static  boolean judgeUser(String x, int minLength, int maxLength) {
		if (x.length() < minLength || x.length() > maxLength) {
			System.out.println(x + "---" + "长度不够");
			return false;
		}
		for (int i = 0; i < x.length(); i++) {
			char indexChar = x.charAt(i);
			if (!Character.isAlphabetic(indexChar) && !Character.isDigit(indexChar)) {
				System.out.println(x + "----" + "非数字或字母");
				return false;
			}
		}
		return true;
	}
}
