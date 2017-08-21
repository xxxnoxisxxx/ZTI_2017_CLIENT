<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	<div class="container">
		<div class="col-lg-8 col-lg-offset-2">
			<form class="form-horizontal" method="POST"
				action="${contextPath}/login">
				<h2>Logowanie</h2>

				<div class="form-group">
					<label for="username" class="col-lg-3 control-label">Nazwa
						użytkownika</label>
					<div class="col-lg-9">
						<input name="username" type="text" class="form-control"
							placeholder="Nazwa użytkownika" required/>
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-lg-3 control-label">Hasło</label>
					<div class="col-lg-9">
						<input name="password" type="password" class="form-control"
							placeholder="Hasło" required/>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>
				<div class="form-group">
					<div class="col-lg-12">
						<button class="btn btn-default btn-block" type="submit">Zaloguj
							się</button>
					</div>
					<div class="col-lg-12">
						<h4 class="text-center">
							<a href="${contextPath}/registration">Utwórz konto</a>
						</h4>
					</div>
				</div>

			</form>
		</div>
	</div>
	<script src="${contextPath}/resources/js/jquery-3.2.1.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>