<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="page.loginPage" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>

<form action="${pageContext.request.contextPath}/dispatcher" method="post">
    <input type="hidden" name="command" value="login"/>
    <input type="hidden" name="previousRequestLink" value="${requestScope.previousRequestLink}">
    <div class="segment1">
        <c:choose>
            <c:when test="${not empty requestScope.loginMessage}">
                <h1><fmt:message key="${requestScope.loginMessage}" bundle="${rb}"/></h1>
            </c:when>
            <c:otherwise>
                <h1><fmt:message key="text.login" bundle="${rb}"/></h1>
            </c:otherwise>
        </c:choose>
    </div>
    <label>
        <input type="text" name="login" placeholder="<fmt:message key="text.loginPlaceholder" bundle="${rb}"/>"/>
    </label>
    <label>
        <input type="password" name="password"
               placeholder="<fmt:message key="text.passwordPlaceholder" bundle="${rb}"/>"/>
    </label>
    <button class="red" type="submit">
        <i class="icon ion-md-lock"></i>
        <fmt:message key="text.signin" bundle="${rb}"/>
    </button>
</form>


<c:if test="${not empty requestScope.errorLoginPassMessageKey}">
    <div class="segment2">
        <h2 style="color: red"><fmt:message key="${requestScope.errorLoginPassMessageKey}" bundle="${rb}"/></h2>
    </div>
</c:if>


<c:if test="${empty requestScope.loginMessage}">
    <form action="${pageContext.request.contextPath}/dispatcher" method="post">
        <input type="hidden" name="command" value="get_user_create_form"/>
        <input type="hidden" name="previousRequestLink" value="${requestScope.previousRequestLink}">
        <div class="segment2">
            <h1><fmt:message key="text.newCustomer" bundle="${rb}"/></h1>
        </div>
        <button class="red" type="submit">
            <i class="icon ion-md-lock"></i>
            <fmt:message key="text.createNewAccount" bundle="${rb}"/>
        </button>
    </form>
</c:if>


</body>
</html>