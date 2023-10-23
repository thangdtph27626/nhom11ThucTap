<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div class="row">
    <div class="col-6">
        <div id="columnchart_values" ></div>
    </div>
    <div class="col-6">
        <div id="piechart" ></div>
    </div>
</div>
<div class="row" style="margin-top: 20px">
    <table class="table align-middle mb-0 bg-white">
        <thead class="bg-light">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Sole</th>
            <th>Sale</th>
        </tr>
        </thead>
        <tbody>
<c:forEach items="${products}" var="product">
        <tr>
            <td>
                <div class="d-flex align-items-center">
                    <img
                            src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/10.webp"
                            alt=""
                            style="width: 45px; height: 45px"
                            class="rounded-circle"
                    />
                    <div class="ms-3">
                        <p class="fw-bold mb-1">${product.name}</p>
                    </div>
                </div>
            </td>
            <td>
                <p class="fw-normal mb-1">${product.price}</p>
            </td>
            <td>
                <span class="badge badge-success rounded-pill d-inline">${product.sold}</span>
            </td>
            <td>${product.sales}</td>
        </tr>
    </c:forEach>
        </tbody>
    </table>
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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: 'http://localhost:8080/admin/api/statistical',
            dataType: 'json',
            success: function (responseData) {

                const statusMapping = {
                    TAO_HOA_DON: "Tạo hóa đơn",
                    CHO_XAC_NHAN: "Chờ xác nhận",
                    CHO_VAN_CHUYEN: "Chờ vận chuyển",
                    VAN_CHUYEN: "vận chuyển",
                    DA_THANH_TOAN: "Đã thanh toán",
                    THANH_CONG: "Thành công",
                    TRA_HANG: "Trả hàng",
                    DA_HUY: "Đã Hủy",
                };

                const statusColors = {
                    TAO_HOA_DON: "#E46651",
                    CHO_XAC_NHAN: "#00D8FF",
                    CHO_VAN_CHUYEN: "#FFCE56",
                    VAN_CHUYEN: "#9C27B0",
                    DA_THANH_TOAN: "#41B883",
                    THANH_CONG: "#4CAF50",
                    TRA_HANG: "##FF5733",
                    DA_HUY: "#DD1B16",
                };

                const newDataPie = responseData.map(item => ({
                    category: statusMapping[item.statusBill] || item.statusBill, // Sử dụng mapping hoặc giữ nguyên nếu không tìm thấy
                    value: item.totalStatusBill,
                    color: statusColors[item.statusBill] || item.statusBill,
                }));
                const dataResponse = newDataPie.map(item => (
                    [
                        item.category, item.value
                    ]
                ))
                dataResponse.unshift(['Task', 'Status Bill'])
                console.log(dataResponse)
                var data = google.visualization.arrayToDataTable(dataResponse);

                var options = {
                    title: 'Trạng thái hóa đơn'
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                chart.draw(data, options);
            },
            error: function (e) {
            }
        });
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: 'http://localhost:8080/admin/api/statistical/product',
            dataType: 'json',
            success: function (responseData) {
                console.log(responseData)
                const dataResponse = responseData.map(item => (
                    [
                        moment(billDate).format("DD/MM"), item.totalProductDate, "color: #e5e4e2"
                    ]
                ))
                dataResponse.unshift( ["Element", "Density", { role: "style" } ],
                    [moment(1698067501705).format("DD/MM"), 8000, "#b87333"])
                console.log(dataResponse)
                var data = google.visualization.arrayToDataTable(dataResponse);

                var view = new google.visualization.DataView(data);
                view.setColumns([0, 1,
                    { calc: "stringify",
                        sourceColumn: 1,
                        type: "string",
                        role: "annotation" },
                    2]);

                var options = {
                    title: "Transactions product",
                    width: 600,
                    height: 400,
                    bar: {groupWidth: "95%"},
                    legend: { position: "none" },
                };
                var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
                chart.draw(view, options);
            },
            error: function (e) {
            }
        });
    }
</script>
</body>
</html>
