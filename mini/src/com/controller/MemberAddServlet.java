package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.MemberService;


@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userid = request.getParameter("userid");
	    String passwd = request.getParameter("passwd");
	    String username = request.getParameter("username");
	    String post = request.getParameter("post");
	    String addr1 = request.getParameter("addr1");
	    String addr2 = request.getParameter("addr2");
	    String phone1 = request.getParameter("phone1");
	    String phone2 = request.getParameter("phone2");
	    String phone3 = request.getParameter("phone3");
	    String email1 = request.getParameter("email1");
	    String email2 = request.getParameter("email2");
	    
	    MemberDTO dto =
	    		new MemberDTO(userid, passwd,
	    				username, post, addr1, addr2,
	    				phone1, phone2, phone3, email1, email2);
	    
	    MemberService service = new MemberService();
	    String nextPage=null;
	    try {
			service.memberAdd(dto);
			nextPage="home.jsp";
			request.setAttribute("success", "회원가입 성공");
		} catch (MyException e) {
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
