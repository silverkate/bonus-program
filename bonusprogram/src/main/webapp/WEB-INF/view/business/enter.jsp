<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="secure" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Enter Business</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="<spring:url value="/static/css/main.css"/>" rel="stylesheet"/>
</head>
<body id="u9">
<form action="<spring:url value="login"/>" method="POST">
    <div>
        <h1>Sign in</h1>
        <div>
            <input name="login" placeholder = "Phone" required />
        </div>
        <div>
            <input name="password" placeholder = "Password" required type="password"/>
            <secure:csrfInput/>
        </div>
    </div>
    <div>
        <a type="submit" href="<spring:url value="/"/>" >Cancel</a>
        <button type="submit" href="<spring:url value="login"/>">Submit</button>
    </div>
</form>

</body>
</html>
