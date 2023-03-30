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
    <title><fmt:message key="page.administratorUsersPage" bundle="${rb}"/></title>
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
<c:import url="/jsp/administrator/navbar.jsp"/>

<div class="main">


    <div class="mainTable">
        <div class="container">
            <ul class="responsive-table users">
                <li class="table-search">
                    <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                        <input type="hidden" name="command" value="${requestScope.command}">
                        <input type="hidden" name="orderField" value="${requestScope.orderObject.orderField}">
                        <input type="hidden" name="orderType" value="${requestScope.orderObject.orderType}">
                        <input type="hidden" name="recordsPerPage" value="${requestScope.users.recordsPerPage}">
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
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=healthCareCardNumber&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.users.recordsPerPage}&currentPage=${requestScope.users.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.healthCareCardNumber" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=healthCareCardNumber&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.users.recordsPerPage}&currentPage=${requestScope.users.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-3">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=login&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.users.recordsPerPage}&currentPage=${requestScope.users.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.login" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=login&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.users.recordsPerPage}&currentPage=${requestScope.users.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-4">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=role&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.users.recordsPerPage}&currentPage=${requestScope.users.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.role" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=role&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.users.recordsPerPage}&currentPage=${requestScope.users.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-5">
                    <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=joinedDate&orderType=asc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.users.recordsPerPage}&currentPage=${requestScope.users.currentPage}">∧</a>
                    </span>
                        <fmt:message key="table.joinedDate" bundle="${rb}"/>
                        <span class="sortSpan">
                        <a class="sortAnchor"
                           href="${pageContext.request.contextPath}/dispatcher?command=${requestScope.command}&orderField=joinedDate&orderType=desc&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.users.recordsPerPage}&currentPage=${requestScope.users.currentPage}">∨</a>
                    </span>
                    </div>
                    <div class="col col-6"><fmt:message key="table.avatarImage" bundle="${rb}"/></div>
                    <div class="col col-7"></div>
                    <div class="col col-8"></div>
                </li>
                <c:set var="previousRecordsNum" scope="page"
                       value="${(requestScope.users.currentPage-1)*requestScope.users.recordsPerPage}"/>
                <c:forEach var="elem" items="${requestScope.users.records}" varStatus="status">
                    <li class="table-row">
                        <div class="col col-1">${previousRecordsNum+status.count}</div>
                        <div class="col col-2">${elem.healthCareCardNumber}</div>
                        <div class="col col-3">${elem.login}</div>
                        <div class="col col-4">${elem.role}</div>
                        <div class="col col-5"><fmt:formatDate value="${elem.joinedDate}" pattern="MM-dd-yyyy"/></div>
                        <div class="col col-6"><img class="tableAvatar"
                                                    src="${pageContext.request.contextPath}${elem.avatarImagePath}">
                        </div>
                        <div class="col col-7">
                            <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                                <input type="hidden" name="command" value="get_user_edit_form">
                                <input type="hidden" name="previousRequestLink"
                                       value="/dispatcher?${pageContext.request.queryString}"/>
                                <input type="hidden" name="health_care_card_number" value=${elem.healthCareCardNumber}>
                                <button type="submit"><fmt:message key="table.edit" bundle="${rb}"/></button>
                            </form>
                        </div>
                        <div class="col col-8">
                            <form method="post" action="${pageContext.request.contextPath}/dispatcher">
                                <c:choose>
                                    <c:when test="${requestScope.users.records.size() > 1}">
                                        <input type="hidden" name="previousRequestLink"
                                               value="/dispatcher?${pageContext.request.queryString}"/>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="hidden" name="previousRequestLink"
                                               value="/dispatcher?command=${requestScope.command}&orderField=${requestScope.orderObject.orderField}&orderType=${requestScope.orderObject.orderType}&searchValue=${requestScope.searchValue}&recordsPerPage=${requestScope.users.recordsPerPage}&currentPage=${requestScope.users.currentPage-1}"/>
                                    </c:otherwise>
                                </c:choose>
                                <input type="hidden" name="command" value="delete_user">
                                <input type="hidden" name="health_care_card_number" value=${elem.healthCareCardNumber}>
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
            currentPage="${requestScope.users.currentPage}"
            recordsPerPage="${requestScope.users.recordsPerPage}"
            pagesNum="${requestScope.users.pagesNum}"/>


    <form class="addForm" method="post" action="${pageContext.request.contextPath}/dispatcher">
        <input type="hidden" name="command" value="get_user_create_form">
        <input type="hidden" name="previousRequestLink" value="/dispatcher?${pageContext.request.queryString}"/>
        <button class="red" type="submit"><i class="icon ion-md-lock"></i><fmt:message key="table.addNewUser"
                                                                                       bundle="${rb}"/></button>
    </form>


</div>
<c:import url="/jsp/common/footer.jsp"/>
</body>
</html>