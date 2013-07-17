<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@page import="ru.t_systems.demail.controllers.URL" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link
            href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"
            rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/application.css"
          rel="stylesheet" type="text/css"/>
    <title>User page</title>
    <style>
        .center {
            align: center;
        }
    </style>

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


                    <li
                            class="<c:if test="${param.box == null}"><c:out value="active"/></c:if>"><a
                            href="<%=request.getAttribute("javax.servlet.forward.request_uri")%>">Input</a></li>

                    <li
                            class="<c:if test="${param.box == 'output'}"><c:out value="active"/></c:if>"><a
                            href="?box=<%=URL.MAILBOXOUTPUT%>">Output</a></li>
                    <li
                            class="<c:if test="${param.box == 'spam'}"><c:out value="active"/></c:if>"><a
                            href="?box=<%=URL.MAILBOXSPAM%>">Spam</a></li>
                    <li
                            class="<c:if test="${param.box == 'trash'}"><c:out value="active"/></c:if>"><a
                            href="?box=<%=URL.MAILBOXTRASH%>">Trash</a></li>
                    <hr></hr>
                    <c:forEach var="label" items="${labels}">

                        <li
                                class="<c:if test="${param.box == label.id}"><c:out value="active"/></c:if>"><a
                                href="?box=${label.id}">${label.name}</a></li>
                    </c:forEach>

                </ul>
            </div>
            <div class="span10">

                <table class="table table-condensed table-hover">
                    <thead>
                    <tr>
                        <th class="span1"><input type="checkbox"/></th>
                        <th class="span1"></th>
                        <th class="span2"></th>
                        <th class="span4"></th>
                        <th class="span1"></th>
                        <th class="span2"><select class="span12 label pull-right"
                                                  name="accounts"
                                                  onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
                            <option
                                    value="${pageContext.request.contextPath}<%= URL.MAILBOX %>">All
                            </option>
                            <c:forEach var="account" items="${accounts}">
                                <c:set var="selected" scope="page" value=""/>
                                <c:if test="${account.id == selectAccount}">
                                    <c:set var="selected" scope="page" value="selected"/>
                                </c:if>
                                <option
                                        value="${pageContext.request.contextPath}<%= URL.MAILBOX %>/${account.id}?${pageContext.request.queryString}"
                                    ${selected}>${account.accountName}</option>
                            </c:forEach>
                        </select></th>
                        <th class="span1"></th>
                    </tr>
                    </thead>
                    <!--  <button class="btn btn-mini">New Message</button>-->

                    <tbody>
                    <c:forEach var="status" items="${status}">
                        <tr>
                            <td><input type="checkbox"/> <a href="#"><i
                                    class="icon-star-empty"></i></a></td>
                            <td><c:choose>
                                <c:when test="${status.isRead==true}">
                                    <c:set var="isRead" scope="page" value="icon-eye-open"/>
                                </c:when>
                                <c:when test="${status.isRead==false}">
                                    <c:set var="isRead" scope="page" value="icon-envelope"/>
                                </c:when>
                            </c:choose><i class="${isRead}"></i></td>
                            <td>
                                <small><c:choose>
                                    <c:when
                                            test="${fn:length(status.acountsSender.accountName)>18}">
                                        ${fn:substring(status.acountsSender.accountName, 0, 12)}...
                                    </c:when>
                                    <c:when
                                            test="${fn:length(status.acountsSender.accountName)<=18}">
                                        ${status.acountsSender.accountName}
                                    </c:when>
                                </c:choose>

                                </small>
                            </td>
                            <td class="span4"><a class="span12"
                                                 href="${pageContext.request.contextPath}<%= URL.OPENMAIL %>?id=${status.id}">
                                <small>${fn:substring(status.message.title,
                                        0, 20)}</small>
                            </a></td>
                            <td class="span1">${status.timeStamp}</td>
                            <td class="span2"><a class="label"
                                                 href="${pageContext.request.contextPath}<%= URL.MAILBOX %>?box=${status.label.id}">${status.label.name}</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>


</body>
</html>