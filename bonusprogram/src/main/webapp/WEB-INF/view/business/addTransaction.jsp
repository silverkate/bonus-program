<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="secure" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %><html>
<head>
    <title>Title</title>

    <link href="<spring:url value="/static/css/main.css"/>" rel="stylesheet"/>
</head>
<body>
<a type="submit" href="<spring:url value="/business/account"/>" ><<</a>
<form action="<spring:url value="addTransaction"/>" method="POST">
    <div>
        <h4>Добавить транзакцию</h4>
        <div>
            <label>Клиентский номер телефона<input name="phone" required /></label>
        </div>
        <div>
            <label>Изначальная сумма<input id= "dirty_sum" name="dirty_sum" required /></label>
        </div>
        <div>
            <input type = "checkbox" id = "bonus_ch" name = "bonus_ch"/>
            <label for = "bonus_ch">Списать бонусы?</label>
        </div>
        <div>
            <label>Бонусы<input id="bonus" name="bonus" required /></label>
        </div>
        <div>
            <label>Cумма к оплате<input name="sum" required /></label>
        </div>
        <button type="submit" href="<spring:url value="addTransaction"/>">Submit</button>
    </div>
    <div>
        ${error}
    </div>
</form>
</body>
</html>
