<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
<title>Mise à jour d'une solution !</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<!-- Liens nécessaires pour le datepicker  -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js"
	type="text/javascript"></script>
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />

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
		<img src="../resources/img/DT.png" width="2%" alt=""> <a
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
				<li class="nav-item active">
					<form id="addSol" action="initaddsoluce" method="post">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("addSol").submit()'>Ajouter
						une solution</a>
				</li>
			</ul>
			<form class="form-inline mt-2 mt-md-0" action="disconnect"
				method="post">
				<button class="btn btn-danger my-2 my-sm-0" type="submit">Se
					deconnecter</button>
			</form>
		</div>
	</nav>

	<!-- Formulaire d'ajout d'une solution -->

	<div class="container-fluid col-md-6">
		<h1 class="display-4" style="margin-top: 80px">Mettre à jour une
			solution</h1>
		<p>Veuillez remplir le formulaire ci-dessous pour mettre à jour une
			solution.</p>
		<hr>
		<form>
			<div class="form-group col-md-6">
				<label for="inputTechnologie">Technologie</label> <input
					type="text" class="form-control" id="inputTechnologie"/>
			</div>
			<div class="form-group col-md-6">
				<label for="inputVersion">Version</label> <input
					type="text" class="form-control" id="inputVersion">
			</div>

			<div class="form-group col-md-10">
				<label for="inputType">Type de bug</label> <input
					type="text" class="form-control" id="inputType">
			</div>
			<div class="form-group col-md-10">
				<label for="inputDescription">Description du bug</label>
				<textarea class="form-control" id="inputDescription"
					rows="6"></textarea>
			</div>
			<div class="form-group col-md-10">
				<label for="inputDemarche">Démarche à suivre</label>
				<textarea class="form-control" id="inputDemarche"
					rows="6"></textarea>
			</div>
		</form>

		<!-- Importer le fichier Log -->

		<form>
			<div class="form-group col-md-6">
				<label for="exampleFormControlFile1">Importer votre fichier
					logs</label> <input type="file" class="form-control-file"
					id="exampleFormControlFile1">
			</div>
		</form>

		<br>

		<!-- Bouton d'annulation et de confirmation d'ajout-->
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