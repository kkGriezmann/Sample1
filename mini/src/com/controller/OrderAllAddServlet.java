package com.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.exception.MyException;
import com.service.MemberService;
import com.service.OrderService;

/**
 * Servlet implementation class OrderAddServlet
 */
@WebServlet("/OrderAllAddServlet")
public class OrderAllAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] nums = request.getParameterValues("check");
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		OrderService service = new OrderService();
		MemberService mService = new MemberService();
		String nextPage = null;
		if (dto == null) {
			nextPage = "LoginUIServlet";
			request.setAttribute("mesg", "로그인이 필요한 작업");
		} else {
			try {
				List<CartDTO> list = service.orderAllAdd(Arrays.asList(nums));
				nextPage = "orderAllConfirm.jsp";
				MemberDTO mDTO = mService.mypage(dto.getUserid());
				request.setAttribute("cartList", list);
				request.setAttribute("memberDTO", mDTO);
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				nextPage = "error.jsp";
				request.setAttribute("fail", e.getMessage());
			}//end try~catch
		}//end if~else
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);

	}// end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
