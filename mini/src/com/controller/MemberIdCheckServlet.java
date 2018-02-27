package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.MyException;
import com.service.MemberService;


@WebServlet("/MemberIdCheckServlet")
public class MemberIdCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String userid = request.getParameter("userid");
	   
	   MemberService service = new MemberService();

	String mesg = "아이디 사용 가능";
	   try {
		int count = service.memberIdCheck(userid);
		 if(count==1) {
			 mesg = "아이디 중복";
		 }
	   } catch (MyException e) {
		    mesg = e.getMessage();
	   }
	   
	   //서블릿의 응답처리
	   response.setContentType("text/html;charset=UTF-8");
	   PrintWriter out = response.getWriter();
	   out.println(mesg);
	   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
