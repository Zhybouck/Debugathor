<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">

<title>loool</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	
		<div>
			<h1>Formulaire d'inscription</h1>
			<form:form action="add" method="POST"
				modelAttribute="creationutilisateur">
				<div class="form-group">
					<label for="exampleInputEmail1">Mail</label>
					<form:input type="email" class="form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp"
						placeholder="Identifiant" path="mail" />
					<small><form:errors path="mail" cssClass="errormsg" /></small>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Mot de passe</label>
					<form:input type="password" class="form-control"
						id="exampleInputPassword1" placeholder="Password" path="mdp" />
					<small><form:errors path="mdp" cssClass="errormsg" /></small>
					<div class="form-group"></div>
				</div>
				
				<div class="form-group">
					<label for="exampleInputPassword1">prenom</label>
					<form:input type="text" class="form-control"
						id="exampleInputPassword1" placeholder="prenom" path="prenom" />
					<small><form:errors path="prenom" cssClass="prenom" /></small>
					<div class="form-group"></div>
				</div>
				
				<div class="form-group">
					<label for="exampleInputPassword1">nom</label>
					<form:input type="text" class="form-control"
						id="exampleInputPassword1" placeholder="nom" path="nom" />
					<small><form:errors path="nom" cssClass="nom" /></small>
					<div class="form-group"></div>
				</div>
				
				<div class="form-group">
					<label for="exampleInputPassword1">poste</label>
					<form:input type="text" class="form-control"
						id="exampleInputPassword1" placeholder="poste" path="poste" />
					<small><form:errors path="poste" cssClass="poste" /></small>
					<div class="form-group"></div>
				</div>
				
				<div class="form-group">
					<label for="exampleInputPassword1">rang</label>
					<form:input type="text" class="form-control"
						id="exampleInputPassword1" placeholder="rang" path="rang" />
					<small><form:errors path="rang" cssClass="rang" /></small>
					<div class="form-group"></div>
				</div>

				<button type="submit" class="btn btn-primary">Inscription</button>
					
			</form:form>

		</div>
</body>
</html>
