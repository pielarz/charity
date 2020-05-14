<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Foundations</title>
</head>
<body>
<table border="1">
    <h3>
        <a href="/admin/foundations/form">DODAJ</a>
    </h3>
    <ul>
    <c:forEach items="${institutions}" var="institution">
        <div>
        ID: <c:out value="${institution.id}"/><br/>
        Nazwa: <c:out value="${institution.name}"/><br/>
        <a href="/admin/foundations/form?id=${institution.id}">Edytuj</a>
        <a href="/admin/foundations/delete?id=${institution.id}">Usuń</a>
        </div>
    </hr>
    </c:forEach>
    </ul>
</table>
</body>
</html>
