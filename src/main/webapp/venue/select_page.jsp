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

<h3>��Ƭd��:</h3>
	
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
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
        <b>��J���a�s�� (�p1):</b>
        <input type="text" name="venId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="venueSvc" scope="page" class="com.venue.model.VenueService" />
   
  <li>
     <FORM METHOD="post" ACTION="venue.do" >
       <b>��ܳ��a�s��:</b>
       <select size="1" name="venId">
         <c:forEach var="venueVO" items="${venueSvc.all}" > 
          <option value="${venueVO.venId}">${venueVO.venId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="venue.do" >
       <b>��ܳ��a�W��:</b>
       <select size="1" name="venId">
         <c:forEach var="venueVO" items="${venueSvc.all}" > 
          <option value="${venueVO.venId}">${venueVO.venName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>


<h3>���a�޲z</h3>

<ul>
  <li><a href='addVenue.jsp'>Add</a> a new Venue.</li>
</ul>

</body>
</html>