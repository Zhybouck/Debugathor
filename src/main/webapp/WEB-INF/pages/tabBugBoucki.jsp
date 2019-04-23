<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="fr.formation.dao.ILogicielDAO,fr.formation.dao.LogicielDAO,fr.formation.entities.Logiciel,java.util.ArrayList"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2">
		<c:forEach items="${listesol}" var="solution">
			<tr>
				<td><c:out value="${solution.idSolution}" /></td>
				<td>
				<table border="2">
					<tr>
						<td><c:out value="${solution.logiciel.version}" /></td>
						<td><c:out value="${solution.logiciel.nomLogiciel}" /></td>
					</tr>
				</table>
				</td>
				<td><c:out value="${solution.type}" /></td>
				<td><c:out value="${solution.dateBug}" /></td>
				<td><c:out value="${solution.titre}" /></td>
				<td><c:out value="${solution.description}" /></td>
				<td><c:out value="${solution.demarche}" /></td>
				<td><c:out value="${solution.technologie}" /></td>
				<td>
				<table border="2">
					<c:forEach items="${solution.propositions}" var="proposition">
						<tr>
						<td><c:out value="${proposition.dateProp}"/></td>
						<td><c:out value="${proposition.commentaire}"/></td>
						<td><c:out value="${proposition.note}"/></td>
						</tr>
					</c:forEach>
				</table>
				</td>
				<%-- 				<td><c:out value="${logiciel.solutions}" /></td>
 --%>
			<tr>
		</c:forEach>
	</table>
	
	
	Bouton avec ID pour consulter un bug en lui même
	