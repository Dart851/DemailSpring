<html>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <link
            href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"
            rel="stylesheet" type="text/css"/>
    <title>Home page</title>
</head>
<body>
<h1>Install</h1>

<h2>Install complete!</h2>
<table class="span12">
    <tbody>
    <%
        String m[][] = {
                {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
                {"Aa", "Bb", "Cc", "Dd", "Ee", "Ff", "Gg", "Hh", "Ii",
                        "Jj"},
                {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
                {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
                {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
                {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
                {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
                {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
                {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
                {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},};

        for (int i = 0; i < m.length; i++) {
            //	int k = (i % 2 != 0) ? 9 : 0;
    %>
    <tr>
        <%
            for (int ii = 0; ii < m[i].length; ii++) {
                int column = (i % 2 != 0) ? (ii - 9) * (-1) : ii;
        %>
        <td>
            <%
                out.println(i + ";" + column + " <strong>" + m[i][column]
                        + "</strong>");
            %>

        </td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
    </tbody>
</table>


</body>
</html>