<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>IBM Membership: Home</title>

<style>

table#table-1 {
	width: 450px;
	background-color: pink;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 2px ridge dipink;
	height: 80px;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td><h3>IBM Membership: Home</h3>
				<h4>( MVC )</h4></td>
		</tr>
	</table>

	<p>This is the Home page for IBM Membership: Home</p>

	<h3>資料查詢:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<ul>
		<li><a href='listAllMembership.jsp'>查詢全部會員資料</a> all Memberships. <br>
		<br></li>


		<li>
			<FORM METHOD="post" ACTION="membership.do">
				<b>輸入會員編號(如01):</b> <input type="text" name="memId"> <input
					type="hidden" name="action" value="getOne_For_Display"> <input
					type="submit" value="送出">
			</FORM>
		</li>

		<jsp:useBean id="membershipSvc" scope="page"
			class="com.membership.service.MembershipService" />

		<li>
			<FORM METHOD="post" ACTION="membership.do">
				<b>選擇會員編號:</b> <select size="1" name="memId">
					<c:forEach var="membershipVO" items="${membershipSvc.all}">
						<option value="${membershipVO.memId}">${membershipVO.memId}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post" ACTION="membership.do">
				<b>選擇會員姓名:</b> <select size="1" name="memId">
					<c:forEach var="membershipVO" items="${membershipSvc.all}">
						<option value="${membershipVO.memId}">${membershipVO.memAcc}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<ul>
			<li><a href='addMembership.jsp'>新增會員資料</a> a new Membership.</li>
		</ul>
</body>
</html>