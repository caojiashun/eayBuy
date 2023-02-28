<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="lefter">
	<div class="box">
		<h2>商品分类</h2>
		<dl>
			<c:forEach items="${categories}" var="category">
				<c:if test="${category.epcParentId==0}">
					<dt>${category.epcName}</dt>
				</c:if>
				<c:if test="${category.epcParentId!=0}">
					<dd>
						<a href="index?action=product_list&categoryId=${category.epcId}">${category.epcName}</a>
					</dd>
				</c:if>
			</c:forEach>
		</dl>
	</div>

	<div class="spacer"></div>
	<div class="last-view">
		<h2>最近浏览</h2>
		<dl class="clearfix">
<%--			<c:if test="${pro == null}">--%>
<%--				没有--%>
<%--			</c:if>--%>
<%--			<c:forEach items="${pro}" var="product">--%>
<%--				<dt>--%>
<%--					<img style="width: 30px; height: 20px;"--%>
<%--						src="files/${product.epFileName}" />--%>
<%--				</dt>--%>
<%--				<dd>--%>
<%--					<a href="Product?action=view&entityId=${product.id}">${product.epName}</a>--%>
<%--				</dd>--%>
<%--			</c:forEach>--%>
		</dl>
	</div>
</div>