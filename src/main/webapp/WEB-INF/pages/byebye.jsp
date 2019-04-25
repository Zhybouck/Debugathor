<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
<title>A bientôt !</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


<!-- Style CSS -->
<style type="text/css">
.jumbotron {
	background-color: #343a40;
	color: #eff2f3;
}

/* Permet d'aligner les boutons à droite */
.ml-auto {
	left: auto !important;
	right: 0px;
}

/* Fixe la taille des boutons */
.custom {
	width: 120px !important;
}

body {
	background-color: #eff2f3;
	color: #343a40;
}

/* Pour éviter d'avoir une ligne grise sous la navbar */
.topwelcome {
	background-color: #343a40;
	color: #eff2f3;
}
</style>

</head>

<body>

	<div class="topwelcome">

		<!-- Navbar -->
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
			<img src="../resources/img/DT.png" width="2%">
			<a class="navbar-brand ml-2" href="#">Debugathor</a>
			<ul class="nav navbar-nav ml-auto">
				<li><form action="user/init" method="get">
						<button class="btn btn-outline-light custom" type="submit">Se
							connecter</button>
					</form></li>
				<li><form action="user/addone" method="post">
						<button class="btn btn-light custom" type="submit">S'inscrire</button>
					</form></li>
			</ul>
		</nav>

		<!-- Jumbotron -->
		<div class="jumbotron text-center">
			<img class="img-fluid" src="../resources/img/logoDT.png"
				width="40%">
		</div>
	</div>

	<!-- Contenu -->
	<div class="container-fluid col-md-6 down">
		
			<div class="col-md-6">
				
				<form action="user/init" method="get">
					<p>
						<button class="btn btn-secondary" type="submit">Retour à la page d'accueil
							&raquo;</button>
					</p>
				</form>

			</div>
	
		<hr>

		<!-- Footer -->

		<footer class="container">
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