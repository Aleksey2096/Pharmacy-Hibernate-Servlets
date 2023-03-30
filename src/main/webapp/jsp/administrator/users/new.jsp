<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<jsp:useBean id="date" class="java.util.Date"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="page.administratorAddUserPage" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formStyle.css">
</head>
<body>

<div class="login-box">
    <h2><fmt:message key="text.addUser" bundle="${rb}"/></h2>

    <form id="mainForm" method="post" action="${pageContext.request.contextPath}/dispatcher"
          enctype="multipart/form-data">
        <input type="hidden" name="command" value="save_new_user">
        <input type="hidden" name="previousRequestLink" value="${requestScope.previousRequestLink}">
        <fmt:formatDate var="parsedDateJoined" value="${date}" pattern="yyyy-MM-dd"/>
        <input type="hidden" name="date_joined" value="${parsedDateJoined}">

        <input type="hidden" name="valueRequired" value="<fmt:message key="text.valueRequired" bundle="${rb}"/>">
        <input type="hidden" name="valueInvalid" value="<fmt:message key="text.valueInvalid" bundle="${rb}"/>">


        <div class="user-box">
            <input id="healthCareCardNumberInput" type="text" name="health_care_card_number">
            <label for="healthCareCardNumberInput"><fmt:message key="text.enterHealthCareCardNumber"
                                                                bundle="${rb}"/><span class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="loginInput" type="text" name="login">
            <label for="loginInput"><fmt:message key="text.enterLogin" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="passwordInput" type="password" name="password">
            <label for="passwordInput"><fmt:message key="text.enterPassword" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <c:choose>
            <c:when test="${not empty sessionScope.user and sessionScope.user.role eq 'ADMINISTRATOR'}">
                <div class="user-box">
                    <select id="roleSelect" name="role">
                        <c:forEach items="${requestScope.roles}" var="roleElem">
                            <c:choose>
                                <c:when test="${roleElem eq requestScope.user.role}">
                                    <option value="${roleElem}" selected>${roleElem}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${roleElem}">${roleElem}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <label for="roleSelect"><fmt:message key="text.selectRole" bundle="${rb}"/></label>
                </div>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="role" value="CLIENT">
            </c:otherwise>
        </c:choose>
        <div class="user-box">
            <input id="avatarInput" type="file" name="image">
            <label for="avatarInput"><fmt:message key="text.enterAvatar" bundle="${rb}"/><span class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="nameInput" type="text" name="name">
            <label for="nameInput"><fmt:message key="text.enterName" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="surnameInput" type="text" name="surname">
            <label for="surnameInput"><fmt:message key="text.enterSurname" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="birthDateInput" type="date" name="date_of_birth">
            <label for="birthDateInput"><fmt:message key="text.enterBirthDate" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="phoneInput" type="text" name="phone">
            <label for="phoneInput"><fmt:message key="text.enterPhone" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="emailInput" type="text" name="email">
            <label for="emailInput"><fmt:message key="text.enterEmail" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="positionInput" type="text" name="position">
            <label for="positionInput"><fmt:message key="text.enterPosition" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="personalAccountInput" type="text" name="personal_account">
            <label for="personalAccountInput"><fmt:message key="text.enterPersonalAccount" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="paymentCardNumberInput" type="text" name="payment_card_number">
            <label for="paymentCardNumberInput"><fmt:message key="text.enterPaymentCardNumber" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="postcodeInput" type="text" name="postcode">
            <label for="postcodeInput"><fmt:message key="text.enterPostcode" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="cityInput" type="text" name="city">
            <label for="cityInput"><fmt:message key="text.enterCity" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="streetInput" type="text" name="street">
            <label for="streetInput"><fmt:message key="text.enterStreet" bundle="${rb}"/><span class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="houseInput" type="text" name="house">
            <label for="houseInput"><fmt:message key="text.enterHouse" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="apartmentInput" type="text" name="apartment">
            <label for="apartmentInput"><fmt:message key="text.enterApartment" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>

        <a class="leftButton" href="#" onclick="validateAdministratorUserForm()">
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