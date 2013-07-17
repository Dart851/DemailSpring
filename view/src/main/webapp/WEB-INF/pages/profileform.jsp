<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form:form method="Post" action="profile.html" commandName="profile">
    <table>
        <tbody>
        <tr>
            <td>Current Password:<FONT color="red">
                <form:errors
                        path="oldPassword"/></FONT>
            </td>

        </tr>
        <tr>
            <td><form:password path="oldPassword"/></td>
        </tr>

        <tr>
            <td>Password:<FONT color="red"><form:errors
                    path="password"/></FONT></td>

        </tr>
        <tr>
            <td><form:password path="password"/></td>
        </tr>

        <tr>
            <td>Confirm Password:<FONT color="red"><form:errors
                    path="confirmPassword"/></FONT></td>

        </tr>
        <tr>
            <td><form:password path="confirmPassword"/></td>
        </tr>

        <tr>
            <td>firstName:<FONT color="red"><form:errors
                    path="firstName"/></FONT></td>

        </tr>
        <tr>
            <td><form:input path="firstName"/></td>
        </tr>

        <tr>
            <td>lastName:<FONT color="red"><form:errors
                    path="lastName"/></FONT></td>

        </tr>
        <tr>
            <td><form:input path="lastName"/></td>
        </tr>

        <tr>
            <td>Country:<FONT color="red"><form:errors
                    path="country"/></FONT></td>

        </tr>
        <tr>
            <td><form:select path="country">
                <form:options items="${countryList}" itemValue="id"
                              itemLabel="country"/>
            </form:select></td>

        </tr>

        <tr>
            <td>Email:<FONT color="red"><form:errors path="email"/></FONT></td>

        </tr>
        <tr>
            <td><form:input path="email"/></td>

            <td><input type="submit" value="Submit"/></td>
        </tr>
        </tbody>
    </table>
</form:form>
<a href="${pageContext.request.contextPath}/index.html">Home page</a>

</body>
</html>