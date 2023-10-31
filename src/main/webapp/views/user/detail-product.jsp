<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
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
                    <a class="text-white"><u>detail product</u></a>
                </h6>
            </nav>
            <!-- Breadcrumb -->
        </div>
    </div>
    <!-- Heading -->
</header>

<!-- content -->
<section class="py-5">
    <div class="container">
        <div class="row gx-5">
            <aside class="col-lg-6">
                <div class="border rounded-4 mb-3 d-flex justify-content-center">
                    <a data-fslightbox="mygalley" class="rounded-4" target="_blank" data-type="image"
                       href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big.webp">
                        <img style="max-width: 100%; max-height: 100vh; margin: auto;" class="rounded-4 fit"
                             src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big.webp"/>
                    </a>
                </div>
                <div class="d-flex justify-content-center mb-3">
                    <a data-fslightbox="mygalley" class="border mx-1 rounded-2" target="_blank" data-type="image"
                       href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big1.webp"
                       class="item-thumb">
                        <img width="60" height="60" class="rounded-2"
                             src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big1.webp"/>
                    </a>
                    <a data-fslightbox="mygalley" class="border mx-1 rounded-2" target="_blank" data-type="image"
                       href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big2.webp"
                       class="item-thumb">
                        <img width="60" height="60" class="rounded-2"
                             src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big2.webp"/>
                    </a>
                    <a data-fslightbox="mygalley" class="border mx-1 rounded-2" target="_blank" data-type="image"
                       href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big3.webp"
                       class="item-thumb">
                        <img width="60" height="60" class="rounded-2"
                             src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big3.webp"/>
                    </a>
                    <a data-fslightbox="mygalley" class="border mx-1 rounded-2" target="_blank" data-type="image"
                       href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big4.webp"
                       class="item-thumb">
                        <img width="60" height="60" class="rounded-2"
                             src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big4.webp"/>
                    </a>
                    <a data-fslightbox="mygalley" class="border mx-1 rounded-2" target="_blank" data-type="image"
                       href="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big.webp"
                       class="item-thumb">
                        <img width="60" height="60" class="rounded-2"
                             src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/detail1/big.webp"/>
                    </a>
                </div>
                <!-- thumbs-wrap.// -->
                <!-- gallery-wrap .end// -->
            </aside>
            <main class="col-lg-6">
                <div class="ps-lg-3">
                    <h4 class="title text-dark">
                        ${product.name}
                    </h4>
                    <div class="d-flex flex-row my-3">
                        <div class="text-warning mb-1 me-2">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                            <span class="ms-1">
                4.5
              </span>
                        </div>
                        <span class="text-muted"><i class="fas fa-shopping-basket fa-sm mx-1"></i>154 orders</span>
                        <span class="text-success ms-2">In stock</span>
                    </div>

                    <div class="mb-3">
                        <span class="h5" id="priceProduct">${product.prices[0].price} VND</span>
                    </div>
                    <p>
                        Modern look and quality demo item is a streetwear-inspired collection that continues to break
                        away from the conventions of mainstream fashion. Made in Italy, these black and brown clothing
                        low-top shirts for
                        men.
                    </p>

                    <div class="row">
                        <dt class="col-3">Gender:</dt>
                        <dd class="col-9">${product.gender == 'NAM_VA_NU'? "nam và nữ" : product.gender == 'NAM' ? 'Nam' : 'Nữ'}</dd>

                        <dt class="col-3">Category</dt>
                        <dd class="col-9">${product.category}</dd>
                        <dt class="col-3">Quantity</dt>
                        <dd class="col-9" id="quantityProduct">${product.quantitys[0].quantity}</dd>
                        <dt class="col-3">Form</dt>
                        <dd class="col-9">${product.form}</dd>
                    </div>

                    <hr/>

                    <form action="/cart" method="post" >
                        <input type="hidden" name="idProduct" value="${id}" id="">
                        <div class="row mb-4">
                            <div class="col-md-4 col-6">
                                <label class="mb-2">Color</label>
                                <select class="form-select border border-secondary" id="myComboxColor" name="idColor"
                                        style="height: 35px;">
                                    <c:forEach items="${product.colors}" var="color">
                                        <option value="${color.id}">${color.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-4 col-6">
                                <label class="mb-2">Size</label>
                                <select class="form-select border border-secondary" id="myComboxSize" name="idSize"
                                        style="height: 35px;">
                                    <c:forEach items="${product.sizes}" var="size">
                                        <option value="${size.id}">${size.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <!-- col.// -->
                            <div class="col-md-4 col-6 mb-3">
                                <label class="mb-2 d-block">Quantity</label>
                                <div class="input-group mb-3" style="width: 170px;">
                                    <button class="btn btn-white border border-secondary px-3" type="button"
                                            id="button-addon1" data-mdb-ripple-color="dark"
                                            onclick="this.parentNode.querySelector('#inputNumber').stepDown()"
                                    >
                                        <i class="fas fa-minus"></i>
                                    </button>
                                    <input type="number" class="form-control text-center border border-secondary"
                                           aria-label="Example text with button addon"
                                           name="quantity" value="1"
                                           aria-describedby="button-addon1" id="inputNumber" min="1" />
                                    <button class="btn btn-white border border-secondary px-3" type="button"
                                            id="button-addon" data-mdb-ripple-color="dark"
                                            onclick="this.parentNode.querySelector('#inputNumber').stepUp()"
                                    >
                                        <i class="fas fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <a href="#" class="btn btn-warning shadow-0"> Buy now </a>
                        <button type="submit" class="btn btn-primary shadow-0"><i
                                class="me-1 fa fa-shopping-basket"></i> Add to cart
                        </button>
                        <a href="#" class="btn btn-light border border-secondary py-2 icon-hover px-3"> <i
                                class="me-1 fa fa-heart fa-lg"></i> Save </a>
                    </form>
                </div>
            </main>
        </div>
    </div>
</section>
<!-- content -->

<div class="row">

    <c:forEach items="${listProduct}" var="product">
        <div class="col-lg-3 col-md-6 col-sm-6 d-flex">
            <a href="/product-detail/${product.id}">
                <div class="card w-100 my-2 shadow-2-strong">
                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/10.webp"
                         class="card-img-top" style="aspect-ratio: 1 / 1"/>
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text">${product.priceMin} - ${product.priceMax}</p>
                        <div class="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
                            <a href="#!" class="btn btn-primary shadow-0 me-1">Add to cart</a>
                            <p class="btn btn-light border px-2 pt-2 icon-hover"
                               style="margin: 0px"> ${product.quantity} </p>
                        </div>
                    </div>
                </div>
            </a>
        </div>
    </c:forEach>
</div>

<!-- Footer -->
<jsp:include page="./component/footer.jsp"/>
<!-- Footer -->


<!-- MDB -->
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/mdb.min.js"></script>
<script>

    var quantitys = [
        <c:forEach items="${product.quantitys}" var="quantity">
        {quantity: ${quantity.quantity}, size: "${quantity.size}", color: "${quantity.color}"},
        </c:forEach>
    ];

    var prices = [
        <c:forEach items="${product.prices}" var="price">
        {price: ${price.price}, size: "${price.size}", color: "${price.color}"},
        </c:forEach>
    ];

    var sizes = [
        <c:forEach items="${product.sizes}" var="size">
        {id: "${size.id}", name: "${size.name}"},
        </c:forEach>
    ];

    function selectSize() {
        // Lấy ra id của giá trị được chọn trong combox
        var idSize = document.getElementById("myComboxSize").value;
        var idColor = document.getElementById("myComboxColor").value;
        var price = 0;
        prices.map(item => {
            console.log(item.color == idColor && item.size == idSize)
            if (item.color == idColor && item.size == idSize) {
                price = item.price
            }
        })
        document.getElementById("myComboxColor").addEventListener("change", selectColor);
        document.getElementById("priceProduct").textContent = price
        setQuantity()
    }

    selectColor()

    function selectColor() {
        // Lấy ra id của giá trị được chọn trong combox
        var idColor = document.getElementById("myComboxColor").value;

        const selectElement = document.getElementById("myComboxSize");
        const options = [];
        prices.map(item => {
            if (item.color == idColor) {
                sizes.map(item2 => {
                    if (item2.id == item.size) {
                        const option = document.createElement("option");
                        option.value = item2.id;
                        option.text = item2.name;
                        options.push(option);
                    }
                })
            }
        })

        selectElement.options.length = 0;

        for (const option of options) {
            selectElement.appendChild(option);
        }
    }

    setQuantity()

    function setQuantity() {
        var idSize = document.getElementById("myComboxSize").value;
        var idColor = document.getElementById("myComboxColor").value;
        var quantity = 0;
        quantitys.map(item => {
            if (item.color == idColor && item.size == idSize) {
                quantity = item.quantity
            }
        })
        document.getElementById("myComboxColor").addEventListener("change", selectColor);
        document.getElementById("quantityProduct").textContent = quantity

        const inputElement = document.getElementById("inputNumber");
        inputElement.setAttribute("max", quantity);
        inputElement.setAttribute("min", 1);
    }

    // Gắn sự kiện onchange cho combox
    document.getElementById("myComboxSize").addEventListener("change", selectSize);
    document.getElementById("myComboxColor").addEventListener("change", selectColor);
</script>
<!-- Custom scripts -->
</body>
</html>

