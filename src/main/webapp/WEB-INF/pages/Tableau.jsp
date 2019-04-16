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

<title>Liste</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>


<form>
  <div class="row">
    <div class="col">
      <input type="text" class="form-control" placeholder="Technologie">
    </div>
    <div class="col">
      <input type="text" class="form-control" placeholder="Version">
    </div>
    <div class="col">
      <input type="text" class="form-control" placeholder="Date">
    </div>
    <div class="col">
      <input type="text" class="form-control" placeholder="Type de bug">
    </div>
</div>


<h3>Decrivez le problème</h3>
<div class="form-group">
    <label for="exampleFormControlTextarea1">Description du problème</label>
    <textarea class="form-control" id="description" rows="4"></textarea>
  </div>
<h3>Decrivez les étapes à suivre</h3>
 <div class="form-group">
    <label for="exampleFormControlTextarea1">Démarche à suivre</label>
    <textarea class="form-control" id="demarche" rows="4"></textarea>
  </div>
 
  <div class="implog">
    <label for="exampleFormControlFile1">Importer Votre fichier log</label>
    <input type="file" class="form-control-file" id="impLog">
  </div>
</form>
</body>
</html>