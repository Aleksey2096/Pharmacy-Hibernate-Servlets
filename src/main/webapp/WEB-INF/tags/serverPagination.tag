<%@ tag pageEncoding="UTF-8" %>
<%@ tag body-content="empty" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<%@ attribute name="permanentParameters" required="true"
              rtexprvalue="true" type="java.lang.String" %>
<%@ attribute name="currentPage" required="true" rtexprvalue="true"
              type="java.lang.Integer" %>
<%@ attribute name="recordsPerPage" required="true" rtexprvalue="true"
              type="java.lang.Integer" %>
<%@ attribute name="pagesNum" required="true" rtexprvalue="true"
              type="java.lang.Integer" %>


<c:set var="recordsPerPageList" value="${[5,10,15,20]}"/>


<nav data-pagination>
    <c:choose>
        <c:when test="${currentPage eq 1}">
            <a class="chevron" href="#" disabled>
                <svg class="data-pagination" fill="#000000" id="Layer_1" xmlns="http://www.w3.org/2000/svg"
                     viewBox="0 0 407.436 407.436" xml:space="preserve" transform="matrix(-1, 0, 0, 1, 0, 0)"><polygon
                        points="112.814,0 91.566,21.178 273.512,203.718 91.566,386.258 112.814,407.436 315.869,203.718 "/>
                    </g></svg>
            </a>
        </c:when>
        <c:otherwise>
            <a class="chevron"
               href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">
                <svg class="data-pagination" fill="#000000" id="Layer_1" xmlns="http://www.w3.org/2000/svg"
                     viewBox="0 0 407.436 407.436" xml:space="preserve" transform="matrix(-1, 0, 0, 1, 0, 0)"><polygon
                        points="112.814,0 91.566,21.178 273.512,203.718 91.566,386.258 112.814,407.436 315.869,203.718 "/>
                    </g></svg>
            </a>
        </c:otherwise>
    </c:choose>
    <ul>
        <c:choose>
        <c:when test="${pagesNum lt 10}">
        <c:forEach begin="1" end="${pagesNum}" var="i">
        <c:choose>
        <c:when test="${currentPage ne i}">
        <li><a
                href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
            </c:when>
            <c:otherwise>
        <li class=current><a href="#">${i}</a>
            </c:otherwise>
            </c:choose>
            </c:forEach>
            </c:when>
            <c:when test="${currentPage le 4}">
            <c:forEach begin="1" end="7" var="i">
            <c:choose>
            <c:when test="${currentPage ne i}">
        <li><a
                href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
            </c:when>
            <c:otherwise>
        <li class=current><a href="#">${i}</a>
            </c:otherwise>
            </c:choose>
            </c:forEach>
        <li class="dots"><a href="#">...</a>
        <li><a
                href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${pagesNum}">${pagesNum}</a>
            </c:when>
            <c:when test="${pagesNum - currentPage lt 4}">
        <li><a
                href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=1">1</a>
        <li class="dots"><a href="#">...</a>
            <c:forEach
                    begin="${pagesNum-6}" end="${pagesNum}" var="i">
            <c:choose>
            <c:when test="${currentPage ne i}">
        <li><a
                href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
            </c:when>
            <c:otherwise>
        <li class=current><a href="#">${i}</a>
            </c:otherwise>
            </c:choose>
            </c:forEach>
            </c:when>
            <c:otherwise>
        <li><a
                href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=1">1</a>
        <li class="dots"><a href="#">...</a>
            <c:forEach
                    begin="${currentPage-2}" end="${currentPage+2}" var="i">
            <c:choose>
            <c:when test="${currentPage ne i}">
        <li><a
                href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
            </c:when>
            <c:otherwise>
        <li class=current><a href="#">${i}</a>
            </c:otherwise>
            </c:choose>
            </c:forEach>
        <li class="dots"><a href="#">...</a>
        <li><a
                href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${pagesNum}">${pagesNum}</a>
            </c:otherwise>
            </c:choose>
    </ul>
    <c:choose>
        <c:when test="${currentPage eq pagesNum}">
            <a class="chevron" href="#" disabled>
                <svg class="data-pagination" fill="#000000" id="Layer_1" xmlns="http://www.w3.org/2000/svg"
                     viewBox="0 0 407.436 407.436" xml:space="preserve"><polygon
                        points="112.814,0 91.566,21.178 273.512,203.718 91.566,386.258 112.814,407.436 315.869,203.718 "/></svg>
            </a>
        </c:when>
        <c:otherwise>
            <a class="chevron"
               href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">
                <svg class="data-pagination" fill="#000000" id="Layer_1" xmlns="http://www.w3.org/2000/svg"
                     viewBox="0 0 407.436 407.436" xml:space="preserve"><polygon
                        points="112.814,0 91.566,21.178 273.512,203.718 91.566,386.258 112.814,407.436 315.869,203.718 "/></svg>
            </a>
        </c:otherwise>
    </c:choose>


    <label for="recordsPerPage" class="recordsPerPage"> <fmt:message
            key="text.recordsPerPage" bundle="${rb}"/> <select
            id="recordsPerPage" class="recordsPerPage"
            onchange="document.location=this.options[this.selectedIndex].value">
        <c:forEach var="recordsPerPageItem" items="${recordsPerPageList}">
            <c:choose>
                <c:when test="${recordsPerPageItem eq recordsPerPage}">
                    <option selected hidden>${recordsPerPage}</option>
                </c:when>
                <c:otherwise>
                    <option
                            value="${permanentParameters}&recordsPerPage=${recordsPerPageItem}&currentPage=1">
                            ${recordsPerPageItem}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
    </label>
</nav>



