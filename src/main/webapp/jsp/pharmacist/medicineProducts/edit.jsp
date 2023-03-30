<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="page.pharmacistEditMedicineProductPage" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shortFormStyle.css">
</head>
<body>

<div class="login-box">
    <h2><fmt:message key="text.editMedicineProduct" bundle="${rb}"/></h2>

    <form id="mainForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
        <input type="hidden" name="command" value="save_updated_medicine_product">
        <input type="hidden" name="medicine_product_id" value="${requestScope.medicineProduct.id}">
        <input type="hidden" name="previousRequestLink" value="${requestScope.previousRequestLink}">

        <input type="hidden" name="valueRequired" value="<fmt:message key="text.valueRequired" bundle="${rb}"/>">
        <input type="hidden" name="valueInvalid" value="<fmt:message key="text.valueInvalid" bundle="${rb}"/>">


        <div class="user-box">
            <input id="dosageInput" type="text" name="dosage" value="${requestScope.medicineProduct.dosage}">
            <label for="dosageInput"><fmt:message key="text.editDosage" bundle="${rb}"/><span class="errorSpan"></span></label>
        </div>

        <div class="user-box">
            <select id="formSelect" name="form">
                <c:forEach items="${requestScope.forms}" var="formElem">
                    <c:choose>
                        <c:when test="${formElem eq requestScope.medicineProduct.form}">
                            <option value="${formElem}" selected>${formElem}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${formElem}">${formElem}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <label for="formSelect"><fmt:message key="text.selectForm" bundle="${rb}"/></label>
        </div>

        <div class="user-box">
            <input id="priceInput" type="text" name="price" value="${requestScope.medicineProduct.price}">
            <label for="priceInput"><fmt:message key="text.editPrice" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="amountInput" type="text" name="amount" value="${requestScope.medicineProduct.amount}">
            <label for="amountInput"><fmt:message key="text.editAmount" bundle="${rb}"/><span class="errorSpan"></span></label>
        </div>

        <div class="user-box">
            <select id="medicineSelect" name="medicine_id">
                <c:forEach items="${requestScope.medicines}" var="medicineElem">
                    <c:choose>
                        <c:when test="${medicineElem.id eq requestScope.medicineProduct.medicineDTO.id}">
                            <option value="${medicineElem.id}" selected>${medicineElem.title}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${medicineElem.id}">${medicineElem.title}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <label for="medicineSelect"><fmt:message key="text.selectMedicine" bundle="${rb}"/></label>
        </div>


        <a class="leftButton" href="#" onclick="validateMedicineProduct()">
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