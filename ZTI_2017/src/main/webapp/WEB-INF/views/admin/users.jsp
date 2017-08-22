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
<link href="${contextPath}/resources/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/buttons.bootstrap.min.css"
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
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li>
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
			<h2>Użytkownicy</h2>
			<hr>

			<table id="user_list" class="table table-striped table-bordered"
				cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Imię</th>
						<th>Nazwisko</th>
						<th>E-mail</th>
						<th>Nazwa użytkownika</th>
						<th>Role</th>
						<th>Edycja</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${users}" var="user">
						<tr>
							<td><c:out value="${user.firstname}" /></td>
							<td><c:out value="${user.lastname}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.roles}" /></td>
							<td><a
								href="${contextPath}/admin/user/edit/<c:out value="${user.id}" />">
									<button type="button" class="btn btn-sm btn-primary btn-block">
										<span class="glyphicon glyphicon-edit" aria-hidden="true"> </span>
										Edytuj
									</button>
							</a></td>
						</tr>

					</c:forEach>



				</tbody>
			</table>
		</div>
	</div>
	<script src="${contextPath}/resources/js/jquery-3.2.1.min.js"
		type="text/javascript"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="${contextPath}/resources/js/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script src="${contextPath}/resources/js/dataTables.bootstrap.min.js"
		type="text/javascript"></script>
	<script src="${contextPath}/resources/js/dataTables.buttons.min.js"
		type="text/javascript"></script>
	<script src="${contextPath}/resources/js/buttons.bootstrap.min.js"
		type="text/javascript"></script>
	<script src="${contextPath}/resources/js/jszip.min.js"
		type="text/javascript"></script>
	<script src="${contextPath}/resources/js/pdfmake.min.js"
		type="text/javascript"></script>
	<script src="${contextPath}/resources/js/vfs_fonts.js"
		type="text/javascript"></script>
	<script src="${contextPath}/resources/js/buttons.html5.min.js"
		type="text/javascript"></script>
	<script src="${contextPath}/resources/js/buttons.colVis.min.js"
		type="text/javascript"></script>
	<script>
	  $(document).ready(function () {
          $('#user_list').DataTable({
              dom: "<'row'<'col-sm-6 col-sm-offset-3 text-center 'B>>" +
              "<'row'<'col-sm-6'l><'col-sm-6'f>>" +
              "<'row'<'col-sm-12'tr>>" +
              "<'row'<'col-sm-5'i><'col-sm-7'p>>",
              language: {
                  url: '${contextPath}/resources/json/datatable_polish.json'
              },
             buttons: [
                  {
                      extend: 'excelHtml5', className: 'btn-primary', exportOptions: {
                      columns: ':visible(:not(.not-export-col))'
                  }
                  },
                  {
                      extend: 'pdfHtml5', className: 'btn-primary', exportOptions: {
                      columns: ':visible(:not(.not-export-col))'
                  }
                  },
                  {extend: 'colvis', className: 'btn-primary'}
              ],
              columnDefs: [
                  {"orderable": false, "targets": 5}
              ],
          });
      });

	</script>
</body>
</html>