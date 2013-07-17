<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>You Account</h2>
<table>
    <tr>
        <form:form method="Post" action="account.html" commandName="account">
        <td>Add new account:<FONT color="red"><form:errors
                path="newaccount"/></FONT></td>

    <tr>
        <td><form:input path="newaccount"/></td>
        <td><input type="submit" value="Submit"/></td>
        </form:form>
    </tr>


    <tr>
        <th>Account Name</th>
    </tr>
    <c:forEach items="${accountList}" var="account">
        <tr>
            <td>${account.accountName}</td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/index.html">Home page</a>

</body>
</html>