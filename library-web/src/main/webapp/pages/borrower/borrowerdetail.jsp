<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>读者信息</title>
<script type="text/javascript">

</script>
<link href="css/bootstrap.min.css"  rel="stylesheet" >
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>


<div class="panel panel-default">
 
 <div class="panel-heading">
    <h3 class="panel-title" style="color: blue;">
    	读者信息
     </h3>
 </div>
  <div class="panel-body">
  
		<table class="table table-bordered table-hover table-striped">
			
			<tbody>
				<tr>
					<td>id</td><td>${user.id }</td>
				</tr>
				<tr>
					<td>账号</td><td>${user.account }</td>
				</tr>
				<tr>
					<td>密码</td><td>${user.password }</td>
				</tr>
				<tr>
					<td>已借图书数</td><td>${user.saveBooks }</td>
				</tr>
				<tr>
					<td>最大借书数</td><td>${user.maxSaveBooks }</td>
				</tr>
				<tr>
					<td>当前状态</td>
					<td>
					<c:if test="${user.visible==true }">可借书</c:if>
					<c:if test="${user.visible==false }">不可借书</c:if>
					</td>
				</tr>
			</tbody>
		</table>
  </div>
   
</div>
	
</body>
</html>