<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
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
            <td class="users">Użytkownik: <c:out value="${user.username}"/></td>
            <td class="users" id="elem">Aktywny: <c:out value="${user.enabled}"/></td>
            <td class="users" id="block"><a href="/admin/users/block?id=${user.id}">Zablokuj/Odblokuj</a></td>
        </tr>
        <tr>
            <td id="edit"><a href="/user/users/form?id=${user.id}">Edytuj</a></td>
            <td id="delete"><a href="/admin/users/delete?id=${user.id}">Usuń</a></td>
            <td id="promote"><a href="/admin/users/changeRole?id=${user.id}">Mianuj adminem</a></td>
        </tr>
    </c:forEach>
</table>
<script src="<c:url value="/resources/js/admin.js"/>"></script>
</body>
</html>
