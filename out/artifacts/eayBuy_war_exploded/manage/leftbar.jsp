<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="menu-mng" class="lefter">
	<div class="box">
		<dl>
			<!-- 管理员显示的导航菜单 -->
			<c:if test="${sessionScope.loginUser!=null && sessionScope.loginUser.euStatus > 1}">
				<dt>用户管理</dt>
				<dd>
					<a href="user.do?action=user">用户管理</a>
				</dd>
				<dt>商品信息</dt>
				<dd>
					<em><a href="Category?action=create">新增</a></em><a href="Category">分类管理</a>
				</dd>
				<dd>
					<em><a href="Product?action=create">新增</a></em><a href="Product">商品管理</a>
				</dd>
				<dt>订单管理</dt>
				<dd>
					<a href="Order">订单管理</a>
				</dd>
				<dt>留言管理</dt>
				<dd>
					<a href="GuestBook">留言管理</a>
				</dd>
				<dt>新闻管理</dt>
				<dd>
					<em><a href="News?action=create">新增</a></em><a href="News">新闻管理</a>
				</dd>
			</c:if>
			<!-- 普通用户显示的导航菜单 -->
			<c:if test="${sessionScope.loginUser!=null && sessionScope.loginUser.euStatus <= 1}">
				<dt>用户管理</dt>
				<dd>
					<a href="User?action=self">用户管理</a>
				</dd>
				<dt>订单管理</dt>
				<dd>
					<a href="Order">订单管理</a>
				</dd>
			</c:if>
		</dl>
	</div>
</div>