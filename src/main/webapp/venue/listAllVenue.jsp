<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.venue.model.*"%>
<%@ page import="com.venue.model.*"%>
<%@ page import="util.Util"%>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    VenueService venSvc = new VenueService();
    List<VenueVO> list = venSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有場地資料 - listAllVenue.jsp</title>

<link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>


<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
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

<style>
  table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有場地資料 - listAllVenue.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table id="venues">
	<thead>
	<tr>
<!-- 		<th>場地編號</th> -->
		<th>場地編號</th>
		<th>場地名稱</th>
		<th>場地圖片</th>
		<th>場地地點</th>
		<th>場地租金</th>
		<th>場地狀態</th>
		<th>評價總分數</th>
		<th>評價總人數</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="venVO" items="${list}">
		<tr>
			<td>${venVO.venId}</td>
			<td>${venVO.venName}</td>
<%-- 			<td><img style="max-width:200px" src=${"data:".concat(Util.getMimeType(venVO.venPic)).concat(";base64,").concat(Base64.getEncoder().encodeToString(venVO.venPic))}></td> --%>
			<td><img style="max-width:200px" src="data:${Util.getMimeType(venVO.venPic)};base64,${Base64.getEncoder().encodeToString(venVO.venPic)}"></td>
			<td>${venVO.venLoc}</td>
			<td>${venVO.venPrice}</td>
			<td>${venVO.venStatus == 1? "下架":"上架"}</td>
			<td>${venVO.venTotRating}</td> 
			<td>${venVO.venRateCount}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/venue/venue.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="venId"  value="${venVO.venId}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/venue/venue.do" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="刪除"> -->
<%-- 			     <input type="hidden" name="venId"  value="${venVO.venId}"> --%>
<!-- 			     <input type="hidden" name="action" value="delete"></FORM> -->
<!-- 			</td> -->
		</tr>
	</c:forEach>
	</tbody>
</table>

<script>
	new DataTable('#venues');
</script>

</body>
</html>