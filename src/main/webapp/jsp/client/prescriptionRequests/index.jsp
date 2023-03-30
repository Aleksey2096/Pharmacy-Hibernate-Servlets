<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="page.clientPrescriptionRequestsPage" bundle="${rb}"/></title>
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
            <ul class="responsive-table prescriptionRequests">
                <li class="table-search">
                    <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                        <input type="hidden" name="command" value="${requestScope.command}">
                        <input type="hidden" name="orderField" value="${requestScope.orderObject.orderField}">
                        <input type="hidden" name="orderType" value="${requestScope.orderObject.orderType}">
                        <input type="hidden" name="recordsPerPage"
                               value="${requestScope.prescriptionRequests.recordsPerPage}">
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
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=id&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptionRequests.recordsPerPage}&currentPage=${requestScope.prescriptionRequests.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.id" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=id&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptionRequests.recordsPerPage}&currentPage=${requestScope.prescriptionRequests.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-3">
                        <fmt:message key="table.prescriptionScan" bundle="${rb}"/>
                    </div>
                    <div class="col col-4">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=uploadDateTime&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptionRequests.recordsPerPage}&currentPage=${requestScope.prescriptionRequests.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.uploadDateTime" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=uploadDateTime&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptionRequests.recordsPerPage}&currentPage=${requestScope.prescriptionRequests.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-5">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=prescriptionRequestStatus&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptionRequests.recordsPerPage}&currentPage=${requestScope.prescriptionRequests.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.prescriptionRequestStatus" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=prescriptionRequestStatus&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.prescriptionRequests.recordsPerPage}&currentPage=${requestScope.prescriptionRequests.currentPage}">∨</a>
                    </span>
                    </div>

                </li>
                <c:set var="previousRecordsNum" scope="page"
                       value="${(requestScope.prescriptionRequests.currentPage-1)*requestScope.prescriptionRequests.recordsPerPage}"/>
                <c:forEach var="elem" items="${requestScope.prescriptionRequests.records}" varStatus="status">
                    <li class="table-row">
                        <div class="col col-1">${previousRecordsNum+status.count}</div>
                        <div class="col col-2">${elem.id}</div>
                        <div class="col col-3"><img class="tableAvatar"
                                                    src="${pageContext.request.contextPath}${elem.prescriptionScanPath}">
                        </div>
                        <div class="col col-4">${elem.uploadDateTime}</div>
                        <div class="col col-5">${elem.prescriptionRequestStatus}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>


    <t:serverPagination
            permanentParameters="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=${requestScope.orderObject.orderField}&orderType=${requestScope.orderObject.orderType}&searchValue=${requestScope.searchValue}"
            currentPage="${requestScope.prescriptionRequests.currentPage}"
            recordsPerPage="${requestScope.prescriptionRequests.recordsPerPage}"
            pagesNum="${requestScope.prescriptionRequests.pagesNum}"/>


    <form class="addForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
        <input type="hidden" name="command" value="get_prescription_request_create_form">
        <input type="hidden" name="previousRequestLink" value="/dispatcher?${pageContext.request.queryString}"/>
        <button class="red" type="submit"><i class="icon ion-md-lock"></i><fmt:message
                key="table.addNewPrescriptionRequestScan" bundle="${rb}"/></button>
    </form>


</div>
<c:import url="/jsp/common/footer.jsp"/>
</body>
</html>