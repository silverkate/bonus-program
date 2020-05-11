<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %><html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<spring:url value="transaction"/>" method="POST">
    <div>
        <h4>Добавить транзакцию</h4>
        <div>
            <label>Клиентский номер телефона<input name="phone" required /></label>
        </div>
        <div>
            <label>Изначальная сумма<input name="dirty_sum" required /></label>
        </div>
        <div>
            <input type = "checkbox" id = "bonus" name = "bonus_ch"/>
            <label for = "bonus">Списать бонусы?</label>
        </div>
        <div>
            <label>Бонусы<input name="bonus" required /></label>
        </div>
        <div>
            <label>Cумма к оплате<input name="sum" required /></label>
        </div>
    </div>

</form>
</body>
</html>
