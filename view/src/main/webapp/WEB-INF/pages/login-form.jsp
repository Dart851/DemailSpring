<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@page import="ru.t_systems.demail.controllers.URL" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login page</title>
    <link
            href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"
            rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/application.css"
          rel="stylesheet" type="text/css"/>

    <script
            src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.2.min.js"></script>

    <script
            src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <script>
        $(document).ready(function () {
            $('.carousel').carousel({
                interval: 8000
            });
        });
    </script>
    <style>
    </style>
</head>

<c:choose>
    <c:when test="${error_login == null}">
        <c:set var="errorText" scope="page" value="Input login and password"/>
        <c:set var="errorStyle" scope="page" value="control-group"/>
    </c:when>

    <c:when test="${error_login == true}">
        <c:set var="errorText" scope="page"
               value="Incorrect login or password"/>
        <c:set var="errorStyle" scope="page" value="control-group error"/>
    </c:when>
</c:choose>


<body>

<div class="header-bar">

    <div class="container-fluid">

        <div class="header content clearfix">
            <span class="help-inline">New to Demail?</span> <a
                href="${pageContext.request.contextPath}<%= URL.REGISTRATION %>"
                id="createNewAccount" class="btn btn-custom-lighten">Sign up</a>


        </div>
    </div>
</div>
<div class="main-content">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span1"></div>
            <div class="span6">
                <div class="bs-docs-example">
                    <div id="myCarousel" class="carousel slide">
                        <div class="carousel-inner">
                            <div class="item active">
                                <img
                                        src="${pageContext.request.contextPath}/img/420x297_DeMail-Motive-8-1343x950.jpg"
                                        alt=""/>

                                <div class="carousel-caption">
                                    <h4>First Thumbnail label</h4>

                                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget
                                        quam. Donec id elit non mi porta gravida at eget metus.
                                        Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                </div>
                            </div>
                            <div class="item">
                                <img
                                        src="${pageContext.request.contextPath}/img/420x297_DeMail-Motive-7-1343x950.jpg"
                                        alt=""/>

                                <div class="carousel-caption">
                                    <h4>Second Thumbnail label</h4>

                                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget
                                        quam. Donec id elit non mi porta gravida at eget metus.
                                        Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                </div>
                            </div>
                            <div class="item">
                                <img
                                        src="${pageContext.request.contextPath}/img/420x297_DeMail-Motive-5-1343x950.jpg"
                                        alt=""/>

                                <div class="carousel-caption">
                                    <h4>Second Thumbnail label</h4>

                                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget
                                        quam. Donec id elit non mi porta gravida at eget metus.
                                        Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                </div>
                            </div>
                            <div class="item">
                                <img
                                        src="${pageContext.request.contextPath}/img/420x297_DeMail-Motive-4-1343x950.jpg"
                                        alt=""/>

                                <div class="carousel-caption">
                                    <h4>Third Thumbnail label</h4>

                                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget
                                        quam. Donec id elit non mi porta gravida at eget metus.
                                        Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                </div>
                            </div>
                        </div>
                        <a class="left carousel-control" href="#myCarousel"
                           data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
                                                             href="#myCarousel" data-slide="next">&rsaquo;</a>
                    </div>
                </div>
            </div>
            <div class="span3 offset1">
                <form class="form" method="post"
                      action="<c:url value='j_spring_security_check'/>">

                    <legend>Login page</legend>


                    <div class="container-fluid">
                        <div class="row-fluid">
                            <div class="control-group">

                                <div class="controls">
                                    <label class="control-label">Login</label>

                                    <div class="input-prepend span12">
                                        <span class="add-on"><i class="icon-user"></i></span> <input
                                            type="text" class="span12" name="j_username" id="j_username"
                                            placeholder="Login"/>

                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row-fluid">
                            <div class="${errorStyle}">

                                <div class="controls">
                                    <label class="control-label" for="inputPassword">Password</label>

                                    <div class="input-prepend span12">
                                        <span class="add-on"><i class="icon-lock"></i></span> <input
                                            class="span12" type="password" name="j_password"
                                            id="j_password" placeholder="Password"/>
                                    </div>
                                    <span class="help-block">${errorText}</span>
                                </div>

                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="control-group">
                                <div class="controls">
                                    <label class="checkbox"> <input type="checkbox"
                                                                    id="j_remember"
                                                                    name="_spring_security_remember_me"/>
                                        Remember me
                                    </label>

                                    <button type="submit" class="btn btn-primary">Sign in</button>
                                </div>
                            </div>

                        </div>
                    </div>
                </form>
            </div>
            <div class="span1"></div>
        </div>
    </div>
</div>


</body>
</html>