<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@page import="ru.t_systems.demail.controllers.URL" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

    <script>
        $(function () {
            window.prettyPrint && prettyPrint();
            var nowTemp = new Date();
            var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp
                    .getDate(), 0, 0, 0, 0);
            $('#dp3').datepicker({
                endDate: now,
                autoclose: true,
                startView: 2,
                format: 'mm-dd-yyyy'
            });
        });
    </script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <title>Insert title here</title>
</head>
<body>
<div class="header-bar">

    <div class="container-fluid">

        <div class="header content clearfix">
            <span class="help-inline">You have account?</span> <a
                href="${pageContext.request.contextPath}<%= URL.LOGIN %>"
                id="createNewAccount" class="btn btn-custom-lighten">Sign in</a>


        </div>
    </div>
</div>
<div class="main-content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span1"></div>
            <div class="span6">
                <table class="table table-condensed table-hover">
                    <thead>
                    <tr>
                        <th class="span1"><input type="checkbox"></th>
                        <th class="span2"></th>
                        <th class="span2"></th>
                        <th class="span9"></th>
                        <th class="span2"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input type="checkbox"> <a href="#"><i
                                class="icon-star-empty"></i></a></td>
                        <td><strong>John Doe</strong></td>
                        <td><span class="label pull-right">Notifications</span></td>
                        <td><strong>Message body goes here</strong></td>
                        <td><strong>11:23 PM</strong></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"> <a href="#"><i
                                class="icon-star-empty"></i></a></td>
                        <td>John Doe</td>
                        <td><span class="label pull-right">Notifications</span></td>
                        <td>Message body goes here</td>
                        <td>Sept4</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"> <a href="#"><i
                                class="icon-star"></i></a></td>
                        <td><strong>John Doe</strong></td>
                        <td><span class="label pull-right">Notifications</span></td>
                        <td><strong>Message body goes here</strong></td>
                        <td><strong>Sept3</strong></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"> <a href="#"><i
                                class="icon-star"></i></a></td>
                        <td><strong>John Doe</strong></td>
                        <td><span class="label pull-right">Notifications</span></td>
                        <td><strong>Message body goes here</strong></td>
                        <td><strong>Sept3</strong></td>
                    </tr>
                    </tbody>
                </table>

            </div>
            <div class="span3 offset1">
                <form:form method="Post" commandName="registration">
                    <legend>Registration</legend>

                    <div class="container-fluid">
                        <div class="row-fluid">
                            <div class="control-group">


                                <div class="controls">
                                    <label class="control-label">Login</label>


                                    <form:input class="span12" path="login"/>
                                    <form:errors path="login"/>


                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="control-group">
                                <div class="controls controls-row">

                                    <label class="control-label">You name?</label>

                                    <form:input class="span6" path="fistName"
                                                placeholder="Fist name"/>

                                    <form:errors path="fistName"/>

                                    <form:input class="span6" path="lastName"
                                                placeholder="Last Name"/>


                                    <form:errors path="lastName"/>


                                </div>

                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="control-group">
                                <div class="controls">
                                    <div class="controls-row">
                                        <label class="span6" for="dp3">Birth Day</label> <label
                                            class="span6" for="gender">Gender</label>
                                    </div>
                                    <div class="controls-row">
                                        <form:input class="span6" type="text" value="" id="dp3" path="birthDay"/>
                                        <select
                                                class="span6" id="gender">
                                            <option>Male</option>
                                            <option>Female</option>

                                        </select>
                                    </div>


                                </div>
                            </div>
                        </div>

                        <div class="row-fluid">
                            <div class="control-group">
                                <div class="controls">
                                    <label class="control-label">Password</label>
                                    <form:errors path="password"/>


                                    <form:password class="span12" path="password"/>
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="control-group">
                                <div class="controls">
                                    <label class="control-label">Confirm Password</label>

                                    <form:errors path="confirmPassword"/>


                                    <form:password class="span12" path="confirmPassword"/>
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="control-group">


                                <div class="controls">
                                    <label class="control-label">Email</label>
                                    <form:input type="email" class="span12" path="email"/>
                                    <form:errors path="email"/>
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">

                            <div class="control-group">
                                <div class="controls">
                                    <input class="btn btn-success" type="submit" value="Submit"/>
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