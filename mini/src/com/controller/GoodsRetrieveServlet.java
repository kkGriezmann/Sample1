package com.controller;

import java.io.IOException;

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
 * Servlet implementation class GoodsRetrieveServlet
 */
@WebServlet("/GoodsRetrieveServlet")
public class GoodsRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gCode = request.getParameter("gCode");
		GoodsService service = new GoodsService();
		String nextPage=null;
		try {
			GoodsDTO dto = service.goodsRetrieve(gCode);
			request.setAttribute("goodsRetrieve", dto);
			nextPage="goodsRetrieve.jsp";
		} catch (MyException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			nextPage="error.jsp";
			request.setAttribute("fail", e.getMessage());
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}//end doGEt

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
