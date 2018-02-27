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
import com.dto.OrderDTO;
import com.exception.MyException;
import com.service.MemberService;
import com.service.OrderService;

/**
 * Servlet implementation class OrderAddServlet
 */
@WebServlet("/OrderDoneServlet")
public class OrderDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String userid = request.getParameter("userid");
String num = request.getParameter("num");
		String gCode = request.getParameter("gCode");
		String gName = request.getParameter("gName");
		String gSize = request.getParameter("gSize");
		String gColor = request.getParameter("gColor");
		String gPrice = request.getParameter("gPrice");
		String gAmount = request.getParameter("gAmount");
		String gImage = request.getParameter("gImage");
				
		String orderName = request.getParameter("orderName");
		String post = request.getParameter("post");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String payMethod = request.getParameter("payMethod");

		OrderDTO oDTO = new OrderDTO();
		oDTO.setUserid(userid);
		oDTO.setgCode(gCode);
		oDTO.setgName(gName);
		oDTO.setgSize(gSize);
		oDTO.setgColor(gColor);
		oDTO.setgPrice(Integer.parseInt(gPrice));
		oDTO.setgAmount(Integer.parseInt(gAmount));
		oDTO.setgImage(gImage);
		oDTO.setOrderName(orderName);
		oDTO.setPost(post);
		oDTO.setAddr1(addr1);
		oDTO.setAddr2(addr2);
		oDTO.setPhone(phone);
		oDTO.setPayMethod(payMethod);
		OrderService service = new OrderService();
		String nextPage=null;
		try {
			service.orderDone(oDTO, Integer.parseInt(num));
			request.setAttribute("orderDone", oDTO);
			nextPage="orderDone.jsp";
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			nextPage="error.jsp";
			request.setAttribute("fail", e.getMessage());
		}
		 RequestDispatcher dis = 
					request.getRequestDispatcher(nextPage);
			dis.forward(request, response);
		
	}//end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
