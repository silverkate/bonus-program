<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Enter Business</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="<spring:url value="/static/css/main.css"/>" rel="stylesheet"/>
</head>
<body>
<div>
    <div >
        <a href="<spring:url value="/"/>">&lt;&lt;</a>
    </div>
</div>
<form action="<spring:url value="login"/>" method="POST">
    <div>
        <h4>Sign in</h4>
        <div>
            <label>Phone<input name="custom_phone" required /></label>
        </div>
        <div>
            <label>Password<input name="custom_password"  required type="password"/></label>
            <secure:csrfInput/>
        </div>
    </div>
    <div>
        <a type="submit" href="#!" >Cancel</a>
        <button type="submit" href="<spring:url value="login"/>">Submit</button>
    </div>
</form>
<form>

</form>


</body>
</html>
