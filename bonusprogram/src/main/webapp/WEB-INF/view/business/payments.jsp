<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="secure" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Payments</title>

    <link href="<spring:url value="/static/css/main.css"/>" rel="stylesheet"/>
</head>
<body>
<a type="submit" href="<spring:url value="/business/account"/>" ><<</a>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Оплаченная сумма</th>
            <th>Добавленный бонус</th>
            <th>Списанный бонус</th>
            <th>Номер телефона</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${transactions}" var="t">
        <tr>
            <td>${t.id}</td>
            <td>${t.finalSum}</td>
            <td>${t.addedBonus}</td>
            <td>${t.chargedBonus}</td>
            <td>${t.user.phone}</td>
        </tr>
        </c:forEach>
        <tbody>
    </table>
</div>

</body>
</html>
