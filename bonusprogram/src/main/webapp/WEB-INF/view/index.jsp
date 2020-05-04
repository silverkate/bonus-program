<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="<spring:url value="/static/css/main.css"/>" rel="stylesheet"/>
</head>
<body>
<div id="base" class="">
    <div id="u1" class="ax_default button">
        <div id="u1_text" class="text ">
            <a href="<spring:url value="/"/>">Бизнес</a>
        </div>
    </div>

    <div id="u2" class="ax_default button">
        <div id="u2_text" class="text ">
            <a href="<spring:url value="/"/>">Персональный</a>
        </div>
    </div>

    <div id="u3" class="ax_default heading_1">
        <div id="u3_div" class=""></div>
        <div id="u3_text" class="text ">
            <p><span>Take your bonus!</span></p>
        </div>
    </div>

    <div id="u4" class="ax_default button">
        <div id="u4_text" class="text ">
            <a href="<spring:url value="/info"/>">Узнать больше</a>
        </div>
    </div>

</div>
</body>
</html>
