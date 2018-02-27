package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = request.getSession();
		
		MemberDTO dto =(MemberDTO)session.getAttribute("login");
		String nextPage="home.jsp";
		if(dto==null) {
			nextPage="loginForm.jsp";
			request.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}else {
			session.invalidate();
			request.setAttribute("logout", "정상적으로 로그아웃.");
		}//end if
		
		RequestDispatcher dis  = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
		
	}//end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
