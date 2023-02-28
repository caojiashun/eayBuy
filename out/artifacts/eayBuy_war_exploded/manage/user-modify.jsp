<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理 - 易购网</title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body>
<jsp:include page="top.jsp" />
<div id="main" class="wrap">
	<jsp:include page="leftbar.jsp" />
	<div class="main">
		<h2>修改用户</h2>
		<div class="manage">
			<form method="post" action="user.do?action=update&entity = ${pages.euUserId}" >
				<table class="form">
					<tr>
						<td class="field">用户名(*)：</td>
						<td><input class="text" type="text" name="userId"    value="${pages.euUserId}" readonly="readonly" style="border:0px;"/>
							<c:if test="${not empty errors && not empty errors['userId']}">
								<span class="error">${errors['userId']}</span>
							</c:if>
							<c:if test="${empty errors || empty errors['userId']}"><span></span></c:if>
						</td>
					</tr>
					<tr>
						<td class="field">真实姓名(*)：</td>
						<td><input class="text" type="text" name="userName"    value="${pages.euUserName}"/>
							<c:if test="${not empty errors && not empty errors['userName']}">
								<span class="error">${errors['userName']}</span>
							</c:if>
							<c:if test="${empty errors || empty errors['userName']}"><span></span></c:if>
						</td>
					</tr>
					<tr>
						<td class="field">登录密码(*)：</td>
						<td><input class="text" type="password" id="password" name="password"    value="${pages.euPassword}"/>
							<c:if test="${not empty errors && not empty errors['password']}">
								<span class="error">${errors['password']}</span>
							</c:if>
							<c:if test="${empty errors || empty errors['password']}"><span></span></c:if>
						</td>
					</tr>
					<tr>
						<td class="field">确认密码(*)：</td>
						<td><input class="text" type="password" name="confirmPassword"    value="${confirmPassword}"/>
						<c:if test="${not empty errors && not empty errors['confirmPassword']}">
								<span class="error">${errors['confirmPassword']}</span>
							</c:if>
							<c:if test="${empty errors || empty errors['confirmPassword']}"><span></span></c:if>
						</td>
					</tr>
					<tr>
						<td class="field">性别(*)：</td>
						<td>
						  <input class="radio" type="radio" name="sex" value="1" <c:if test="${pages.euSex==1|| pages.euSex == null}">checked="checked" </c:if> />男性
						  <input class="radio" type="radio" name="sex" value="0" <c:if test="${pages.euSex==0}">checked="checked" </c:if> />女性
						  <span></span></td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td><input class="text" type="text" name="birthday"   value="${pages.euBirthday}"/>
							<c:if test="${not empty errors && not empty errors['birthday']}">
								<span class="error">${errors['birthday']}</span>
							</c:if>
							<c:if test="${empty errors || empty errors['birthday']}"><span></span></c:if>
						</td>
					</tr>
					<tr>
						<td class="field">身份证：</td>
						<td><input class="text" type="text" name="identityCode"   value="${pages.euIdentityCode}"/><span></span></td>
					</tr>
					<tr>
						<td class="field">电子邮件：</td>
						<td><input class="text" type="text" name="email"   value="${pages.euEmail}"/>
							<c:if test="${not empty errors && not empty errors['email']}">
								<span class="error">${errors['email']}</span>
							</c:if>
							<c:if test="${empty errors || empty errors['email']}"><span></span></c:if>
						</td>
					</tr>
					<tr>
						<td class="field">手机(*)：</td>
						<td><input class="text" type="text" name="mobile"   value="${pages.euMobile}"/>
							<c:if test="${not empty errors && not empty errors['mobile']}">
								<span class="error">${errors['mobile']}</span>
							</c:if>
							<c:if test="${empty errors || empty errors['mobile']}"><span></span></c:if>
						</td>
					</tr>
					<tr>
						<td class="field">收货地址(*)：</td>		
						<td>
							<c:forEach items="${pages.euAddress}" var="add">
							<input  class="text" type="text" name="address"   value="<c:out value="${add}"/>" />
							</c:forEach>
							<c:if test="${not empty errors && not empty errors['address']}">
								<span class="error">${errors['address']}</span>
							</c:if>
							<c:if test="${empty errors || empty errors['address']}"><span></span></c:if>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2020 皓晨教育 All Rights Reserved. 湘ICP证1000001号
</div>
</body>
</html>
