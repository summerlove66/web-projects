package com.plan1.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeConverter {
	
	public static String getNow() {
		 SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
		 return sdf.format(new Date());
	}
}
