<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>


<nav role="navigation" class="primary-navigation">
    <hr class="hr-nav">
    <ul class="ul-nav ul-nav-main">
        <c:choose>
            <c:when test="${requestScope.command == 'read_paginated_users'}">
                <li class="li-nav disabled"><a href="#" class="a-nav"><fmt:message key="text.users" bundle="${rb}"/></a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="li-nav"><a href="${pageContext.request.contextPath}/dispatcher?command=read_paginated_users"
                                      class="a-nav"><fmt:message key="text.users" bundle="${rb}"/></a></li>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${requestScope.command == 'read_paginated_orders'}">
                <li class="li-nav disabled"><a href="#" class="a-nav"><fmt:message key="text.orders"
                                                                                   bundle="${rb}"/></a></li>
            </c:when>
            <c:otherwise>
                <li class="li-nav"><a href="${pageContext.request.contextPath}/dispatcher?command=read_paginated_orders"
                                      class="a-nav"><fmt:message key="text.orders" bundle="${rb}"/></a></li>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${requestScope.command == 'read_paginated_prescription_requests'}">
                <li class="li-nav disabled"><a href="#" class="a-nav"><fmt:message key="text.prescriptionRequests"
                                                                                   bundle="${rb}"/></a></li>
            </c:when>
            <c:otherwise>
                <li class="li-nav"><a
                        href="${pageContext.request.contextPath}/dispatcher?command=read_paginated_prescription_requests"
                        class="a-nav"><fmt:message key="text.prescriptionRequests" bundle="${rb}"/></a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>

