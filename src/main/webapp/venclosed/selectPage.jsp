<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
<title>Venue Closed</title>
</head>
<body>
	<h2>管理場地不開放系統</h2>
	<a href="${pageContext.request.contextPath}/venClosed/venClosed.do?action=getAll">查詢所有不開放日期</a>
	<br><br>
	<ul>
		<li>
	    	<FORM METHOD="post" ACTION="venClosed/venClosed.do" >
	        	<b>輸入訂單編號 (1.2.3...):</b>
	        	<input type="text" name="closedDateId">
	        	<input type="hidden" name="action" value="getOne_For_Display"><font color=red>${errorMsgs.empno}</font>
	        	<input type="submit" value="送出">
	    	</FORM>
	  	</li>
  	
<%--   	<jsp:useBean id="venClosedS" scope="page" class="" /> --%>
   
<!-- 		<li> -->
<!-- 			<FORM METHOD="post" ACTION="venClosed/venClosed.do" > -->
<!-- 	      		<b>選擇場地:</b> -->
<!-- 	       		<select size="1" name="closedDateId"> -->
<%-- 	         		<c:forEach var="venClosedVO" items="${venClosedSvc.all}" >  --%>
<%-- 	          			<option value="${venClosedVO.closedDateId}"><b>場地</b>${venClosedVO.venId} --%>
<%-- 	         		</c:forEach>    --%>
<!-- 	       		</select> -->
<!-- 	       		<input type="hidden" name="action" value="getOne_For_Display"> -->
<!-- 	       		<input type="submit" value="送出"> -->
<!-- 	     	</FORM> -->
<!-- 		</li> -->
<!-- 	</ul>	  -->
	 
	 
	
<!-- 	<h3><b>複合查詢 (使用 Criteria Query)：</b></h3> -->
<%-- 	<form action="${pageContext.request.contextPath}/emp/emp.do" method="post"> --%>
<!-- 		<p><label>員工名字模糊查詢：</label></p> -->
<!-- 		<input type="text" name="ename"><br> -->
<!-- 		<p><label>員工職位：</label></p> -->
<!-- 		<select name="job"> -->
<!-- 			<option value="">選取職位</option> -->
<!-- 			<option value="PRESIDENT">PRESIDENT</option> -->
<!-- 			<option value="MANAGER">MANAGER</option> -->
<!-- 			<option value="SALESMAN">SALESMAN</option> -->
<!-- 			<option value="CLERK">CLERK</option> -->
<!-- 			<option value="ANALYST">ANALYST</option> -->
<!-- 		</select> -->
<!-- 		<p><label>到職日期間範圍</label></p> -->
<!-- 		<input type="date" name="starthiredate"> ～ <input type="date" name="endhiredate"><br> -->
<!-- 		<p><label>薪資範圍</label></p> -->
<!-- 		<input type="text" name="startsal"> ～ <input type="text" name="endsal"><br> -->
<!-- 		<p><input type="submit" value="送出"></p> -->
<!-- 		<input type="hidden" name="action" value="compositeQuery"> -->
<!-- 	</form> -->
</body>
</html>