<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  MemberDTO dto = (MemberDTO)session.getAttribute("login");
  if(dto== null){
%>    
    
<a href="LoginUIServlet">로그인</a>
<a href="MemberUIServlet">회원가입</a>
<%
  }else{
   String username = dto.getUsername();
%>
 <%=username %>&nbsp;
<a href="LogoutServlet">로그아웃</a>
<a href="MemberMyPageServlet">MyPage</a>
<a href="CartListServlet">장바구니</a>
<%
  }//end if~else
%>



