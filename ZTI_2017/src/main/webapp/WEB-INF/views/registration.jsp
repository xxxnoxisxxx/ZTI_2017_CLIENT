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
<title>Rejestracja</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-lg-8 col-lg-offset-2">
			<form:form method="POST" modelAttribute="userForm"
				class="form-horizontal">
				<h2>Tworzenie konta</h2>
				<spring:bind path="username">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<span>${message}</span> <label for="username"
							class="col-lg-2 control-label">Nazwa użytkownika</label>
						<div class="col-lg-10">
							<form:input type="text" path="username" class="form-control"
								placeholder="Nazwa użytkownika" autofocus="true"></form:input>
							<form:errors path="username"></form:errors>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="password">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label for="password" class="col-lg-2 control-label">Hasło</label>
						<div class="col-lg-10">
							<form:input type="password" path="password" class="form-control"
								placeholder="Podaj hasło"></form:input>
							<form:errors path="password"></form:errors>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="passwordConfirm">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label for="passwordConfirm" class="col-lg-2 control-label">Hasło</label>
						<div class="col-lg-10">
							<form:input type="password" path="passwordConfirm"
								class="form-control" placeholder="Potwierdź hasło"></form:input>
							<form:errors path="passwordConfirm"></form:errors>
						</div>
					</div>
				</spring:bind>
				<div class="form-group">
				<div class="col-lg-12">
					<button class="btn btn-default btn-block" type="submit">Wyślij</button>
				</div>
				</div>
			</form:form>
		</div>

	</div>
	<script src="${contextPath}/resources/js/jquery-3.2.1.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>