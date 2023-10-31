<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
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
<div class="container">
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
        <div class="row">
            <button type="button" class="col-2 btn btn-primary" data-mdb-toggle="modal" data-mdb-target="#exampleModal">
                change status
            </button>
            <div class="col-8"></div>
            <button type="button" class="col-2 btn btn-danger" data-mdb-toggle="modal" data-mdb-target="#cancelBill">
                cancel
            </button>
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


    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/admin/bill/change-status" method="post">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Confirm</h5>
                        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <input type="hidden" class="form-control" name="id" value="${bill.id}"
                                   aria-describedby="emailHelp">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">describe</label>
                            <textarea name="desc" id="" cols="30" style="width: 100%"></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="modal fade" id="cancelBill" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/admin/bill/cancel-bill" method="post">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Confirm</h5>
                        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <input type="hidden" class="form-control" name="id" value="${bill.id}"
                                   aria-describedby="emailHelp">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">describe</label>
                            <textarea name="desc" id="" cols="30" style="width: 100%"></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </form>
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
</body>
</html>