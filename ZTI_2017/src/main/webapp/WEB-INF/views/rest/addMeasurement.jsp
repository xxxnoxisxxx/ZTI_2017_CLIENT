<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="ZTI Project">
<title>Użytkownicy</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextPath}">ZTI 2017</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#"></a></li>
					<li class="dropdown"><a href="/" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Panel
							administratora <span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${contextPath}/admin/users">Użytkownicy</a></li>
							<li class="divider"></li>
							<li><a href="/admin/addMeasurement">REST - Dodawanie</a></li>
							<li><a href="${contextPath}/admin/editMeasurement">REST
									- Edytowanie i usuwanie</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><c:if
							test="${pageContext.request.userPrincipal.name != null}">
							<form id="logoutForm" method="POST"
								action="${contextPath}/logout">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>

							<a style="cursor: pointer"
								onclick="document.forms['logoutForm'].submit()">Wyloguj</a>

						</c:if></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<h2>Dodaj pomiar</h2>
			<hr>
			<form id="addForm">
				<div class="form-group">
					<label for="city">Miasto:</label> <input type="text"
						class="form-control" id="city" name="city" value="Krakow" readonly>
				</div>
				<div class="form-group">
					<label for="temperature">Temperatura</label> <input type="number"
						class="form-control" id="temperature" name="temperature"
						step="0.01" required>
				</div>
				<div class="form-group">
					<label for="totalPrecipitation">Ilość opadów</label> <input
						type="number" class="form-control" id="totalPrecipitation"
						name="totalPrecipitation" min="0" step="0.01" required>
				</div>
				<div class="form-group">
					<label for="windSpeed">Prędkość wiatru</label> <input type="number"
						class="form-control" id="windSpeed" name="windSpeed" step="0.01"
						min="0" required>
				</div>
				<div class="form-group">
					<label for="dateOfMeasurement">Data pomiaru</label> <input
						type="datetime-local" class="form-control" id="dateOfMeasurement"
						name="dateOfMeasurement"
						pattern="[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}"
						step="1" required>
				</div>
				<button onclick="Add()" type="button" class="btn btn-default">Dodaj
					rekord</button>
			</form>
		</div>
	</div>
	<script src="${contextPath}/resources/js/jquery-3.2.1.min.js"
		type="text/javascript"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script>
	function Add() {

	    if ($("#addForm")[0].checkValidity()) {
	        var data = $("#addForm").serializeArray().reduce(
	            function(a, x) {
	                a[x.name] = x.value;
	                return a;
	            }, {});

	        var fData = data['dateOfMeasurement'];
	        fData = fData.replace("T", " ");
	        if (fData.length = 16)
	            fData += ":00"
	        data['dateOfMeasurement'] = fData;

	        $
	            .ajax({
	                type: "POST",
	                url: "${contextPath}/rest/measurements",
	                data: JSON.stringify(data),
	                contentType: "application/json; charset=utf-8",
	                dataType: "json",
	                complete: function() {
	                    window.location.href = '${contextPath}/home'
	                },
	                failure: function(errMsg) {
	                    alert(errMsg);
	                }
	            });
	    }

	}
	</script>
</body>
</html>