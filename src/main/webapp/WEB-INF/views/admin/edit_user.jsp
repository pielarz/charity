<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Editor</title>
</head>
<body>
<form:form modelAttribute="user">
    Nazwa użytkownika: <form:input path="username"></form:input>
    <form:errors path="username"></form:errors><br/>
    Nowe hasło: <form:input path="password" type="password"></form:input>
    <form:errors path="password"></form:errors><br/>
    E-mail: <form:input path="email"></form:input>
    <form:errors path="email"></form:errors><br/>
    Imię: <form:input path="name"></form:input>
    <form:errors path="name"></form:errors><br/>
    Nazwisko: <form:input path="lastName"></form:input>
    <form:errors path="lastName"></form:errors>
    <form:button type="submit">Zatwierdź</form:button>
</form:form>
</body>
</html>
