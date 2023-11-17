<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <title></title>
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
    <!-- Jumbotron -->

    <!-- Heading -->
    <div class="bg-primary mb-4">
        <div class="container py-4">
            <h3 class="text-white mt-2">Men's wear</h3>
            <!-- Breadcrumb -->
            <nav class="d-flex mb-2">
                <h6 class="mb-0">
                    <a href="" class="text-white-50">Home</a>
                    <span class="text-white-50 mx-2"> > </span>
                    <a href="" class="text-white-50">Library</a>
                    <span class="text-white-50 mx-2"> > </span>
                    <a href="" class="text-white"><u>Data</u></a>
                </h6>
            </nav>
            <!-- Breadcrumb -->
        </div>
    </div>
    <!-- Heading -->
</header>

<!-- sidebar + content -->
<section class="">
    <div class="container">
        <div class="row">
            <!-- sidebar -->
            <div class="col-lg-3">
                <!-- Toggle button -->
                <button
                        class="btn btn-outline-secondary mb-3 w-100 d-lg-none"
                        type="button"
                        data-mdb-toggle="collapse"
                        data-mdb-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                >
                    <span>Show filter</span>
                </button>
                <!-- Collapsible wrapper -->
                <div class="collapse card d-lg-block mb-5" id="navbarSupportedContent">
                    <div class="accordion" id="accordionPanelsStayOpenExample">
                        <form action="/home/search" method="get">
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="headingOne">
                                    <button
                                            class="accordion-button text-dark bg-light"
                                            type="button"
                                            data-mdb-toggle="collapse"
                                            data-mdb-target="#panelsStayOpen-collapseTwo"
                                            aria-expanded="true"
                                            aria-controls="panelsStayOpen-collapseTwo"
                                    >
                                        Colors
                                    </button>
                                </h2>
                                <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show"
                                     aria-labelledby="headingOne">
                                    <div class="accordion-body">
                                        <div>
                                            <c:forEach items="${colors}" var="color">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="color"
                                                           value="${color.id}"
                                                           id="flexCheckChecked1" />
                                                    <label class="form-check-label"
                                                           for="flexCheckChecked1">${color.name}</label>
                                                        <%--                                                    <span class="badge badge-secondary float-end">120</span>--%>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="headingTwo">
                                    <button
                                            class="accordion-button text-dark bg-light"
                                            type="button"
                                            data-mdb-toggle="collapse"
                                            data-mdb-target="#panelsStayOpen-collapseTwo"
                                            aria-expanded="true"
                                            aria-controls="panelsStayOpen-collapseTwo"
                                    >
                                        Categorys
                                    </button>
                                </h2>
                                <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse show"
                                     aria-labelledby="headingTwo">
                                    <div class="accordion-body">
                                        <div>
                                            <c:forEach items="${categorys}" var="category">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="category"
                                                           value="${category.id}"
                                                           id="flexCheckChecked1" />
                                                    <label class="form-check-label"
                                                           for="flexCheckChecked1">${category.name}</label>
