package com.controller;

import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/OrderAllDoneServlet")
public class OrderAllDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] nums = request.getParameterValues("num");
		//배송지 정보
		String orderName= request.getParameter("orderName");
		String post= request.getParameter("post");
		String addr1= request.getParameter("addr1");
		String addr2= request.getParameter("addr2");
		String phone= request.getParameter("phone");
		String payMethod= request.getParameter("payMethod");
		
		HttpSession session = request.getSession();
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		OrderService oService = new OrderService();
		String nextPage = null;
		if (mDTO == null) {
			nextPage = "LoginUIServlet";
			request.setAttribute("mesg", "로그인이 필요한 작업");
		} else {
			try {
				List<CartDTO> list = oService.orderAllAdd(Arrays.asList(nums));
				////////////////////////////
				List<OrderDTO> oList = new ArrayList<>();
				for(CartDTO cDTO: list) {
					OrderDTO oDTO = new OrderDTO();
					oDTO.setUserid(mDTO.getUserid());
					oDTO.setgCode(cDTO.getgCode());
					oDTO.setgName(cDTO.getgName());
					oDTO.setgSize(cDTO.getGoodsSize());
					oDTO.setgColor(cDTO.getGoodsColor());
					oDTO.setgPrice(cDTO.getgPrice());
					oDTO.setgAmount(cDTO.getGoodsAmount());
					oDTO.setgImage(cDTO.getgImage());
					oDTO.setOrderName(orderName);
					oDTO.setPost(post);
					oDTO.setAddr1(addr1);
					oDTO.setAddr2(addr2);
					oDTO.setPhone(phone);
					oDTO.setPayMethod(payMethod);
					oList.add(oDTO);
				}

				oService.orderAllDone(oList);
				
				/////////////////////////////////
				nextPage = "orderDone.jsp";
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				nextPage = "error.jsp";
				request.setAttribute("fail", e.getMessage());
			}
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);

	}// end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
