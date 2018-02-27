package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.CartDTO;
import com.exception.MyException;
import com.service.CartService;

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/CartListServlet")
public class CartListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 CartService service = new CartService();
		 String nextPage = null;
		 try {
			List<CartDTO> list = service.cartList();
			request.setAttribute("cartList", list);
			nextPage = "cartList.jsp";
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			nextPage = "error.jsp";
			request.setAttribute("fail", e.getMessage());
		}
		 RequestDispatcher dis = 
					request.getRequestDispatcher(nextPage);
			dis.forward(request, response);
		
	}// end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
