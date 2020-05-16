<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admins list</title>
    <link rel="stylesheet" href="/resources/css/foundations.css">
</head>
<body>
<header>
    <nav>
        <a href="/admin" id="navi">POWRÓT</a>
    </nav>
</header>
<table>
    <c:forEach items="${admins}" var="admin">
        <tr>
            <td class="users">Użytkownik: <c:out value="${admin.username}"/></td>
            <td id="demote"><a href="/admin/users/changeRole?id=${admin.id}">Zdegraduj admina</a></td>
            <td id="edit"><a href="/user/users/form?id=${admin.id}">Edytuj</a></td>
            <td id="delete" colspan="2"><a href="/admin/users/delete?id=${admin.id}">Usuń</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
