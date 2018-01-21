<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加图书</title>
    
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
  
  	 <div class="col-md-8 col-md-offset-3" ><span style="color: red;">${message }</span></div>
 	<form action="servlet/adminAction/addBook.html" method="post" class="form-horizontal">

	  <div class="form-group">
	    <label for="name" class="col-md-2 control-label">书名</label>
	    <div class="col-md-3">
	      <input type="text" class="col-md-2 form-control" name="name" id="name" value="${formbean.name }" required="required" >
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="insb" class="col-md-2 control-label">作者</label>
	    <div class="col-md-3">
	      <input type="text" class=" form-control" id="insb" name="insb" value="${formbean.insb }" required="required" >
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="sum" class="col-md-2 control-label">总数量</label>
	    <div class="col-md-3">
	      <input type="text" class=" form-control" id="sum" name="sum"  value="${formbean.sum }"  required="required" >
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
