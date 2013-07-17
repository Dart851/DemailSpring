<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@page import="ru.t_systems.demail.controllers.URL" %>
    <link
            href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"
            rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/application.css"
          rel="stylesheet" type="text/css"/>
    <link
            href="${pageContext.request.contextPath}/datepicker/css/datepicker.css"
            rel="stylesheet" type="text/css"/>

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
          href="${pageContext.request.contextPath}/redactor/redactor.css"/>
    <script
            src="${pageContext.request.contextPath}/redactor/redactor.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $('#redactor_content').redactor({
                focus: true,
                toolbarFixed: true,
                autoresize: false,
                linebreaks: true,
                css: '/redactor/redactor-iframe.css'
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
            <div class="span1"></div>
            <div class="span10">


                <form:form method="Post" commandName="newMail">
                    <legend>
                        Create New Mail
                    </legend>

                    <div class="container-fluid">
                        <div class="row-fluid">
                            <div class="control-group">


                                <div class="controls">

                                    <form:select path="accountSender">
                                        <form:options items="${accounts}" itemValue="id"
                                                      itemLabel="accountName"/>
                                    </form:select>

                                    <label class="control-label">Send to</label>


                                    <form:input class="span12" path="accounts"/>
                                    <form:errors path="title"/>


                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">

                            <label class="control-label">Title</label>


                            <form:input class="span12" path="title"/>
                            <form:errors path="title"/>

                            <label class="control-label">Body</label>

                            <form:textarea id="redactor_content" style="height: 200px;"
                                           path="body" class="span12"/>

                            <form:errors path="body"/>


                        </div>

                        <div class="row-fluid">

                            <div class="control-group">
                                <div class="controls">
                                    <input class="btn btn-success" type="submit"
                                           name="submitButton" value="Submit"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
            <div class="span1"></div>
        </div>
    </div>

</div>


<a href="${pageContext.request.contextPath}/index.html">Home page</a>
</body>
</html>