<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

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
	<div class="main">
		<h2>新增商品</h2>
		<div class="manage">
			<form action="ProductUpload?action=add" method="post" enctype="multipart/form-data" id="productAdd">
				<table class="form">
					<tr>
						<td class="field">商品名称(*)：</td>
						<td><input type="text" class="text" name="name"/>
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="field">描述：</td>
						<td><input type="text" class="text" name="description"/></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="categoryId">
								<c:forEach items="${categories}" var="category"  >								
								<c:if test="${category.parentId==0}">
								<option value="<c:out value='${category.id}' />" disabled>								         
									<c:out value="${category.name}"/>	
								</option>
								</c:if>								
								<c:if test="${category.parentId!=0}"> 
								<option value="<c:out value='${category.id}'/>" >								         
										└<c:out value="${category.name}"/>
								</option>
								</c:if>								
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品价格(*)：</td>
						<td><input type="text" class="text tiny" name="price"/> 元<span></span>	
						</td>
					</tr>
					<tr>
						<td class="field">库存(*)：</td>
						<td><input type="text" class="text tiny" name="stock"/><span></span>
						</td>
					</tr>
					<tr>
						<td class="field">商品图片(*)：</td>
						<td><input type="file" class="text" name="photo" /><span></span></td>
					</tr>					
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" value="确定" /></label></td>
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
