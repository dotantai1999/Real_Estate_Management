<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>View Customer</title>
</head>

<body>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>
                    <li class="active">Dashboard</li>
                </ul><!-- /.breadcrumb -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <h2 class="header blue text-center">Xem chi tiết khách hàng </h2>
                        <form class="form-horizontal" id="formEdit" role="form" method="POST"
                            action="${buildingApiURL}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="name"> Họ và Tên
                                </label>
                                <div class="col-sm-9">
                                    <input value="${customer.name}" type="text" id="name" name="name"
                                        class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="address"> Địa chỉ
                                </label>
                                <div class="col-sm-9">
                                    <input value="${customer.address}" type="text" id="address" name="address"
                                        class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="phone"> Số điện thoại
                                </label>
                                <div class="col-sm-9">
                                    <input value="${customer.phone}" type="text" id="phone" name="address"
                                        class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="email"> Email
                                </label>
                                <div class="col-sm-9">
                                    <input value="${customer.email}" type="text" id="email" name="email"
                                        class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>