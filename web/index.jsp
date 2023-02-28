<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta charset="UTF-8">
<title>易购网 - 首页</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<script type="text/javascript" src="scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<jsp:include page="top.jsp" />
<div id="main" class="wrap">
	<jsp:include page="leftbar.jsp" />
	<div class="main">
		<div class="price-off">
			<!-- 轮播图 -->
            <div class="slideBox">
                <ul id="slideBox">
                    <li><img src="images/product/banner_1.jpg"/></li>
                    <li><img src="images/product/banner_2.jpg"/></li>
                    <li><img src="images/product/banner_3.jpg"/></li>
                    <li><img src="images/product/banner_4.jpg"/></li>
                </ul>
            </div>
			<h2>商品列表</h2>
			<ul class="product clearfix">
			<c:if test="${productPages==null && productPages == 0}">
				             无任何商品！
			</c:if>
			<c:forEach items="${productPages.resultList}" var="product">
				<li>
					<dl>
						<dt><a href="index?action=view&entityId=${product.epId}" target="_self"><img  src="files/${product.epFileName}" /></a></dt>
						<dd class="title"><a href="index?action=view&entityId=${product.epId}" target="_self">${product.epId}</a></dd>
						<dd class="price"><fmt:formatNumber value="${product.epPrice}" type="NUMBER" minFractionDigits="2" /></dd>
					</dl>
				</li>
			</c:forEach>
			</ul>
			<div class="pager">
					<ul class="clearfix">
						当前是第【${productPages.pageNo}】页，共【${productPages.pageTotal==1?"1":productPages.pageTotal}】页
						<c:choose>
							<c:when test="${productPages.pageNo <= 1}">
								<a href="index?action=list&pageNo=1">首页</a>
								<a href="index?action=list&pageNo=${productPages.pageNo-1}">上一页</a>
							</c:when>
							<c:otherwise>
								<a href="index?action=list&pageNo=1">首页</a>
								<a href="index?action=list&pageNo=${productPages.pageNo-1}">上一页</a>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${productPages.pageNo < productPages.pageTotal}">
								<a href="index?action=list&pageNo=${productPages.pageNo+1}">下一页</a>
								<a href="index?action=list&pageNo=${productPages.pageTotal}">尾页</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:void(0)">下一页</a>
								<a href="javascript:void(0)">尾页</a>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
		</div>
		<div class="side">
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
					<c:forEach items="${allNews}" var="news">					    
					   <c:if test="${news.enTitle.length()>16}">
					    <li><a href="News?action=view&entityId=${news.allNews}" target="_self">${news.enTitle.substring(0, 16)}...</a></li>
					    </c:if>
					    <c:if test="${news.enTitle.length()<=16}">
						<li><a href="News?action=view&entityId=${news.allNews}" target="_self">${news.enTitle}</a></li>
						</c:if> 
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2020 皓晨教育 All Rights Reserved. 湘ICP证1000001号
</div>
</body>
</html>