<%--                                                    <span class="badge badge-secondary float-end">120</span>--%>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="headingThere">
                                    <button
                                            class="accordion-button text-dark bg-light"
                                            type="button"
                                            data-mdb-toggle="collapse"
                                            data-mdb-target="#panelsStayOpen-collapseTwo"
                                            aria-expanded="true"
                                            aria-controls="panelsStayOpen-collapseTwo"
                                    >
                                        Forms
                                    </button>
                                </h2>
                                <div id="panelsStayOpen-collaps" class="accordion-collapse collapse show"
                                     aria-labelledby="headingThere">
                                    <div class="accordion-body">
                                        <div>
                                            <c:forEach items="${forms}" var="form">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="form"
                                                           value="${form.id}"
                                                           id="flexCheckChecked1" />
                                                    <label class="form-check-label"
                                                           for="flexCheckChecked1">${form.name}</label>
                                                        <%--                                                    <span class="badge badge-secondary float-end">120</span>--%>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="heading4">
                                    <button
                                            class="accordion-button text-dark bg-light"
                                            type="button"
                                            data-mdb-toggle="collapse"
                                            data-mdb-target="#panelsStayOpen-collapseTwo"
                                            aria-expanded="true"
                                            aria-controls="panelsStayOpen-collapseTwo"
                                    >
                                        Sizes
                                    </button>
                                </h2>
                                <div id="panelsStayOpen-collaps4" class="accordion-collapse collapse show"
                                     aria-labelledby="heading4">
                                    <div class="accordion-body">
                                        <div>
                                            <c:forEach items="${sizes}" var="size">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="size"
                                                           value="${size.id}"
                                                           id="flexCheckChecked1" />
                                                    <label class="form-check-label"
                                                           for="flexCheckChecked1">${size.name}</label>
                                                        <%--                                                    <span class="badge badge-secondary float-end">120</span>--%>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="accordion-item">
                                <h2 class="accordion-header" >
                                    <button
                                            class="accordion-button text-dark bg-light"
                                            type="button"
                                            data-mdb-toggle="collapse"
                                            data-mdb-target="#panelsStayOpen-collapseThree"
                                            aria-expanded="false"
                                            aria-controls="panelsStayOpen-collapseThree"
                                    >
                                        Price
                                    </button>
                                </h2>
                                <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse show"
                                     aria-labelledby="headingThree">
                                    <div class="accordion-body">
                                        <div class="row mb-3">
                                            <div class="col-6">
                                                <p class="mb-0">
                                                    Min
                                                </p>
                                                <div class="form-outline">
                                                    <input type="number" name="priceMin" class="form-control"/>
                                                    <label class="form-label" for="typeNumber">$0</label>
                                                </div>
                                            </div>
                                            <div class="col-6">
                                                <p class="mb-0">
                                                    Max
                                                </p>
                                                <div class="form-outline">
                                                    <input type="number" id="typeNumber" class="form-control" name="priceMax"/>
                                                    <label class="form-label" for="typeNumber">$1,0000</label>
                                                </div>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-white w-100 border border-secondary">
                                            apply
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- sidebar -->
            <!-- content -->
            <div class="col-lg-9">
                <header class="d-sm-flex align-items-center border-bottom mb-4 pb-3">
                    <strong class="d-block py-2">${listProduct.size()} Items found </strong>
                    <div class="ms-auto">
                        <select class="form-select d-inline-block w-auto border pt-1">
                            <option value="0">Best match</option>
                            <option value="1">Recommended</option>
                            <option value="2">High rated</option>
                            <option value="3">Randomly</option>
                        </select>
                        <div class="btn-group shadow-0 border">
                            <a href="#" class="btn btn-light" title="List view">
                                <i class="fa fa-bars fa-lg"></i>
                            </a>
                            <a href="#" class="btn btn-light active" title="Grid view">
                                <i class="fa fa-th fa-lg"></i>
                            </a>
                        </div>
                    </div>
                </header>
                <div class="row">
                    <c:forEach items="${listProduct}" var="product">
                        <div class="col-lg-4 col-md-6 col-sm-6 d-flex">
                            <a href="/product-detail/${product.id}">
                                <div class="card w-100 my-2 shadow-2-strong">
                                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/10.webp"
                                         class="card-img-top" style="aspect-ratio: 1 / 1"/>
                                    <div class="card-body d-flex flex-column">
                                        <h5 class="card-title">${product.name}</h5>
                                        <p class="card-text">${product.priceMin} - ${product.priceMax}</p>
                                        <div class="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
                                            <a href="#!" class="btn btn-primary shadow-0 me-1">Add to cart</a>
                                            <p class="btn btn-light border px-2 pt-2 icon-hover" style="margin: 0px"> ${product.quantity} </p>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>

                <hr/>

                <!-- Pagination -->
<%--                <nav aria-label="Page navigation example" class="d-flex justify-content-center mt-3">--%>
<%--                    <ul class="pagination">--%>
<%--                        <li class="page-item disabled">--%>
<%--                            <a class="page-link" href="#" aria-label="Previous">--%>
<%--                                <span aria-hidden="true">&laquo;</span>--%>
<%--                            </a>--%>
<%--                        </li>--%>
<%--                        <li class="page-item active"><a class="page-link" href="#">1</a></li>--%>
<%--                        <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--                        <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--                        <li class="page-item"><a class="page-link" href="#">4</a></li>--%>
<%--                        <li class="page-item"><a class="page-link" href="#">5</a></li>--%>
<%--                        <li class="page-item">--%>
<%--                            <a class="page-link" href="#" aria-label="Next">--%>
<%--                                <span aria-hidden="true">&raquo;</span>--%>
<%--                            </a>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                </nav>--%>
                <!-- Pagination -->
            </div>
        </div>
    </div>
</section>
<!-- sidebar + content -->

<!-- Footer -->
<jsp:include page="./component/footer.jsp"/>
<!-- Footer -->
<!-- MDB -->
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/mdb.min.js"></script>
<!-- Custom scripts -->
</body>
</html>

