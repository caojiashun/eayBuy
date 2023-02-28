<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>" />
<title>易购网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<script type="text/javascript"
	src="scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
	<jsp:include page="top.jsp" />
	<div id="register" class="wrap">
		<div class="shadow">
			<em class="corner lb"></em> <em class="corner rt"></em>
			<div class="box">
				<h1>欢迎回到易购网</h1>
				<form id="loginForm" method="post" action="<c:url value="/user.do?action=login"/>" onsubmit="return checkForm(this)">
					
					<table>
						<tr>
							<td class="field">用户名：</td>
							<td><input class="text" type="text" id="userId" name="userId" value="${param.userId}" /> 
								<c:if test="${not empty errors && not empty errors['userId']}">
									<span class="error">${errors['userId']}</span>
								</c:if> 
								<c:if test="${empty errors || empty errors['userId']}">
									<span></span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td class="field">登录密码：</td>
							<td>
								<input class="text" type="password" id="password" name="password" value="${param.password}" />
								<c:if test="${not empty errors && not empty errors['password']}">
									<span class="error">${errors['password']}</span>
								</c:if>
								<c:if test="${empty errors || empty errors['password']}">
									<span></span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td class="field">验证码：</td>
							<td>
							<img src="Number.jsp" id="safeCode" /><a href="#"
								onclick="reloadCode()">看不清，换一张</a><br /> <input type="text"
								name="code" /> 
								<c:if test="${not empty errors && not empty errors['code']}">
									<span class="error">${errors['code']}</span>
								</c:if> 
								<c:if test="${empty errors || empty errors['code']}">
									<span></span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-green"><input type="submit" name="submit" value="立即登录" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2020 皓晨教育 All Rights Reserved.湘ICP证1000001号</div>
</body>
</html>
