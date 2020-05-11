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
            <button type="submit" href="<spring:url value="/logout"/>" >Log Out</button>
            <secure:csrfInput/>
        </div>
    </form>
</div>
<div>
    <h4>${firstName}</h4>
</div>

</body>
</html>
