<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
<header>
    <!-- Jumbotron -->
    <div class="p-3 text-center bg-white border-bottom">
        <jsp:include page="./component/header.jsp"/>
    </div>
    <!-- Jumbotron -->

    <!-- Heading -->
    <div class="bg-primary">
        <div class="container py-4">
            <!-- Breadcrumb -->
            <nav class="d-flex">
                <h6 class="mb-0">
                    <a href="/home" class="text-white-50">Home</a>
                    <span class="text-white-50 mx-2"> > </span>
                    <a href="" class="text-white"><u>Shopping cart</u></a>
                </h6>
            </nav>
            <!-- Breadcrumb -->
        </div>
    </div>
    <!-- Heading -->
</header>

<!-- cart + summary -->
<section class="bg-light my-5">
    <div class="container">
        <div class="row">
            <!-- cart -->
            <div class="col-lg-9">
                <div class="card border shadow-0">
                    <div class="m-4">
                        <h4 class="card-title mb-4">Your shopping cart</h4>
                        <c:forEach items="${products}" var="product">
                            <form action="/cart/update-quantity" method="post">
                            <div class="row gy-3 mb-4">
                                 <input type="hidden" name="id" value="${product.id}">
                                <div class="col-lg-4">
                                    <div class="me-lg-5">
                                        <div class="d-flex">
                                            <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/11.webp"
                                                 class="border rounded me-3" style="width: 96px; height: 96px;"/>
                                            <div class="">
                                                <a href="#" class="nav-link">${product.name}</a>
                                                <p class="text-muted">${product.nameColor}, ${product.nameSize}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-sm-6 col-6 d-flex flex-row flex-lg-column flex-xl-row text-nowrap">
                                    <div class="row">
                                        <div class="col-6">
                                            <div class="row">
                                                <input type="number" class=" text-center border border-secondary col-lg-7"
                                                       aria-label="Example text with button addon"
                                                       name="quantity"
                                                       onchange="checkQuantity(this)"

                                                       aria-describedby="button-addon1" id="${product.quantity}" min="1" value="${product.quantity}" max="${product.quantityMax}"/>
                                                <button class="btn btn-white border border-secondary px-3 col-lg-5" type="submit"
                                                        id="button-addon" data-mdb-ripple-color="dark"

                                                >
                                                    Save
                                                </button>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <text class="h6">${product.price}</text>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-sm-6 d-flex justify-content-sm-center justify-content-md-start justify-content-lg-center justify-content-xl-end mb-2">
                                    <div class="float-md-end">
                                        <a href="#!" class="btn btn-light border px-2 icon-hover-primary"><i
                                                class="fas fa-heart fa-lg px-1 text-secondary"></i></a>
                                        <a href="/cart/delete/${product.id}" class="btn btn-light border text-danger icon-hover-danger">
                                            Remove</a>
                                    </div>
                                </div>
                            </div>
                            </form>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <!-- cart -->
            <!-- summary -->
                <div class="card shadow-0 border col-lg-3">
                    <div class="card-body">
                        <div class="d-flex justify-content-between">
                            <p class="mb-2">Total price:</p>
                            <p class="mb-2" id="total">0 VND</p>
                        </div>
                        <div class="d-flex justify-content-between">
                            <p class="mb-2">Number of products:</p>
                            <p class="mb-2 text-success" id="numberProduct">0</p>
                        </div>
<%--                        <div class="d-flex justify-content-between">--%>
<%--                            <p class="mb-2">TAX:</p>--%>
<%--                            <p class="mb-2">$14.00</p>--%>
<%--                        </div>--%>
<%--                        <hr/>--%>
<%--                        <div class="d-flex justify-content-between">--%>
<%--                            <p class="mb-2">Total price:</p>--%>
<%--                            <p class="mb-2 fw-bold">$283.00</p>--%>
<%--                        </div>--%>

                        <div class="mt-3">
                            <a href="/bill/payment" class="btn btn-success w-100 shadow-0 mb-2"> Make Purchase </a>
                            <a href="/home" class="btn btn-light w-100 border mt-2"> Back to shop </a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- summary -->
        </div>
    </div>
</section>
<!-- cart + summary -->
<%--<section>--%>
<%--    <div class="container my-5">--%>
<%--        <header class="mb-4">--%>
<%--            <h3>Recommended items</h3>--%>
<%--        </header>--%>

