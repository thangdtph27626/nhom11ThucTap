<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>Material Design for Bootstrap</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
    <!-- MDB -->
    <link rel="stylesheet" href="../../css/mdb.min.css" />
    <!-- Custom styles -->
    <link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
<!--Main Navigation-->
<header>
    <!-- Jumbotron -->
    <div class="p-3 text-center bg-white border-bottom">
        <jsp:include page="./component/header.jsp"/>
        <!-- Jumbotron -->

        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-white">
            <!-- Container wrapper -->
            <div class="container justify-content-center justify-content-md-between">
                <!-- Toggle button -->
                <button
                        class="navbar-toggler border py-2 text-dark"
                        type="button"
                        data-mdb-toggle="collapse"
                        data-mdb-target="#navbarLeftAlignExample"
                        aria-controls="navbarLeftAlignExample"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                >
                    <i class="fas fa-bars"></i>
                </button>

                <!-- Collapsible wrapper -->
                <div class="collapse navbar-collapse" id="navbarLeftAlignExample">
                    <!-- Left links -->
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link text-dark" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="#">Categories</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="#">Hot offers</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="#">Gift boxes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="#">Projects</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="#">Menu item</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="#">Menu name</a>
                        </li>
                        <!-- Navbar dropdown -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-dark" href="#" id="navbarDropdown" role="button" data-mdb-toggle="dropdown" aria-expanded="false">
                                Others
                            </a>
                            <!-- Dropdown menu -->
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li>
                                    <a class="dropdown-item" href="#">Action</a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="#">Another action</a>
                                </li>
                                <li><hr class="dropdown-divider" /></li>
                                <li>
                                    <a class="dropdown-item" href="#">Something else here</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <!-- Left links -->
                </div>
            </div>
            <!-- Container wrapper -->
        </nav>
        <!-- Navbar -->
        <!-- Jumbotron -->
        <div class="bg-primary text-white py-5">
            <div class="container py-5">
                <h1>
                    Best products & <br />
                    brands in our store
                </h1>
                <p>
                    Trendy Products, Factory Prices, Excellent Service
                </p>
                <button type="button" class="btn btn-outline-light">
                    Learn more
                </button>
                <button type="button" class="btn btn-light shadow-0 text-primary pt-2 border border-white">
                    <span class="pt-1">Purchase now</span>
                </button>
            </div>
        </div>
        <!-- Jumbotron -->
</header>

<div class="row">
    <div class="row">
        <h2>History</h2>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">stt</th>
                <th scope="col">status</th>
                <th scope="col">action Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${billHistorys}" var="billHistory" varStatus="status">
                <tr>
                    <th>${status.index + 1}</th>
                    <th>${billHistory.statusBill}</th>
                    <td>${billHistory.actionDescription}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="row">
    <div class="card">
        <div class="card-body">
            <div class="container mb-5 mt-3">
                <div class="row d-flex align-items-baseline">
                    <div class="col-xl-9">
                        <p style="color: #7e8d9f;font-size: 20px;">Invoice >> <strong>Id: ${bill.code} </strong></p>
                    </div>
                    <hr>
                </div>

                <div class="container">


                    <div class="row">
                        <div class="col-xl-8">
                            <ul class="list-unstyled">
                                <li class="text-muted">full name: <span
                                        style="color:#5d9fc5 ;">${bill.userName}</span></li>
                                <li class="text-muted">method payment: ${payment.method}</li>
                                <li class="text-muted">status payment: ${payment.status}</li>
                                <li class="text-muted">transaction payment: ${payment.vnp_TransactionNo}</li>
                                <li class="text-muted">address: ${bill.address}</li>
                                <li class="text-muted"><i class="fas fa-phone"></i> ${bill.phoneNumber}</li>
                            </ul>
                        </div>
                        <div class="col-xl-4">
                            <p class="text-muted">Invoice</p>
                            <ul class="list-unstyled">
                                <li class="text-muted"><i class="fas fa-circle" style="color:#84B0CA ;"></i> <span
                                        class="fw-bold">ID: </span>${bill.code}</li>
                                <li class="text-muted"><i class="fas fa-circle" style="color:#84B0CA ;"></i> <span
                                        class="fw-bold">Creation Date: </span>${bill.createdDate}</li>
                                <li class="text-muted"><i class="fas fa-circle" style="color:#84B0CA ;"></i> <span
                                        class="me-1 fw-bold">Status:</span><span
                                        class="badge bg-warning text-black fw-bold">
                                    ${bill.statusBill}</span></li>
                            </ul>
                        </div>
                    </div>

                    <div class="row my-2 mx-1 justify-content-center">
                        <table class="table table-striped table-borderless">
                            <thead style="background-color:#84B0CA ;" class="text-white">
                            <tr>
                                <th scope="col">stt</th>
                                <th scope="col">product</th>
                                <th scope="col">color</th>
                                <th scope="col">size</th>
                                <th scope="col">quantity</th>
                                <th scope="col">price</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${billDetails}" var="billDetail" varStatus="status">
                                <tr>
                                    <th>${status.index + 1}</th>
                                    <th>${billDetail.nameProduct}</th>
                                    <td>${billDetail.nameColor}</td>
                                    <td>${billDetail.nameSize}</td>
                                    <td>${billDetail.quantity}</td>
                                    <td>${billDetail.price}</td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                    </div>
                    <div class="row">
                        <div class="col-8">
                        </div>
                        <div class="col-4">
                            <ul class="list-unstyled">
                                <li class="text-muted ms-3"><span
                                        class="text-black me-4">SubTotal</span${bill.totalMoney} VND</li>
                                <li class="text-muted ms-3 mt-2"><span
                                        class="text-black me-4">Item Discount</span>${bill.itemDiscount} VND
                                </li>
                                <li class="text-muted ms-3 mt-2"><span
                                        class="text-black me-4">Money Ship</span>${bill.moneyShip} VND
                                </li>
                            </ul>
                            <p class="text-black float-start"><span
                                    class="text-black me-3"> Total Amount</span><span
                                    style="font-size: 25px;">${ bill.totalMoney + bill.moneyShip - bill.itemDiscount}</span>
                            </p>
                        </div>
                    </div>
                    <hr>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<jsp:include page="./component/footer.jsp"/>
<!-- Footer -->
<!-- MDB -->
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/mdb.min.js"></script>
<!-- Custom scripts -->
</body>
</html>

