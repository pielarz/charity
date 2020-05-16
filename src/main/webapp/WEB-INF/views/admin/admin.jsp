<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/foundations.css">
    <title>Panel Admininstratora</title>
</head>
<body>
<div>
    <h3>
        WITAJ <c:out value="${admin}"/>
    </h3>
    <header>
        <nav>
            <a href="/admin/admins" id="navi">ADMINISTRATORZY</a>
            <a href="/admin/foundations" id="navi">INSTYTUCJE</a>
            <a href="/admin/users" id="navi">UŻYTKOWNICY</a>
            <a href="/logout" id="navi">WYLOGUJ</a>
        </nav>
    </header>
</div>
</body>
</html>
