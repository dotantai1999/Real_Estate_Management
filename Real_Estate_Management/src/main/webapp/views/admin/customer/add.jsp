<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>
<c:url var="customerURL" value="/admin-customer?action=ADD" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Add Customer</title>
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
                        <h2 class="header blue text-center">Thêm khách hàng </h2>
                        <form class="form-horizontal" id="formEdit" role="form" method="POST" action="${customerURL}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="name"> Tên đầy đủ
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="name" name="name" class="col-xs-10 col-sm-5" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="address"> Địa chỉ
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="address" name="address" class="col-xs-10 col-sm-5" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="phonenumber"> Số điện thoại
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="phonenumber" name="phonenumber" class="col-xs-10 col-sm-5" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="email"> Email
                                </label>
                                <div class="col-sm-9">
                                    <input type="email" id="email" name="email" class="col-xs-10 col-sm-5" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">

                                </label>
                                <div class="col-sm-9">
                                    <button type="submit" class="btn btn-primary" id="btnAddBuilding">Thêm khách
                                        hàng</button>
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