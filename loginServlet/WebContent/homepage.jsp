<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	 response.setHeader("Cache-Control", "no-cache. no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", -10);
	
	if(session.getAttribute("username") == null)
		{
			response.sendRedirect("loginpage.jsp");
			
		}
		
	%>


Welcome ${username }

<a href ="video.jsp">video HERE</a>

<form action="Logout" method ="post">
<input type ="submit" value ="logout">
</form>




</body>
</html>