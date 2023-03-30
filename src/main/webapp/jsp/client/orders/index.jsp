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
    <title><fmt:message key="page.clientOrdersPage" bundle="${rb}"/></title>
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
        <div class="container">
            <ul class="responsive-table userOrders">
                <li class="table-search">
                    <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                        <input type="hidden" name="command" value="${requestScope.command}">
                        <input type="hidden" name="orderField" value="${requestScope.orderObject.orderField}">
                        <input type="hidden" name="orderType" value="${requestScope.orderObject.orderType}">
                        <input type="hidden" name="recordsPerPage" value="${requestScope.orders.recordsPerPage}">
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
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=id&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.id" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=id&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-3">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=localDateTime&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.dateTime" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=localDateTime&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-4">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=medicineProductEntity&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.medicineProductId" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=medicineProductEntity&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-5">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=amount&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.amount" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=amount&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-6">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=price&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.price" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=price&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-7">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=paymentCardNumber&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.paymentCardNumber" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=paymentCardNumber&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-8">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=contactPhone&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.contactPhone" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=contactPhone&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-9">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=deliveryAddress&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.deliveryAddress" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=deliveryAddress&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.orders.recordsPerPage}&currentPage=${requestScope.orders.currentPage}">∨</a>
                    </span>
                    </div>

                </li>
                <c:set var="previousRecordsNum" scope="page"
                       value="${(requestScope.orders.currentPage-1)*requestScope.orders.recordsPerPage}"/>
                <c:forEach var="elem" items="${requestScope.orders.records}" varStatus="status">
                    <li class="table-row">
                        <div class="col col-1">${previousRecordsNum+status.count}</div>
                        <div class="col col-2">${elem.id}</div>
                        <div class="col col-3">${elem.localDateTime}</div>
                        <div class="col col-4">${elem.medicineProductDTO.id}</div>
                        <div class="col col-5">${elem.amount}</div>
                        <div class="col col-6">${elem.price}</div>
                        <div class="col col-7">${elem.paymentCardNumber}</div>
                        <div class="col col-8">${elem.contactPhone}</div>
                        <div class="col col-9">${elem.deliveryAddress}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>


    <t:serverPagination
            permanentParameters="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=${requestScope.orderObject.orderField}&orderType=${requestScope.orderObject.orderType}&searchValue=${requestScope.searchValue}"
            currentPage="${requestScope.orders.currentPage}"
            recordsPerPage="${requestScope.orders.recordsPerPage}"
            pagesNum="${requestScope.orders.pagesNum}"/>


</div>
<c:import url="/jsp/common/footer.jsp"/>
</body>
</html>