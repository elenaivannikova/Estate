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
			<div class="col-xs-2"></div>
			<div class="col-xs-8" style="text-align: center;">
				<div class="alert alert-success" role="alert">
					<h2>${message}</h2>
				</div>
			</div>
			<div class="col-xs-2"></div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
