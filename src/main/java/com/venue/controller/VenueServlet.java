package com.venue.controller;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.venue.model.*;

@MultipartConfig(maxFileSize = 16177215)
public class VenueServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("venId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入場地編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/venue/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer venId = null;
			try {
				venId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("場地編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/venue/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			VenueService venSvc = new VenueService();
			VenueVO venVO = venSvc.getOneVenue(venId);
			if (venVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/venue/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("venVO", venVO); // 資料庫取出的empVO物件,存入req
			String url = "/venue/listOneVenue.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer venId = Integer.valueOf(req.getParameter("venId"));

			/*************************** 2.開始查詢資料 ****************************************/
			VenueService venSvc = new VenueService();
			VenueVO venVO = venSvc.getOneVenue(venId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("venVO", venVO); // 資料庫取出的empVO物件,存入req
			String url = "/venue/update_venue_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer venId = Integer.valueOf(req.getParameter("venId").trim());

			VenueService venSvc = new VenueService();
			VenueVO venVO = venSvc.getOneVenue(venId);
			String prevVenName = venVO.getVenName();
			String venName = req.getParameter("venName");
			String venNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (venName == null || venName.trim().length() == 0) {
				errorMsgs.add("場地名稱: 請勿空白");
			} else if (!venName.trim().matches(venNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("場地名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			} else if (venSvc.isVenueUsed(venName) && !prevVenName.toLowerCase().equals(venName.toLowerCase())) {
				errorMsgs.add("場地名稱已經被使用過");
			}

			Integer venTypeId = Integer.valueOf(req.getParameter("venTypeId").trim());

			String venDescr = req.getParameter("venDescr").trim();
			if (venDescr == null || venDescr.trim().length() == 0) {
				errorMsgs.add("場地說明請勿空白");
			}

			String venLoc = req.getParameter("venLoc").trim();
			if (venLoc == null || venLoc.trim().length() == 0) {
				errorMsgs.add("場地地點請勿空白");
			}

			BigDecimal venPrice = new BigDecimal(0);
			if (!req.getParameter("venPrice").trim().isEmpty()) {
				venPrice = new BigDecimal(req.getParameter("venPrice").trim());
			}
			Byte venStatus = Byte.parseByte(req.getParameter("venStatus"));

			InputStream inputStream = null; // input stream of the upload file
			byte[] venPic = venVO.getVenPic();

			// obtains the upload file part in this multipart request
			Part filePart = req.getPart("venPic");
			if (filePart != null && filePart.getSize() != 0) {
				// prints out some information for debugging
//	            System.out.println(filePart.getName());
//	            System.out.println(filePart.getSize());
//	            System.out.println(filePart.getContentType());

				// obtains input stream of the upload file
				inputStream = filePart.getInputStream();
				venPic = inputStream.readAllBytes();
				inputStream.close();
			}


//String job = req.getParameter("job").trim();
//				if (job == null || job.trim().length() == 0) {
//					errorMsgs.add("職位請勿空白");
//				}	
//				
//				java.sql.Date hiredate = null;
//				try {
//hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}
//
//				Double sal = null;
//				try {
//sal = Double.valueOf(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("薪水請填數字.");
//				}
//
//				Double comm = null;
//				try {
//comm = Double.valueOf(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("獎金請填數字.");
//				}
//
//Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());

			venVO.setVenId(venId);
			venVO.setVenName(venName);
			venVO.setVenTypeId(venTypeId);
			venVO.setVenDescr(venDescr);
			venVO.setVenLoc(venLoc);
			venVO.setVenPrice(venPrice);
			venVO.setVenStatus(venStatus);

			if (filePart != null && filePart.getSize() != 0 && errorMsgs.isEmpty()) {
				venVO.setVenPic(venPic);
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("venVO", venVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/venue/update_venue_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			venSvc.updateVenue(venId, venName, venPic, venTypeId, venDescr, venLoc, venPrice, venStatus);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("venVO", venVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/venue/listOneVenue.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			// check database for venName uniqueness
			VenueService venSvc = new VenueService();
			String venName = req.getParameter("venName");
			String venNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (venName == null || venName.trim().length() == 0) {
				errorMsgs.add("場地名稱: 請勿空白");
			} else if (!venName.trim().matches(venNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("場地名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			} else if (venSvc.isVenueUsed(venName)) {
				errorMsgs.add("場地名稱已經被使用過");
			}

			Integer venTypeId = Integer.valueOf(req.getParameter("venTypeId").trim());

			String venDescr = req.getParameter("venDescr").trim();
			if (venDescr == null || venDescr.trim().length() == 0) {
				errorMsgs.add("場地說明請勿空白");
			}

			String venLoc = req.getParameter("venLoc").trim();
			if (venLoc == null || venLoc.trim().length() == 0) {
				errorMsgs.add("場地地點請勿空白");
			}

			BigDecimal venPrice = new BigDecimal(0);
			if (!req.getParameter("venPrice").trim().isEmpty()) {
				venPrice = new BigDecimal(req.getParameter("venPrice").trim());
			}

			Byte venStatus = Byte.parseByte(req.getParameter("venStatus"));

			Timestamp venModTime = Timestamp.valueOf(LocalDateTime.now());

			InputStream inputStream = null; // input stream of the upload file
			byte[] venPic = null;

			// obtains the upload file part in this multipart request
			Part filePart = req.getPart("venPic");
			if (filePart != null) {
				// prints out some information for debugging
//	            System.out.println(filePart.getName());
//	            System.out.println(filePart.getSize());
//	            System.out.println(filePart.getContentType());

				// obtains input stream of the upload file
				inputStream = filePart.getInputStream();
				venPic = inputStream.readAllBytes();
				inputStream.close();
			}

			if (filePart != null && filePart.getSize() == 0) {
				errorMsgs.add("請選擇場地圖片");
			}

			VenueVO venVO = new VenueVO();
			venVO.setVenName(venName);
			venVO.setVenTypeId(venTypeId);
			venVO.setVenDescr(venDescr);
			venVO.setVenLoc(venLoc);
			venVO.setVenPrice(venPrice);
			venVO.setVenModTime(venModTime);
			venVO.setVenStatus(venStatus);
			venVO.setVenPic(venPic);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("venVO", venVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/venue/addVenue.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/

			venVO = venSvc.addVenue(venName, venTypeId, venDescr, venLoc, venPrice, venStatus, venModTime, 0.0, 0,
					venPic);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/venue/listAllVenue.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

//		if ("delete".equals(action)) { // 來自listAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//				/***************************1.接收請求參數***************************************/
//				Integer empno = Integer.valueOf(req.getParameter("empno"));
//				
//				/***************************2.開始刪除資料***************************************/
//				VenueService empSvc = new VenueService();
////				empSvc.deleteEmp(empno);
//				
//				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
//				String url = "/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//				successView.forward(req, res);
//		}
	}
}
