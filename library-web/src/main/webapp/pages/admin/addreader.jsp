<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'right.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link href="css/bootstrap.min.css"  rel="stylesheet" >
  </head>
  
  <body>
  <div id="container" style="margin-top: 20px;">
 	<form action="servlet/adminAction/addBorrower.html" method="post" class="form-horizontal">

	  <div class="form-group">
	    <label for="account" class="col-md-2 control-label">账号</label>
	    <div class="col-md-3">
	      <input type="text" class="col-md-2 form-control" name="account" id="account"  required="required" >
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="password" class="col-md-2 control-label">密码</label>
	    <div class="col-md-3">
	      <input type="text" class=" form-control" id="password" name="password"  value="123456" required="required" >
	    </div>
	  </div>
	 
	  <div class="form-group">
	    <div class="col-md-offset-3 col-md-2">
	      <button type="submit" class="btn btn-default">添加</button>
	    </div>
	  </div>
	</form>
 </div>
  </body>
</html>
