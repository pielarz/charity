<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="/home" class="btn btn--without-border active">Start</a></li>
            <li><a href="/about" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="/about_us" class="btn btn--without-border">O nas</a></li>
            <li><a href="/foundations" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="/contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
</header>
<section class="login-page">
    <h2>Zaloguj się</h2>
    <form:form method="post" action="/login" modelAttribute="user">
        <div class="form-group">
            <form:input type="text" name="username" path="username" placeholder="Username" />
            <form:errors path="username" cssStyle="color: red"/>
        </div>
        <div class="form-group">
            <form:input type="password" name="password" path="password" placeholder="Hasło" />
            <form:errors path="password" cssStyle="color: red"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="#" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form:form>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp"%>
<c:url value="/resources/js/app.js"/>
</body>
</html>