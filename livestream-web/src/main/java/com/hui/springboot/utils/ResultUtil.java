package com.hui.springboot.utils;

import com.hui.springboot.projectmodel.Result;

public class ResultUtil {
	
	public static final Result sucessOrExists=  new Result(1,null,null);
	public static final Result  faultOrNull = new Result(0,null,null);
	public static final Result unKnowError = new Result(0,"未知错误",null);
	public static final Result noPermission = new Result(0,"没有权限",null);
}
