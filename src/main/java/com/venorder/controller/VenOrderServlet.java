package com.venorder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.venorder.model.VenOrderVO;


@WebServlet("/venorder/venOrder.do")
public class VenOrderServlet extends HttpServlet {
	
	private VenOrderServiceInterface venOrderSrv;

	@Override
	public void init() throws ServletException {
		venOrderSrv = new VenOrderService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";
		switch (action) {
			case "getAll":
				forwardPath = getAllVenOrder(req, res);
				break;
//			case "compositeQuery":
//				forwardPath = getCompositeEmpsQuery(req, res);
//				break;
			default:
				forwardPath = "/index.jsp";
		}
		
		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	private String getAllVenOrder(HttpServletRequest req, HttpServletResponse res) {
		String page = req.getParameter("page");
		int currentPage = (page == null) ? 1 : Integer.parseInt(page);
		
		List<VenOrderVO> venOrderList = venOrderSrv.getAllVenOrder(currentPage);
		
		if (req.getSession().getAttribute("venOrderPageQty") == null) {
			int venOrderPageQty = venOrderSrv.getPageTotal();
			req.getSession().setAttribute("venOrderPageQty", venOrderPageQty);
		}
		
		req.setAttribute("venOrderList", venOrderList);
		req.setAttribute("currentPage", currentPage);
		
		return "/emp/listAllVenueOrder.jsp";
	}
	
//	private String getCompositeEmpsQuery(HttpServletRequest req, HttpServletResponse res) {
//		
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
}
