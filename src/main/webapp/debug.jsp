<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="fr.formation.dao.ILogicielDAO,fr.formation.dao.LogicielHome,fr.formation.beans.Logiciel,java.util.ArrayList"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2">
		<c:forEach items="${liste}" var="logiciel">
			<tr>
				<td><c:out value="${logiciel.idLogiciel}" /></td>
				<td><c:out value="${logiciel.version}" /></td>
				<td><c:out value="${logiciel.nomLogiciel}" /></td>
				<td><c:out value="${logiciel.solutions}" /></td>
			<tr>
		</c:forEach>
	</table>
</body>
</html>