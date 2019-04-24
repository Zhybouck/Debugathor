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

/* Column Filter row at top of table  */
.datatable tfoot {
	display: table-header-group;
}

.datatable tfoot .filter-column {
	width: 100% !important;
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
						des solutions </a></li>
				<li class="nav-item active"><a class="nav-link"
					href="http://localhost:8080/TestDebugathor/myBugs.jsp">Mes
						solutions<span class="sr-only">(current)</span>
				</a></li>
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

	<!-- Tableau qui regroupe l'ensemble des bugs postés par l'utilisateur connecté-->

	<div class="container-fluid mb-5" style="padding-top: 90px;">

		<h1 class="display-4">Mes solutions</h1>
		<hr>

		<table
			class="datatable table table-striped table-hover table-bordered">

			<!-- Entête du tableau -->
			<thead>
				<tr>
					<th>ID</th>
					<th>Technologie</th>
					<th>Type</th>
					<th>Date</th>
					<th>Titre</th>
					<th>Description</th>
					<th>Démarche</th>
					<th>Mise à jour</th>
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
				</tr>
			</tfoot>

			<!-- Corps du tableau -->
			<tbody>
				<tr>
					<td>1</td>
					<td>Java</td>
					<td>java.io.FileNotFoundException</td>
					<td>29/03/2018</td>
					<td>Impossible de trouver le fichier</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Donec sed odio dui. Fusce dapibus, tellus ac cursus
						commodo, tortor mauris condimentum nibh, ut fermentum massa justo
						sit amet risus.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise à jour</button></td>
				</tr>

				<tr>
					<td>2</td>
					<td>JavaScript</td>
					<td>java.io.NullPointer</td>
					<td>25/02/2019</td>
					<td>Serveur indisponible</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
						in, egestas eget quam. Vestibulum id ligula porta felis euismod
						semper.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise à jour</button></td>
				</tr>

				<tr>
					<td>3</td>
					<td>CSS</td>
					<td>org.apache.NullPointer</td>
					<td>12/04/2019</td>
					<td>Impossible de trouver le fichier</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Vestibulum id ligula porta felis euismod semper. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise à jour</button></td>
				</tr>

				<tr>
					<td>4</td>
					<td>Java</td>
					<td>java.io.FileNotFoundException</td>
					<td>29/03/2018</td>
					<td>Impossible de trouver le fichier</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Donec sed odio dui. Fusce dapibus, tellus ac cursus
						commodo, tortor mauris condimentum nibh, ut fermentum massa justo
						sit amet risus.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise à jour</button></td>
				</tr>

				<tr>
					<td>5</td>
					<td>JavaScript</td>
					<td>java.io.NullPointer</td>
					<td>25/02/2019</td>
					<td>Serveur indisponible</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
						in, egestas eget quam. Vestibulum id ligula porta felis euismod
						semper.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise à jour</button></td>
				</tr>

				<tr>
					<td>6</td>
					<td>CSS</td>
					<td>org.apache.NullPointer</td>
					<td>12/04/2019</td>
					<td>Impossible de trouver le fichier</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Vestibulum id ligula porta felis euismod semper. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise à jour</button></td>
				</tr>

				<tr>
					<td>7</td>
					<td>Java</td>
					<td>java.io.FileNotFoundException</td>
					<td>29/03/2018</td>
					<td>Impossible de trouver le fichier</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Donec sed odio dui. Fusce dapibus, tellus ac cursus
						commodo, tortor mauris condimentum nibh, ut fermentum massa justo
						sit amet risus.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise à jour</button></td>
				</tr>

				<tr>
					<td>8</td>
					<td>JavaScript</td>
					<td>java.io.NullPointer</td>
					<td>25/02/2019</td>
					<td>Serveur indisponible</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
						in, egestas eget quam. Vestibulum id ligula porta felis euismod
						semper.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise à jour</button></td>
				</tr>

				<tr>
					<td>9</td>
					<td>CSS</td>
					<td>org.apache.NullPointer</td>
					<td>12/04/2019</td>
					<td>Impossible de trouver le fichier</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Vestibulum id ligula porta felis euismod semper. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise à jour</button></td>
				</tr>

				<tr>
					<td>10</td>
					<td>Java</td>
					<td>java.io.FileNotFoundException</td>
					<td>29/03/2018</td>
					<td>Impossible de trouver le fichier</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Donec sed odio dui. Fusce dapibus, tellus ac cursus
						commodo, tortor mauris condimentum nibh, ut fermentum massa justo
						sit amet risus.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise
							à jour</button></td>
				</tr>

				<tr>
					<td>11</td>
					<td>JavaScript</td>
					<td>java.io.NullPointer</td>
					<td>25/02/2019</td>
					<td>Serveur indisponible</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
						in, egestas eget quam. Vestibulum id ligula porta felis euismod
						semper.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise
							à jour</button></td>
				</tr>

				<tr>
					<td>12</td>
					<td>CSS</td>
					<td>org.apache.NullPointer</td>
					<td>12/04/2019</td>
					<td>Impossible de trouver le fichier</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Vestibulum id ligula porta felis euismod semper. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise
							à jour</button></td>
				</tr>

				<tr>
					<td>13</td>
					<td>Java</td>
					<td>java.io.FileNotFoundException</td>
					<td>29/03/2018</td>
					<td>Impossible de trouver le fichier</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Donec sed odio dui. Fusce dapibus, tellus ac cursus
						commodo, tortor mauris condimentum nibh, ut fermentum massa justo
						sit amet risus.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise
							à jour</button></td>
				</tr>

				<tr>
					<td>14</td>
					<td>JavaScript</td>
					<td>java.io.NullPointer</td>
					<td>25/02/2019</td>
					<td>Serveur indisponible</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
						in, egestas eget quam. Vestibulum id ligula porta felis euismod
						semper.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise
							à jour</button></td>
				</tr>

				<tr>
					<td>3</td>
					<td>CSS</td>
					<td>org.apache.NullPointer</td>
					<td>12/04/2019</td>
					<td>Impossible de trouver le fichier</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Vestibulum id ligula porta felis euismod semper. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise
							à jour</button></td>
				</tr>

				<tr>
					<td>1</td>
					<td>Java</td>
					<td>java.io.FileNotFoundException</td>
					<td>29/03/2018</td>
					<td>Impossible de trouver le fichier</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Donec sed odio dui. Fusce dapibus, tellus ac cursus
						commodo, tortor mauris condimentum nibh, ut fermentum massa justo
						sit amet risus.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise
							à jour</button></td>
				</tr>

				<tr>
					<td>2</td>
					<td>JavaScript</td>
					<td>java.io.NullPointer</td>
					<td>25/02/2019</td>
					<td>Serveur indisponible</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
						in, egestas eget quam. Vestibulum id ligula porta felis euismod
						semper.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise
							à jour</button></td>
				</tr>

				<tr>
					<td>3</td>
					<td>CSS</td>
					<td>org.apache.NullPointer</td>
					<td>12/04/2019</td>
					<td>Impossible de trouver le fichier</td>
					<td>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</td>
					<td>Vestibulum id ligula porta felis euismod semper. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus.</td>
					<td><button type="button" class="btn btn-outline-secondary">Mise
							à jour</button></td>
				</tr>


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