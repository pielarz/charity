<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/foundations.css">
    <title>Panel Użytkownika</title>
</head>
<body>
<div>
    <h3>
        WITAJ <c:out value="${user}"/>
    </h3>
    <header>
        <nav>
            <a href="/user/users/form?id=${currentUserId}" id="navi">EDYTUJ PROFIL</a>
            <a href="/user/donation/add" id="navi">ODDAJ RZECZY</a>
            <a href="/home" id="navi">STRONA GŁÓWNA</a>
            <a href="/logout" id="navi">WYLOGUJ</a>
        </nav>
    </header>
</div>
</body>
</html>