<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="page.pharmacistAddProducerPage" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shortFormStyle.css">
</head>
<body>

<div class="login-box">
    <h2><fmt:message key="text.addProducer" bundle="${rb}"/></h2>

    <form id="mainForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
        <input type="hidden" name="command" value="save_new_producer">
        <input type="hidden" name="previousRequestLink" value="${requestScope.previousRequestLink}">

        <input type="hidden" name="valueRequired" value="<fmt:message key="text.valueRequired" bundle="${rb}"/>">
        <input type="hidden" name="valueInvalid" value="<fmt:message key="text.valueInvalid" bundle="${rb}"/>">


        <div class="user-box">
            <input id="companyNameInput" type="text" name="companyName">
            <label for="companyNameInput"><fmt:message key="text.enterCompanyName" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <select id="countrySelect" name="country">
                <c:forEach items="${requestScope.countries}" var="countryElem">
                    <option value="${countryElem}">${countryElem}</option>
                </c:forEach>
            </select>
            <label for="countrySelect"><fmt:message key="text.selectCountry" bundle="${rb}"/></label>
        </div>
        <div class="user-box">
            <input id="creationDateInput" type="date" name="creationDate">
            <label for="creationDateInput"><fmt:message key="text.enterCreationDate" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>


        <a class="leftButton" href="#" onclick="validateProducer()">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <fmt:message key="text.save" bundle="${rb}"/>
        </a>
        <a class="rightButton" href="${pageContext.request.contextPath}${requestScope.previousRequestLink}">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <fmt:message key="text.cancel" bundle="${rb}"/>
        </a>

    </form>

</div>

<script src="${pageContext.request.contextPath}/js/formValidation.js"></script>
</body>
</html>