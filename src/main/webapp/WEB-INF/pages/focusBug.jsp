<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Zoom solution</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Lien pour Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- Lien pour les tableaux -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">


<!-- Style CSS -->
<style type="text/css">
body {
	background-color: #eff2f3;
	color: #343a40;
}

.tabcomp {
	width: 80% !important;
}

.row {
	margin-bottom: 10px;
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
						des solutions</a></li>
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/TestDebugathor/myBugs.jsp">Mes
						solutions</a></li>
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/TestDebugathor/addBug.jsp">Ajouter
						une solution</a></li>
			</ul>

			<form class="form-inline mt-2 mt-md-0">
				<button class="btn btn-danger my-2 my-sm-0" type="submit">Se
					deconnecter</button>
			</form>
		</div>
	</nav>

	<!-- Tableau qui regroupe l'ensemble des bugs postés-->

	<div class="container-fluid mb-5" style="padding-top: 90px;">

		<h1 class="display-4">Zoom sur une solution</h1>
		<hr>

		<div class="row ml-2">
			<div class="col-1"><b>ID :</b> 1 </div>

			<div class="col-3"><b>Technologie :</b> Java</div>

			<div class="col-4"><b>Type :</b> java.io.FileNotFoundException</div>

			<div class="col-3"><b>Date :</b> 29/03/2018</div>

			<div class="col-1"></div>
		</div>

		<div class="row ml-2">
			<div class="col-1"><b>Titre :</b></div>
			<div class="col-9">Impossible de trouver le fichier</div>
			<div class="col-2"></div>
		</div>

		<div class="row ml-2">
			<div class="col-1"><b>Description :</b> </div>
				
			<div class="col-8">Donec id elit non mi porta
				gravida at eget metus. Fusce dapibus, tellus ac cursus commodo,
				tortor mauris condimentum nibh, ut fermentum massa justo sit amet
				risus. Etiam porta sem malesuada magna mollis euismod. Donec sed
				odio dui.</div>
			<div class="col-3"></div>
		</div>

		<div class="row ml-2">
			<div class="col-1"><b>Démarche :</b> </div>
			<div class="col-8">Donec sed odio dui. Fusce
				dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
				ut fermentum massa justo sit amet risus.</div>
			<div class="col-3"></div>
		</div>
	</div>

	<h1 class="display-4 mt-5">Compléments</h1>
	<hr>

	<table class="tabcomp table">
		<tr>
			<td>28/04/2019</td>
			<td>Illud tamen clausos vehementer angebat quod captis navigiis,
				quae frumenta vehebant per flumen, Isauri quidem alimentorum copiis
				adfluebant, ipsi vero solitarum rerum cibos iam consumendo inediae
				propinquantis aerumnas exitialis horrebant.</td>

		</tr>

		<tr>
			<td>25/02/2019</td>
			<td>Procedente igitur mox tempore cum adventicium nihil
				inveniretur, relicta ora maritima in Lycaoniam adnexam Isauriae se
				contulerunt ibique densis intersaepientes itinera praetenturis
				provincialium et viatorum opibus pascebantur.</td>

		</tr>

		<tr>
			<td>12/12/2018</td>
			<td>Nemo quaeso miretur, si post exsudatos labores itinerum
				longos congestosque adfatim commeatus fiducia vestri ductante
				barbaricos pagos adventans velut mutato repente consilio ad
				placidiora deverti.</td>

		</tr>

	</table>

	</div>

	<div class="col-4 mt-5">
		<button type="button" class="btn btn-success">Compléter cette
			solution</button>
	</div>


	<!-- Footer -->
	<hr>
	<footer class="container-fluid">
		<p>&copy; Debugathor 2019</p>
	</footer>


	<!-- Les balises script sont à mettre à la fin du body pour éviter de surcharger le chargement de la page -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<!-- Balises script pour les tableaux -->

	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

	<script
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>

	<!-- Responsive extension -->

	<script
		src="https://cdn.datatables.net/responsive/2.1.0/js/responsive.bootstrap.min.js"></script>

	<!-- Buttons extension -->

	<script
		src="//cdn.datatables.net/buttons/1.2.1/js/dataTables.buttons.min.js"></script>

	<script
		src="//cdn.datatables.net/buttons/1.2.1/js/buttons.bootstrap.min.js"></script>

	<script src="//cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>

	<script
		src="//cdn.datatables.net/buttons/1.2.1/js/buttons.html5.min.js"></script>
</body>
</html>