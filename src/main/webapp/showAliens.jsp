<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"   %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql"  prefix = "sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Aliens</title>
</head>

<body>

<!--  DISPLAY DATA FROM DB -----------------------
	<br> Aliens in DB: 
	<br> 

<sql:setDataSource
    var="db"  driver="org.h2.Driver"
    url="jdbc:h2:mem:aliens"
    user="sa" password=""
/>

<sql:query dataSource="${db}" var="rs">  
SELECT * from Alien;  
</sql:query>

<table border="1" width="90%">
	<tr style="background-color: yellow">
		<th>Alien ID</th>
		<th>Name</th>
		<th>Tech</th>
	</tr>
	<c:forEach var="alien" items="${rs.rows}">
		<tr>
			<td><c:out value="${alien.aid}" /></td>
			<td><c:out value="${alien.aname}" /></td>
			<td><c:out value="${alien.tech}" /></td>
		</tr>
	</c:forEach>
</table>
-->

<!-- DISPLAYING DATA PASSED TO THIS PAGE -->

Aliens Found: <p>

<!--  c:if test="${fn:length(alienlist) > 0}" -->
<c:if test="${not empty alienlist}">

	<ul>
		<c:forEach var="alien" items="${alienlist}">
			<li>${alien.aid} ... ${alien.aname} ... ${alien.tech}</li>
		</c:forEach>
	</ul>
</c:if>











</body>
</html>