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
				<!-- commandName="viewing" -->
				<form id="showViewingsForm" method="POST" class="form-signin">
					<h2 class="form-signin-heading">Choose the date:</h2>
					<input type="date" name="datetime" value='<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>' id="datetime"
						class="form-control" />
					<%-- <form:errors path="date"></form:errors> --%>
					<input id="showViewings" class="btn btn-lg btn-primary btn-block"
						type="submit" value="Show">
				</form>
			</div>
			<br />
			<div class="col-xs-4"></div>
		</div>
		<br />
		<div class="row">
			<div class="col-xs-2"></div>
			<div class="col-xs-8">
				<table id="ajaxResponse" class="table table-hover table-striped">
				</table>
			</div>
			<div class="col-xs-2"></div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
