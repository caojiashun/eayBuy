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
<script type="text/javascript"
	src="../scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
	<jsp:include page="top.jsp" />
	<div id="main" class="wrap">
		<jsp:include page="leftbar.jsp" />
		<div class="main">

			<h2>新增分类</h2>
			<div class="manage">
				<form action="Category?action=add" method="post">
					<table class="form">
						<tr>
							<td class="field">父分类：</td>
							<td><select name="parentId">
									<option value="0">根分类</option>
									<c:forEach items="${categories}" var="item">
										<option value="${item.epcId}">
										└<c:out value="${item.epcName}"/>
										</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td class="field">分类名称：</td>
							<td><input type="text" class="text" name="name"
								value="${category.epcName}" /></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit"
									name="submit" value="确定" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2020 皓晨教育 All Rights Reserved.
		湘ICP证1000001号</div>
</body>
</html>
