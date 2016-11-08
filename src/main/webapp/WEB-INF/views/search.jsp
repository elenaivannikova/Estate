<%@include file="/WEB-INF/views/jspf/taglib.jspf"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login page</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">

<script src="resources/js/jquery-3.1.1.js"></script>
<script src="resources/js/script.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/jspf/header.jspf"%>
	<div class="container">
		<div class="row">
			<div class="col-xs-4"></div>
			<div class="col-xs-4">
				<form:form id="searchForm" method="POST" action="login"
					commandName="searchDTO" class="form-signin">
					<h2 class="form-signin-heading">Search parameters:</h2>
					<form:input path="address" class="form-control"
						placeholder="Address" />
					<form:select class="form-control" path="type">
						<form:option value="room"></form:option>
						<form:option value="flat"></form:option>
						<form:option value="house"></form:option>
					</form:select>
					<form:select class="form-control" path="minSquare">
						<c:forEach var="i" begin="10" end="150" step="10">
							<form:option value="${i}" />
						</c:forEach>
					</form:select>
					<form:select class="form-control" path="maxSquare">
						<c:forEach var="i" begin="150" end="1000" step="10">
							<form:option value="${i}" />
						</c:forEach>
					</form:select>
					<%-- <form:errors path="password"></form:errors> --%>
					<input class="btn btn-lg btn-primary btn-block" type="submit"
						value="Search">
				</form:form>
			</div>
			<div class="col-xs-4"></div>
		</div>
		<br />
		<div class="row">
			<div class="col-xs-3"></div>
			<div class="col-xs-6">
				<table id="ajaxResponse" class="table table-hover table-striped">
				</table>
			</div>
			<div class="col-xs-3"></div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
