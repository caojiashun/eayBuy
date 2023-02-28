<%@page import="com.haochen.egou.entity.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		<c:set var="i" value="0"></c:set>
		<div class="main">
			<h2>新闻管理</h2>
			<div class="manage">
				<table class="list">
					<tr>
						<th>编号</th>
						<th>新闻标题</th>
						<th>时间</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${allNews}" var="news">
						<c:set var="i" value="${i+1}"></c:set>
						<tr>
							<td class="first w4 c"><c:out
									value="${(pageNo-1)*(pager.pageSize)+i}" />
							</td>
							<td><c:out value="${news.title}" />
							</td>
							<td><c:out value="${news.createTime}" />
							</td>
							<td class="w1 c"><a
								href="News?action=read&entityId=${news.id}">修改</a> 
								<div class="manageDel">
								<a  href="News?action=delete&entityId=${news.id}">删除</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div class="pager">
					<ul class="clearfix">
						<!-- 分页链接 -->
						<c:if test="${pager.pageCount>1}">
							<li><a href="News?page=1">首页</a></li>

							<c:if test="${pager.displayPages[0]!=1}">
								<li>...</li>
							</c:if>
							<c:forEach items="${pager.displayPages}" var="pageIndex">
								<li <c:if test="${pageIndex==pager.pageNo}">class="current"</c:if>><a href="News?page=${pageIndex}">${pageIndex}</a></li>
							</c:forEach>
							<c:if test="${pager.displayPages[fn:length(pager.displayPages)-1]!=pager.pageCount}">
								<li>...</li>
							</c:if>
							<li><a href="News?page=${pager.pageCount}">尾页</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2020 皓晨教育 All Rights Reserved.
		湘ICP证1000001号</div>
</body>
</html>
