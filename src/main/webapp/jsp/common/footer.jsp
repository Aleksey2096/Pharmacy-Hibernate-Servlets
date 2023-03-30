<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<jsp:useBean id="date" class="java.util.Date"/>


<footer class="footer">

    <div class="row">
        <ul>
            <li><a href="#"><fmt:message key="footer.aboutUs" bundle="${rb}"/></a></li>
            <li>|</li>
            <li><fmt:message key="footer.JoinUs" bundle="${rb}"/></li>
            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
            <li><a href="#"><i class="fa fa-youtube"></i></a></li>
            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
        </ul>
    </div>

    <div class="row">© 1996-<fmt:formatDate value="${date}" pattern="yyyy"/>, Huge Pharma <fmt:message
            key="footer.copyright" bundle="${rb}"/>.
    </div>

    <div class="row">
        <a href="#"><fmt:message key="footer.backToTop" bundle="${rb}"/></a>
    </div>

</footer>
