<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="secure" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>User Register</title>

    <link href="<spring:url value="/static/css/main.css"/>" rel="stylesheet"/>
</head>
<body id = "u11">
<form action="<spring:url value="register"/>" method="POST">
    <div>
        <h4>Регистрация</h4>
        <div>
            <input name="firstName" placeholder="Имя" required />
        </div>
        <div>
            <input name="lastName" placeholder="Фамилия" required />
        </div>
        <div>
            <input type="tel" name="phone" placeholder = "Номер телефона" pattern="[0-9]{10}" required />
        </div>
        <div>
            <input name="email" placeholder="e-mail" required />
        </div>
        <div>
            <input name="password" placeholder="Пароль" required type="password"/>
            <secure:csrfInput/>
        </div>

    </div>
    <div>
        <a type="submit" href="<spring:url value="/user/enter"/>" >Отмена</a>
        <button type="submit" href="<spring:url value="register"/>">Регистрация</button>
    </div>
</form>
</body>
</html>
