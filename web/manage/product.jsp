<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

<script type="text/javascript">
	//这个方法作为跳转页面的方法
	function goPage(pageIndex) {
		$("[name='page']").val(pageIndex);
		$("form").submit();
	}
</script>
</head>
<body>
	<jsp:include page="top.jsp" />
	<div id="main" class="wrap">
		<jsp:include page="leftbar.jsp" />
		<div class="main">
			<h2>商品管理</h2>
			<div class="manage">
				<div class="search">
					<form method="post" action="Product?action=list">
						<input type="hidden" name="page" value="1"/>
						所属分类： <select name="categoryId" id="category">
							<option value="0">根分类</option>
							<c:forEach items="${categories}" var="cgy">
								<option value="${cgy.epcId}"
									<c:if test="${param.epId==cgy.epcId}">selected="selected"</c:if>>${cgy.epcName}</option>
							</c:forEach>
						</select>
							商品名称：<input type="text" class="text" name="name" id="name" value="${param.name}" />
							价格区间：<input type="text" name="minPrice" size="5" value="${param.minPrice}" />
							-
							<input type="text" name="maxPrice" size="5" value="${param.maxPrice}" />
							<label class="ui-blue">
								<input type="submit" value="查询" />
							</label>
					</form>
				</div>
				<div class="spacer"></div>
				<table class="list">
					<c:if test="${pager.resultList==null || pager.resultList.size()==0}">
				             无符合此条件的商品！
				    </c:if>
					<c:if test="${pager.resultList!=null && pager.resultList.size()>0}">
						<tr>
							<th>编号</th>
							<th>商品分类</th>
							<th>商品名称</th>
							<th>商品价格</th>
							<th>操作</th>
						</tr>
					</c:if>

					<c:forEach items="${pager.resultList}" var="product">
						<c:set var="i" value="${i+1}"></c:set>
						<tr>
							<td class="first w4 c"><c:out value="${product.epId}" /></td>
							<td class="thumb">${product.epcId}</td>
							<td class="thumb"><img src="../files/${product.epFileName}" /><a
								href="Product?action=read&entityId=${product.epId}"><c:out
										value="${product.epName}" /> </a></td>
							<td class="thumb">￥<fmt:formatNumber pattern="#,###.##"
									value="${product.epPrice}" /></td>
							<td class="w1 c"><a
								href="Product?action=read&entityId=${product.epId}">修改</a>
								<div class="manageDel">
									<a href="Product?action=delete&entityId=${product.epId}">删除</a>
								</div></td>
						</tr>
					</c:forEach>
				</table>

				<div class="pager">
					<ul class="clearfix">
						当前是第【${pager.pageNo}】页，共【${pager.pageTotal}】页
						<c:choose>
							<c:when test="${pager.pageNo <= 1}">
								<a href="Product?action=list&pageNo=1">首页</a>
								<a href="Product?action=list&pageNo=${pager.pageNo-1}">上一页</a>
							</c:when>
							<c:otherwise>
								<a href="Product?action=list&pageNo=1">首页</a>
								<a href="Product?action=list&pageNo=${pager.pageNo-1}">上一页</a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${pager.pageNo < pager.pageTotal}">
								<a href="Product?action=list&pageNo=${pager.pageNo+1}">下一页</a>
								<a href="Product?action=list&pageNo=${pager.pageTotal}">尾页</a>
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
	<div id="footer">Copyright &copy; 2020 皓晨教育 All Rights Reserved.湘ICP证1000001号</div>
</body>
</html>
