<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<html>
<head>
<title>所有場地訂單資料 - listAllVenueOrder.jsp</title>
 
 <!-- 引入 Bootstrap CSS 文件 -->
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
                    <li class="nav-item"><a class="nav-link" href="register.html">註冊</a></li>
                    <li class="nav-item">
						<!-- 加入 data-bs-toggle 和 data-bs-target 以觸發 Modal -->
						<a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#loginModal">登入</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="index.html">首頁</a></li>
                    <li class="nav-item"><a class="nav-link" href="join.html">瀏覽活動</a></li>
                    <li class="nav-item"><a class="nav-link" href="rent.html">場地租借</a></li>
                    <li class="nav-item"><a class="nav-link" href="#discussion">討論區</a></li>
				</ul>
			  </div>
			</div>
		</nav>
    </div>
</header>

<main>
<table id="table-1">
	<tr><td>
		 <h3>所有場地訂單資料</h3>
	</td></tr>
</table>

<table id="table-2">
	<tr>
		<th>訂單編號</th>
		<th>場地編號</th>
		<th>會員編號</th>
		<th>員工編號</th>
		<th>預約日期</th>
		<th>電話號碼</th>
		<th>活動概述</th>
		<th>預估人數</th>
		<th>統編號碼</th>
		<th>成立時間</th>
		<th>付款方式</th>
		<th>轉帳帳號</th>
		<th>信用卡號</th>
		<th>訂單狀態</th>
		<th>租借狀態</th>
		<th>場地評分</th>
		<th>使用評論</th>
		<th>評論狀態</th>
		<th>評論時間</th>
		<th>場地訂金</th>
	</tr>
	<c:if test="${empPageQty > 0}">
  		<b><font color=red>第${currentPage}/${empPageQty}頁</font></b>
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
			     <input type="submit" value="修改">
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
            <a class="nav-link" href="about.html" style="display: inline-block; padding: 10px;">關於我們</a>
          </li>
          <li style="display: inline-block" class="nav-item">
            <a class="nav-link" href="customer.html" style="display: inline-block; padding: 10px;">客服中心</a>
          </li>
        </ul>
      </div>
      <div class="row">
        <p class="col-md-6">&copy; 2023 EventHub. All rights reserved.</p>
        <p class="col-md-6 d-flex justify-content-end">聯絡我們@eventhub.com</p>
      </div>
    </div>
  </footer>

</body>
</html>