<%--        <div class="row">--%>
<%--            <div class="col-lg-3 col-md-6 col-sm-6">--%>
<%--                <div class="card px-4 border shadow-0 mb-4 mb-lg-0">--%>
<%--                    <div class="mask px-2" style="height: 50px;">--%>
<%--                        <div class="d-flex justify-content-between">--%>
<%--                            <h6><span class="badge bg-danger pt-1 mt-3 ms-2">New</span></h6>--%>
<%--                            <a href="#"><i class="fas fa-heart text-primary fa-lg float-end pt-3 m-2"></i></a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <a href="#" class="">--%>
<%--                        <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/7.webp"--%>
<%--                             class="card-img-top rounded-2"/>--%>
<%--                    </a>--%>
<%--                    <div class="card-body d-flex flex-column pt-3 border-top">--%>
<%--                        <a href="#" class="nav-link">Gaming Headset with Mic</a>--%>
<%--                        <div class="price-wrap mb-2">--%>
<%--                            <strong class="">$18.95</strong>--%>
<%--                            <del class="">$24.99</del>--%>
<%--                        </div>--%>
<%--                        <div class="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">--%>
<%--                            <a href="#" class="btn btn-outline-primary w-100">Add to cart</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-3 col-md-6 col-sm-6">--%>
<%--                <div class="card px-4 border shadow-0 mb-4 mb-lg-0">--%>
<%--                    <div class="mask px-2" style="height: 50px;">--%>
<%--                        <a href="#"><i class="fas fa-heart text-primary fa-lg float-end pt-3 m-2"></i></a>--%>
<%--                    </div>--%>
<%--                    <a href="#" class="">--%>
<%--                        <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/5.webp"--%>
<%--                             class="card-img-top rounded-2"/>--%>
<%--                    </a>--%>
<%--                    <div class="card-body d-flex flex-column pt-3 border-top">--%>
<%--                        <a href="#" class="nav-link">Apple Watch Series 1 Sport </a>--%>
<%--                        <div class="price-wrap mb-2">--%>
<%--                            <strong class="">$120.00</strong>--%>
<%--                        </div>--%>
<%--                        <div class="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">--%>
<%--                            <a href="#" class="btn btn-outline-primary w-100">Add to cart</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-3 col-md-6 col-sm-6">--%>
<%--                <div class="card px-4 border shadow-0">--%>
<%--                    <div class="mask px-2" style="height: 50px;">--%>
<%--                        <a href="#"><i class="fas fa-heart text-primary fa-lg float-end pt-3 m-2"></i></a>--%>
<%--                    </div>--%>
<%--                    <a href="#" class="">--%>
<%--                        <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/9.webp"--%>
<%--                             class="card-img-top rounded-2"/>--%>
<%--                    </a>--%>
<%--                    <div class="card-body d-flex flex-column pt-3 border-top">--%>
<%--                        <a href="#" class="nav-link">Men's Denim Jeans Shorts</a>--%>
<%--                        <div class="price-wrap mb-2">--%>
<%--                            <strong class="">$80.50</strong>--%>
<%--                        </div>--%>
<%--                        <div class="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">--%>
<%--                            <a href="#" class="btn btn-outline-primary w-100">Add to cart</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-3 col-md-6 col-sm-6">--%>
<%--                <div class="card px-4 border shadow-0">--%>
<%--                    <div class="mask px-2" style="height: 50px;">--%>
<%--                        <a href="#"><i class="fas fa-heart text-primary fa-lg float-end pt-3 m-2"></i></a>--%>
<%--                    </div>--%>
<%--                    <a href="#" class="">--%>
<%--                        <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/10.webp"--%>
<%--                             class="card-img-top rounded-2"/>--%>
<%--                    </a>--%>
<%--                    <div class="card-body d-flex flex-column pt-3 border-top">--%>
<%--                        <a href="#" class="nav-link">Mens T-shirt Cotton Base Layer Slim fit </a>--%>
<%--                        <div class="price-wrap mb-2">--%>
<%--                            <strong class="">$13.90</strong>--%>
<%--                        </div>--%>
<%--                        <div class="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">--%>
<%--                            <a href="#" class="btn btn-outline-primary w-100">Add to cart</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
<!-- Recommended -->

<!-- Footer -->
<jsp:include page="./component/footer.jsp"/>
<!-- Footer -->
<!-- MDB -->
<script type="text/javascript" src="../../js/mdb.min.js"></script>
<!-- Custom scripts -->
<script>

    var products = [
        <c:forEach items="${products}" var="product">
        {price: ${product.price}, quantity: ${product.quantity}},
        </c:forEach>
    ];
    var totalMoney = products.reduce((acc, product) => acc + (product.price * product.quantity), 0);
    var item = products.length
    document.getElementById("total").textContent = totalMoney + "VND"
    document.getElementById("numberProduct").textContent = item
    function checkQuantity(input) {
        let max = input.getAttribute("max");
         if (!Number.isInteger(input.value)) {
            input.value = input.id;
        }else if (input.value > max) {
            input.value = input.id;
        }
    }
</script>
</body>
</html>

