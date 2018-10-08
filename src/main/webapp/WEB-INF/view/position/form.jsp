<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CRUD Positions - Form</title>
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
				<li class="nav-item"><a class="nav-link active" href="${ pageContext.request.contextPath }/positions/list">Positions</a></li>
				<li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/offices/list">Offices</a></li>
			</ul>
			<div class="clearfix mt-5">
				<h2 class="float-left">Position Form</h2>
				<a class="btn btn-dark float-right" href="${ pageContext.request.contextPath }/positions/list" role="button">Back to all positions</a>
			</div>
		</header>
		<div class="content mt-3">
			<form:form action="${ pageContext.request.contextPath }/positions/save" method="POST" modelAttribute="position">
				<core:set var="errors">
					<form:errors path="*" class="text-center" />
				</core:set>
				<core:if test="${ not empty errors }">
					<div class="alert alert-danger">
						${ errors }
					</div>
				</core:if>
				<form:hidden path="id" />
				<div class="form-row">
					<div class="form-group col-xl-12">
						<form:label path="title">Title</form:label>
						<form:input path="title" class="form-control" />
					</div>
				</div>
				<input type="submit" value="Save" class="btn btn-success">
			</form:form>
		</div>
	</div>
</body>
</html>