<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row gy-3">
        <!-- Left elements -->
        <div class="col-lg-2 col-sm-4 col-4">
        </div>
        <!-- Left elements -->

        <!-- Center elements -->
        <div class="order-lg-last col-lg-10 col-sm-8 col-8">
            <div class="d-flex float-end">
                <a href="/user/detail" class="me-1 border rounded py-1 px-3 nav-link d-flex align-items-center" target="_blank"> <i class="fas fa-user-alt m-1 me-md-2"></i><p class="d-none d-md-block mb-0">user</p> </a>
                <a href="/cart/cart-detail" class="border rounded py-1 px-3 nav-link d-flex align-items-center" target="_blank"> <i class="fas fa-shopping-cart m-1 me-md-2"></i><p class="d-none d-md-block mb-0">My cart</p> </a>


            </div>
            <!-- Center elements -->

            <!-- Right elements -->
            <div class="col-lg-10 col-md-12 col-12">
                <form action="/home/search" method="get">
                    <div class="input-group float-center">
                        <div class="form-outline">
                            <input type="search" style="border: 1px solid " id="form1" name="name" class="form-control" />
                            <label class="form-label" for="form1">Search</label>
                        </div>
                        <button type="submit" class="btn btn-primary shadow-0">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </form>

            </div>
            <!-- Right elements -->
        </div>
    </div>
</div>