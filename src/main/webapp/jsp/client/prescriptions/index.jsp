<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="page.clientPrescriptionsPage" bundle="${rb}"/></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mainTable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/data-pagination.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
</head>
<body>
<c:import url="/jsp/common/header.jsp"/>
<c:import url="/jsp/common/navbar.jsp"/>

<div class="main">


    <div class="mainTable">
        <div class="container narrow">
            <ul class="responsive-table prescriptions">
                <li class="table-search">
                    <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                        <input type="hidden" name="command" value="${requestScope.command}">
                        <input type="hidden" name="orderField" value="${requestScope.orderObject.orderField}">
                        <input type="hidden" name="orderType" value="${requestScope.orderObject.orderType}">
                        <input type="hidden" name="recordsPerPage" value="${requestScope.prescriptions.recordsPerPage}">
                        <input type="hidden" name="currentPage" value="1">
                        <input class="searchInput" type="text" name="searchValue">
                        <button class="searchButton" type="submit"><fmt:message key="text.search"
                                                                                bundle="${rb}"/></button>
                    </form>
                </li>
                <li class="table-header">
                    <div class="col col-1">&#8470;</div>
                    <div class="col col-2">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=id&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptions.recordsPerPage}&currentPage=${requestScope.prescriptions.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.id" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=id&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptions.recordsPerPage}&currentPage=${requestScope.prescriptions.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-3">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=medicineProductEntity&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptions.recordsPerPage}&currentPage=${requestScope.prescriptions.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.medicineProductId" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=medicineProductEntity&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptions.recordsPerPage}&currentPage=${requestScope.prescriptions.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-4">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=amount&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptions.recordsPerPage}&currentPage=${requestScope.prescriptions.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.amount" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=amount&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptions.recordsPerPage}&currentPage=${requestScope.prescriptions.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-5">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=date&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptions.recordsPerPage}&currentPage=${requestScope.prescriptions.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.date" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=date&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptions.recordsPerPage}&currentPage=${requestScope.prescriptions.currentPage}">∨</a>
                    </span>
                    </div>
                </li>
                <c:set var="previousRecordsNum" scope="page"
                       value="${(requestScope.prescriptions.currentPage-1)*requestScope.prescriptions.recordsPerPage}"/>
                <c:forEach var="elem" items="${requestScope.prescriptions.records}" varStatus="status">
                    <li class="table-row">
                        <div class="col col-1">${previousRecordsNum+status.count}</div>
                        <div class="col col-2">${elem.id}</div>
                        <div class="col col-3">${elem.medicineProductDTO.id}</div>
                        <div class="col col-4">${elem.amount}</div>
                        <div class="col col-5"><fmt:formatDate value="${elem.date}" pattern="MM-dd-yyyy"/></div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>


    <t:serverPagination
            permanentParameters="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=${requestScope.orderObject.orderField}&orderType=${requestScope.orderObject.orderType}&searchValue=${requestScope.searchValue}"
            currentPage="${requestScope.prescriptions.currentPage}"
            recordsPerPage="${requestScope.prescriptions.recordsPerPage}"
            pagesNum="${requestScope.prescriptions.pagesNum}"/>


</div>
<c:import url="/jsp/common/footer.jsp"/>
</body>
</html>
