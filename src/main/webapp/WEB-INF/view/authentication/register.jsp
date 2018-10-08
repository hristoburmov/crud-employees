<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CRUD Employees - Register</title>
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/webjars/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/style.css">
</head>
<body>
	<div class="container">
		<div class="content mt-3">
			<form:form action="${ pageContext.request.contextPath }/auth/register" method="POST" modelAttribute="user" class="card mt-5 p-5" id="user-form">
				<h2 class="text-center mb-3">Register</h2>
				<core:set var="errors">
					<form:errors path="*" class="text-center" />
				</core:set>
				<core:if test="${ not empty errors }">
					<div class="alert alert-danger text-center">
						${ errors }
					</div>
				</core:if>
				<div class="form-row mb-1 mt-1">
					<form:label path="username">Username</form:label>
					<form:input path="username" class="form-control" />
				</div>
				<div class="form-row mb-1 mt-1">
					<form:label path="password">Password</form:label>
					<form:password path="password" class="form-control" />
				</div>
				<div class="form-row mt-3">
					<a href="${ pageContext.request.contextPath }/auth/login" class="btn btn-primary col mr-2">&laquo; Login</a>
					<input type="submit" value="Register" class="btn btn-success col ml-2">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>