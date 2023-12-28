<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.membership.model.*"%>


<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
MembershipVO membershipVO = (MembershipVO) request.getAttribute("membershipVO");
%>



<!-- <%=membershipVO == null%>  -->
<!--${empVO.deptno}-- -- line 100 -->

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>會員資料新增 - addMembership.jsp</title>

<style>
table#table-1 {
	background-color: pink;
	text-align: center;
}

table#table-1 h4 {
	color: black;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 700px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>會員資料新增 - addMembership.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="65" border="0">回首頁</a>
				</h4>

			</td>
		</tr>
	</table>

	<h3>資料新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<form method="post" action="membership.do" enctype="multipart/form-data">
		<table>

			<tr>
				<td>會員帳號:<font color=red><b>*</b></font></td>
				<td><input type="TEXT" name="memAcc"
					value="<%=(membershipVO == null) ? "ballball" : membershipVO.getMemAcc()%>"
					size="45" /></td>
			</tr>

			<tr>
				<td>會員電子信箱:<font color=red><b>*</b></font></td>
				<td><input type="TEXT" name="memEmail"
					value="<%=(membershipVO == null) ? "balbrother8787@yahoo.com.tw" : membershipVO.getMemEmail()%>"
					size="45" /></td>
			</tr>

			<tr>
				<td>會員密碼:<font color=red><b>*</b></font></td>
				<td><input type="TEXT" name="memPwd"
					value="<%=(membershipVO == null) ? "bbbbbbbb" : membershipVO.getMemPwd()%>"
					size="45" /></td>
			</tr>

			<tr>
				<td>會員姓名:<font color=red><b>*</b></font></td>
				<td><input type="TEXT" name="memName"
					value="<%=(membershipVO == null) ? "江俞萩" : membershipVO.getMemName()%>"
					size="45" /></td>
			</tr>

			<tr>
				<td>會員性別:<font color=red><b>*</b></font></td>
				<td><input type="radio" name="memGender" value="1"
					${(membershipVO.memGender==1)?'checked':''} />女</td>
				<td><input type="radio" name="memGender" value="2"
					${(membershipVO.memGender==2)?'checked':'' } />男</td>
			</tr>

			<tr>
				<td>會員出生日期:<font color=red><b>*</b></font></td>
				<td><input name="memBirthdate" id="f_date1" type="text"></td>
			</tr>

			<tr>
				<td>使用者名稱:<font color=red><b>*</b></font></td>
				<td><input type="TEXT" name="memUsername"
					value="<%=(membershipVO == null) ? "江俞萩" : membershipVO.getMemUsername()%>"
					size="45" /></td>
			</tr>

			<tr>
				<td>會員圖片:</td>
				<td><input type="file" name="memPic"
					accept="image/*"></td>
			</tr>

			<tr>
				<td>會員帳戶狀態:</td>
				<td><input type="radio" name="isAccEna" value="1"
					${(membershipVO.isAccEna==1)?'checked':''} />已停用會員帳戶</td>
				<td><input type="radio" name="isAccEna" value="2"
					${(membershipVO.isAccEna==2)?'checked':''} />沒有停用會員帳戶</td>
			</tr>

			<tr>
				<td>會員參加活動權限:</td>
				<td><input type="radio" name="isPartEna" value="1"
					${(membershipVO.isPartEna==1)?'checked':''} />會員無法參加活動</td>
				<td><input type="radio" name="isPartEna" value="2"
					${(membershipVO.isPartEna==2)?'checked':''} />會員可以參加活動</td>
			</tr>

			<tr>
				<td>會員舉辦活動權限:</td>
				<td><input type="radio" name="isHostEna" value="1"
					${(membershipVO.isHostEna==1)?'checked':''} />會員無法舉辦活動</td>
				<td><input type="radio" name="isHostEna" value="2"
					${(membershipVO.isHostEna==2)?'checked':''} />會員可以舉辦活動</td>
			</tr>

			<tr>
				<td>會員租借場地權限:</td>
				<td><input type="radio" name="isRentEna" value="1"
					${(membershipVO.isRentEna==1)?'checked':''} />會員無法租借場地</td>
				<td><input type="radio" name="isRentEna" value="2"
					${(membershipVO.isRentEna==2)?'checked':''} />會員可以租借場地</td>
			</tr>

			<tr>
				<td>會員留言權限:</td>
				<td><input type="radio" name="isMsgEna" value="1"
					${(membershipVO.isMsgEna==1)?'checked':''} />會員無法留言</td>
				<td><input type="radio" name="isMsgEna" value="2"
					${(membershipVO.isMsgEna==2)?'checked':''} />會員可以留言</td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>
</body>




<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<%
java.sql.Date memBirthdate = null;
try {
	memBirthdate = membershipVO.getMemBirthdate();
} catch (Exception e) {
	memBirthdate = new java.sql.Date(System.currentTimeMillis());
}
%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=memBirthdate%> ', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});

	// ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

	//      1.以下為某一天之前的日期無法選擇
	//      var somedate1 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      2.以下為某一天之後的日期無法選擇
	//      var somedate2 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
	//      var somedate1 = new Date('2017-06-15');
	//      var somedate2 = new Date('2017-06-25');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//		             ||
	//		            date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//     }});
</script>
</html>