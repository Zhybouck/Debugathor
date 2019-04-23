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

.div-left {
	background-color: #343a40;
	color: #eff2f3;
}

.div-right {
	background-color: #eff2f3;
	color: #343a40;
}

a {
	color: #eff2f3;
}

</style>

</head>


<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-4 div-left">

				<!-- Navbar -->
				<!-- 	Rajouter les form -->
				<nav class="navbar navbar-expand-md navbar-dark bg-dark">
					<img src="C:\Users\IN-ST-008\Desktop\DT.png" width="8%" alt="">
					<a class="navbar-brand" href="#">Debugathor</a>
				</nav>

				<div class="text-center">
					<img class="img-fluid mt-5 mb-5"
						src="C:\Users\IN-ST-008\Desktop\logoDT.png" alt="Responsive image"
						width="80%">
				</div>
				
				<div class="text-center mb-5">
					<p>
						Pas encore inscrit ?</p> <p> <a class="btn btn-outline-light"
							href="http://localhost:8080/TestDebugathor/login.jsp"
							role="button">Nous rejoindre ! &raquo;</a>
					</p>
				</div>
			</div>


			<div class="col-8 div-right">
				<form class="form-signin ml-5 mt-5 mb-5">
					<h1 class="display-4">Se connecter</h1>
					<h6>Veuillez vous identifier.</h6>
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

				<!-- Footer -->
				<hr>
				<footer class="container-fluid ml-5">
					<p>&copy; Debugathor 2019</p>
				</footer>
			</div>
		</div>



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