<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>


<c:url value="/dispatcher?command=get_user_edit_form&health_care_card_number=${sessionScope.user.healthCareCardNumber}"
       var="editUserUrl">
    <c:param name="previousRequestLink" value="/dispatcher?${pageContext.request.queryString}"></c:param>
</c:url>


<c:if test="${not empty sessionScope.user}">
    <nav role="navigation" class="primary-navigation">
        <hr class="hr-nav">
        <ul class="ul-nav ul-nav-main">
            <c:choose>
                <c:when test="${requestScope.command == 'read_paginated_client_medicines' or requestScope.command == 'read_paginated_concrete_medicine_products'}">
                    <li class="li-nav disabled"><a href="#" class="a-nav"><fmt:message key="text.main"
                                                                                       bundle="${rb}"/></a></li>
                </c:when>
                <c:otherwise>
                    <li class="li-nav"><a
                            href="${pageContext.request.contextPath}/dispatcher?command=read_paginated_client_medicines"
                            class="a-nav"><fmt:message key="text.main" bundle="${rb}"/></a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${requestScope.command == 'read_cart'}">
                    <li class="li-nav disabled"><a href="#" class="a-nav"><fmt:message key="text.cart"
                                                                                       bundle="${rb}"/></a></li>
                </c:when>
                <c:otherwise>
                    <li class="li-nav"><a href="${pageContext.request.contextPath}/dispatcher?command=read_cart"
                                          class="a-nav"><fmt:message key="text.cart" bundle="${rb}"/></a></li>
                </c:otherwise>
            </c:choose>
            <li class="li-nav"><a href="${editUserUrl}" class="a-nav"><fmt:message key="text.myAccount"
                                                                                   bundle="${rb}"/></a></li>
            <c:choose>
                <c:when test="${requestScope.command == 'read_paginated_user_prescriptions'}">
                    <li class="li-nav disabled"><a href="#" class="a-nav"><fmt:message key="text.prescriptions"
                                                                                       bundle="${rb}"/></a></li>
                </c:when>
                <c:otherwise>
                    <li class="li-nav"><a
                            href="${pageContext.request.contextPath}/dispatcher?command=read_paginated_user_prescriptions"
                            class="a-nav"><fmt:message key="text.prescriptions" bundle="${rb}"/></a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${requestScope.command == 'read_paginated_user_prescription_requests'}">
                    <li class="li-nav disabled"><a href="#" class="a-nav"><fmt:message key="text.prescriptionRequests"
                                                                                       bundle="${rb}"/></a></li>
                </c:when>
                <c:otherwise>
                    <li class="li-nav"><a
                            href="${pageContext.request.contextPath}/dispatcher?command=read_paginated_user_prescription_requests"
                            class="a-nav"><fmt:message key="text.prescriptionRequests" bundle="${rb}"/></a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${requestScope.command == 'read_paginated_user_orders'}">
                    <li class="li-nav disabled"><a href="#" class="a-nav"><fmt:message key="text.purchaseHistory"
                                                                                       bundle="${rb}"/></a></li>
                </c:when>
                <c:otherwise>
                    <li class="li-nav"><a
                            href="${pageContext.request.contextPath}/dispatcher?command=read_paginated_user_orders"
                            class="a-nav"><fmt:message key="text.purchaseHistory" bundle="${rb}"/></a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${sessionScope.user.role == 'PHARMACIST'}">
                    <li class="li-nav"><a
                            href="${pageContext.request.contextPath}/dispatcher?command=read_paginated_producers"
                            class="a-nav special"><fmt:message key="text.pharmacistMenu" bundle="${rb}"/></a></li>
                </c:when>
                <c:when test="${sessionScope.user.role == 'ADMINISTRATOR'}">
                    <li class="li-nav"><a
                            href="${pageContext.request.contextPath}/dispatcher?command=read_paginated_users"
                            class="a-nav special"><fmt:message key="text.administratorMenu" bundle="${rb}"/></a></li>
                </c:when>
            </c:choose>
        </ul>
    </nav>
</c:if>


<!-- <nav role="navigation" class="primary-navigation"> -->
<!-- <hr class="hr-nav"> -->
<!-- <ul class="ul-nav ul-nav-main"> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">Work &dtrif;</a> -->
<!-- <ul class="dropdown ul-nav"> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">Web Development</a></li> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">Web Design</a></li> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">Illustration</a></li> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">Iconography</a></li> -->
<!-- </ul> -->
<!-- </li> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">Home</a></li> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">About</a></li> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">Contact</a></li> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">Work &dtrif;</a> -->
<!-- <ul class="dropdown ul-nav"> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">Web Development</a></li> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">Web Design</a></li> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">Illustration</a></li> -->
<!-- <li class="li-nav"><a href="#" class="a-nav">Iconography</a></li> -->
<!-- </ul> -->
<!-- </li> -->
<!-- </ul> -->
<!-- </nav> -->
