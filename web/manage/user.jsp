<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>后台管理 - 易购网</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css"/>
	<script type="text/javascript" src="../scripts/jquery.min.js"></script>
	<script type="text/javascript"
			src="../scripts/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
<jsp:include page="top.jsp"/>
<div id="main" class="wrap">
	<jsp:include page="leftbar.jsp"/>
	<div class="main">
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>用户名</th>
					<th>真实姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pages.resultList}" var="user">
					<tr>
						<td class="first w4 c">${user.euUserId}</td>
						<td class="w1 c">${user.euUserName}</td>
						<td class="w2 c">${user.euSex==1?"男":"女"}</td>
						<td>${user.euEmail}</td>
						<td class="w4 c">${user.euMobile}</td>
						<td class="w1 c"><c:if
								test="${sessionScope.loginUser!=null && (sessionScope.loginUser.euUserId==user.euUserId)}">
							<a href="user.do?action=updateUser&userId=${user.euUserId}">修改</a>
						</c:if> <c:if
								test="${sessionScope.loginUser!=null && (sessionScope.loginUser.euStatus > 1) && (!(user.euLogin==1))}">
							<div class="manageDel">
								<a href="user.do?action=delete&userId=${user.euUserId}">删除</a>
							</div>
						</c:if></td>
					</tr>
				</c:forEach>
				<c:if
						test="${sessionScope.loginUser!=null && (sessionScope.loginUser.euStatus <= 1)}">
					<tr>
						<td class="first w4 c">${user.euUserId}</td>
						<td class="w1 c">${user.euUserName}</td>
						<td class="w2 c">${user.euSex==1?"男":"女"}</td>
						<td>${user.euEmail}</td>
						<td class="w4 c">${user.euMobile}</td>
						<td class="w1 c"><c:if
								test="${sessionScope.loginUser!=null && !(sessionScope.loginUser.euStatus <= 1)}">
							<a href="User?action=updateUser&userId=${user.userId}">修改</a>
						</c:if></td>
					</tr>
				</c:if>
			</table>
			<div class="pager">
				<ul class="clearfix">
					当前是第【${pages.pageNo }】页，共【${pages.pageTotal }】页
					<c:choose>
						<c:when test="${pages.pageNo <= 1}">
							<a href="user.do?action=user&pageNo=1">首页</a>
							<a href="user.do?action=user&pageNo=${pages.pageNo-1}">上一页</a>
						</c:when>
						<c:otherwise>
							<a href="user.do?action=user&pageNo=1">首页</a>
							<a href="user.do?action=user&pageNo=${pages.pageNo-1}">上一页</a>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${pages.pageNo < pages.pageTotal}">
							<a href="user.do?action=user&pageNo=${pages.pageNo+1}">下一页</a>
							<a href="user.do?action=user&pageNo=${pages.pageTotal}">尾页</a>
						</c:when>
						<c:otherwise>
							<a href="javascript:void(0)">下一页</a>
							<a href="javascript:void(0)">尾页</a>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">Copyright &copy; 2020 皓晨教育 All Rights Reserved.
	湘ICP证1000001号
</div>

</body>
</html>
