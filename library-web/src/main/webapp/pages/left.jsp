<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>" target="right">
    
    <title>My JSP 'right.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	
  </head>
  
  <body>
 
   <div class="list-group">
  <!--  管理员登陆 -->
   <c:if test="${userType==0 }">
     <a href='<c:url value="/pages/admin/addreader.jsp"/>' class="list-group-item  list-group-item-success"> 添加读者  </a>
  	<a href="<c:url value="/servlet/adminAction/listBorrowers.html?page=1"/>" class="list-group-item list-group-item-success">查看读者</a>
  	<a href="<c:url value="/pages/admin/addbook.jsp"/>" class="list-group-item list-group-item-success">添加图书</a>
   	<a href="<c:url value="/servlet/adminAction/listBooks.html?page=1"/>" class="list-group-item list-group-item-success">查看图书</a>
   </c:if>
	<!-- 用户登录 -->
   <c:if test="${userType==1 }">
   	<a href="<c:url value="/servlet/borrowerAction/borrowerDetail.html"/>" class="list-group-item list-group-item-success">个人信息</a>
   	<a href="<c:url value="/servlet/borrowerAction/listBooks.html?page=1"/>" class="list-group-item list-group-item-success">借书</a>
   	<a href="<c:url value="/servlet/borrowerAction/listSaveBooks.html?page=1"/>" class="list-group-item list-group-item-success">还书</a>
   </c:if>
  
  </div>
  </body>
  <link href="css/bootstrap.min.css"  rel="stylesheet" >
</html>
