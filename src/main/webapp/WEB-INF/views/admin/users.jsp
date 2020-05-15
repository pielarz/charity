<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Foundations</title>
    <link rel="stylesheet" href="/resources/css/foundations.css">
</head>
<body>
<header>
    <nav>
        <a href="/admin" id="navi">POWRÓT</a>
    </nav>
</header>
<table>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.username}"/></td>
            <td id="edit"><a href="/admin/users/form?id=${institution.id}">Edytuj</a></td>
            <td id="delete"><a href="/admin/users/delete?id=${institution.id}">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
