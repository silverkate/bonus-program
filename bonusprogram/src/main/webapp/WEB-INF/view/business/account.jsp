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
<body id = "u13">
<form id = "u14" action="<spring:url value="/logout"/>" method="POST">
    <div>
        <button type="submit" href="<spring:url value="/logout"/>" >Выйти</button>
        <secure:csrfInput/>
    </div>
</form>
<h1>
    Добро пожаловать!
</h1>
<div>
    <a href="<spring:url value="/business/payments"/>">Платежи</a>
    <a href="<spring:url value="/business/addTransaction"/>">Добавление</a>
    <a href="<spring:url value="/business/users"/>">Участники</a>
</div>
<div class = "footer">
<div class="plan plan1">
    <div><b>Получение информации</b></div>
    <p>Инструкция как получить информацию о новых зарегистрированных пользователях в акции.</p>
</div>

<div class="plan plan1">
    <div><b>Передача информации</b></div>
    <p>Инструкция как передать транзакции по зарегистрированным участникам.</p>
</div>

<div class="plan plan1">
    <div><b>Редактирование данных</b></div>
    <p>Инструкция как изменить информацию об акции.</p>
</div>


<div class="plan plan1">
    <div><b>Связь с разработчиками</b></div>
    <p>Контантные данные</p>
</div>
</div>
</body>
</html>
