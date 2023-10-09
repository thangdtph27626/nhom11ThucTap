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
                                <div class="row">
                                    <div class="col-9">
                                        <h6>Address</h6>
                                    </div>
                                    <div class="col-3 mb-2">
                                        <div class="row">
                                            <button type="button" class=" btn btn-primary" data-mdb-toggle="modal"
                                                    data-mdb-target="#modall-add-Address" onclick="showModalAddAdress()">
                                                Add address
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <hr class="mt-0 mb-4">
                                <div class="row pt-1">
                                    <div class="row mb-3">
                                        <div class="row">
                                            <table class="table">
                                                <tbody id="dataMyAddress">

                                                </tbody>
                                            </table>
                                        </div>
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
    dataMyAddress()
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
                 padding-left: 13px;" >
                <td>` + address.line + `,` + address.province + `,` + address.district + `,` + address.ward +  `</td>
                <td ><button type="button" onclick="deleteAddress('`+address.id+`')" class="btn btn-danger">delete</button></td>
                </tr>
                `
                }))
            },
            error: function (e) {
            }
        });
        // $("#modall-my-Address").modal("show");
    }

    function deleteAddress(id) {
        console.log(id)
        $.ajax({
            type: "DELETE",
            contentType: "application/json",
            url: 'http://localhost:8080/address/' + id,
            success: function (responseData) {
                window.open("/user/detail", '_self');
            },
            error: function (e) {
            }
            }
        )
    }
</script>
</body>
</html>