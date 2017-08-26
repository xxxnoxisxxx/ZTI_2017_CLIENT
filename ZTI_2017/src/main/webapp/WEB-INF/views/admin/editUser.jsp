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
<title>Edycja użytkownika</title>

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
							<li><a href="${contextPath}/admin/addMeasurement">REST - Dodawanie</a></li>
							<li><a href="${contextPath}/admin/editMeasurement">REST - Edytowanie i usuwanie</a></li>
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
		<div class="col-lg-8 col-lg-offset-2">
			<form:form method="POST" modelAttribute="userForm"
				class="form-horizontal"
				action="${contextPath}/admin/user/edit/${userForm.id}">
				<h2>Edycja konta</h2>

				<spring:bind path="firstname">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<span>${message}</span> <label for="firstname"
							class="col-lg-2 control-label">Imię</label>
						<div class="col-lg-10">
							<form:input type="text" path="firstname" class="form-control"
								placeholder="Imię" autofocus="true"></form:input>
							<form:errors cssClass="error" path="firstname"></form:errors>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="lastname">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<span>${message}</span> <label for="lastname"
							class="col-lg-2 control-label">Nazwisko</label>
						<div class="col-lg-10">
							<form:input type="text" path="lastname" class="form-control"
								placeholder="Nazwisko" autofocus="true"></form:input>
							<form:errors cssClass="error" path="lastname"></form:errors>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="email">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<span>${message}</span> <label for="email"
							class="col-lg-2 control-label">Email</label>
						<div class="col-lg-10">
							<form:input type="email" path="email" class="form-control"
								placeholder="Email" autofocus="true"></form:input>
							<form:errors cssClass="error" path="email"></form:errors>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="username">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<span>${message}</span> <label for="username"
							class="col-lg-2 control-label">Nazwa użytkownika</label>
						<div class="col-lg-10">
							<form:input type="text" path="username" class="form-control"
								placeholder="Nazwa użytkownika" autofocus="true"></form:input>
							<form:errors cssClass="error" path="username"></form:errors>
						</div>
					</div>
				</spring:bind>

				<div class="form-group">
					<div class="col-lg-12">
						<button class="btn btn-default btn-block" type="submit">Wyślij</button>
					</div>
				</div>
				<div class="form-group">
					<form:hidden path="id" />
					<div class="col-lg-12">
						<button class="btn btn-danger btn-block"
							onclick="deleteUser(${userForm.id})" type="button">Usuń</button>
					</div>
				</div>
			</form:form>
		</div>

	</div>
	<script src="${contextPath}/resources/js/jquery-3.2.1.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script>
	function deleteUser(id) {

		$.ajax({
		     type: "DELETE",
		     url: "${contextPath}/admin/user/delete/"+id,
		     beforeSend: function(request) {
		    	    request.setRequestHeader("X-CSRF-TOKEN", '${_csrf.token}' );
		    	  },
		})
	}
	
	</script>
</body>
</html>