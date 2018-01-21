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
		form.submit();
	}
	
	function _action(method,id){
		var form = document.forms[0];
		form.id.value=id;
		form.action="servlet/adminAction/"+method+".html";
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
    	读者列表
     </h3>
 </div>
  <div class="panel-body">
  
	<form  action="servlet/adminAction/listBorrowers.html" method="post">

	<input type="hidden" name="page" value="${formbean.page}">
	<input type="hidden" name="id">
	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<td align="center" width="30%">读者id</td>
				<td align="center" width="15%">账号</td>
				<td align="center" width="15%">已借图书数</td>
				<td align="center" width="15%">预定图书数</td>
				<td align="center" width="15%">最多借书数</td>
				<td align="center" width="10%">操作</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pageView.records }" var="entity">
			<tr>
				<td align="center">
					${entity.id}
				</td>
				<td align="center">
				${entity.account}
				 </td>
				<td align="center">
					${entity.saveBooks}
				</td>
				<td align="center">
				${entity.reserveBooks}
				</td>
				<td align="center">${entity.maxSaveBooks}</td>
				
				<td align="center" >
					<c:if test="${entity.visible==true }">
					<input type="button" value="取消借书资格" class="btn btn-warning btn-xs" onclick="javascript:_action('disableBorrower','${entity.id}')">
 					</c:if>
					 <c:if test="${entity.visible==false }">
					 <input type="button" value="恢复借书资格" class="btn btn-success btn-xs" onclick="javascript:_action('enableBorrower','${entity.id}')">
 					</c:if>
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