<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
<title>Zoom solution</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Lien pour Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- Lien pour les tableaux -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">


<!-- Style CSS -->
<style type="text/css">
body {
	background-color: #eff2f3;
	color: #343a40;
	padding-left: 25px;
}

.tabcomp {
	width: 80% !important;
	margin-right: 150px;
	margin-left: 90px;
	hyphens: auto;
}

.row {
	margin-bottom: 10px;
}

.cadre {
	border-left-style: groove;
	padding: 25px 25px 25px 25px;
	border-color: #343a40;
	background-color: #e2e3e3;
	border-width: 5px;
	margin-right: 150px;
	margin-left: 90px;
	hyphens: auto;
}

.mb-5 {
	margin-right: 150px;
	margin-left: 90px;
}
</style>

</head>

<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<img src="../resources/img/DT.png" width="2%"> <a
			class="navbar-brand ml-2" href="#">Debugathor</a>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><form id="list" action="back">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("list").submit()'>Liste des
						solutions</a></li>
				<li class="nav-item"><form id="mySol" action="mybugs">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("mySol").submit()'>Mes
						solutions</a></li>
				<li class="nav-item"><form id="addSol" action="initaddsoluce">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("addSol").submit()'>Ajouter
						une solution</a></li>
			</ul>

			<form class="form-inline mt-2 mt-md-0" action="disconnect" onsubmit="return confirm('Etes-vous sûr de vouloir vous déconnecter ?');">
				<i class="nav-item nav-link"
					style="color: #eff2f3; margin-right: 20px;">Bonjour
					${Utilisateur.prenom}</i>
				<button class="btn btn-danger my-2 my-sm-0" type="submit">Se
					deconnecter</button>
			</form>
		</div>
	</nav>

	<div class="mb-5" style="padding-top: 100px;">

		<!-- Partie haute de la vue - Zoom sur la solution sélectionnée-->
		<h1 class="display-4">Zoom sur une solution</h1>
		<hr>

		<!-- Trouver un moyen de récupérer les éléments (c:forEach / form) -->

		<div class="cadre mt-5">
			<div class="row ml-1 mb-2">
				<div class="col-2">
					<b>ID : </b> ${focusedSol.idSolution}
				</div>

				<div class="col-3">
					<b>Technologie : </b> ${focusedSol.technologie}
				</div>

				<div class="col-4">
					<b>Type : </b> ${focusedSol.type}
				</div>

				<div class="col-3">
					<b>Date : </b> ${focusedSol.dateBug}
				</div>

			</div>
			
			<hr>

			<div class="row ml-1 mb-2">
				<div class="col-2">
					<b>Titre : </b>
				</div>
				<div class="col-9"><h2>${focusedSol.titre}</h2></div>
				<div class="col-1"></div>
			</div>
			
			<div class="row ml-1 mb-2">
				<div class="col-2">
					<b>Description : </b>
				</div>

				<div class="col-9">${focusedSol.description}</div>
				<div class="col-1"></div>
				
			</div>
			
			<hr>

			<div class="row ml-1 mb-2">
				<div class="col-2">
					<b>Démarche : </b>
				</div>
				<div class="col-9">${focusedSol.demarche}</div>
				<div class="col-1"></div>
			</div>
		</div>

		<!-- Partie basse de la vue - Liste des compléments de la solution -->
		<h1 class="display-4 mt-5">Compléments</h1>
		<hr>

		<table class="tabcomp table">

			<!-- 		Boucle forEach pour les propositions associées à la solution affichée -->
			<tr>
				<th width="15%">Nom utilisateur</th>
				<th width="15%">Prénom utilisateur</th>
				<th width="15%">Date proposition</th>
				<th width="55%">Commentaire</th>
			</tr>
			<c:forEach items="${focusedSol.propositions}" var="proposition">
				<tr>
					<td><c:out value="${proposition.utilisateur.nom}" /></td>
					<td><c:out value="${proposition.utilisateur.prenom}" /></td>
					<td><c:out value="${proposition.dateProp}" /></td>
					<td><c:out value="${proposition.commentaire}" /></td>
				</tr>
			</c:forEach>
		</table>

		<h1 class="display-4 mt-5">Ajouter une proposition</h1>
		<hr>
		<div class="mb-5">
			<form:form class="form-signin ml-5 mt-5 mb-5" action="addprop"
				method="post" modelAttribute="nouvProp">
				<input name="idSol" type="hidden" value="${focusedSol.idSolution}" />
				<tr>
					<form:textarea class="form-control" id="inputCommentaire"
						name="inputCommentaire" rows="6" path="Commentaire"
						maxlength="500" onkeyup="success()"
						title="Votre commentaire ne doit pas excéder 500 caractères."></form:textarea>
				</tr>

				<br />
				<button type="submit" class="btn btn-success" id="sendButton"
					class="sendButton" disabled>Compléter cette solution</button>
				<script>
				function success() {
					 if(document.getElementById("inputCommentaire").value==="") { 
				            document.getElementById('sendButton').disabled = true; 
				        } else { 
				            document.getElementById('sendButton').disabled = false;
				        }
				    }
				</script>
			</form:form>
		</div>

		<!-- Footer -->
		<hr>
		<footer class="container-fluid">
			<p>&copy; Debugathor 2019</p>
		</footer>

	</div>

	<!-- Les balises script sont à mettre à la fin du body pour éviter de surcharger le chargement de la page -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<!-- Balises script pour les tableaux -->

	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

	<script
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>

	<!-- Responsive extension -->

	<script
		src="https://cdn.datatables.net/responsive/2.1.0/js/responsive.bootstrap.min.js"></script>

	<!-- Buttons extension -->

	<script
		src="//cdn.datatables.net/buttons/1.2.1/js/dataTables.buttons.min.js"></script>

	<script
		src="//cdn.datatables.net/buttons/1.2.1/js/buttons.bootstrap.min.js"></script>

	<script src="//cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>

	<script
		src="//cdn.datatables.net/buttons/1.2.1/js/buttons.html5.min.js"></script>
</body>
</html>