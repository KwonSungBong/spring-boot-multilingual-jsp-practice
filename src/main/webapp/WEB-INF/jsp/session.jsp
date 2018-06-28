<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TEST</title>
</head>
<body>
    <div>
        <a href="${pageContext.request.contextPath}/session?lang=en">en</a>
         |
        <a href="${pageContext.request.contextPath}/session?lang=kr">kr</a>
    </div>
    <div>
        message : ${hello}
    </div>
    <div>
        <spring:message code="greeting" />
    </div>
</body>
</html>
