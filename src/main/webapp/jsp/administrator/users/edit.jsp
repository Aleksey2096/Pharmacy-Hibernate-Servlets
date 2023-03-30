<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="page.administratorEditUserPage" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formStyle.css">
</head>
<body>

<div class="login-box">
    <h2><fmt:message key="text.editUser" bundle="${rb}"/></h2>

    <form id="mainForm" method="post" action="${pageContext.request.contextPath}/dispatcher"
          enctype="multipart/form-data">
        <input type="hidden" name="command" value="save_updated_user">
        <input type="hidden" name="health_care_card_number" value="${requestScope.user.healthCareCardNumber}">
        <input type="hidden" name="previousRequestLink" value="${requestScope.previousRequestLink}">

        <input type="hidden" name="valueRequired" value="<fmt:message key="text.valueRequired" bundle="${rb}"/>">
        <input type="hidden" name="valueInvalid" value="<fmt:message key="text.valueInvalid" bundle="${rb}"/>">


        <div class="user-box">
            <input id="loginInput" type="text" name="login" value="${requestScope.user.login}">
            <label for="loginInput"><fmt:message key="text.editLogin" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="passwordInput" type="password" name="password">
            <label for="passwordInput"><fmt:message key="text.editPassword" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <c:choose>
            <c:when test="${sessionScope.user.role eq 'ADMINISTRATOR'}">
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
            <fmt:formatDate var="parsedJoinedDate" value="${requestScope.user.joinedDate}" pattern="yyyy-MM-dd"/>
            <input id="joinedDateInput" type="date" name="date_joined" value="${parsedJoinedDate}">
            <label for="joinedDateInput"><fmt:message key="text.editJoinedDate" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="avatarInput" type="file" name="image">
            <label for="avatarInput"><fmt:message key="text.editAvatar" bundle="${rb}"/><span class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="nameInput" type="text" name="name" value="${requestScope.user.personalInfoDTO.name}">
            <label for="nameInput"><fmt:message key="text.editName" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="surnameInput" type="text" name="surname" value="${requestScope.user.personalInfoDTO.surname}">
            <label for="surnameInput"><fmt:message key="text.editSurname" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <fmt:formatDate var="parsedBirthDate" value="${requestScope.user.personalInfoDTO.birthDate}"
                            pattern="yyyy-MM-dd"/>
            <input id="birthDateInput" type="date" name="date_of_birth" value="${parsedBirthDate}">
            <label for="birthDateInput"><fmt:message key="text.editBirthDate" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="phoneInput" type="text" name="phone" value="${requestScope.user.personalInfoDTO.phone}">
            <label for="phoneInput"><fmt:message key="text.editPhone" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="emailInput" type="text" name="email" value="${requestScope.user.personalInfoDTO.email}">
            <label for="emailInput"><fmt:message key="text.editEmail" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="positionInput" type="text" name="position" value="${requestScope.user.personalInfoDTO.position}">
            <label for="positionInput"><fmt:message key="text.editPosition" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="personalAccountInput" type="text" name="personal_account"
                   value="${requestScope.user.personalInfoDTO.personalAccount}">
            <label for="personalAccountInput"><fmt:message key="text.editPersonalAccount" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="paymentCardNumberInput" type="text" name="payment_card_number"
                   value="${requestScope.user.personalInfoDTO.paymentCardNumber}">
            <label for="paymentCardNumberInput"><fmt:message key="text.editPaymentCardNumber" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="postcodeInput" type="text" name="postcode"
                   value="${requestScope.user.personalInfoDTO.addressDTO.postcode}">
            <label for="postcodeInput"><fmt:message key="text.editPostcode" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="cityInput" type="text" name="city" value="${requestScope.user.personalInfoDTO.addressDTO.city}">
            <label for="cityInput"><fmt:message key="text.editCity" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="streetInput" type="text" name="street"
                   value="${requestScope.user.personalInfoDTO.addressDTO.street}">
            <label for="streetInput"><fmt:message key="text.editStreet" bundle="${rb}"/><span class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="houseInput" type="text" name="house"
                   value="${requestScope.user.personalInfoDTO.addressDTO.house}">
            <label for="houseInput"><fmt:message key="text.editHouse" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="apartmentInput" type="text" name="apartment"
                   value="${requestScope.user.personalInfoDTO.addressDTO.apartment}">
            <label for="apartmentInput"><fmt:message key="text.editApartment" bundle="${rb}"/><span
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