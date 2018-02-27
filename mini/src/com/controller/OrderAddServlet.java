package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.MemberService;
import com.service.OrderService;

/**
 * Servlet implementation class OrderAddServlet
 */
@WebServlet("/OrderAddServlet")
public class OrderAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String num = request.getParameter("num");

		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		OrderService oService = new OrderService();
		MemberService mService = new MemberService();
		String nextPage = null;
		if (dto == null) {
			nextPage = "LoginUIServlet";
			request.setAttribute("mesg", "로그인이 필요한 작업");
		} else {
			nextPage = "orderConfirm.jsp";
			String userid = dto.getUserid();
			try {
				CartDTO cDTO = oService.orderByNum(Integer.parseInt(num));
				MemberDTO mDTO = mService.mypage(userid);
				request.setAttribute("cartDTO", cDTO);
				request.setAttribute("memberDTO", mDTO);
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				nextPage = "error.jsp";
				request.setAttribute("fail", e.getMessage());
			}

		} // end if~else

		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
