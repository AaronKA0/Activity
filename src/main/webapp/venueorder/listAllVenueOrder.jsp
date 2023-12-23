<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<html>
<head>
<title>�Ҧ����a�q���� - listAllVenueOrder.jsp</title>
 
 <!-- �ޤJ Bootstrap CSS ��� -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
 	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<style>
  main{
    height: calc(100% - 200px);
    margin: 0 20px;
  }
  table {
  	width: 100%;
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
    white-space: nowrap;
  }
  table#table-1 {
	background-color: #FFDA81;
    border: 3px ridge Gray;
    margin-top: 5px;
	margin-bottom: 10px;
    text-align: center;
  }
  table#table-2 {
	display: block;
	overflow-x: auto;
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
              <a class="navbar-brand" href="select_page.jsp"><img src="images/logo.jpg" width="80" height="80" border="0"></a>
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
		 <h3>�Ҧ����a�q����</h3>
	</td></tr>
</table>

<table id="table-2">
	<tr>
		<th>�q��s��</th>
		<th>���a�s��</th>
		<th>�|���s��</th>
		<th>���u�s��</th>
		<th>�w�����</th>
		<th>�q�ܸ��X</th>
		<th>���ʷ��z</th>
		<th>�w���H��</th>
		<th>�νs���X</th>
		<th>���߮ɶ�</th>
		<th>�I�ڤ覡</th>
		<th>��b�b��</th>
		<th>�H�Υd��</th>
		<th>�q�檬�A</th>
		<th>���ɪ��A</th>
		<th>���a����</th>
		<th>�ϥε���</th>
		<th>���ת��A</th>
		<th>���׮ɶ�</th>
		<th>���a�q��</th>
	</tr>
	<c:if test="${empPageQty > 0}">
  		<b><font color=red>��${currentPage}/${empPageQty}��</font></b>
	</c:if>
		<tr>
			<td>${venOrderVO.venOrderId}</td>
			<td>${venOrderVO.venId}</td>
			<td>${venOrderVO.memId}</td>
			<td>${venOrderVO.empId}</td>
			<td>${venOrderVO.orderDate}</td>
			<td>${venOrderVO.memPhone}</td>
			<td>${venOrderVO.actDescr}</td>
			<td>${venOrderVO.userCount}</td>
			<td>${venOrderVO.memTaxid}</td>
			<td>${venOrderVO.orderTime}</td>
			<td>${venOrderVO.orderPayType}</td>
			<td>${venOrderVO.memTransferNum}</td>
			<td>${venOrderVO.memCreditNum}</td>
			<td>${venOrderVO.orderStatus}</td>
			<td>${venOrderVO.venRentStatus}</td>
			<td>${venOrderVO.venRating}</td>
			<td>${venOrderVO.venCom}</td>
			<td>${venOrderVO.venComStatus}</td>
			<td>${venOrderVO.venComTime}</td>
			<td>${venOrderVO.venResFee}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/venueorder/venOrder.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�ק�">
			     <input type="hidden" name="venOrderId"  value="${venOrderVO.venOrderId}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
		</tr>
</table>
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