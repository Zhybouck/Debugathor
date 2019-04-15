<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">

<title>loool</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<div class="backcolor">
		<div>
			<img class="hector" height=25% width=25%
				src="https://cdn.discordapp.com/attachments/560398829506002970/565804052101726249/debugathor.png" />
		</div>
		<div>
			<h1>Formulaire de connexion</h1>
			<form>
				<div class="form-group">
					<label for="exampleInputEmail1">Identifiant</label> <input
						type="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Identifiant"> <small
						id="emailHelp" class="form-text text-muted"><h6>ne
							vous demanderons jamais votre identifiant, ne le partagez jamais.</h6></small>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Mot de passe</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Password">
				</div>
				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1">
					<label class="form-check-label" for="exampleCheck1">Rester
						connecter</label>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Connexion</button>
				</div>
			</form>
		</div>
		<div class="redircreacompte">
			<h1>Vous n'avez pas de compte?</h1>
			<button class="btn btn-success">Créer un compte</button>

		</div>
		</div>
</body>