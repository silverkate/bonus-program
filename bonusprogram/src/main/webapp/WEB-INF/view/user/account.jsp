<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="secure" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Account User</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="<spring:url value="/static/css/main.css"/>" rel="stylesheet"/>
</head>
<body>
<div>
    <form action="<spring:url value="/logout"/>" method="POST">
        <div>
            <button type="submit" href="<spring:url value="/logout"/>" >Выйти</button>
            <secure:csrfInput/>
        </div>
    </form>
</div>
<div>
    <h4>Добро пожаловать, ${firstName}</h4>
    <h4>Бонусы ${bonus}</h4>
</div>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>Дата</th>
            <th>Сумма</th>
            <th>Добавленный бонус</th>
            <th>Списанный бонус</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${transactions}" var="t">
            <tr>
                <td>${t.date}</td>
                <td>${t.finalSum}</td>
                <td>${t.addedBonus}</td>
                <td>${t.chargedBonus}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
