package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.MyException;
import com.service.CartService;

/**
 * Servlet implementation class CartAmountUpdateServlet
 */
@WebServlet("/CartAmountUpdateServlet")
public class CartAmountUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String num = request.getParameter("num");
		String amount = request.getParameter("amount");
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("num", Integer.parseInt(num));
		map.put("amount", Integer.parseInt(amount));
		
		CartService service = new CartService();
		String nextPage=null;
		try {
			service.amountUpdate(map);
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
