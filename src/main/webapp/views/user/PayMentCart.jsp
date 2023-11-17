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
                    <a href="/cart/cart-detail" class="text-white-50">2. Shopping cart</a>
                    <span class="text-white-50 mx-2"> > </span>
                    <a href="" class="text-white-50">3. Payment</a>
                </h6>
            </nav>
            <!-- Breadcrumb -->
        </div>
    </div>
    <!-- Heading -->
</header>

<section class="bg-light py-5">
    <div class="container">
        <div class="row">
            <div class="col-xl-8 col-lg-8 mb-4">
                <div class="card mb-4 border shadow-0">
                    <div class="p-4 d-flex justify-content-between">
                        <div class="">
                            <h5>Have an account?</h5>
                            <p class="mb-0 text-wrap " id="addressSelected">Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit</p>
                        </div>
                        <div class="d-flex align-items-center justify-content-center flex-column flex-md-row">
                            <button type="button" class="btn btn-primary" data-mdb-toggle="modal"
                                    data-mdb-target="#modall-my-Address" onclick="dataMyAddress()">
                                My address
                            </button>
                        </div>
                    </div>
                </div>
                <!-- Checkout -->
                <div class="card shadow-0 border">
                    <div class="p-4">
                        <h5 class="card-title mb-3">Guest checkout</h5>
                        <div class="row">
                            <div class="col-6 mb-3">
                                <p class="mb-0">full name</p>
                                <div class="form-outline">
                                    <input type="text" id="full-name" placeholder="Type here" class="form-control"/>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <p class="mb-0">Phone</p>
                                <div class="form-outline">
                                    <input type="tel" id="phone" placeholder="+84 " class="form-control"/>
                                </div>
                            </div>

                            <div class="col-12 mb-3">
                                <p class="mb-0">Note</p>
                                <div class="form-outline">
                                    <textarea name="" id="note" cols="30" style="width: 100%;"></textarea>
                                </div>
                            </div>
                        </div>

                        <div class="form-check">
                            <label class="form-check-label" >date of receipt of goods : <span id="dayShip"></span></label>
                        </div>

                        <hr class="my-4"/>
                        <h5 class="card-title mb-3">Payment methods</h5>
                        <div class="row mb-3">
                            <div class="col-lg-4 mb-3">
                                <!-- Default checked radio -->
                                <div class="form-check h-100 border rounded-3">
                                    <div class="p-3" onclick="paymentVnPay()">
                                        <input class="form-check-input" type="radio" name="flexRadioDefault"
                                               id="flexRadioDefault1"/>
                                        <label class="form-check-label" for="flexRadioDefault1">
                                            vnpay <br/>
                                            <small class="text-muted">total pay: ${totalPay} </small>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 mb-3">
                                <!-- Default radio -->
                                <div class="form-check h-100 border rounded-3">
                                    <div class="p-3">
                                        <input class="form-check-input" type="radio" name="flexRadioDefault"
                                               id="flexRadioDefault2" checked/>
                                        <label class="form-check-label" for="flexRadioDefault2">
                                            Payment on delivery <br/>
                                        </label>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-10">
                                <h5 class="card-title mb-3">Vouchers</h5>
                            </div>
                            <div class="col-2">
                                <button type="button" class="btn btn-primary" data-mdb-toggle="modal"
                                        data-mdb-target="#modal-voucher">
                                    Select Voucher
                                </button>
                            </div>
                        </div>
                        <div class="row">
                            <p id="voucherSelect"></p>
                        </div>
                    </div>
                </div>
                <!-- Checkout -->
            </div>
            <div class="col-xl-4 col-lg-4 d-flex justify-content-center justify-content-lg-end">
                <div class="ms-lg-4 mt-4 mt-lg-0" style="max-width: 320px;">
                    <h6 class="mb-3">Summary</h6>
                    <div class="d-flex justify-content-between">
                        <p class="mb-2">Total price:</p>
                        <p class="mb-2" id="totalBill">$195.90</p>
                    </div>
                    <div class="d-flex justify-content-between">
                        <p class="mb-2">Discount:</p>
                        <p class="mb-2 text-danger" id="Discount">0</p>
                    </div>
                    <div class="d-flex justify-content-between">
                        <p class="mb-2">Shipping cost:</p>
                        <p class="mb-2" id="shipCost">+ $14.00</p>
                    </div>
                    <hr/>
                    <div class="d-flex justify-content-between">
                        <p class="mb-2">Total price:</p>
                        <p class="mb-2 fw-bold" id="totalPrice">$149.90</p>
                    </div>

                    <div class="input-group mt-3 mb-4">
                        <button class="btn btn-light text-primary border" style="width: 450px;height: 46px;" onclick="saveBill()">Order</button>
                    </div>

                    <hr/>
                    <h6 class="text-dark my-4">Items in cart</h6>

                    <c:forEach items="${products}" var="product">
                        <div class="d-flex align-items-center mb-4">
                            <div class="me-3 position-relative">
              <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill badge-secondary">
                      ${product.quantity}
              </span>
                                <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/7.webp"
                                     style="height: 96px; width: 96x;" class="img-sm rounded border"/>
                            </div>
                            <div class="">
                                <a href="#" class="nav-link">
                                        ${product.name} <br/>
                                        ${product.nameColor}, ${product.nameSize}
                                </a>
                                <div class="price text-muted">Total: ${product.quantity} * ${product.price}</div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="modal fade" id="modal-voucher" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Vouchers</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <table class="table">
                    <tbody>
                    <c:forEach items="${vouchers}" var="voucher">
                        <tr style="height: 81px" onclick="selectedVoucher('${voucher.code}' ,  '${voucher.id}',${voucher.value})">
                            <td >${voucher.code} - ${voucher.name}</td>
                            <td >${voucher.value}</td>
                            <td >${voucher.quantity}</td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>

            </div>

        </div>
    </div>
