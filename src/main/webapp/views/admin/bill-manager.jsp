<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="container">

    <div class="row">
        <form action="/admin/bill" method="get">
            <div class="row">
                Fillter
            </div>
            <div class="row mt-3">
                <div class="col-6 mt-3">
                    <div class="row">
                        <h2 class="">Search</h2>
                    </div>
                    <div class="row">
                        <input type="text" name="key" class="form-control" id="exampleFormControlInput1" placeholder="Hd333">
                    </div>
                </div>
                <div class="col-6 mt-3">
                    <div class="row">
                        Status
                    </div>
                    <div class="row">
                        <select class="form-select" name="status" aria-label="Default select example">
                            <option  value="" selected>Open this select menu</option>
                            <option value="CHO_XAC_NHAN">Chờ xác nhận</option>
                            <option value="XAC_NHAN">Xác nhận</option>
                            <option value="CHO_VAN_CHUYEN">Chờ vận chuyển</option>
                            <option value="VAN_CHUYEN">Vận chuyển</option>
                            <option value="DA_THANH_TOAN">Thanh toán</option>
                            <option value="THANH_CONG">thành công</option>
                            <option value="DA_HUY">Hủy</option>
                        </select>
                    </div>
                </div>
                <div class="col-6 mt-3">
                    <div class="row">
                        Start date
                    </div>
                    <div class="row">
                        <input type="date" name="startTimeString" class="form-control"  placeholder="Hd333">
                    </div>
                </div>
                <div class="col-6 mt-3">
                    <div class="row">
                        End date
                    </div>
                    <div class="row">
                        <input type="date" name="endTimeString" class="form-control"  placeholder="Hd333">
                    </div>
                </div>
            </div>
            <div class="row mt-3 offset-9">
                <button type="submit">Search</button>
            </div>
        </form>
    </div>
    <div class="row mt-6">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">stt</th>
                <th scope="col">code</th>
                <th scope="col">user name</th>
                <th scope="col">status</th>
                <th scope="col">total money</th>
                <th scope="col">item discount</th>
                <th scope="col">action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bills}" var="bill">
            <tr>
                <th scope="row">${bill.stt}</th>
                <td>${bill.code}</td>
                <td>${bill.userName}</td>
                <td>${bill.statusBill}</td>
                <td>${bill.totalMoney}</td>
                <td>${bill.itemDiscount}</td>
                <td><a href="/admin/bill/${bill.id}">detail</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>