<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>

<header class="header">
    <div class="languageTag">


        <c:url value="/dispatcher?command=change_language" var="permanentRequestPart">
            <c:param name="previousRequestLink" value="/dispatcher?${pageContext.request.queryString}"></c:param>
        </c:url>


        <c:choose>
            <c:when test="${sessionScope.locale eq 'de_DE'}">
                <div class="select-box">
                    <div class="select-box__current" tabindex="1">
                        <div class="select-box__value">
                            <input class="select-box__input" type="radio" checked="checked"/>
                            <p class="select-box__input-text">DE</p>
                        </div>
                        <img class="select-box__icon" src="${pageContext.request.contextPath}/img/img_295694.svg"
                             alt="Arrow Icon" aria-hidden="true"/>
                    </div>
                    <ul class="select-box__list">
                        <li>
                            <label class="select-box__option" aria-hidden="aria-hidden"
                                   onclick="document.location='${permanentRequestPart}&locale=es_ES'">Español</label>
                        </li>
                        <li>
                            <label class="select-box__option" aria-hidden="aria-hidden"
                                   onclick="document.location='${permanentRequestPart}&locale=en_US'">English</label>
                        </li>
                        <li>
                            <label class="select-box__option" aria-hidden="aria-hidden"
                                   onclick="document.location='${permanentRequestPart}&locale=ru_RU'">Русский</label>
                        </li>
                    </ul>
                </div>
            </c:when>
            <c:when test="${sessionScope.locale eq 'es_ES'}">
                <div class="select-box">
                    <div class="select-box__current" tabindex="1">
                        <div class="select-box__value">
                            <input class="select-box__input" type="radio" checked="checked"/>
                            <p class="select-box__input-text">ES</p>
                        </div>
                        <img class="select-box__icon" src="${pageContext.request.contextPath}/img/img_295694.svg"
                             alt="Arrow Icon" aria-hidden="true"/>
                    </div>
                    <ul class="select-box__list">
                        <li>
                            <label class="select-box__option" aria-hidden="aria-hidden"
                                   onclick="document.location='${permanentRequestPart}&locale=de_DE'">Deutsch</label>
                        </li>
                        <li>
                            <label class="select-box__option" aria-hidden="aria-hidden"
                                   onclick="document.location='${permanentRequestPart}&locale=en_US'">English</label>
                        </li>
                        <li>
                            <label class="select-box__option" aria-hidden="aria-hidden"
                                   onclick="document.location='${permanentRequestPart}&locale=ru_RU'">Русский</label>
                        </li>
                    </ul>
                </div>
            </c:when>
            <c:when test="${sessionScope.locale eq 'ru_RU'}">
                <div class="select-box">
                    <div class="select-box__current" tabindex="1">
                        <div class="select-box__value">
                            <input class="select-box__input" type="radio" checked="checked"/>
                            <p class="select-box__input-text">RU</p>
                        </div>
                        <img class="select-box__icon" src="${pageContext.request.contextPath}/img/img_295694.svg"
                             alt="Arrow Icon" aria-hidden="true"/>
                    </div>
                    <ul class="select-box__list">
                        <li>
                            <label class="select-box__option" aria-hidden="aria-hidden"
                                   onclick="document.location='${permanentRequestPart}&locale=de_DE'">Deutsch</label>
                        </li>
                        <li>
                            <label class="select-box__option" aria-hidden="aria-hidden"
                                   onclick="document.location='${permanentRequestPart}&locale=es_ES'">Español</label>
                        </li>
                        <li>
                            <label class="select-box__option" aria-hidden="aria-hidden"
                                   onclick="document.location='${permanentRequestPart}&locale=en_US'">English</label>
                        </li>
                    </ul>
                </div>
            </c:when>
            <c:otherwise>
                <div class="select-box">
                    <div class="select-box__current" tabindex="1">
                        <div class="select-box__value">
                            <input class="select-box__input" type="radio" checked="checked"/>
                            <p class="select-box__input-text">EN</p>
                        </div>
                        <img class="select-box__icon" src="${pageContext.request.contextPath}/img/img_295694.svg"
                             alt="Arrow Icon" aria-hidden="true"/>
                    </div>
                    <ul class="select-box__list">
                        <li>
                            <label class="select-box__option" aria-hidden="aria-hidden"
                                   onclick="document.location='${permanentRequestPart}&locale=de_DE'">Deutsch</label>
                        </li>
                        <li>
                            <label class="select-box__option" aria-hidden="aria-hidden"
                                   onclick="document.location='${permanentRequestPart}&locale=es_ES'">Español</label>
                        </li>
                        <li>
                            <label class="select-box__option" aria-hidden="aria-hidden"
                                   onclick="document.location='${permanentRequestPart}&locale=ru_RU'">Русский</label>
                        </li>
                    </ul>
                </div>
            </c:otherwise>
        </c:choose>
    </div>


    <div class="logo"><a
            href="${pageContext.request.contextPath}/dispatcher?command=read_paginated_client_medicines"><span
            class="companyName">Huge Pharma</span></a></div>


    <div class="loginTag">
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <fmt:message key="text.welcome" bundle="${rb}"/>&nbsp;<fmt:message key="text.guest" bundle="${rb}"/>&nbsp;
                <form class="loginForm" method="get" action="${pageContext.request.contextPath}/dispatcher">
                    <input type="hidden" name="command" value="get_login_form">
                    <input type="hidden" name="previousRequestLink"
                           value="/dispatcher?${pageContext.request.queryString}"/>
                    <button class="loginButton" type="submit"><fmt:message key="text.login" bundle="${rb}"/></button>
                </form>
            </c:when>
            <c:otherwise>
                <fmt:message key="text.welcome" bundle="${rb}"/>&nbsp;<c:out value="${sessionScope.user.login}"/>&nbsp;
                <form class="loginForm" method="get" action="${pageContext.request.contextPath}/dispatcher">
                    <input type="hidden" name="command" value="logout">
                    <button class="loginButton" type="submit"><fmt:message key="text.logout" bundle="${rb}"/></button>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</header>