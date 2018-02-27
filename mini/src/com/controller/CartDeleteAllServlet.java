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
import com.exception.MyException;
import com.service.CartService;

/**
 * Servlet implementation class CartAddServlet
 */
@WebServlet("/CartDeleteAllServlet")
public class CartDeleteAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] nums = request.getParameterValues("check");
		CartService service = new CartService();
		List<String> list = Arrays.asList(nums);
		String nextPage=null;
		try {
			service.cartDeleteAll(list);
			nextPage="CartListServlet";
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
