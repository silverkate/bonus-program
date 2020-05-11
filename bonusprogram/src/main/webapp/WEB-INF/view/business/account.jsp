<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="secure" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Account Business</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="<spring:url value="/static/css/main.css"/>" rel="stylesheet"/>
</head>
<body>
<form action="<spring:url value="/logout"/>" method="POST">
    <div>
        <button type="submit" href="<spring:url value="/logout"/>" >Log Out</button>
        <secure:csrfInput/>
    </div>
</form>
<div>
    Добро пожаловать!
</div>
<div>
    <a href="<spring:url value="/business/payments"/>">Платежи</a>
    <a href="<spring:url value="/business/addTransaction"/>">Добавить операцию</a>
    <a href="<spring:url value="/business/users"/>">Участники</a>
</div>
<div>
    Инфо.
</div>
</body>
</html>
