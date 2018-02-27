package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");

		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);

		MemberService service = new MemberService();
		String nextPage = null;
		try {
			MemberDTO dto = service.login(map);
			if (dto != null) {
				HttpSession session = request.getSession();
				session.setAttribute("login", dto);
				nextPage = "home.jsp";
			} else {
				nextPage = "LoginUIServlet";
			}
		} catch (MyException e) {
			nextPage = "error.jsp";
			request.setAttribute("fail", e.getMessage());
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
