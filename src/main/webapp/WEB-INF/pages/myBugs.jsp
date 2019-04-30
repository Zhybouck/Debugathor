<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">

<head>
<title>Mes solutions</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Lien pour Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="/open-iconic/font/css/open-iconic.css" rel="stylesheet">



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

/* Column Filter row at top of table  */
.datatable tfoot {
	display: table-header-group;
}

.datatable tfoot .filter-column {
	width: 100% !important;
}

.ellipsis {
    max-width: 40px;
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
}
</style>

</head>

<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<img src="../resources/img/DT.png" width="2%"> <a
			class="navbar-brand ml-2" href="#">Debugathor</a>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><form id="list" action="back">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("list").submit()'>Liste des
						solutions</a></li>
				<li class="nav-item active"><form id="mySol" action="mybugs">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("mySol").submit()'>Mes
						solutions</a></li>
				<li class="nav-item"><form id="addSol" action="initaddsoluce">
						<input type="hidden" />
					</form> <a class="nav-link" href="#"
					onclick='document.getElementById("addSol").submit()'>Ajouter
						une solution</a></li>
			</ul>

			<form class="form-inline mt-2 mt-md-0" action="disconnect">
				<i class="nav-item nav-link"
					style="color: #eff2f3; margin-right: 20px;">Bonjour
					${Utilisateur.prenom}</i>
				<button class="btn btn-danger my-2 my-sm-0" type="submit">Se
					deconnecter</button>
			</form>
		</div>
	</nav>

	<!-- Tableau qui regroupe l'ensemble des bugs postés par l'utilisateur connecté-->

	<div class="container-fluid mb-5" style="padding-top: 100px;">

		<h1 class="display-4">Mes solutions</h1>
		<hr>

		<table
			class="datatable table table-striped table-hover table-bordered">


			<!-- Entête du tableau -->
			<thead>
				<tr>
					<th width="3%">ID</th>
					<th>Technologie</th>
					<th>Type</th>
					<th>Date</th>
					<th>Titre</th>
					<th>Description</th>
					<th>Démarche</th>
					<th width="7%">Mise à jour</th>
					<th width="7%">Consulter</th>
					<th width="7%">Supprimer</th>
				</tr>
			</thead>

			<!-- Ligne filtres -->
			<tfoot>
				<tr>
					<th><input type="text"
						class="form-control input-sm filter-column"></th>
					<th><input type="text"
						class="form-control input-sm filter-column"></th>
					<th><input type="text"
						class="form-control input-sm filter-column"></th>
					<th><input type="text"
						class="form-control input-sm filter-column"></th>
					<th><input type="text"
						class="form-control input-sm filter-column"></th>
					<th><input type="text"
						class="form-control input-sm filter-column"></th>
					<th><input type="text"
						class="form-control input-sm filter-column"></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</tfoot>

			<!-- Corps du tableau -->
			<tbody>
				<c:forEach items="${listesol}" var="solution">
					<tr>
						<td><c:out value="${solution.idSolution}" /></td>
						<td><c:out value="${solution.technologie}" /></td>
						<td><c:out value="${solution.type}" /></td>
						<td><c:out value="${solution.dateBug}" /></td>
						<td><c:out value="${solution.titre}" /></td>
						<td class="ellipsis"><c:out value="${solution.description}" /></td>
						<td class="ellipsis"><c:out value="${solution.demarche}" /></td>

						<td>
							<form action="focus">
								<input name="Id" type="hidden" value="${solution.idSolution}">
								<button type="submit" class="btn btn-outline-secondary">
									<span class="fa fa-search"></span> Consulter
								</button>
							</form>
						</td>

						<td>
							<form action="update">
								<input name="Id" type="hidden" value="${solution.idSolution}">
								<button type="submit" class="btn btn-outline-secondary">
								<span class="fa fa-edit"></span> Mise à jour
								</button>
							</form>
						</td>

						<td>
							<form action="delete">
								<input name="Id" type="hidden" value="${solution.idSolution}">
								<button type="submit" class="btn btn-outline-danger">
								<span class="fa fa-remove"></span> Supprimer</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>


		</table>

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

	<script src="script.js"></script>

	<!-- 	JS pour les filtres et les tris du tableau -->

	<script>
		var dataTable = $('.datatable').DataTable();

		// 		Filtre dans les colonnes
		dataTable.columns().every(function() {
			var column = this;

			$('.filter-column', this.footer()).on('keyup change', function() {
				if (column.search() !== this.value) {
					column.search(this.value).draw();
					this.focus();
				}
			});
		});
	</script>

</body>
</html>