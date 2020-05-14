<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h3>
        WITAJ <c:out value="${admin}"/>
    </h3>
    <div>
        <h5>
            <a href="/admin/foundations">FUNDACJE</a>
        </h5>
    </div>
</div>
</body>
</html>
