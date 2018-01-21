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
    
    <title>头部</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="css/bootstrap.min.css"  rel="stylesheet" >
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
  </head>
  
  <body>
  <div id="container" style="height:100%;">
	  <nav class="navbar navbar-default" style="padding-bottom: 30px;padding-top: 6px;padding-right: 10px;" >
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="javascript:void()" >
	        <img alt="Brand" height="30" src="images/logo.png">
	      </a>
	    </div>
		  <h1 class="navbar-text">图书管理系统 </h1>
	   
		<!-- Single button -->
		<div class="btn-group  navbar-btn  navbar-right">
		  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    ${user.account } <span class="glyphicon glyphicon-user"></span>
		  </button>
		  <ul class="dropdown-menu">
		    <li style="height:20px;"><a href="<c:url value='servlet/loginAction/exit.html'/>"  target="_parent" >退出</a></li>
		  </ul>
		</div>
	  </div>
	</nav>
</div>
  </body>
</html>
