<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
    
<%	
	HttpServletRequest httpRequest=(HttpServletRequest)request;
	String strBackUrl = "http://" + request.getServerName() //服务器地址  
		+ ":"   
		+ request.getServerPort()           //端口号  
		+ httpRequest.getContextPath()      //项目名称  
		+ "/" ;
out.print(strBackUrl);
%>
