<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
    
<%	
	HttpServletRequest httpRequest=(HttpServletRequest)request;
	String strBackUrl = "http://" + request.getServerName() //��������ַ  
		+ ":"   
		+ request.getServerPort()           //�˿ں�  
		+ httpRequest.getContextPath()      //��Ŀ����  
		+ "/" ;
out.print(strBackUrl);
%>
