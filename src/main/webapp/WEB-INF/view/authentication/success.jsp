<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CRUD Employees - Confirmation</title>
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/webjars/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/style.css">
</head>
<body>
	<div class="container">
		<div class="content mt-3">
			<div class="card mt-5 p-5" id="user-form">
				<h2 class="text-center mb-3">Success</h2>
				<p class="text-center">You have been registered successfully.<br>Use the login page to get in the system.</p>
				<a href="${ pageContext.request.contextPath }/auth/login" class="btn btn-primary mt-3">&laquo; Login</a>
			</div>
		</div>
	</div>
</body>
</html>