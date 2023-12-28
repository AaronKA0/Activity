package com.membership.controller;

import java.io.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.membership.model.*;
import com.membership.service.*;

@MultipartConfig(maxFileSize = 16177215)
public class MembershipServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>(); // LinkedList的列表通常用來存儲和管理一組字符串類型的錯誤消息或訊息
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("memId");
			if (str == null || (str.trim()).length() == 0) { // str == null防呆用的
				errorMsgs.add("請輸入會員編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/membership/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer memId = null;
			try {
				memId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("會員編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/membership/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			MembershipService membershipSvc = new MembershipService();
			MembershipVO membershipVO = membershipSvc.getOneMembership(memId);
			if (membershipVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/membership/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("membershipVO", membershipVO); // 資料庫取出的empVO物件,存入req
			String url = "/membership/listOneMembership.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer memId = Integer.valueOf(req.getParameter("memId"));

			/*************************** 2.開始查詢資料 ****************************************/
			MembershipService membershipSvc = new MembershipService();

			MembershipVO membershipVO = membershipSvc.getOneMembership(memId);
			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("membershipVO", membershipVO); // 資料庫取出的empVO物件,存入req
			String url = "/membership/update_membership_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer memId = Integer.valueOf(req.getParameter("memId").trim());

			MembershipService membershipSvc = new MembershipService();
			MembershipVO membershipVO = membershipSvc.getOneMembership(memId);

			String memAcc = req.getParameter("memAcc");
			String memAccReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			String memAll = req.getParameter("membership.memAcc");
			if (memAcc == null || memAcc.trim().length() == 0) {
				errorMsgs.add("會員帳號: 請勿空白");
			} else if (!memAcc.trim().matches(memAccReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("會員帳號: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}
			String memEmail = req.getParameter("memEmail").trim();
			if (memEmail == null || memEmail.trim().length() == 0) {
				errorMsgs.add("信箱請勿空白");
			}

			String memPwd = req.getParameter("memPwd").trim();
			if (memPwd == null || memPwd.trim().length() == 0) {
				errorMsgs.add("密碼請勿空白");
			}

			String memName = req.getParameter("memName").trim();
			if (memName == null || memName.trim().length() == 0) {
				errorMsgs.add("姓名請勿空白");
			}

			Byte memGender = Byte.valueOf(req.getParameter("memGender").trim());

			java.sql.Date memBirthdate = null;
			try {
				memBirthdate = java.sql.Date.valueOf(req.getParameter("memBirthdate").trim());
			} catch (IllegalArgumentException e) {
				memBirthdate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			String memUsername = req.getParameter("memUsername").trim();
			if (memUsername == null || memUsername.trim().length() == 0) {
				errorMsgs.add("使用者名稱請勿空白");
			}

			// 修改圖片後如果沒有更新圖片 也要保留原本的檔案

			Byte isAccEna = Byte.valueOf(req.getParameter("isAccEna").trim());

			Byte isPartEna = Byte.valueOf(req.getParameter("isPartEna").trim());

			Byte isHostEna = Byte.valueOf(req.getParameter("isHostEna").trim());

			Byte isRentEna = Byte.valueOf(req.getParameter("isRentEna").trim());

			Byte isMsgEna = Byte.valueOf(req.getParameter("isMsgEna").trim());

//			Double sal = null;
//			try {
//				sal = Double.valueOf(req.getParameter("sal").trim());
//			} catch (NumberFormatException e) {
//				sal = 0.0;
//				errorMsgs.add("薪水請填數字.");
//			}
//
//			Double comm = null;
//			try {
//				comm = Double.valueOf(req.getParameter("comm").trim());
//			} catch (NumberFormatException e) {
//				comm = 0.0;
//				errorMsgs.add("獎金請填數字.");
//			}

//			Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());

			membershipVO.setMemId(memId);
			membershipVO.setMemAcc(memAcc);
			membershipVO.setMemEmail(memEmail);
			membershipVO.setMemPwd(memPwd);
			membershipVO.setMemName(memName);
			membershipVO.setMemGender(memGender);
			membershipVO.setMemBirthdate(memBirthdate);
			membershipVO.setMemUsername(memUsername);

			byte[] memPic = membershipVO.getMemPic();
			Part filePart = req.getPart("memPic");
			if (filePart != null && filePart.getSize() != 0 && errorMsgs.isEmpty()) {
				// obtains input stream of the upload file
				InputStream inputStream = filePart.getInputStream();
				memPic = inputStream.readAllBytes();
				inputStream.close();
				membershipVO.setMemPic(memPic);
			}

			membershipVO.setIsAccEna(isAccEna);
			membershipVO.setIsPartEna(isPartEna);
			membershipVO.setIsHostEna(isHostEna);
			membershipVO.setIsRentEna(isRentEna);
			membershipVO.setIsMsgEna(isMsgEna);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("membershipVO", membershipVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/membership/update_membership_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			membershipVO = membershipSvc.updateMembership(memId, memAcc, memEmail, memPwd, memName, memGender,
					memBirthdate, memUsername, memPic, isAccEna, isPartEna, isHostEna, isRentEna, isMsgEna);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("membershipVO", membershipVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/membership/listOneMembership.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String memAcc = req.getParameter("memAcc");
			String memAccReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (memAcc == null || memAcc.trim().length() == 0) {
				errorMsgs.add("會員姓名: 請勿空白");
			} else if (!memAcc.trim().matches(memAccReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("會員帳號: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String memEmail = req.getParameter("memEmail").trim();
			if (memEmail == null || memEmail.trim().length() == 0) {
				errorMsgs.add("信箱請勿空白");
			}

			String memPwd = req.getParameter("memPwd").trim();
			if (memPwd == null || memPwd.trim().length() == 0) {
				errorMsgs.add("密碼請勿空白");
			}

			String memName = req.getParameter("memName").trim();
			if (memName == null || memName.trim().length() == 0) {
				errorMsgs.add("姓名請勿空白");
			}

			Byte memGender = null;
			if (req.getParameter("memGender") == null) {
				errorMsgs.add("會員性別請勾選!");
			} else {
				memGender = Byte.valueOf(req.getParameter("memGender"));
			}

			java.sql.Date memBirthdate = null;
			try {
				memBirthdate = java.sql.Date.valueOf(req.getParameter("memBirthdate").trim());
			} catch (IllegalArgumentException e) {
				memBirthdate = new java.sql.Date(System.currentTimeMillis()); // 預設為當天的日期 currentTimeMillis毫秒
				errorMsgs.add("請輸入日期!");
			}

			String memUsername = req.getParameter("memUsername").trim();
			if (memUsername == null || memUsername.trim().length() == 0) {
				errorMsgs.add("使用者名稱請勿空白");
			}

			// 要判斷有沒有新增檔案 或是檔案大小為0 也是要判斷無檔案

			Byte isAccEna = null;
			if (req.getParameter("isAccEna") == null) {
				errorMsgs.add("會員帳戶狀態請勾選!");
			} else {
				isAccEna = Byte.valueOf(req.getParameter("isAccEna"));
			}

			Byte isPartEna = null;
			if (req.getParameter("isPartEna") == null) {
				errorMsgs.add("會員參加活動權限請勾選!");
			} else {
				isPartEna = Byte.valueOf(req.getParameter("isPartEna"));
			}

			Byte isHostEna = null;
			if (req.getParameter("isHostEna") == null) {
				errorMsgs.add("會員舉辦活動權限請勾選!");
			} else {
				isHostEna = Byte.valueOf(req.getParameter("isHostEna"));
			}

			Byte isRentEna = null;
			if (req.getParameter("isRentEna") == null) {
				errorMsgs.add("會員租借場地權限請勾選!");
			} else {
				isRentEna = Byte.valueOf(req.getParameter("isRentEna"));
			}

			Byte isMsgEna = null;
			if (req.getParameter("isMsgEna") == null) {
				errorMsgs.add("會員留言權限請勾選!");
			} else {
				isMsgEna = Byte.valueOf(req.getParameter("isMsgEna"));
			}

//Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());

			MembershipVO membershipVO = new MembershipVO();
			membershipVO.setMemAcc(memAcc);
			membershipVO.setMemEmail(memEmail);
			membershipVO.setMemPwd(memPwd);
			membershipVO.setMemName(memName);
			membershipVO.setMemGender(memGender);
			membershipVO.setMemBirthdate(memBirthdate);
			membershipVO.setMemUsername(memUsername);

			byte[] memPic = null;
			Part filePart = req.getPart("memPic");
			if (filePart != null && filePart.getSize() != 0 && errorMsgs.isEmpty()) {
				// obtains input stream of the upload file
				InputStream inputStream = filePart.getInputStream();
				memPic = inputStream.readAllBytes();
				inputStream.close();
				membershipVO.setMemPic(memPic);
			}

			membershipVO.setIsAccEna(isAccEna);
			membershipVO.setIsPartEna(isPartEna);
			membershipVO.setIsHostEna(isHostEna);
			membershipVO.setIsRentEna(isRentEna);
			membershipVO.setIsMsgEna(isMsgEna);
//		

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("membershipVO", membershipVO); // 含有輸入格式錯誤的empVO物件,也存入req //如果註解掉
																// 輸入資料錯誤時就算沒錯的資料也會消失
				RequestDispatcher failureView = req.getRequestDispatcher("/membership/addMembership.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			MembershipService membershipSvc = new MembershipService();
			membershipVO = membershipSvc.addMembership(memAcc, memEmail, memPwd, memName, memGender, memBirthdate,
					memUsername, memPic, isAccEna, isPartEna, isHostEna, isRentEna, isMsgEna); // 順手回傳

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/membership/listAllMembership.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer memId = Integer.valueOf(req.getParameter("memId"));

			/*************************** 2.開始刪除資料 ***************************************/
			MembershipService membershipSvc = new MembershipService();
			membershipSvc.deleteMembership(memId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/membership/listAllMembership.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
