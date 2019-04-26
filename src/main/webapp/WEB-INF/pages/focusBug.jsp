<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
<title>Zoom solution</title>
<meta charset="UTF-8">
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
}

.tabcomp {
	width: 80% !important;
	margin-right: 150px;
	margin-left: 90px;
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
				<li class="nav-item"><form id="list" action="back"
						method="post">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("list").submit()'>Liste des
						solutions</a></li>
				<li class="nav-item"><form id="mySol" action="mybugs"
						method="post">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("mySol").submit()'>Mes
						solutions</a></li>
				<li class="nav-item"><form id="addSol" action="initaddsoluce"
						method="post">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("addSol").submit()'>Ajouter
						une solution</a></li>
			</ul>

			<form class="form-inline mt-2 mt-md-0" action="disconnect"
				method="post">
				<button class="btn btn-danger my-2 my-sm-0" type="submit">Se
					deconnecter</button>
			</form>
		</div>
	</nav>

	<div class="container-fluid mb-5" style="padding-top: 90px;">

		<!-- Partie haute de la vue - Zoom sur la solution sélectionnée-->
		<h1 class="display-4">Zoom sur une solution</h1>
		<hr>

		<!-- Trouver un moyen de récupérer les éléments (c:forEach / form) -->

		<div class="cadre">
			<div class="row ml-2">
				<div class="col-1">
					<b>ID :</b> (id à récupérer)
				</div>

				<div class="col-3">
					<b>Technologie :</b> (tech à récupérer)
				</div>

				<div class="col-4">
					<b>Type :</b> (type à récupérer)
				</div>

				<div class="col-3">
					<b>Date :</b> (date à récupérer)
				</div>

				<div class="col-1"></div>
			</div>

			<div class="row ml-2">
				<div class="col-1">
					<b>Titre :</b>
				</div>
				<div class="col-9">(titre à récupérer)</div>
				<div class="col-2"></div>
			</div>

			<div class="row ml-2">
				<div class="col-1">
					<b>Description :</b>
				</div>

				<div class="col-8">(description à récupérer)</div>
				<div class="col-3"></div>
			</div>

			<div class="row ml-2">
				<div class="col-1">
					<b>Démarche :</b>
				</div>
				<div class="col-8">(démarche à récupérer)</div>
				<div class="col-3"></div>
			</div>
		</div>
	</div>


	<!-- Partie basse de la vue - Liste des compléments de la solution -->
	<h1 class="display-4 mt-5">Compléments</h1>
	<hr>

	<table class="tabcomp table">

		<!-- 		Boucle forEach pour les propositions associées à la solution affichée -->
		<%-- 		<c:forEach items="" var=""> --%>

		<tr>
			<td><c:out value="" />(date prop à récup)</td>
			<td><c:out value="" />(proosition à récupérer)</td>
		</tr>

		<%-- 		</c:forEach> --%>

	</table>

	<div class="col-4 mt-5">

		<!-- 		Formulaire pour ajouter une proposition -->
		<form>
			<button type="button" class="btn btn-success">Compléter
				cette solution</button>
		</form>
	</div>


	<!-- Footer -->
	<hr>
	<footer class="container-fluid">
		<p>&copy; Debugathor 2019</p>
	</footer>


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