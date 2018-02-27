<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쇼핑몰</h1>
<%
   String success = (String)request.getAttribute("success");
   if(success != null){
%>
   <script type="text/javascript">
    alert('<%=success %>');
   </script>
<%
   }
%>
<%
   String logout = (String)request.getAttribute("logout");
   if(logout != null){
%>
   <script type="text/javascript">
    alert('<%=logout %>');
   </script>
<%
   }
%>
<jsp:include page="include/top.jsp" flush="true" /><br>
<jsp:include page="include/submenu.jsp" flush="true" />
<hr>
<img src="images/items/main.png" width="300" height="300" >
</body>
</html>