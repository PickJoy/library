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
<title>图书</title>
<script type="text/javascript">
	
	function topage(page)
	{
		var form = document.forms[0];
		form.page.value= page;
		form.bookId.value=0;//无意义
		form.submit();
	}
	
	function _action(method,id){
		var form = document.forms[0];
		form.bookId.value=id;
		form.action="servlet/borrowerAction/"+method+".html";
		form.submit();

}
</script>
<link href="css/bootstrap.min.css"  rel="stylesheet" >
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>


<div class="panel panel-default">
 
 <div class="panel-heading">
    <h3 class="panel-title" style="color: blue;">
    	还书列表
     </h3>
 </div>
  <div class="panel-body">
  
	<form  action="servlet/borrowerAction/listSaveBooks.html" method="post">

	<input type="hidden" name="page" value="${formbean.page}">
	<input type="hidden" name="bookId">
	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<td align="center" width="30%">图书id</td>
				<td align="center" width="20%">图书作者</td>
				<td align="center" width="30%">书名</td>
				<td align="center" width="20%">操作</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pageView.records }" var="entity">
			<tr>
				<td align="center">
					${entity.id}
				</td>
				<td align="center">
				${entity.insb}
				 </td>
				<td align="center">
					${entity.name}
				</td>
				<td align="center" >
					 <input type="button" value="归还" class="btn btn-warning btn-xs" onclick="javascript:_action('returnBook','${entity.id}')">
 				</td>
			</tr>
		 </c:forEach>
		</tbody>
	</table>
	</form>
  </div>
   <div class="panel-footer">
     <%@ include file="/pages/share/fenye.jsp"%>
   </div>
</div>
	
</body>
</html>