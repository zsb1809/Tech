package com.zhihua.tt.util;

import javax.servlet.http.HttpServletRequest;

public class ParameterUtils {
	
	
	
	public static long getLongParameter(HttpServletRequest request,String param){
		
		
		return Long.parseLong(request.getParameter(param));
	}
	
}
