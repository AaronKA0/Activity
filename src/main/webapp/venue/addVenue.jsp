<%@page import="java.util.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.venue.model.*"%>

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
VenueVO venVO = (VenueVO) request.getAttribute("venVO");
%>

<%-- <%=venVO == null%> --%>
<%-- -- ${venVO.venStatus} -- --%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>場地資料新增 - addVenue.jsp</title>

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
	width: 450px;
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

<style>
        #preview {
            border: 1px solid lightgray;
            display: inline-block;
            width: 100px;
            min-height: 150px;
            position: relative;
        }
        
        #preview span.text {
            position: absolute;
            display: inline-block;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
			z-index: 1;
            color: lightgray;
        }
        
        #preview img.preview_img {
        	position: relative;
            width: 100%;
            z-index:10;
        }
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>場地資料新增 - addVenue.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp"><img src="images/tomcat.png"
						width="100" height="100" border="0">回首頁</a>
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

	<FORM METHOD="post" ACTION="venue.do" name="form1" enctype="multipart/form-data">
		<table>

			<tr>
				<td>場地名稱:</td>
				<td><input type="TEXT" name="venName"
					value="<%=(venVO == null) ? "場地名稱" : venVO.getVenName()%>"
					size="45" /></td>
			</tr>

			<jsp:useBean id="venTypeSvc" scope="page"
				class="com.venuetype.model.VenueTypeService" />
			<tr>
				<td>場地類別:<font color=red><b>*</b></font></td>
				<td><select size="1" name="venTypeId">
						<c:forEach var="venTypeVO" items="${venTypeSvc.all}">
							<option value="${venTypeVO.venTypeId}"
								${venVO.venTypeId==venTypeVO.venTypeId? 'selected':'' }>${venTypeVO.venTypeName}
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>場地說明:</td>
				<td><input type="TEXT" name="venDescr"
					value="<%=(venVO == null) ? "場地說明" : venVO.getVenDescr()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>場地地點:</td>
				<td><input type="TEXT" name="venLoc"
					value="<%=(venVO == null) ? "桃園" : venVO.getVenLoc()%>" size="45" /></td>
			</tr>

			<!-- make it allow double values -->
			<tr>
				<td><label for="venPrice">場地租金:</label></td>
				<td>
				
				<input type="NUMBER" name="venPrice" min="0" step="0.01" id="venPrice"
					value="<%=(venVO == null) ? 0 : venVO.getVenPrice()%>" /></td>
			</tr>

			<tr>
				<td>場地狀態:<font color=red><b>*</b></font></td>
				<td><select size="1" name="venStatus">
						<option value="1" ${venVO.venStatus == 1? 'selected':''}><%="下架"%>
						<option value="2" ${venVO.venStatus == 2? 'selected':''}><%="上架"%>				
				</select></td>
			</tr>

			<tr>
				<td>場地圖片:</td>
				<td><input type="file" id="p_file" name="venPic" accept="image/*"></td>
				    
			</tr>
			<tr><td><span id="preview"><span class="text">預覽圖</span></span>
			</td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>


	<script>
    let p_file = document.getElementById("p_file");
    let preview = document.getElementById("preview");
    let img_base64;
    
    function readFile(file) {
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.addEventListener("load", function() {
            preview.innerHTML = "<span class='text'>預覽圖</span>";
            img_base64 = reader.result;
            preview.insertAdjacentHTML("afterbegin", `<img src="\${reader.result}" class="preview_img"></img>`);
        });
    }
    
    p_file.addEventListener("change", function() {
        let file = this.files[0];
        if (this.files.length > 0) {
            readFile(file);
        } else {
            img_base64 = null;
            preview.innerHTML = "<span class='text'>預覽圖</span>";
        }
    });
	</script>

</body>