<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Home page</title>
</head>
<body>
<h1>Home page</h1>

<div>
    <sec:authorize access="isFullyAuthenticated()">
        Fully Authenticated
    </sec:authorize>
</div>
<div>
    <sec:authorize access="isAuthenticated()">
        Authenticated (rather than FullyAuthenticated)
    </sec:authorize>
</div>

<p>
    This is Home page. It's available for all users.<br/> <a
        href="${pageContext.request.contextPath}/mail/index.html">User
    page</a><br/> <a
        href="${pageContext.request.contextPath}/admin/first.html">First
    Admin page</a><br/> <a
        href="${pageContext.request.contextPath}/admin/second.html">Second
    Admin page</a><br/> <a
        href="${pageContext.request.contextPath}/registrationform.html">Register</a><br/>

</p>
</body>
</html>