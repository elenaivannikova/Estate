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
					<div class="alert alert-warning" role="alert">${message}</div>
				</c:if>
				<form:form method="POST" action="success" commandName="viewing"
					class="form-signin">
					<h4 class="form-signin-heading">Enter your contact
						information:</h4>

					<form:input path="firstname" value="Elena" class="form-control"
						placeholder="First name" />
					<form:errors class="text-danger" path="firstname"></form:errors>
					<form:input path="lastname" value="Ivannikova" class="form-control"
						placeholder="Last name" />
					<form:errors class="text-danger" path="lastname"></form:errors>
					<form:input type="tel" value="+380638546588" path="phone"
						class="form-control" placeholder="Phone number" />
					<form:errors class="text-danger" path="phone"></form:errors>
					<h4 class="form-signin-heading">Specify date and time of the
						review:</h4>

					<form:input type="date" name="datetime" path="datetime"
						class="form-control"
						value='<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>'
						placeholder="Date" />
					<form:input type="time" name="time" path="time"
						class="form-control" value="09:00" />
					<form:input path="id" type="hidden" value="${id}" />

					<%-- <form:errors path="password"></form:errors> --%>
					<input class="btn btn-lg btn-primary btn-block" type="submit"
						value="Sign up">

				</form:form>
			</div>
			<div class="col-xs-4"></div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
