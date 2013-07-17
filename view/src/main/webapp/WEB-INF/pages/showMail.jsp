<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="ru.t_systems.demail.controllers.URL"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/application.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/datepicker/css/datepicker.css"
	rel="stylesheet" type="text/css" />

<script
	src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.min.js"></script>

<script
	src="${pageContext.request.contextPath}/datepicker/js/bootstrap-datepicker.js"></script>

<script
	src="${pageContext.request.contextPath}/datepicker/js/prettify.js"></script>

<script
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>

<!-- Redactor is here -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/redactor/redactor.css" />
<script
	src="${pageContext.request.contextPath}/redactor/redactor.min.js"></script>

<script type="text/javascript">
	$(function() {
		$('#redactor_content').redactor({
			focus : true,
			toolbarFixed : true,
			autoresize : false,
			linebreaks : true,
			css : '/redactor/redactor-iframe.css'
		});
	});
</script>


<title>Insert title here</title>


</head>
<body>
	<div class="header-bar">

		<div class="container-fluid">
			<div class="header content clearfix">
				<a href="<c:url value="/j_spring_security_logout" />"
					id="createNewAccount" class="btn btn-custom-lighten">Logout</a>


			</div>
		</div>
	</div>
	<div class="main-content">
		<div class="container-fluid">
			<div class="row-fluid">

				<div class="span2">
					<a class="btn btn-mini"
						href="${pageContext.request.contextPath}<%= URL.NEWMAIL %>">New
						Message</a>

					<ul class="nav nav-pills nav-stacked">


						<li><a
							href="${pageContext.request.contextPath}<%=URL.MAILBOX%>">Input</a></li>

						<li><a href="${pageContext.request.contextPath}<%=URL.MAILBOX%>?box=<%=URL.MAILBOXOUTPUT%>">Output</a></li>
						<li><a href="${pageContext.request.contextPath}<%=URL.MAILBOX%>?box=<%=URL.MAILBOXSPAM%>">Spam</a></li>
						<li><a href="${pageContext.request.contextPath}<%=URL.MAILBOX%>?box=<%=URL.MAILBOXTRASH%>">Trash</a></li>
					</ul>


				</div>
				<div class="span10">

					<div>
						<h4>${status.message.title}</h4>
						<form:form method="Post" commandName="newMail">
					</div>

					<div class="span12"></div>


<div class="input-prepend">
					<button class="btn" name="submitButton" type="submit" title="Reply"
						value="Reply">
						<i class="icon-share-alt"></i> Reply
					</button>
					<button class="btn" name="submitButton" type="submit"
						title="Delete" value="Delete">
						<i class="icon-trash"></i> Delete
					</button>
					<button class="btn" name="submitButton" type="submit"
						title="Forward" value="Forward">
						<i class="icon-random"></i> Forward
					</button>
					<button class="btn" name="submitButton" type="submit" title="Spam"
						value="Spam">
						<i class="icon-fire"></i> Spam
					</button>
					
					
						<button class="btn" name="submitButton" type="submit"
							title="To folder" value="ToFolder">
							<i class="icon-folder-open"></i>
							Move to folder</button>
						<form:select path="label">
							<form:option value="NONE" label=""/>
							<form:options items="${labels}" itemValue="id" itemLabel="name" />
						</form:select>

					</div>


					<div class="span12"></div>


					<div>
						<small>From: <strong>${status.acountsSender.user.firstName}
								${status.acountsSender.user.lastName}</strong> &lt;
							${status.acountsSender.accountName} &gt;;
						</small>
					</div>


					<div>
						<small>To: <c:forEach var="mail" items="${mailList}">
								<em>${mail.account.user.firstName}
									${mail.account.user.lastName}</em> &lt; ${mail.account.accountName}
                            &gt;;
                        </c:forEach>

						</small>
					</div>
					<hr></hr>
					<p>${status.message.body}</p>
					<hr></hr>


					<form:textarea id="redactor_content" style="height: 200px;"
						path="bodyFast" />

					<form:errors path="bodyFast" />


					<div class="row-fluid">

						<div class="control-group">
							<div class="controls">
								<input class="btn btn-success" name="submitButton" type="submit"
									value="FastReply" />

							</div>
						</div>
					</div>

					</form:form>
				</div>

			</div>
		</div>

	</div>


	<a href="${pageContext.request.contextPath}/index.html">Home page</a>
</body>
</html>