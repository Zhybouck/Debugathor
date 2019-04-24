<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
<title>Ajouter une solution !</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<!-- Liens nécessaires pour le datepicker	 -->
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
		<img src="C:\Users\IN-ST-008\Desktop\DT.png" width="4%" alt="">
		<a class="navbar-brand" href="#">Debugathor</a>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/TestDebugathor/tabBug.jsp">Liste
						des solutions </a></li>
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/TestDebugathor/myBugs.jsp">Mes
						solutions</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="http://localhost:8080/TestDebugathor/addBug.jsp">Ajouter
						une solution <span class="sr-only">(current)</span>
				</a></li>
			</ul>
			<form class="form-inline mt-2 mt-md-0">
				<button class="btn btn-danger my-2 my-sm-0" type="submit">Se
					deconnecter</button>
			</form>
		</div>
	</nav>

	<!-- Formulaire d'ajout d'une solution -->

	<div class="container-fluid col-md-6">
		<h1 class="display-4" style="margin-top: 70px">Ajouter une
			solution</h1>
		<p>Veuillez remplir le formulaire ci-dessous pour ajouter une
			solution.</p>
		<hr>
		<form>
			<div class="form-group col-md-6">
				<label for="exampleFormControlInput1">Technologie</label> <input
					type="text" class="form-control" id="exampleFormControlInput1">
			</div>
			<div class="form-group col-md-6">
				<label for="exampleFormControlInput1">Version</label> <input
					type="text" class="form-control" id="exampleFormControlInput1">
			</div>

			<div class="form-group col-md-6">
				<label for="exampleFormControlInput1">Date</label> <input
					id="datepicker" />
			</div>
			<script>
				$('#datepicker').datepicker({
					uiLibrary : 'bootstrap4'
				});
			</script>


			<div class="form-group col-md-10">
				<label for="exampleFormControlInput1">Type de bug</label> <input
					type="text" class="form-control" id="exampleFormControlInput1">
			</div>
			<div class="form-group col-md-10">
				<label for="exampleFormControlTextarea1">Description du bug</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="6"></textarea>
			</div>
			<div class="form-group col-md-10">
				<label for="exampleFormControlTextarea1">Démarche à suivre</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
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
		<form class="form-inline col-md-6">
			<button class="btn btn-outline-secondary" type="submit" style="width: 120px;">Annuler</button>
			<button class="btn btn-success" type="submit" style="width: 120px;">Confirmer</button>
		</form>

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