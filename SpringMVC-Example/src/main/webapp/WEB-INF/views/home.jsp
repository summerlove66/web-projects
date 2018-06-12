<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1><spring:message code="label.headMessage" /></h1>

<h2> welcome ${username} </h2>
<P>  The time on the server is ${serverTime}. </P>

</body>
</html>
