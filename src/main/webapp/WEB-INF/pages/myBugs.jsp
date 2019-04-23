<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Mes solutions</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- Lien pour les tableaux -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">

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
		<img src="C:\Users\IN-ST-008\Desktop\DT.png" width="4%"
			alt=""> <a class="navbar-brand" href="#">Debugathor</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/TestDebugathor/tabBug.jsp">Liste
						des bugs </a></li>
				<li class="nav-item active"><a class="nav-link"
					href="http://localhost:8080/TestDebugathor/myBugs.jsp">Mes bugs
						<span class="sr-only">(current)</span>
				</a></li>
			</ul>
			<form class="form-inline mt-2 mt-md-0">
				<button class="btn btn-danger my-2 my-sm-0" type="submit">Se
					deconnecter</button>
			</form>
		</div>
	</nav>

	<!-- Tableau de l'ensemble des solutions postées par l'utilisateur connecté -->

	<div class="container mb-3 mt-3">

		<table class="table table-striped table-bordered" style="width: 100%"
			id="myBugs">




		</table>


	</div>






	<!-- Les balises script sont à mettre à la fin du body pour éviter de surcharger le chargement de la page -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<!-- Balises script pour les tableaux -->
	<script
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>

	<!-- 	Script relatif à l'ID du tableau -->
	<script>
		$('myBugs').DataTable();
	</script>
</body>
</html>