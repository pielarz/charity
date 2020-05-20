<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/style.css" />
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <%@include file="/WEB-INF/views/common/header-user.jsp"%>
</sec:authorize>
<sec:authorize access="isAnonymous()">
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
</sec:authorize>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="user" method="post">
        <div class="form-group">
            <form:input type="text" name="username" path="username" placeholder="Nazwa użytkownika" />
            <form:errors path="username" cssStyle="color: red"></form:errors>
        </div>
        <div class="form-group">
            <form:input type="password" name="password" path="password" placeholder="Hasło" />
            <form:errors path="password" cssStyle="color: red"></form:errors>
        </div>
        <div class="form-group">
            <form:input type="text" name="name" path="name" placeholder="Imię" />
            <form:errors path="name" cssStyle="color: red"></form:errors>
        </div>
        <div class="form-group">
            <form:input type="text" name="lastName" path="lastName" placeholder="Nazwisko" />
            <form:errors path="lastName" cssStyle="color: red"></form:errors>
        </div>
        <div class="form-group">
            <form:input type="email" name="email" path="email" placeholder="Email" />
            <form:errors path="email" cssStyle="color: red"></form:errors>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@include file="/WEB-INF/views/common/footer.jsp"%>
<script src="<c:url value="app.js"/>"></script>
</body>
</html>
