<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
<title>List VenueClosed</title>
</head>
<body>
	<h1>場地不開放列表</h1>
	<c:if test="${venClosedPageQty > 0}">
  		<b><font color=red>第${currentPage}/${venClosedPageQty}頁</font></b>
	</c:if>
	<br>
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png">
	<table style="width:50%; text-align:center;">
		<tr>
			<th>不開放場地編號</th>
			<th>場地編號</th>
			<th>場地不開放日期</th>
			<th>場地不開放原因</th>
		</tr>
		
		<c:forEach var="venClosedList" items="${venClosedList}">
			<tr>
				<td>${venClosedList.closedDateId}</td>
				<td>${venClosedList.venId}</td>
				<td>${venClosedList.closedDate}</td>
				<td>${venClosedList.closedReason}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/venClosed/venClosed.do?action=getAll&page=1">至第一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage - 1 != 0}">
		<a href="${pageContext.request.contextPath}/venClosed/venClosed.do?action=getAll&page=${currentPage - 1}">上一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage + 1 <= venClosedPageQty}">
		<a href="${pageContext.request.contextPath}/venClosed/venClosed.do?action=getAll&page=${currentPage + 1}">下一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage != venClosedPageQty}">
		<a href="${pageContext.request.contextPath}/venClosed/venClosed.do?action=getAll&page=${venClosedPageQty}">至最後一頁</a>&nbsp;
	</c:if>
	<br>
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png">
	<br><br>
	
	<a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>	
</body>
</html>