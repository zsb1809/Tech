package com.zhihua.tt.util;


public class StringUtils {
	
	
	public static boolean isNullOrEmpty(String s){
		
		if(null==s){
			return true;
		}else if(s.equals("")){
			return true ;
		}
		return false; 
	}
	
	public static ResultMessage succJsonObj(String s){

		return new ResultMessage(true,s);
	}
	
	
	public static ResultMessage failJsonObj(String s){
		return new ResultMessage(false,s);
	}
	
	
	
}
