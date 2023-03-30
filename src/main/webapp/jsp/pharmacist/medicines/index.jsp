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
    <title><fmt:message key="page.pharmacistMedicinesPage" bundle="${rb}"/></title>
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
<c:import url="/jsp/pharmacist/navbar.jsp"/>

<div class="main">


    <div class="mainTable">
        <div class="container">
            <ul class="responsive-table medicines">
                <li class="table-search">
                    <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                        <input type="hidden" name="command" value="${requestScope.command}">
                        <input type="hidden" name="orderField" value="${requestScope.orderObject.orderField}">
                        <input type="hidden" name="orderType" value="${requestScope.orderObject.orderType}">
                        <input type="hidden" name="recordsPerPage" value="${requestScope.medicines.recordsPerPage}">
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
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=id&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicines.recordsPerPage}&currentPage=${requestScope.medicines.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.id" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=id&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicines.recordsPerPage}&currentPage=${requestScope.medicines.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-3">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=title&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicines.recordsPerPage}&currentPage=${requestScope.medicines.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.title" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=title&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicines.recordsPerPage}&currentPage=${requestScope.medicines.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-4">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=isNonprescription&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicines.recordsPerPage}&currentPage=${requestScope.medicines.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.isNonprescription" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=isNonprescription&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicines.recordsPerPage}&currentPage=${requestScope.medicines.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-5">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=approvalDate&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicines.recordsPerPage}&currentPage=${requestScope.medicines.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.approvalDate" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=approvalDate&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicines.recordsPerPage}&currentPage=${requestScope.medicines.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-6"><fmt:message key="table.medicineImage" bundle="${rb}"/></div>
                    <div class="col col-7"></div>
                    <div class="col col-8"></div>
                </li>
                <c:set var="previousRecordsNum" scope="page"
                       value="${(requestScope.medicines.currentPage-1)*requestScope.medicines.recordsPerPage}"/>
                <c:forEach var="elem" items="${requestScope.medicines.records}" varStatus="status">
                    <li class="table-row">
                        <div class="col col-1">${previousRecordsNum+status.count}</div>
                        <div class="col col-2">${elem.id}</div>
                        <div class="col col-3">${elem.title}</div>
                        <div class="col col-4">${elem.isNonprescription}</div>
                        <div class="col col-5"><fmt:formatDate value="${elem.approvalDate}" pattern="MM-dd-yyyy"/></div>
                        <div class="col col-6"><img class="tableAvatar"
                                                    src="${pageContext.request.contextPath}${elem.medicineImagePath}">
                        </div>
                        <div class="col col-7">
                            <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                                <input type="hidden" name="command" value="get_medicine_edit_form">
                                <input type="hidden" name="previousRequestLink"
                                       value="/dispatcher?${pageContext.request.queryString}"/>
                                <input type="hidden" name="medicine_id" value=${elem.id}>
                                <button type="submit"><fmt:message key="table.edit" bundle="${rb}"/></button>
                            </form>
                        </div>
                        <div class="col col-8">
                            <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                                <c:choose>
                                    <c:when test="${requestScope.medicines.records.size() > 1}">
                                        <input type="hidden" name="previousRequestLink"
                                               value="/dispatcher?${pageContext.request.queryString}"/>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="hidden" name="previousRequestLink"
                                               value="/dispatcher?command=${requestScope.command}&orderField=${requestScope.orderObject.orderField}&orderType=${requestScope.orderObject.orderType}&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicines.recordsPerPage}&currentPage=${requestScope.medicines.currentPage-1}"/>
                                    </c:otherwise>
                                </c:choose>
                                <input type="hidden" name="command" value="delete_medicine">
                                <input type="hidden" name="medicine_id" value=${elem.id}>
                                <button type="submit"><fmt:message key="table.delete" bundle="${rb}"/></button>
                            </form>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>


    <t:serverPagination
            permanentParameters="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=${requestScope.orderObject.orderField}&orderType=${requestScope.orderObject.orderType}&searchValue=${requestScope.searchValue}"
            currentPage="${requestScope.medicines.currentPage}"
            recordsPerPage="${requestScope.medicines.recordsPerPage}"
            pagesNum="${requestScope.medicines.pagesNum}"/>


    <form class="addForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
        <input type="hidden" name="command" value="get_medicine_create_form">
        <input type="hidden" name="previousRequestLink" value="/dispatcher?${pageContext.request.queryString}"/>
        <button class="red" type="submit"><i class="icon ion-md-lock"></i><fmt:message key="table.addNewMedicine"
                                                                                       bundle="${rb}"/></button>
    </form>


</div>
<c:import url="/jsp/common/footer.jsp"/>
</body>
</html>