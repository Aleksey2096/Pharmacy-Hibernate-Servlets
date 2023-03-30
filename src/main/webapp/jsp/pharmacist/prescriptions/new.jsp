<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="page.pharmacistAddPrescriptionPage" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shortFormStyle.css">
</head>
<body>

<div class="login-box">
    <h2><fmt:message key="text.addPrescription" bundle="${rb}"/></h2>

    <form id="mainForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
        <input type="hidden" name="command" value="approve_prescription_request">
        <input type="hidden" name="previousRequestLinkApproved" value="${requestScope.previousRequestLinkApproved}">
        <input type="hidden" name="prescription_request_id" value="${requestScope.prescription_request_id}">

        <input type="hidden" name="valueRequired" value="<fmt:message key="text.valueRequired" bundle="${rb}"/>">
        <input type="hidden" name="valueInvalid" value="<fmt:message key="text.valueInvalid" bundle="${rb}"/>">


        <div class="user-box">
            <input id="healthCareCardNumberInput" type="text" name="health_care_card_number">
            <label for="healthCareCardNumberInput"><fmt:message key="text.enterHealthCareCardNumber"
                                                                bundle="${rb}"/><span class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="medicineProductIdInput" type="text" name="medicine_product_id">
            <label for="medicineProductIdInput"><fmt:message key="text.enterMedicineProductId" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="amountInput" type="text" name="amount">
            <label for="amountInput"><fmt:message key="text.enterAmount" bundle="${rb}"/><span class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="dateInput" type="date" name="date">
            <label for="dateInput"><fmt:message key="text.enterDate" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>


        <a class="leftButton" href="#" onclick="validatePrescription()">
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