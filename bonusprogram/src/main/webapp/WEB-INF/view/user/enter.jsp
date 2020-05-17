<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="secure" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>User Enter</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="<spring:url value="/static/css/main.css"/>" rel="stylesheet"/>
</head>
<body>

<form action="<spring:url value="login"/>" method="POST">
    <div>
        <h4>Sign in</h4>
        <div>
            <label>Phone<input name="login" required /></label>
        </div>
        <div>
            <label>Password<input name="password"  required type="password"/></label>
            <secure:csrfInput/>
        </div>
    </div>
    <div>
        <a type="submit" href="<spring:url value="/"/>" >Cancel</a>
        <button type="submit" href="<spring:url value="login"/>">Submit</button>
    </div>
</form>
<div>
    <div>
        <a href="<spring:url value="/user/register"/>">Register</a>
    </div>
</div>
<div>
    <c:if test="${param.error == 'notentry'}">
        Login and/or password are incorrect.
    </c:if>
</div>
</body>
</html>
