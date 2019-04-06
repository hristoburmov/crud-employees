<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CRUD Employees - Form</title>
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
				<li class="nav-item"><a class="nav-link active" href="${ pageContext.request.contextPath }/employees/list">Employees</a></li>
				<li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/positions/list">Positions</a></li>
				<li class="nav-item"><a class="nav-link" href="${ pageContext.request.contextPath }/offices/list">Offices</a></li>
			</ul>
			<div class="clearfix mt-5">
				<h2 class="float-left">Employee Form</h2>
				<a class="btn btn-danger float-right" href="${ pageContext.request.contextPath }/employees/list" role="button">Back</a>
			</div>
		</header>
		<div class="content mt-3">
			<form:form action="${ pageContext.request.contextPath }/employees/save" method="POST" modelAttribute="employee">
				<core:set var="errors">
					<form:errors path="firstName" element="p" cssClass="mb-0" />
					<form:errors path="lastName" element="p" cssClass="mb-0" />
					<form:errors path="email" element="p" cssClass="mb-0" />
					<form:errors path="position.id" element="p" cssClass="mb-0" />
					<form:errors path="office.id" element="p" cssClass="mb-0" />
					<form:errors path="salary" element="p" cssClass="mb-0" />
				</core:set>
				<core:if test="${ not empty errors }">
					<div class="alert alert-danger text-center">
						${ errors }
					</div>
				</core:if>
				<form:hidden path="id" />
				<div class="form-row">
					<div class="form-group col-xl-4">
						<form:label path="firstName">First Name*</form:label>
						<form:input path="firstName" class="form-control" />
					</div>
					<div class="form-group col-xl-4">
						<form:label path="lastName">Last Name*</form:label>
						<form:input path="lastName" class="form-control" />
					</div>
					<div class="form-group col-xl-4">
						<form:label path="email">Email*</form:label>
						<form:input path="email" class="form-control" />
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-xl-4">
						<form:label path="position.id">Position*</form:label>
						<form:select path="position.id" items="${ positions }" itemLabel="title" itemValue="id" class="custom-select" />
					</div>
					<div class="form-group col-xl-4">
						<form:label path="office.id">Office*</form:label>
						<form:select path="office.id" items="${ offices }" itemLabel="name" itemValue="id" class="custom-select" />
					</div>
					<div class="form-group col-xl-4">
						<form:label path="salary">Salary*</form:label>
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text" id="dollarSign">$</span>
							</div>
							<form:input path="salary" class="form-control" area-describedby="dollarSign" />
						</div>
					</div>
				</div>
				<input type="submit" value="Save" class="btn btn-success float-right">
			</form:form>
		</div>
	</div>
</body>
</html>