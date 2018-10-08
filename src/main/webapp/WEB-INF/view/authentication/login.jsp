<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CRUD Employees - Login</title>
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/webjars/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/style.css">
</head>
<body>
	<div class="container">
		<div class="content mt-3">
			<form:form action="${ pageContext.request.contextPath }/auth/login" method="POST" class="card mt-5 p-5" id="user-form">
				<h2 class="text-center mb-3">Login</h2>
				<core:if test="${ param.error != null }">
					<div class="alert alert-danger text-center">Wrong username and/or password</div>
				</core:if>
				<core:if test="${ param.logout != null }">
					<div class="alert alert-success text-center">You have been logged out</div>
				</core:if>
				<div class="form-row mb-1 mt-1">
					<label for="username">Username</label>
					<input type="text" name="username" id="username" class="form-control">
				</div>
				<div class="form-row mb-1 mt-1">
					<label for="password">Password</label>
					<input type="password" name="password" id="password" class="form-control">
				</div>
				<div class="form-row mt-3">
					<a href="${ pageContext.request.contextPath }/auth/register" class="btn btn-primary col mr-2">Register</a>
					<input type="submit" value="Login" class="btn btn-success col ml-2">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>