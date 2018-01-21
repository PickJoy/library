<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	text-align: center;
	margin: 0px;
}

.table {
	width: 100%;
	height: 100%;
	border: 0px solid gray; /*固定边框,1像素*/
	border-collapse: collapse; /*单线的列表边框*/
}

.table td {
	border: 0px solid gray; /*固定边框,1像素*/
}

iframe {
	width: 100%;
	height: 100%;
} 
</style>
  </head>
  
  <body>
<table class="table" align="center">
	<tr>
		<td colspan="2" align="center" height="80px;">
			<iframe frameborder="0" src="<c:url value='pages/top.jsp'/>" scrolling="no" name="top"></iframe>
		</td>
	</tr>
	<tr>
		<td style="width: 200px;">
			<iframe frameborder="0"  src="<c:url value='/pages/left.jsp'/>" name="left"></iframe>
		</td>
		<td>
			<iframe frameborder="0" src="<c:url value='/pages/right.jsp'/>" scrolling="no" name="right"></iframe>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center" height="25px;">
			<iframe frameborder="0" src="<c:url value='/pages/bottom.jsp'/>" name="bottom" scrolling="no"></iframe>
		</td>
	</tr>
</table>
  </body>
</html>
