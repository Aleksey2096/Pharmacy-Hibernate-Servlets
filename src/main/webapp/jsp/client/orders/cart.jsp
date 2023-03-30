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
    <title><fmt:message key="page.clientCartPage" bundle="${rb}"/></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mainTable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/data-pagination.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css">
</head>
<body>
<c:import url="/jsp/common/header.jsp"/>
<c:import url="/jsp/common/navbar.jsp"/>

<div class="main">


    <div class="cartRow">
        <div class="columnCart">

            <div id="emptyCartsContent"><fmt:message key="text.emptyCart" bundle="${rb}"/></div>

            <div class="mainTable" id="tableCartsDiv">

                <div class="cartCaption">
                    <span><fmt:message key="text.shoppingCart" bundle="${rb}"/></span>
                    <span id="shoppingCartSize">${requestScope.medicineProducts.size()} <fmt:message key="text.items"
                                                                                                     bundle="${rb}"/></span>
                </div>

                <div class="container">
                    <ul class="responsive-table carts" id="tableCarts">
                        <li class="table-header">
                            <div class="col col-1">&#8470;</div>
                            <div class="col col-2"><fmt:message key="table.id" bundle="${rb}"/></div>
                            <div class="col col-3"><fmt:message key="table.title" bundle="${rb}"/></div>
                            <div class="col col-4"><fmt:message key="table.dosage" bundle="${rb}"/></div>
                            <div class="col col-5"><fmt:message key="table.form" bundle="${rb}"/></div>
                            <div class="col col-6"><fmt:message key="table.price" bundle="${rb}"/></div>
                            <div class="col col-7"><fmt:message key="table.amountInStock" bundle="${rb}"/></div>
                            <div class="col col-8"></div>
                            <div class="col col-9"></div>
                        </li>
                        <c:forEach var="elem" items="${requestScope.medicineProducts}" varStatus="status">
                            <li class="table-row">
                                <div class="col col-1 rowNumbering">${status.count}</div>
                                <div class="col col-2">${elem.id}</div>
                                <div class="col col-3">${elem.medicineDTO.title}</div>
                                <div class="col col-4">${elem.dosage}</div>
                                <div class="col col-5">${elem.form}</div>
                                <div class="col col-6">${elem.price}</div>
                                <div class="col col-7">${elem.amount}</div>
                                <div class="col col-8">
                                    <form action="${pageContext.request.contextPath}/dispatcher" method="post"
                                          class="addToOrderForm">
                                        <input type="hidden" name="medicine_product_id" value="${elem.id}"/>
                                        <input type="hidden" name="price" value="${elem.price}"/>
                                        <input type="hidden" name="amount" value="${elem.amount}"/>
                                        <input type="hidden" name="title" value="${elem.medicineDTO.title}"/>
                                        <button type="submit" class="addToOrderButton">
                                            <svg class="addToOrderSign" xmlns="http://www.w3.org/2000/svg" width="35"
                                                 height="35" viewBox="0 0 3000 3000" xml:space="preserve">
						                    <g style="stroke: none; stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1;"
                                               transform="translate(1.4065934065934016 1.4065934065934016) scale(2.81 2.81)">
                                                <path d="M578.3,928.7h-476c-8.3,0-15.3-7-15.3-15.3V86.6c0-8.3,7-15.3,15.3-15.3c0,0,474.7,0,474.7,0v214.4c0,16.9,13.7,30.6,30.6,30.6h214.4l0,242.4c22.3,3.9,42.5,10.6,60.7,19.6c0.2,0.1,0.4,0.1,0.6,0.2V316.2c0-13.7-4.2-37.6-40.4-87c-21.3-29-50.9-62.9-83.4-95.5C726.8,101.3,693,71.7,664,50.4C614.6,14.2,590.7,10,577,10H102.3c-42.2,0-76.6,34.3-76.6,76.6v826.8c0,42.2,34.4,76.6,76.6,76.6h530.1C610.2,973.1,592.3,952.1,578.3,928.7z M638.2,107.7c22,17,48.5,40.1,77.9,69.5c29.4,29.4,52.4,55.9,69.4,77.9H638.2L638.2,107.7L638.2,107.7z"/>
                                                <path d="M528.2,712.6H230.7c-11.7,0-21.2-13.7-21.2-30.6c0-16.9,9.5-30.6,21.2-30.6h297.5c11.7,0,21.2,13.7,21.2,30.6C549.4,698.8,539.9,712.6,528.2,712.6z"/>
                                                <path d="M668.8,498.2H240.1c-16.9,0-30.6-13.7-30.6-30.6c0-16.9,13.7-30.6,30.6-30.6h428.7c16.9,0,30.6,13.7,30.6,30.6C699.5,484.5,685.7,498.2,668.8,498.2z"/>
                                                <path d="M639.1,633L639.1,633L639.1,633z"/>
                                                <path d="M770.9,583.2c-112.3,0-203.4,91-203.4,203.4c0,112.3,91,203.4,203.4,203.4c112.3,0,203.4-91,203.4-203.4C974.3,674.3,883.2,583.2,770.9,583.2z M881.5,818.1h-79.1l0,79.1c0,17.4-14.1,31.5-31.5,31.5c-17.5,0-31.5-14.1-31.5-31.5l0-79.1h-79.1c-17.4,0-31.5-14.1-31.5-31.5c0-17.4,14.1-31.5,31.5-31.5h79.1V676c0-17.4,14.1-31.5,31.5-31.5c17.4,0,31.6,14.1,31.5,31.5l0,79.1h79.1c17.4,0,31.5,14.1,31.5,31.5C913.1,804,898.9,818.2,881.5,818.1z"/>
                                            </g>
						                </svg>
                                        </button>
                                    </form>
                                </div>
                                <div class="col col-9">
                                    <form action="${pageContext.request.contextPath}/dispatcher" method="post"
                                          class="deleteFromCartForm">
                                        <input type="hidden" name="command" value="delete_from_cart">
                                        <input type="hidden" name="medicine_product_id" value="${elem.id}"/>
                                        <button type="submit" class="deleteButton">
                                            <svg class="deleteSign" viewBox="0 0 100 100">
                                                <line x1="0" y1="0" x2="100" y2="100" stroke-width="10"></line>
                                                <line x1="0" y1="100" x2="100" y2="0" stroke-width="10"></line>
                                            </svg>
                                        </button>
                                    </form>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>


        </div>


        <div class="columnOrder">

            <div id="emptyOrdersContent"><fmt:message key="text.addProductsToOrder" bundle="${rb}"/></div>


            <div class="mainTable" id="tableOrdersDiv">

                <div class="cartCaption">
                    <span><fmt:message key="text.orders" bundle="${rb}"/></span>
                    <span id="orderItemsSize">0 <fmt:message key="text.items" bundle="${rb}"/></span>
                </div>

                <div class="container">
                    <ul class="responsive-table cartOrders" id="tableOrders">
                        <li class="table-header">
                            <div class="col col-1">&#8470;</div>
                            <div class="col col-2"><fmt:message key="table.id" bundle="${rb}"/></div>
                            <div class="col col-3"><fmt:message key="table.title" bundle="${rb}"/></div>
                            <div class="col col-4"><fmt:message key="table.quantity" bundle="${rb}"/></div>
                            <div class="col col-5"><fmt:message key="table.sum" bundle="${rb}"/></div>
                            <div class="col col-6"></div>
                        </li>
                    </ul>
                </div>


                <form id="mainForm" class="cart" method="post" action="${pageContext.request.contextPath}/dispatcher">
                    <input type="hidden" name="command" value="make_order"/>

                    <input type="hidden" name="valueRequired"
                           value="<fmt:message key="text.valueRequired" bundle="${rb}"/>">
                    <input type="hidden" name="valueInvalid"
                           value="<fmt:message key="text.valueInvalid" bundle="${rb}"/>">


                    <div class="segment cart totalPrice">
                        <h4 class="cart"><fmt:message key="text.totalPrice" bundle="${rb}"/>: <span
                                id="totalPriceSpan"></span></h4>
                    </div>


                    <label class="cart">
                        <div class="segment cart">
                            <h4 class="cart"><fmt:message key="text.paymentCardNumber" bundle="${rb}"/></h4>
                            <span class="errorSpan"></span>
                        </div>
                        <input class="cart" type="text" placeholder="Payment card number" name="payment_card_number"
                               value="${requestScope.user.personalInfoDTO.paymentCardNumber}"/>
                    </label>
                    <label class="cart">
                        <div class="segment cart">
                            <h4 class="cart"><fmt:message key="text.contactPhone" bundle="${rb}"/></h4>
                            <span class="errorSpan"></span>
                        </div>
                        <input class="cart" type="text" placeholder="Contact phone" name="contact_phone"
                               value="${requestScope.user.personalInfoDTO.phone}"/>
                    </label>
                    <label class="cart">
                        <div class="segment cart">
                            <h4 class="cart"><fmt:message key="text.deliveryAddress" bundle="${rb}"/></h4>
                            <span class="errorSpan"></span>
                        </div>
                        <c:set var="address" scope="page" value="${requestScope.user.personalInfoDTO.addressDTO}"/>
                        <input class="cart" type="text" placeholder="Delivery address" name="delivery_address"
                               value="${address.postcode}, ${address.city}, ${address.street} ${address.house}, ${address.apartment}"/>
                    </label>
                    <button id="checkoutButton" class="red" type="button" onclick="validateCart()">
                        <i class="icon ion-md-lock"></i><fmt:message key="text.checkout" bundle="${rb}"/>
                    </button>
                </form>
            </div>


        </div>
    </div>


</div>
<c:import url="/jsp/common/footer.jsp"/>
<script src="${pageContext.request.contextPath}/js/cart.js"></script>
<script src="${pageContext.request.contextPath}/js/formValidation.js"></script>
</body>
</html>