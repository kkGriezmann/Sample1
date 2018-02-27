<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String mesg = (String)request.getAttribute("mesg");
   if(mesg != null){
%>
   <script type="text/javascript">
    alert('<%=mesg %>');
   </script>
<%
   }
%>
<form action="LoginServlet" method="post" >
아이디<input type="text" name="userid"><br>
비밀번호<input type="text" name="passwd" id="passwd"><br>
<input type="submit" value="로그인">
<input type="reset" value="취소">
</form>



