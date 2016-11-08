<%@page import="java.util.Date"%>
<%@include file="/WEB-INF/views/jspf/taglib.jspf"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login page</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
</head>
<body>
	<%@include file="/WEB-INF/views/jspf/header.jspf"%>
	<div class="container">
		<div class="row">
			<div class="col-xs-4"></div>
			<div class="col-xs-4">
				<c:if test="${not empty message}">
					<div class="alert alert-danger" role="alert">${message}</div>
				</c:if>
				<form:form method="POST" action="login" commandName="owner"
					class="form-signin">
					<h2 class="form-signin-heading">Please sign in</h2>
					<form:input path="login" value="iwannikowa" class="form-control"
						placeholder="Email address" />
					<form:errors class="text-danger" path="login"></form:errors>
					<form:password path="password" value="iwannikowa"
						class="form-control" placeholder="Password" />
					<form:errors class="text-danger" path="password"></form:errors>
					<input class="btn btn-lg btn-primary btn-block" type="submit"
						value="Sign in">
				</form:form>
			</div>
			<div class="col-xs-4"></div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
