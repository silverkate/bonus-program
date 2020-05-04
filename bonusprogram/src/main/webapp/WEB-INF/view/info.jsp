<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Info</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="<spring:url value="/static/css/main.css"/>" rel="stylesheet"/>
</head>
<body>
<div id="base" class="">

    <div id="u1" class="ax_default button">
        <div id="u1_text" class="text ">
            <a href="info">Бизнес</a>
        </div>
    </div>

    <div id="u2" class="ax_default button">
        <div id="u2_text" class="text ">
            <a href="info">Персональный</a>
        </div>
    </div>

    <div id="u5" class="ax_default paragraph">
        <div id="u5_div" class=""></div>
        <div id="u5_text" class="text ">
            <p><span><b>Как зарегистрироваться? </b><br/>Кликните кнопку Персональный и заполните Ваши данные. Придумайте пароль.</span></p>
            <br/><br/>
            <p><span><b>Ловите бонусы! </b><br/>При покупке в магазине назовите свой номер телефона. Это и есть Ваша бонусная карта. Бонус 3% от суммы покупки зачисляется на Ваш персональный счет.</span></p>
        </div>
    </div>

    <div id="u6" class="ax_default button">
        <div id="u6_text" class="text ">
            <a href="<spring:url value="/"/>">&lt;&lt;</a>
        </div>
    </div>

    <div id="u7" class="ax_default image">
        <img id="u7_img" class="img " src="<spring:url value="/static/img/cat.jpg"/>"/>
        <div id="u7_text" class="text " style="display:none; visibility: hidden">
            <p></p>
        </div>
    </div>

    <div id="u8" class="ax_default paragraph">
        <div id="u8_div" class=""></div>
        <div id="u8_text" class="text ">
            <p><span><b>Где посмотреть мои бонусы? </b><br/>Персональный раздел. Здесь Вы увидите все Ваши покупки и бонусы.</span></p>
            <br/>
            <p><span><b>Как потратить? </b><br/>Совершая последующие покупки, попросите кассира оплатить покупку бонусами. А если будете делать оплату онлайн, не забудьте отметить “Потратить бонусы”. Сумма оплаты автоматически уменьшится на сумму Ваших бонусов.</span></p>
        </div>
    </div>
</div>
</body>
</html>