</div>
<div class="modal fade" id="modall-add-Address" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Address</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" >
                </div>
                <div class="row mt-3">
                    <div class="col-3">
                        Province/City
                    </div>
                    <div class="col-9">
                        <select class="form-select" aria-label="Default select example" id="Province">
                            <option selected>Open this select menu</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-3 ">
                        District
                    </div>
                    <div class="col-9">
                        <select class="form-select" aria-label="Default select example" id="District">
                        </select>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-3">
                        Wards
                    </div>
                    <div class="col-9">
                        <select class="form-select" aria-label="Default select example" id="Wards">
                        </select>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="addAdress()">Save changes</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="modall-my-Address" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="">My address</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <table>
                        <thead>
                        </thead>
                        <tbody id="dataMyAddress">

                        </tbody>
                    </table>
                </div>
                <div class="row">
                    <button type="button" class="btn btn-primary" data-mdb-toggle="modal"
                            data-mdb-target="#modall-add-Address" onclick="showModalAddAdress()">
                        Add address
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer -->
<jsp:include page="./component/footer.jsp"/>
<!-- Footer -->
<%--<script type="text/javascript" src="../../js/jquery-3.5.1.js"></script>--%>
<%--<script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>--%>
<%--<script type="text/javascript" src="../../js/popper.min.js"></script>--%>
<%--&lt;%&ndash;<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"&ndash;%&gt;--%>
<%--&lt;%&ndash;        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"&ndash;%&gt;--%>
<%--&lt;%&ndash;        crossorigin="anonymous"></script>&ndash;%&gt;--%>
<%--<script src="https://c.min.js"></script>--%>
<!-- MDB -->
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
<script>
    var products = [
        <c:forEach items="${products}" var="product">
        {price: ${product.price}, quantity: ${product.quantity}},
        </c:forEach>
    ];
    var totalMoney = products.reduce((acc, product) => acc + (product.price * product.quantity), 0);
    var item = products.length
    document.getElementById("totalBill").textContent = totalMoney + "VND"



    function paymentVnPay() {
        const data = {
            vnp_Ammount: totalMoney,
            vnp_TxnRef: "${code}",
        };
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: 'http://localhost:8080/payment',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (responseData) {
                window.open(responseData.data, '_self')
            },
            error: function (e) {
                window.open(e.responseText, '_self')
            }
        });
    }

    // begin address
    var dataAddress = {
        district: "",
        province: "",
        ward: "",
        provinceId: "",
        toDistrictId: "",
        wardCode: "",
        line: ""
    }
    getAllProvince()

    function showModalAddAdress() {
        $("#modall-add-Address").modal("show");
        getAllProvince();
        const selectElementProvince = document.getElementById("Province");
        selectElementProvince.options.length = 0;
        const selectElementDistrict = document.getElementById("District");
        selectElementDistrict.options.length = 0;
        const selectElementWards = document.getElementById("Wards");
        selectElementWards.options.length = 0;
    }

    function getAllProvince() {

        const selectElementProvince = document.getElementById("Province");
        const options = [];
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: 'https://online-gateway.ghn.vn/shiip/public-api/master-data/province',
            dataType: 'json',
            headers: {
                "token": "d73043b1-2777-11ee-b394-8ac29577e80e",
            },
            success: function (responseData) {
                const option = document.createElement("option");
                option.value = ""
                option.text = "Open this select menu"
                options.push(option);
                responseData.data.map(item => {
                    const option = document.createElement("option");
                    option.value = item.ProvinceID + "," + item.ProvinceName;
                    option.text = item.ProvinceName
                    options.push(option);
                })
                selectElementProvince.options.length = 0;

                for (const option of options) {
                    selectElementProvince.appendChild(option);
                }
            },
            error: function (e) {
            }
        });

    }

    document.getElementById("Province").addEventListener("change", getAllDistrict);

    function getAllDistrict() {
        const selectElementDistrict = document.getElementById("District");
        var data = document.getElementById("Province").value
        console.log(data)
        const codeProvince = document.getElementById("Province").value.split(",")[0];
        dataAddress.provinceId = document.getElementById("Province").value.split(",")[0];
        dataAddress.province = document.getElementById("Province").value.split(",")[1];
        console.log(dataAddress)
        const options = [];
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: 'https://online-gateway.ghn.vn/shiip/public-api/master-data/district?province_id=' + codeProvince,
            dataType: 'json',
            headers: {
                "token": "d73043b1-2777-11ee-b394-8ac29577e80e",
            },
            success: function (responseData) {
                const option = document.createElement("option");
                option.value = ""
                option.text = "Open this select menu"
                options.push(option);
                responseData.data.map(item => {
                    const option = document.createElement("option");
                    option.value = item.DistrictID + "," + item.DistrictName;
                    option.text = item.DistrictName
                    options.push(option);
                })
                selectElementDistrict.options.length = 0;

                for (const option of options) {
                    selectElementDistrict.appendChild(option);
                }
            },
            error: function (e) {
            }
        });

    }

    document.getElementById("District").addEventListener("change", getAllWards);

    function getAllWards() {
        const selectElementWards = document.getElementById("Wards");
        const codeDistrict = document.getElementById("District").value.split(",")[0];
        dataAddress.toDistrictId = document.getElementById("District").value.split(",")[0];
        dataAddress.district = document.getElementById("District").value.split(",")[1];
        console.log(dataAddress)
        const options = [];
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: 'https://online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id=' + codeDistrict,
            dataType: 'json',
            headers: {
                "token": "d73043b1-2777-11ee-b394-8ac29577e80e",
            },
            success: function (responseData) {
                const option = document.createElement("option");
                option.value = ""
                option.text = "Open this select menu"
                options.push(option);
                responseData.data.map(item => {
                    const option = document.createElement("option");
                    option.value = item.WardCode + "," + item.WardName;
                    option.text = item.WardName
                    options.push(option);
                })
                selectElementWards.options.length = 0;

                for (const option of options) {
                    selectElementWards.appendChild(option);
                }
            },
            error: function (e) {
            }
        });

    }

    document.getElementById("Wards").addEventListener("change", changWard);

    function changWard() {
        dataAddress.wardCode = document.getElementById("Wards").value.split(",")[0];
        dataAddress.ward = document.getElementById("Wards").value.split(",")[1];
        dataAddress.line = document.getElementById("exampleFormControlInput1").value
        billRequest.address = dataAddress.line + ", "+dataAddress.ward +", "+ dataAddress.district+ ", "+ dataAddress.province
        console.log(dataAddress)
    }

    function addAdress() {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: 'http://localhost:8080/address',
            data: JSON.stringify(dataAddress),
            dataType: 'json',
            success: function (responseData) {
                dataAddress = {
                    district: "",
                    province: "",
                    ward: "",
                    provinceId: "",
                    toDistrictId: "",
                    wardCode: "",
                    line: ""
                }
                dataMyAddress()
                $("#modall-add-Address").modal("hide");

            },
            error: function (e) {
            }
        });
    }

    function dataMyAddress() {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: 'http://localhost:8080/address',
            dataType: 'json',
            success: function (responseData) {
                $("#dataMyAddress").html(responseData.map(function (address) {
                    return `
                <tr style="height: 81px;
                 padding-left: 13px;" onclick="selectAddress('` + address.province + `','` + address.district + `','` + address.ward + `',` + address.toDistrictId + `,` + address.wardCode + `)">
                <td>` + address.line + `,` + address.province + `,` + address.district + `,` + address.ward +  `</td>
                </tr>
                `
                }))
            },
            error: function (e) {
            }
        });
        $("#modall-my-Address").modal("show");
    }
    selectAddressInDataMyAddress()
    function selectAddressInDataMyAddress() {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: 'http://localhost:8080/address',
            dataType: 'json',
            success: function (responseData) {
                console.log(responseData)
                console.log(responseData.length)
                if (responseData.length == 0) {
                    document.querySelector("#addressSelected").textContent = "Please add your order address"
                } else {
                    document.querySelector("#addressSelected").textContent = responseData[0].line + ", " + responseData[0].ward + ", "+ responseData[0].district + ", "+ responseData[0].province
                    billRequest.address = responseData[0].line + ", " + responseData[0].ward + ", "+ responseData[0].district + ", "+ responseData[0].province
                    fetchAllDayShip(responseData[0].toDistrictId , responseData[0].wardCode)
                    fetchAllMoneyShip(responseData[0].toDistrictId , responseData[0].wardCode)
                }
            },
            error: function (e) {
            }
        });
    }

    function selectAddress(province, district, ward, to_district_id, to_ward_code) {
        document.querySelector("#addressSelected").textContent = province + ", " + district + ", " + ward
        fetchAllDayShip(to_district_id, to_ward_code)
        fetchAllMoneyShip(to_district_id, to_ward_code)
        $("#modall-my-Address").modal("hide");
    }

    function fetchAllDayShip(to_district_id, to_ward_code) {
        console.log(to_district_id + '    ' + to_ward_code)
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: 'https://online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/leadtime?from_district_id=1485&from_ward_code=1A0607&to_district_id=' + to_district_id + '&to_ward_code=' + to_ward_code + '&service_id=53320',
            dataType: 'json',
            headers: {
                "token": "d73043b1-2777-11ee-b394-8ac29577e80e",
                "shop_id": "4374133",
            },
            success: function (responseData) {
                document.querySelector("#dayShip").textContent = moment(responseData.data.leadtime * 1000).format('DD/MM/YYYY')
            },
            error: function (e) {
                console.log(e)
            }
        });
    }
     var moneyShip = 0;
    function fetchAllMoneyShip(to_district_id, to_ward_code) {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: 'https://online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/fee?service_type_id=2&insurance_value=&coupon&from_district_id=3440&height=15&length=15&weight=1000&width=15&to_district_id='+to_district_id+'&to_ward_code='+to_ward_code,
            dataType: 'json',
            headers: {
                "token": "d73043b1-2777-11ee-b394-8ac29577e80e",
                "shop_id": "4374133",
            },
            success: function (responseData) {
                document.querySelector("#shipCost").textContent =responseData.data.total
                moneyShip = responseData.data.total
                billRequest.moneyShip= responseData.data.total
                console.log(billRequest)
                totalPrice()
            },
            error: function (e) {
                console.log(e)
            }
        });
    }

    // end address
    var valueVouher = 0;
    var billRequest = {
        code: "${code}",
        phoneNumber: "",
        address: "",
        userName: "",
        itemDiscount: "",
        totalMoney: totalMoney,
        moneyShip: "",
        note: "",
        idVoucher: ""
    }
   function selectedVoucher(code,id, value){
       document.querySelector("#voucherSelect").textContent = 'You have selected a promotional code: ' + code
       document.querySelector("#Discount").textContent = value
       valueVouher = value
       totalPrice()
       billRequest.idVoucher = id
       billRequest.itemDiscount(value + "")
       $("#modal-voucher").modal("hide");
   }
   function totalPrice(){
       document.querySelector("#totalPrice").textContent = ((totalMoney + moneyShip) - valueVouher) + 'VND'
   }


   function saveBill() {
       billRequest.itemDiscount = moneyShip
       billRequest.userName = $("#full-name").val().trim();
       billRequest.phoneNumber = $("#phone").val().trim();
       billRequest.note = $("#note").val().trim();

       $.ajax({
           type: "POST",
           contentType: "application/json",
           url: 'http://localhost:8080/api/bill',
           data: JSON.stringify(billRequest),
           dataType: 'json',
           success: function (responseData) {
               window.open('/home', '_self')
           },
           error: function (e) {
           }
       });

   }

</script>
</body>
</html>

