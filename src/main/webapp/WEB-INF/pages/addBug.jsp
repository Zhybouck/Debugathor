<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
<title>Ajouter une solution !</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

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
				<li class="nav-item"><form id="list" action="back">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("list").submit()'>Liste des
						solutions</a></li>
				<li class="nav-item"><form id="mySol" action="mybugs">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("mySol").submit()'>Mes
						solutions</a></li>
				<li class="nav-item active">
					<form id="addSol" action="initaddsoluce">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("addSol").submit()'>Ajouter
						une solution</a>
				</li>
			</ul>
			<form class="form-inline mt-2 mt-md-0" action="disconnect" onsubmit="return confirm('Etes-vous sûr de vouloir vous déconnecter ?');">
				<i class="nav-item nav-link" style="color: #eff2f3; margin-right:20px;">Bonjour ${Utilisateur.prenom}</i>
				<button class="btn btn-danger my-2 my-sm-0" type="submit">Se
					deconnecter</button>
			</form>
		</div>
	</nav>

	<!-- Formulaire d'ajout d'une solution -->

	<div class="container-fluid col-md-6">

		<h1 class="display-4" style="margin-top: 100px">Ajouter une
			solution</h1>
		<p>Veuillez remplir le formulaire ci-dessous pour ajouter une
			solution.<br> <small>* Tous les champs sont obligatoires.</small></p>
		<hr>

		<form:form class="form-signin ml-5 mt-5 mb-5" action="applyadd"
			method="post" modelAttribute="Solution">
		<small style="color: red;"><c:out value="${alreadyinsc}" /></small>
			
			<div class="form-group col-md-6">
				<label for="inputTechnologie">Technologie</label>
				<form:input type="text" class="form-control" id="inputTechnologie"
					path="Technologie" required="required" maxlength="45"/>
			</div>

			<div class="form-group col-md-6">
				<label for="inputNomLogiciel">Nom du logiciel</label> <input
					type="text" class="form-control" name="inputNomLogiciel" required="required" maxlength="45"/>
			</div>

			<div class="form-group col-md-6">
				<label for="inputVersionLogiciel">Version du logiciel</label> <input
					type="text" class="form-control" name="inputVersionLogiciel" required="required" maxlength="45"/>
			</div>

			<div class="form-group col-md-10">
				<label for="inputType">Type de bug</label>
				<form:input type="text" class="form-control" id="inputType"
					path="Type" required="required" maxlength="45"/>
			</div>

			<div class="form-group col-md-10">
				<label for="inputType">Titre</label>
				<form:input type="text" class="form-control" id="inputTitre"
					path="Titre" required="required" maxlength="140"/>
			</div>

			<div class="form-group col-md-12">
				<label for="inputDescription">Description du bug</label>
				<form:textarea class="form-control" id="inputDescription" rows="8"
					path="Description" required="required" name="description"></form:textarea>
			</div>
			<div class="form-group col-md-12">
				<label for="inputDemarche">Démarche à suivre</label>
				<form:textarea class="form-control" id="inputDemarche" rows="8"
					path="Demarche" required="required" name="demarche"></form:textarea>
			</div>

			<!-- Importer le fichier Log -->

			<%-- 			<form> --%>
			<!-- 				<div class="form-group col-md-6"> -->
			<!-- 					<label for="exampleFormControlFile1">Importer votre fichier -->
			<!-- 						logs</label> <input type="file" class="form-control-file" -->
			<!-- 						id="exampleFormControlFile1"> -->
			<!-- 				</div> -->
			<%-- 			</form> --%>

			<!-- Bouton d'annulation et de confirmation d'ajout-->
			<div class="container-fluid row col-6 mt-5 mb-5 ml-2">

				<button class="btn btn-success" type="submit" style="width: 120px;">Confirmer</button>
		</form:form>

		<form class="form-inline" action="back">
			<button class="btn btn-outline-secondary" type="submit"
				style="width: 120px;">Annuler</button>
		</form>

	</div>


	<br>

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
		
                <script src="https://cdn.ckeditor.com/4.11.3/standard/ckeditor.js"></script>
                
                
                <script>
                        CKEDITOR.replace( 'inputDescription' );
                </script>
               
 				<script>
                        CKEDITOR.replace( 'inputDemarche' );
                </script>
               
</body>
</html>