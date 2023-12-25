<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.membership.model.*"%>
<%@ page import="java.util.Base64"%>
<%@ page import="util.Util"%>

<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
MembershipVO membershipVO = (MembershipVO) request.getAttribute("membershipVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>員工資料 - listOneMembership.jsp</title>

<style>
table#table-1 {
	background-color: pink;
	border: 2px solid pink;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

</style>

<style>
table {
	width: 1250px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid pink;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>會員資料 - listOneMembership.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>會員編號</th>
			<th>會員帳號</th>
			<th>會員電子信箱</th>
			<th>會員密碼</th>
			<th>會員姓名</th>
			<th>會員性別</th>
			<th>會員出生日期</th>
			<th>使用者名稱</th>
			<th>會員圖片</th>
			<th>會員帳戶狀態</th>
			<th>會員參加活動權限</th>
			<th>會員舉辦活動權限</th>
			<th>會員租借場地權限</th>
			<th>會員留言權限</th>
		</tr>
		<tr>
			<td>${membershipVO.memId}</td>
			<td>${membershipVO.memAcc}</td>
			<td>${membershipVO.memEmail}</td>
			<td>${membershipVO.memPwd}</td>
			<td>${membershipVO.memName}</td>
			<td>${membershipVO.memGender}</td>
			<td>${membershipVO.memBirthdate}</td>
			<td>${membershipVO.memUsername}</td>
<%-- 			<td> <img src="data:image/png;base64, <%= base64Image %>" --%>
<!-- 		 alt="Image" style="width: 150px; height: auto;"> -->

			<td> <img src="${membershipVO.memPic != null? 'data:'.concat(Util.getMimeType(membershipVO.memPic)).concat(';base64,').concat(Base64.getEncoder().encodeToString(membershipVO.memPic)): 'images/notfind.jpg'}"
		 alt="Image" style="width: 150px; height: auto;">
		 
	
				</td>
			<td>${membershipVO.isAccEna}</td>
			<td>${membershipVO.isPartEna}</td>
			<td>${membershipVO.isHostEna}</td>
			<td>${membershipVO.isRentEna}</td>
			<td>${membershipVO.isMsgEna}</td>
		</tr>
	</table>

</body>
</html>