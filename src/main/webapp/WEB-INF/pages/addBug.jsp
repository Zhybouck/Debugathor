<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
<title>Ajouter une solution</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>

coucou

	<!-- Navbar -->

	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<img src="C:\Users\IN-ST-008\Desktop\logoDT.png" width="30" height="30" alt="">
		<a class="navbar-brand" href="#">Debugathor</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
				</li>
			</ul>
			<form class="form-inline mt-2 mt-md-0">
				<button class="btn btn-danger my-2 my-sm-0" type="submit">Disconnect</button>
			</form>
		</div>
	</nav>

	</br>
	</br>
	</br>

	<!-- Formulaire -->

	<form>
		<div class="form-group col-md-3">
			<label for="exampleFormControlInput1">Technology</label> <input
				type="text" class="form-control" id="exampleFormControlInput1">
		</div>
		<div class="form-group col-md-3">
			<label for="exampleFormControlInput1">Version</label> <input
				type="text" class="form-control" id="exampleFormControlInput1">
		</div>
		<div class="form-group col-md-3">
			<label for="exampleFormControlInput1">Date</label> <input type="text"
				class="form-control" id="exampleFormControlInput1">
		</div>
		<div class="form-group col-md-3">
			<label for="exampleFormControlInput1">Type de bug</label> <input
				type="text" class="form-control" id="exampleFormControlInput1">
		</div>
		<div class="form-group col-md-6">
			<label for="exampleFormControlTextarea1">Description du bug</label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="5"></textarea>
		</div>
		<div class="form-group col-md-6">
			<label for="exampleFormControlTextarea1">Démarche à suivre</label>
			<textarea class="form-control" id="exampleFormControlTextarea1"
				rows="5"></textarea>
		</div>
	</form>

	<!-- Importer le fichier Log -->

	<form>
		<div class="form-group col-md-3">
			<label for="exampleFormControlFile1">Importer votre fichier
				logs</label> <input type="file" class="form-control-file"
				id="exampleFormControlFile1">
		</div>
	</form>

	</br>

	<!-- Bouton d'annulation et de confirmation d'ajout-->
	<form class="form-inline mt-2 mt-md-0">
		<button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Annuler</button>
		<button class="btn btn-success my-2 my-sm-0" type="submit">Confirmer</button>
	</form>


</body>
</html>