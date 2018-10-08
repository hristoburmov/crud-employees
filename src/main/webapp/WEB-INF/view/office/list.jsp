<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CRUD Offices - List</title>
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/webjars/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/style.css">
</head>
<body>
	<div id="top">
		<div class="container clearfix">
			<div class="float-left">
				<span class="btn btn-light">Username: <em><security:authentication property="principal.username" /></em></span>
			</div>
			<div class="float-right">
				<form:form action="${ pageContext.request.contextPath }/logout" method="POST">
					<input type="submit" value="Logout" class="btn btn-danger" />
				</form:form>
			</div>
		</div>
	</div>
	<div class="container">
		<header>
			<ul class="nav nav-pills nav-fill mt-5">
				<li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/employees/list">Employees</a></li>
				<li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/positions/list">Positions</a></li>
				<li class="nav-item"><a class="nav-link active" href="${ pageContext.request.contextPath }/offices/list">Offices</a></li>
			</ul>
			<div class="clearfix mt-5">
				<h2 class="float-left">Offices</h2>
				<a class="btn btn-dark float-right" href="${ pageContext.request.contextPath }/offices/add" role="button">Add office</a>
			</div>
		</header>
		<div class="content mt-3">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<th>Name</th>
					<th>Post Code</th>
					<th>Location</th>
					<th class="text-center">Actions</th>
				</thead>
				<tbody>
					<core:forEach var="office" items="${ offices }">
						<tr>
							<td class="align-middle">${ office.name }</td>
							<td class="align-middle">${ office.postCode }</td>
							<td class="align-middle">${ office.location }</td>
							<td class="align-middle text-center">
								<a class="btn btn-info" href="${ pageContext.request.contextPath }/offices/update?id=${ office.id }" role="button">Update</a>
								<a class="btn btn-danger" href="${ pageContext.request.contextPath }/offices/delete?id=${ office.id }" role="button" onclick="if(!confirm('Are you sure you want to delete this office?')) return false;">Delete</a>
							</td>
						</tr>
					</core:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>