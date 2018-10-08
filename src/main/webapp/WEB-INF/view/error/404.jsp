<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CRUD Employees - 404 Not Found</title>
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/webjars/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/style.css">
</head>
<body>
	<div class="container">
		<div class="content mt-3">
			<div class="card mt-5 p-5" id="user-form">
				<h2 class="text-center mb-3">404</h2>
				<p class="text-center">It appears you're looking for something that does not exist... Head over to the login or home page.</p>
				<a href="${ pageContext.request.contextPath }/auth/login" class="btn btn-primary mt-3">&laquo; Login</a>
			</div>
		</div>
	</div>
</body>
</html>