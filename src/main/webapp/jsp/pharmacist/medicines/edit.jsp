<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="page.pharmacistEditMedicinePage" bundle="${rb}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shortFormStyle.css">
</head>
<body>

<div class="login-box">
    <h2><fmt:message key="text.editMedicine" bundle="${rb}"/></h2>

    <form id="mainForm" method="post" action="${pageContext.request.contextPath}/dispatcher"
          enctype="multipart/form-data">
        <input type="hidden" name="command" value="save_updated_medicine">
        <input type="hidden" name="medicine_id" value="${requestScope.medicine.id}">
        <input type="hidden" name="previousRequestLink" value="${requestScope.previousRequestLink}">

        <input type="hidden" name="valueRequired" value="<fmt:message key="text.valueRequired" bundle="${rb}"/>">
        <input type="hidden" name="valueInvalid" value="<fmt:message key="text.valueInvalid" bundle="${rb}"/>">


        <div class="user-box">
            <input id="titleInput" type="text" name="title" value="${requestScope.medicine.title}">
            <label for="titleInput"><fmt:message key="text.editTitle" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>

        <c:set var="booleanList" value="${['true','false']}"/>
        <div class="user-box">
            <select id="isNonprescriptionSelect" name="is_nonprescription">
                <c:forEach items="${booleanList}" var="booleanElem">
                    <c:choose>
                        <c:when test="${booleanElem eq requestScope.medicine.isNonprescription}">
                            <option value="${booleanElem}" selected>${booleanElem}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${booleanElem}">${booleanElem}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <label for="isNonprescriptionSelect"><fmt:message key="text.selectIsNonprescription"
                                                              bundle="${rb}"/></label>
        </div>


        <div class="user-box">
            <select id="producerSelect" name="producer_id">
                <c:forEach items="${requestScope.producers}" var="producerElem">
                    <c:choose>
                        <c:when test="${producerElem.id eq requestScope.medicine.producerDTO.id}">
                            <option value="${producerElem.id}" selected>${producerElem.companyName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${producerElem.id}">${producerElem.companyName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <label for="producerSelect"><fmt:message key="text.selectProducer" bundle="${rb}"/></label>
        </div>
        <div class="user-box">
            <fmt:formatDate var="parsedApprovalDate" value="${requestScope.medicine.approvalDate}"
                            pattern="yyyy-MM-dd"/>
            <input id="approvalDateInput" type="date" name="approval_date" value="${parsedApprovalDate}">
            <label for="approvalDateInput"><fmt:message key="text.editApprovalDate" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>
        <div class="user-box">
            <input id="medicineImageInput" type="file" name="image">
            <label for="medicineImageInput"><fmt:message key="text.editMedicineImage" bundle="${rb}"/><span
                    class="errorSpan"></span></label>
        </div>


        <a class="leftButton" href="#" onclick="validateMedicine()">
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