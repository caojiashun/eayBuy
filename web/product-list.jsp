<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易购网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<script type="text/javascript" src="scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<jsp:include page="top.jsp" />
<div id="position" class="wrap">
	您现在的位置：<a href="Home">易购网</a> &gt; ${category.name}
</div>
<div id="main" class="wrap">
	<jsp:include page="leftbar.jsp" />
	<div class="main">
		<div class="product-list">
			<h2><a href="index?action=product_list&categoryId=0">全部商品</a><c:if test="${category.name!=null}">|${category.name}</c:if></h2>
			<div class="clear"></div>
			<ul class="product clearfix">
			    <c:if test="${pager.resultList==null || pager.resultList.size()==0}">
				             无此类商品！
				</c:if>
				<c:forEach items="${pager.resultList}" var="product">
				<li>
					<dl>
						<dt><a href="Product?action=view&entityId=${product.epId}" target="_self"><img src="files/${product.epFileName}" /></a></dt>
						<dd class="title"><a href="Product?action=view&entityId=${product.epId}" target="_self">${product.epName}</a></dd>
						<dd class="price"><fmt:formatNumber value="${product.epPrice}" type="NUMBER" minFractionDigits="2" /></dd>
					</dl>
				</li>
				</c:forEach>	
			</ul>
			<div class="clear"></div>
			
			<div class="pager">
					<ul class="clearfix">
						当前是第【${pager.pageNo}】页，共【${pager.pageTotal==1?"1":pager.pageTotal}】页
						<c:choose>
							<c:when test="${pager.pageNo <= 1}">
								<a href="index?action=product_list&pageNo=1">首页</a>
								<a href="index?action=product_list&pageNo=${pager.pageNo-1}">上一页</a>
							</c:when>
							<c:otherwise>
								<a href="index?action=product_list&pageNo=1">首页</a>
								<a href="index?action=product_list&pageNo=${pager.pageNo-1}">上一页</a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${pager.pageNo < pager.pageTotal}">
								<a href="index?action=product_list&pageNo=${pager.pageNo+1}">下一页</a>
								<a href="index?action=product_list&pageNo=${pager.pageTotal}">尾页</a>
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
<div id="footer">
	Copyright &copy; 2020 皓晨教育 All Rights Reserved. 湘ICP证1000001号
</div>
</body>
</html>
