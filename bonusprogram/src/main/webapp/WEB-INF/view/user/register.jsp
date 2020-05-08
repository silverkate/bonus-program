<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>User Register</title>
</head>
<body>
<form action="<spring:url value="register"/>" method="POST">
    <div>
        <h4>Register</h4>
        <div>
            <label>Name<input name="firstName" required /></label>
        </div>
        <div>
            <label>Last Name<input name="lastName" required /></label>
        </div>
        <div>
            <label>Phone<input name="phone" required /></label>
        </div>
        <div>
            <label>Email<input name="email" required /></label>
        </div>
        <div>
            <label>Password<input name="password"  required type="password"/></label>
            <secure:csrfInput/>
        </div>

    </div>
    <div>
        <a type="submit" href="<spring:url value="/"/>" >Cancel</a>
        <button type="submit" href="<spring:url value="register"/>">Register</button>
    </div>
</form>
</body>
</html>
