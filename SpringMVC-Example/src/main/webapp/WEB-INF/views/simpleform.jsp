<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" contentType="text/html;charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>

<a href="/form?siteLanuage=en">English</a>|<a href="/form?siteLanuage=zh">中文</a>
<h1><spring:message code="label.headMessage" /></h1>

<font color="red"> <form:errors path="student.*" /> </font>

<form action="submit" method="post" accept-charset="UTF-8" >
<table>
<tr>
<td><spring:message code="label.studentName" /></td> <td><input name="studentName" /> </td>
</tr>
<tr>
<td><spring:message code="label.studentHobby" /></td> <td><input name="studentHobby" /> </td>
</tr>
<tr>
<td><spring:message code="label.studentMobile" /></td> <td><input name="studentMobile" /> </td>
</tr>
<tr>
<td><spring:message code="label.studentBdo" /></td> <td><input name="studentBdo" /> </td>
</tr>
<tr>
<td><spring:message code="label.studentSkills" /></td> 
<td>
<select name="studentSkill" multiple>
<option value="Java Core"> Java Core</option>
<option value="Spring  Core"> Spring Core</option>
<option value="Spring MVC">Spring MVC</option>
</select>
</td>
</tr>
</table>
<table>
<tr>
<td>
<spring:message code="label.studentAddress" />
</td>
</tr>
<tr>
<td>country:<input name="studentAddress.country" /></td>
<td>city:<input name="studentAddress.city" /></td>
<td>street:<input name="studentAddress.street" /></td>
<td>pincode:<input name="studentAddress.pincode" /></td>
</tr>
</table>



<input type="submit">
</form>
</body>
</html>