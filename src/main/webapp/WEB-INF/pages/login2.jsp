<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Se connecter</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">



<!-- Style CSS -->
<style type="text/css">

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
	margin-top: 70px;
	background-color: #343a40;
	color: #eff2f3;
}
</style>

</head>


<body>

	<!-- Navbar -->
	<!-- 	Rajouter les form -->
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<img src="C:\Users\IN-ST-008\Desktop\DT.png" width="4%"
			alt=""> <a class="navbar-brand" href="#">Debugathor</a>

		<ul class="nav navbar-nav ml-auto">
			<li><button class="btn btn-outline-light custom" type="submit">Se
					connecter</button></li>
			<li><button class="btn btn-light custom" type="submit">S'inscrire</button></li>
		</ul>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-6">

				<div class="text-center">
					<img class="img-fluid mt-5 mb-5"
						src="C:\Users\IN-ST-008\Desktop\logoDT.png" alt="Responsive image"
						width="70%">
				</div>
			</div>


			<div class="col-6">
				<form class="form-signin mt-5 mb-5">
					<h1>Se connecter</h1>
					<p>Veuillez vous identifier.</p>
					<hr>

					<div class="form-label-group col-7">
						Adresse mail <input type="email" id="inputEmail"
							class="form-control mt-2" placeholder="Adresse mail" required
							autofocus> <label for="inputEmail"></label>
					</div>

					<div class="form-label-group col-5">
						Mot de passe <input type="password" id="inputPassword"
							class="form-control mt-2" placeholder="Mot de passe" required>
						<label for="inputPassword"></label>
					</div>

					<div class="checkbox mb-3 col-5">
						<label> <input type="checkbox" value="remember-me">
							Se souvenir de moi
						</label>
					</div>

					<button class="btn btn-lg btn-primary btn-block ml-3 col-3"
						type="submit">Se connecter</button>
				</form>
			</div>
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