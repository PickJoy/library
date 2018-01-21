<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link href="<c:url value='css/bootstrap.min.css'/>"  rel="stylesheet" >
    <script type="text/javascript" src="<c:url value='js/jquery-2.1.3.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='js/bootstrap.min.js'/>" ></script>
</head>
<body>
<div id="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-5" ><span style="color: red;">${message }</span></div>
        <div class="col-md-8 col-md-offset-4" >
            <form action="servlet/loginAction/login.html"  method="post"  class="form-horizontal" style="border: 0px solid red;margin-top: 20px;">

                <div class="form-group">
                    <label for="account" class="col-md-2 control-label">账号</label>
                    <div class="col-md-3">
                        <input id="account"  name="account" value="${formbean.account }" type="text" class="form-control"  placeholder="账号" required="required" >
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-md-2 control-label">密码</label>
                    <div class="col-md-3">
                        <input id="password" name="password"  value="${formbean.password }"  type="password" class="form-control"  placeholder="密码" required="required">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-5">
                        <label class="radio-inline">
                            <input type="radio" name="userType"  ${(formbean.userType!=1)?"checked":"" } id="inlineRadio1" value="0"> 管理员
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="userType"  ${(formbean.userType==1)?"checked":"" } id="inlineRadio2" value="1"> 读者
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-5">
                        <button type="submit"  class="btn  btn-info col-md-3">登陆</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
