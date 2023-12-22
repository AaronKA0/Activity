<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Venue: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
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
   <tr><td><h3>Venue: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for Venue: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllVenue.jsp'>List</a> all venues.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="venue.do" >
        <b>輸入場地編號 (如1):</b>
        <input type="text" name="venId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="venueSvc" scope="page" class="com.venue.model.VenueService" />
   
  <li>
     <FORM METHOD="post" ACTION="venue.do" >
       <b>選擇場地編號:</b>
       <select size="1" name="venId">
         <c:forEach var="venueVO" items="${venueSvc.all}" > 
          <option value="${venueVO.venId}">${venueVO.venId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="venue.do" >
       <b>選擇場地名稱:</b>
       <select size="1" name="venId">
         <c:forEach var="venueVO" items="${venueSvc.all}" > 
          <option value="${venueVO.venId}">${venueVO.venName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>場地管理</h3>

<ul>
  <li><a href='addVenue.jsp'>Add</a> a new Venue.</li>
</ul>

</body>
</html>