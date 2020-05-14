<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj Instytucje</title>
</head>
<body>
<form:form modelAttribute="institution">
    Nazwa instytucji: <form:input path="name" type="text"></form:input><br/>
    <form:errors path="name"></form:errors><br/>
    Opis instytucji: <form:input path="description" type="textarea"></form:input><br/>
    <form:errors path="description"></form:errors><br/>
    <form:button type="submit">Zatwierdź</form:button><br/>
</form:form>
</body>
</html>
