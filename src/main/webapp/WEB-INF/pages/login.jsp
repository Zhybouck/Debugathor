<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">

<head>
<title>Se connecter</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Lien pour Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- Style CSS -->
<style type="text/css">
.div-left {
	background-color: #343a40;
	min-height: 100vh;
	color: #eff2f3;
}

.div-right {
	background-color: #eff2f3;
	min-height: 100vh;
	color: #343a40;
}

a {
	color: #eff2f3;
}

.form-label-group {
	margin-bottom: 15px;
}

.errormsg {
	color: red;
}
</style>

</head>


<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-4 div-left">

				<!-- Navbar -->
				<nav class="navbar navbar-expand-md navbar-dark bg-dark">
					<img src="../resources/img/DT.png" width="4%"> <a
						class="navbar-brand ml-2" href="#">Debugathor</a>
				</nav>

				<div class="text-center">
					<img class="img-fluid mt-5 mb-5" src="../resources/img/logoDT.png"
						width="60%">
				</div>

				<div class="text-center mb-5">
					<p>Pas encore inscrit ?</p>

					<form action="addone">
						<p>
							<button class="btn btn-outline-light" type="submit">Nous
								rejoindre ! &raquo;</button>
						</p>
					</form>
				</div>
			</div>


			<div class="col-8 div-right">
				<form:form class="form-signin ml-5 mt-5 mb-5" action="id"
					method="POST" modelAttribute="userform">

					<h1 class="display-4">Se connecter</h1>
					<h6>Veuillez vous identifier.</h6>
					<hr>

					<div class="form-label-group col-7">
						<label for="inputEmail">Adresse mail</label>
						<form:input type="email" id="inputEmail" class="form-control mt-2"
							placeholder="Adresse mail" path="mail" required="required"/>
						<small><form:errors path="mail" cssClass="errormsg" /></small>
					</div>

					<div class="form-label-group col-5">
						<label for="inputPassword">Mot de passe</label>
						<form:input type="password" id="inputPassword"
							class="form-control mt-2" placeholder="Mot de passe" path="mdp" required="required"/>
						<small style="color: red;"><c:out value="${Connect}" /></small>
					</div>
					
					
					<button class="btn btn-lg btn-primary btn-block ml-3 mt-4 col-3"
						type="submit">Se connecter</button>
				</form:form>
				
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