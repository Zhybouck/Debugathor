<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">

<head>
<title>Faire une proposition</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Lien pour Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- Lien pour les tableaux -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">

<!-- Style CSS -->
<style type="text/css">
body {
	background-color: #eff2f3;
	color: #343a40;
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
				<li class="nav-item">
					<form id="addSol" action="initaddsoluce" method="post">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("addSol").submit()'>Ajouter
						une solution</a>
				</li>
			</ul>
			<form class="form-inline mt-2 mt-md-0" action="disconnect"
				onsubmit="return confirm('Etes-vous sûr de vouloir vous déconnecter ?');">
				<i class="nav-item nav-link" style="color: #eff2f3; margin-right:20px;">Bonjour ${Utilisateur.prenom}</i>
				<button class="btn btn-danger my-2 my-sm-0" type="submit">Se
					deconnecter</button>
			</form>
		</div>
	</nav>

	<!-- 	Formulaire de proposition -->

	<div class="container-fluid col-md-6">
		<h1 class="display-4" style="margin-top: 70px">Compléter une
			solution</h1>
		<p>Veuillez remplir le formulaire ci-dessous pour compléter la
			solution proposée.</p>
		<hr>
		<form>

			<div class="form-group col-md-10">
				<label for="inputCommentaire">Commentaire</label>
				<textarea class="form-control" id="inputCommentaire"
					rows="6" maxlength="500"></textarea>
			</div>

		</form>

		<br>

		<!-- Bouton d'annulation et de confirmation de proposition-->
		<div class="form-group row col-md-6 ml-2">
		<form class="form-inline" action="back" method="post">
			<button class="btn btn-outline-secondary" type="submit"
				style="width: 120px;">Annuler</button>
		</form>

		<form class="form-inline" action="applyadd" method="post">
			<button class="btn btn-success" type="submit" style="width: 120px;">Confirmer</button>
		</form>
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


</body>
</html>