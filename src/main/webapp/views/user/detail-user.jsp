<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <title>Material Design for Bootstrap</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css"/>
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"/>
    <!-- MDB -->
    <link rel="stylesheet" href="../../css/mdb.min.css"/>
    <!-- Custom styles -->
    <link rel="stylesheet" href="../../css/style.css"/>
</head>
<body>
<!--Main Navigation-->
<header>
    <!-- Jumbotron -->
    <div class="p-3 text-center bg-white border-bottom">
        <jsp:include page="./component/header.jsp"/>
    </div>
</header>

<section class="vh-100" style="background-color: #f4f5f7;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="row">
                <div class="card mb-3" style="border-radius: .5rem;">
                    <div class="row g-0">
                        <div class="col-md-4 gradient-custom text-center"
                             style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
                            <div class="row">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                                     alt="Avatar" class="img-fluid my-5" style="width: 70%;margin: auto;"/>
                                <h5>${user.fullName}</h5>
                                <i class="far fa-edit mb-5"></i>
                            </div>
                            <h6>Information</h6>
                            <hr class="mt-0 mb-4">
                            <div class="row pt-1">
                                <div class="row mb-3">
                                    <h6>Email</h6>
                                    <p class="text-muted">${user.email}</p>
                                </div>
                                <div class="row mb-3">
                                    <h6>Phone</h6>
                                    <p class="text-muted">${user.phoneNumber}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <div class="card-body p-4">
                                <h6>Address</h6>
                                <hr class="mt-0 mb-4">
                                <div class="row pt-1">
                                    <div class="col-6 mb-3">
                                        <h6>Recent</h6>
                                        <p class="text-muted">Lorem ipsum</p>
                                    </div>
                                    <div class="col-6 mb-3">
                                        <h6>Most Viewed</h6>
                                        <p class="text-muted">Dolor sit amet</p>
                                    </div>
                                </div>
                                <h6>Bill</h6>
                                <hr class="mt-0 mb-4">
                                <div class="row pt-1">
                                    <c:forEach items="${bills}" var="bill">
                                        <div class="row mt-6" style="border-radius: 5px; border: 1px solid #00bcd4 ">
                                            <div class="row">
                                                <div class="col-8">
                                                    <div class="row">
                                                        Order Id: ${bill.bill.code}
                                                    </div>
                                                    <div class="row">
                                                        Date: ${bill.bill.createdDate}
                                                    </div>
                                                </div>
                                                <div class="col-4">
                                                    <div class="row">
                                                        <button type="button"
                                                                style="border-radius: 5px; border: 1px solid red">cancel
                                                            order
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                            <hr class="mt-3">
                                            <div class="row">
                                                <div class="col-4" style="border-right: 2px solid #ccc">
                                                    <div class="row"
                                                         style="font-size: 16px; font-weight: 600; color: #ccc">
                                                        Contact
                                                    </div>
                                                    <div class="row">
                                                            ${bill.bill.userName}
                                                    </div>
                                                    <div class="row">
                                                        Phone: ${bill.bill.phoneNumber}
                                                    </div>
                                                </div>
                                                <div class="col-4" style="border-right: 2px solid #ccc">
                                                    <div class="row"
                                                         style="font-size: 16px; font-weight: 600; color: #ccc">
                                                        Shopping address
                                                    </div>
                                                    <div class="row">
                                                            ${bill.bill.address}
                                                    </div>
                                                </div>
                                                <div class="col-4">
                                                    <div class="row"
                                                         style="font-size: 16px; font-weight: 600; color: #ccc">
                                                        PayMent
                                                    </div>
                                                    <c:if test="${bill.paymentsMethod.status != 'TRA_SAU'}">
                                                        <div class="row">
                                                            PayMent vnpay: ${bill.paymentsMethod.totalMoney}
                                                        </div>
                                                        <div class="row">
                                                            Transaction: ${bill.paymentsMethod.vnp_TransactionNo}
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${bill.paymentsMethod.status == 'TRA_SAU'}">
                                                        <div class="row">
                                                            Payment on
                                                            delivery: ${bill.paymentsMethod.totalMoney + bill.bill.moneyShip}
                                                            VND
                                                        </div>
                                                        <div class="row">
                                                            ship: ${bill.bill.moneyShip} VND
                                                        </div>
                                                        <div class="row">
                                                            total bill: ${bill.bill.totalMoney} VND
                                                        </div>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <hr class="mt-3">
                                            <div class="row">
                                                <c:forEach items="${bill.billDetails}" var="billDetail">
                                                    <div class="col-6">
                                                        <div class="row"
                                                             style="border: 1px solid #00bcd4; border-radius: 5px; margin: 2px">
                                                            <div class="col-4">
                                                                <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/11.webp"
                                                                     class="border rounded me-3"
                                                                     style="width: 96px; height: 96px;"/>
                                                            </div>
                                                            <div class="col-8">
                                                                <div class="row">
                                                                    <p style="font-size: 18px; font-weight: 600">${billDetail.productDetail.product.name}</p>
                                                                </div>
                                                                <div class="row">
                                                                    <p class="">${billDetail.productDetail.color.name}, ${billDetail.productDetail.size.name}</p>
                                                                </div>
                                                                <div class="row">
                                                                    <p class="">${billDetail.productDetail.quantity}
                                                                        x ${billDetail.productDetail.price} VND</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>

<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.2/mdb.min.js"
></script>
<!-- PRISM -->
<script type="text/javascript" src="https://mdbgo.io/wojstan/mdb5-demo-free/dev/js/new-prism.js"></script>
<!-- MDB SNIPPET -->
<script type="text/javascript" src="https://mdbgo.io/wojstan/mdb5-demo-free/dev/js/dist/mdbsnippet.min.js"></script>
<!-- Custom scripts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
</body>
</html>