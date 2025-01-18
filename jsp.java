<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <c:if test="${not empty param.username}">
        <h2>Welcome, ${param.username}</h2>
    </c:if>
    <c:choose>
        <c:when test="${param.error == 'true'}">
            <p style="color:red;">Invalid credentials, please try again.</p>
        </c:when>
        <c:otherwise>
            <p>Welcome to the system!</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
