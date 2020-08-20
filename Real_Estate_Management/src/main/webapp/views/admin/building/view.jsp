<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>View Building</title>
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
                <div class="page-header">
                    <h1>
                        Dashboard
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            overview &amp; stats
                        </small>
                    </h1>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <form class="form-horizontal" id="formEdit" role="form" method="POST"
                            action="${buildingApiURL}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="name"> Tên tòa
                                    nhà
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.name}
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="district"> Quận
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.district}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="ward"> Phường
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.ward}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="street"> Đường
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.street}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="numberOfBasement"> Số
                                    tầng hầm
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.numberOfBasement}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"> Loại tòa
                                    nhà
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.numberOfBasement}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="areaRent">
                                    Diện tích thuê
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.buildingArea}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="costRent">
                                    Giá thuê
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.costRent}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="costDescription">
                                    Mô tả giá
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.costDescription}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="serviceCost">
                                    Phí dịch vụ
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.serviceCost}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="carCost">
                                    Phí ô tô
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.carCost}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="motorbikeCost">
                                    Phí mô tô
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.motorbikeCost}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="overtimeCost">
                                    Phí ngoài giờ
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.overtimeCost}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="electricityCost">
                                    Tiền điện
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.electricityCost}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="deposit">
                                    Đặt cọc
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.deposit}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="payment">
                                    Thanh toán
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.payment}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="timeRent">
                                    Thời hạn thuê
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.timeRent}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="timeDecorator">
                                    Thời gian trang trí
                                </label>
                                <div class="col-sm-9">
                                    <div class="col-xs-10 col-sm-5 control-label" style="text-align: center;">
                                        ${building.timeDecorator}</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">

                                </label>
                                <div class="col-sm-9">

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