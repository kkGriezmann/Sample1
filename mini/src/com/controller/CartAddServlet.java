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
import com.service.CartService;

/**
 * Servlet implementation class CartAddServlet
 */
@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//gImage=top1&gCode=T1&gName=앨리스+데님+탑&gPrice=12100&goodsSize=L&goodsColor=black&goodsAmount=1	
	    String gImage= request.getParameter("gImage");
	    String gCode= request.getParameter("gCode");
	    String gName= request.getParameter("gName");
	    String gPrice= request.getParameter("gPrice");
	    String goodsSize= request.getParameter("goodsSize");
	    String goodsColor= request.getParameter("goodsColor");
	    String goodsAmount= request.getParameter("goodsAmount");
	    
	    //로그인 세션 체크
	    HttpSession session = request.getSession();
	    MemberDTO dto = (MemberDTO)session.getAttribute("login");
	   
	    String nextPage=null;
	    if(dto == null) {
	    	nextPage="LoginUIServlet";
	    	request.setAttribute("mesg", "로그인이 필요한 작업");
	    }else {
	       	CartDTO cDTO = new CartDTO();
	       	cDTO.setUserid(dto.getUserid());
	       	cDTO.setgCode(gCode);
	       	cDTO.setgImage(gImage);
	       	cDTO.setgName(gName);
	       	cDTO.setGoodsAmount(Integer.parseInt(goodsAmount));
	       	cDTO.setGoodsColor(goodsColor);
	       	cDTO.setGoodsSize(goodsSize);
	       	cDTO.setgPrice(Integer.parseInt(gPrice));
	       	
	    	CartService service = new CartService();
	    	try {
				service.cartAdd(cDTO);
				nextPage="GoodsRetrieveServlet?gCode="+gCode;
				request.setAttribute("cart", gCode+" 상품이 장바구니 저장 성공");
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				nextPage="error.jsp";
				request.setAttribute("fail", e.getMessage());
			}
	    	
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
