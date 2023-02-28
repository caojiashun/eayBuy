<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易购网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
<jsp:include page="top.jsp" />
<div id="main" class="wrap">
	<jsp:include page="leftbar.jsp" />
	<div class="main">
		<h2>分类管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>编号</th>
					<th>分类名称</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${categories}" var="category">
				<c:set var="i" value="${i+1}"></c:set>
				<tr>
					<td class="first w4 c"><c:out
									value="${(pageNo-1)*(pager.pagesPerDisplay)+i}" /></td>				
					<c:if test="${category.epcParentId==0}">
					<td><c:out value="${category.epcName}"/></td>
					</c:if>
					<c:if test="${category.epcParentId!=0}">
					<td class="childClass"><c:out value="${category.epcName}"/></td>
					</c:if>
					<td class="w1 c"><a href="Category?action=read&id=${category.epcId}">修改</a>
					<a href="Category?action=delete&id=${category.epcId}">删除</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2020 皓晨教育 All Rights Reserved. 湘ICP证1000001号
</div>
</body>
</html>
