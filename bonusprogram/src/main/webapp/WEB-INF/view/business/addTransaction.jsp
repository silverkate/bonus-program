<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="secure" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %><html>
<head>
    <title>Добавление транзакции</title>

    <link href="<spring:url value="/static/css/main.css"/>" rel="stylesheet"/>
</head>
<body id = "u12">
<a type="submit" href="<spring:url value="/business/account"/>" ><<</a>
<form action="<spring:url value="addTransaction"/>" method="POST">
    <div>
        <h1>Добавить транзакцию</h1>
        <h4>${state}</h4>
        <div>
            <input name="phone" placeholder="Клиентский номер телефона" required />
        </div>
        <div>
            <input id= "dirty_sum" name="dirty_sum" placeholder="Изначальная сумма" required />
        </div>
        <div>
            <label for = "bonus_ch">Списать бонусы <input type = "checkbox" id = "bonus_ch" class = "container" name = "bonus_ch"/></label>
        </div>

        <sec:csrfInput/>
        <button type="submit" href="<spring:url value="addTransaction"/>">Добавить</button>
    </div>

    <div>
        <h4>${bonus}</h4>
        <h4>${fin_sum}</h4>
    </div>
</form>
</body>
</html>
