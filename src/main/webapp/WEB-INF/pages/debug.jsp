<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="fr.formation.dao.ILogicielDAO,fr.formation.dao.LogicielDAO,fr.formation.entities.Logiciel,java.util.ArrayList"%>
<html>

<head>
<style type="text/css">
table {
  width: 100%;
}
body{
	margin-top: 70px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2">
		<c:forEach items="${list}" var="solution">
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
	<!-- 	<table border="2"> -->
	<%-- 		<c:forEach items="${ls}" var="solution"> --%>
	<!-- 			<tr> -->
	<%-- 				<td><c:out value="${solution.idSolution}" /></td> --%>
	<%-- 				<td><c:out value="${solution.logiciel}" /></td> --%>
	<%-- 				<td><c:out value="${solution.utilisateur}" /></td> --%>
	<%-- 				<td><c:out value="${solution.type}" /></td> --%>
	<!-- 			<tr> -->
	<%-- 		</c:forEach> --%>
	<!-- 	</table> -->
	<!-- 	<table border="2"> -->
	<%-- 		<c:forEach items="${lu}" var="utilisateur"> --%>
	<!-- 			<tr> -->
	<%-- 				<td><c:out value="${utilisateur.idUtilisateur}" /></td> --%>
	<%-- 				<td><c:out value="${utilisateur.mdp}" /></td> --%>
	<%-- 				<td><c:out value="${utilisateur.prenom}" /></td> --%>
	<%-- 				<td><c:out value="${utilisateur.nom}" /></td> --%>
	<!-- 			<tr> -->
	<%-- 		</c:forEach> --%>
	<!-- 	</table> -->
	<!-- 	<table border="2"> -->
	<%-- 		<c:forEach items="${lp}" var="proposition"> --%>
	<!-- 			<tr> -->
	<%-- 				<td><c:out value="${proposition.idProposition}" /></td> --%>
	<%-- 				<td><c:out value="${proposition.solution}" /></td> --%>
	<%-- 				<td><c:out value="${proposition.utilisateur}" /></td> --%>
	<%-- 				<td><c:out value="${proposition.prop}" /></td> --%>
	<!-- 			<tr> -->
	<%-- 		</c:forEach> --%>
	<!-- 	</table> -->
</body>
</html>