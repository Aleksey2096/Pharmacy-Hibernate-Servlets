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
    <title><fmt:message key="page.clientMedicineProductsPage" bundle="${rb}"/></title>
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
            <ul class="responsive-table userMedicineProducts">
                <li class="table-search">
                    <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                        <input type="hidden" name="command" value="${requestScope.command}">
                        <input type="hidden" name="orderField" value="${requestScope.orderObject.orderField}">
                        <input type="hidden" name="orderType" value="${requestScope.orderObject.orderType}">
                        <input type="hidden" name="recordsPerPage"
                               value="${requestScope.medicineProducts.recordsPerPage}">
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
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=id&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicineProducts.recordsPerPage}&currentPage=${requestScope.medicineProducts.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.id" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=id&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicineProducts.recordsPerPage}&currentPage=${requestScope.medicineProducts.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-3">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=dosage&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicineProducts.recordsPerPage}&currentPage=${requestScope.medicineProducts.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.dosage" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=dosage&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicineProducts.recordsPerPage}&currentPage=${requestScope.medicineProducts.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-4">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=form&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicineProducts.recordsPerPage}&currentPage=${requestScope.medicineProducts.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.form" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=form&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicineProducts.recordsPerPage}&currentPage=${requestScope.medicineProducts.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-5">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=price&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicineProducts.recordsPerPage}&currentPage=${requestScope.medicineProducts.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.price" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=price&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicineProducts.recordsPerPage}&currentPage=${requestScope.medicineProducts.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-6">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=amount&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicineProducts.recordsPerPage}&currentPage=${requestScope.medicineProducts.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.amount" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=amount&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.medicineProducts.recordsPerPage}&currentPage=${requestScope.medicineProducts.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-7"></div>
                </li>
                <c:set var="previousRecordsNum" scope="page"
                       value="${(requestScope.medicineProducts.currentPage-1)*requestScope.medicineProducts.recordsPerPage}"/>
                <c:forEach var="elem" items="${requestScope.medicineProducts.records}" varStatus="status">
                    <li class="table-row">
                        <div class="col col-1">${previousRecordsNum+status.count}</div>
                        <div class="col col-2">${elem.id}</div>
                        <div class="col col-3">${elem.dosage}</div>
                        <div class="col col-4">${elem.form}</div>
                        <div class="col col-5">${elem.price}</div>
                        <div class="col col-6">${elem.amount}</div>
                        <div class="col col-7">
                            <form class="addToCartForm" method="post"
                                  action="${pageContext.request.contextPath}/dispatcher">
                                <input type="hidden" name="command" value="add_to_cart">
                                <input type="hidden" name="previousRequestLink"
                                       value="/dispatcher?${pageContext.request.queryString}"/>
                                <input type="hidden" name="medicine_product_id" value=${elem.id}>
                                <input type="hidden" name="isLoggedIn" value="${not empty sessionScope.user}"/>
                                <button type="submit" class="addToCartButton">
                                    <svg class="addToCartSign" xmlns="http://www.w3.org/2000/svg" width="25" height="25"
                                         viewBox="0 0 256 256" xml:space="preserve">
   									<g style="stroke: none; stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1;"
                                       transform="translate(1.4065934065934016 1.4065934065934016) scale(2.81 2.81)">
                                        <path d="M 72.975 58.994 H 31.855 c -1.539 0 -2.897 -1.005 -3.347 -2.477 L 15.199 13.006 H 3.5 c -1.933 0 -3.5 -1.567 -3.5 -3.5 s 1.567 -3.5 3.5 -3.5 h 14.289 c 1.539 0 2.897 1.005 3.347 2.476 l 13.309 43.512 h 36.204 l 10.585 -25.191 h -6.021 c -1.933 0 -3.5 -1.567 -3.5 -3.5 s 1.567 -3.5 3.5 -3.5 H 86.5 c 1.172 0 2.267 0.587 2.915 1.563 s 0.766 2.212 0.312 3.293 L 76.201 56.85 C 75.655 58.149 74.384 58.994 72.975 58.994 z"
                                              style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill-rule: nonzero; opacity: 1;"
                                              transform=" matrix(1 0 0 1 0 0) " stroke-linecap="round"/>
                                        <circle cx="28.88" cy="74.33" r="6.16"
                                                style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill-rule: nonzero; opacity: 1;"
                                                transform="  matrix(1 0 0 1 0 0) "/>
                                        <circle cx="74.59" cy="74.33" r="6.16"
                                                style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill-rule: nonzero; opacity: 1;"
                                                transform="  matrix(1 0 0 1 0 0) "/>
                                        <path d="M 62.278 19.546 H 52.237 V 9.506 c 0 -1.933 -1.567 -3.5 -3.5 -3.5 s -3.5 1.567 -3.5 3.5 v 10.04 h -10.04 c -1.933 0 -3.5 1.567 -3.5 3.5 s 1.567 3.5 3.5 3.5 h 10.04 v 10.04 c 0 1.933 1.567 3.5 3.5 3.5 s 3.5 -1.567 3.5 -3.5 v -10.04 h 10.041 c 1.933 0 3.5 -1.567 3.5 -3.5 S 64.211 19.546 62.278 19.546 z"
                                              style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill-rule: nonzero; opacity: 1;"
                                              transform=" matrix(1 0 0 1 0 0) " stroke-linecap="round"/>
                                    </g>
								</svg>
                                </button>
                            </form>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>


    <t:serverPagination
            permanentParameters="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=${requestScope.orderObject.orderField}&orderType=${requestScope.orderObject.orderType}&searchValue=${requestScope.searchValue}"
            currentPage="${requestScope.medicineProducts.currentPage}"
            recordsPerPage="${requestScope.medicineProducts.recordsPerPage}"
            pagesNum="${requestScope.medicineProducts.pagesNum}"/>


</div>
<c:import url="/jsp/common/footer.jsp"/>
<script src="${pageContext.request.contextPath}/js/commonScript.js"></script>
</body>
</html>