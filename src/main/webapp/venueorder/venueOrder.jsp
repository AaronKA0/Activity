<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>����: ���a�q��</title>

<!-- �ޤJ Bootstrap CSS ��� -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<style>
  main{
    height: calc(100% - 200px);
    margin: 0 20px;
  }
  table#table-1 {
  	width: 100%;
  	background-color: #FFDA81;
    border: 3px ridge Gray;
	margin-top: 5px;
	margin-bottom: 10px;
    text-align: center;
  }
  th, td {
    padding: 5px;
    text-align: center;
    white-space: nowrap;
  }
</style>

</head>
<body bgcolor='white'>
  <header class="bg-Warning text-dark">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-white bg-Warning">
            <div class="container-fluid">
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <a class="navbar-brand" href="#"><img src="images/logo.jpg" width="80" height="80" border="0"></a>
              <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                  </form>
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="register.html">���U</a></li>
                    <li class="nav-item">
                      <!-- �[�J data-bs-toggle �M data-bs-target �HĲ�o Modal -->
                      <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#loginModal">�n�J</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="index.html">����</a></li>
                    <li class="nav-item"><a class="nav-link" href="join.html">�s������</a></li>
                    <li class="nav-item"><a class="nav-link" href="rent.html">���a����</a></li>
                    <li class="nav-item"><a class="nav-link" href="#discussion">�Q�װ�</a></li>
                  </ul>           
              </div>
            </div>
          </nav>
    </div>
  </header>

<main>
<table id="table-1">
   <tr><td>
   		<h3>����: ���a�q�� - select_page.jsp</h3>
   	</td></tr>
</table>

<h5>��Ƭd��:</h5>
	
<%-- ���~��C --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">�Эץ��H�U���~:</font> -->
<!-- 	<ul> -->
<%-- 	    <c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<ul>
  <li><a href='listAllVenueOrder.jsp'>List</a> all VenueOrder.<br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="venOrder.do" >
        <b>��J�q��s�� (1.2.3...):</b>
        <input type="text" name="venOrderId">
        <input type="hidden" name="action" value="getOne_For_Display"><font color=red>${errorMsgs.empno}</font>
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="venOrderSvc" scope="page" class="com.venorder.controller.VenOrderService" />
   
  <li>
     <FORM METHOD="post" ACTION="venOrder.do" >
       <b>��ܭq��s��:</b>
       <select size="1" name="venOrderId">
         <c:forEach var="venOrderVO" items="${venOrderSvc.all}" > 
          <option value="${venOrderVO.venOrderId}">${venOrderVO.venOrderId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="venOrder.do" >
       <b>��ܹq�ܸ��X:</b>
       <select size="1" name="venOrderId">
         <c:forEach var="venOrderVO" items="${venOrderSvc.all}" > 
          <option value="${venOrderVO.venOrderId}">${venOrderVO.memPhone}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>


<h5>���a�q��޲z</h5>

<ul>
  <li><a href='addVenueOrder.jsp'>Add</a> a new VenueOrder.</li>
</ul>
</main>

  <footer class="bg-Warning text-white">
    <div class="container">
      <div class="footer-links">
        <ul style="display: block" class="navbar-nav">
          <li style="display: inline-block" class="nav-item">
            <a class="nav-link" href="about.html" style="display: inline-block; padding: 10px;">����ڭ�</a>
          </li>
          <li style="display: inline-block" class="nav-item">
            <a class="nav-link" href="customer.html" style="display: inline-block; padding: 10px;">�ȪA����</a>
          </li>
        </ul>
      </div>
      <div class="row">
        <p class="col-md-6">&copy; 2023 EventHub. All rights reserved.</p>
        <p class="col-md-6 d-flex justify-content-end">�p���ڭ�@eventhub.com</p>
      </div>
    </div>
  </footer>
</body>
</html>