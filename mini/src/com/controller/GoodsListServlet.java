package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.exception.MyException;
import com.service.GoodsService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gCategory = request.getParameter("gCategory");
		GoodsService service = new GoodsService();
		String nextPage = null;
		try {
			List<GoodsDTO> list = service.goodsList(gCategory);
			request.setAttribute("goodsList", list);
			nextPage = "goodsList.jsp";
		} catch (MyException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			nextPage = "error.jsp";
			request.setAttribute("fail", e.getMessage());
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}//end 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
