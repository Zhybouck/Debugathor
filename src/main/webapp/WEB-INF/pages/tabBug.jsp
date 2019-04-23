<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Listes des solutions</title>
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
				<li class="nav-item active"><a class="nav-link"
					href="http://localhost:8080/TestDebugathor/tabBug.jsp">Liste
						des bugs <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/TestDebugathor/myBugs.jsp">Mes bugs</a></li>
			</ul>

			<form class="form-inline mt-2 mt-md-0">
				<button class="btn btn-danger my-2 my-sm-0" type="submit">Se
					deconnecter</button>
			</form>
		</div>
	</nav>

	<!-- Tableau qui regroupe l'ensemble des bugs postés-->

	<div class="container mb-5 mt-3">

		<table class="table table-striped table-bordered tabBug" style="width: 100%; margin-top:70px">

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
				</tr>
			</thead>

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
					<td>Donec sed odio dui. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</td>
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
					<td>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					</td>
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
					<td>Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</td>
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
					<td>Donec sed odio dui. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</td>
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
					<td>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					</td>
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
					<td>Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</td>
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
					<td>Donec sed odio dui. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</td>
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
					<td>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					</td>
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
					<td>Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</td>
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
					<td>Donec sed odio dui. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</td>
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
					<td>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					</td>
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
					<td>Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</td>
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
					<td>Donec sed odio dui. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</td>
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
					<td>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					</td>
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
					<td>Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</td>
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
					<td>Donec sed odio dui. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</td>
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
					<td>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					</td>
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
					<td>Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</td>
				</tr>
				

			</tbody>

			<!-- Bas du tableau -->
			<tfoot>
				<tr>
					<th>ID</th>
					<th>Technologie</th>
					<th>Type</th>
					<th>Date</th>
					<th>Titre</th>
					<th>Description</th>
					<th>Démarche</th>
				</tr>
			</tfoot>

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
	<script
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>

	<!-- 	Script relatif à l'ID du tableau -->

	
 <script>
$(document).ready(function(){
  $("#tabBug").on("ID", function() {
    var value = $(this).val().toLowerCase();
    $("#tabBug tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script> 

</body>
</html>