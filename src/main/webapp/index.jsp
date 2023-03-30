<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="languages.text" var="rb"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><fmt:message key="page.index" bundle="${rb}"/></title>
</head>
<body>
<%-- 	<c:redirect url="/dispatcher"> --%>
<%-- 		<c:param name="command" value="read_paginated_client_medicines" /> --%>
<%-- 	</c:redirect> --%>

<jsp:forward page="/dispatcher">
    <jsp:param name="command" value="read_paginated_client_medicines"/>
</jsp:forward>

<%-- 	<form method="get" action="${pageContext.request.contextPath}/dispatcher"> --%>
<!-- 		<input type="hidden" name="command" value="read_paginated_client_medicines"> -->
<!-- 		<button type="submit">Go to home page!</button> -->
<!-- 	</form> -->

<%-- 	<form method="post" action="${pageContext.request.contextPath}/dispatcher" enctype="multipart/form-data"> --%>
<!-- 		<input type="hidden" name="command" value="save_test_image"> -->
<!--     	Choose a file: <input type="file" name="image" /> -->
<!--     	<input type="submit" value="Upload" /> -->
<!-- 	</form> -->
<%-- 	<img src="${pageContext.request.contextPath}${requestScope.photoPath}" alt="Jacket"> --%>
</body>
</html>
