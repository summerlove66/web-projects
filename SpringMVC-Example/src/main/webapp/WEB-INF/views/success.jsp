
<%@ page session="false" contentType="text/html;charset=UTF-8"   pageEncoding="UTF-8" %>
<%@ taglib prefix="success"   uri="http://www.springframework.org/tags/form" %>


<html>
<head>
<meta charset="UTF-8">
<title>success</title>
</head>
<body>

<h2><spring:message code="label.headMessage" /> </h2>
 <success:errors path="student.*" /> 

<h2>
	Welcome ${student.getStudentName()}
</h2>

<h2> ${ isok } </h2>

<h2> Detail submitted by you is </h2>
<table>
<tr>
<td>Student Name: </td> <td> ${student.studentName}</td>
</tr>
<tr>
<td>Student Hobby: </td> <td> ${student.studentHobby}</td>
</tr>
<tr>
<td>Student Mobile: </td> <td> ${student.studentMobile}</td>
</tr>
<tr>
<td>Student BDO: </td> <td> ${student.studentBdo}</td>
</tr>
<tr>
<td>Student Skills: </td> <td> ${student.studentSkill}</td>
</tr>
<tr>
<td>Student Address: </td> <td> country: ${student.studentAddress.country}
								city: ${student.studentAddress.city }
								street: ${student.studentAddress.street }
								pincode: ${student.studentAddress.pincode}
						  </td>
</tr>


</table>





</body>
</html>
