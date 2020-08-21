<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>
<c:url var="buildingURL" value="/admin-building?action=ADD" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Add Building</title>
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
                        <h2 class="header blue text-center">Thêm tòa nhà </h2>
                        <form class="form-horizontal" id="formEdit" role="form" method="POST" action="${buildingURL}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="name"> Tên tòa
                                    nhà
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="name" name="name" class="col-xs-10 col-sm-5" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="district"> Quận
                                </label>
                                <div class="col-sm-9">
                                    <select name="district" id="district" class="chosen-select">
                                        <option value="" selected disabled>Chọn quận</option>
                                        <option value="QUAN_1">1</option>
                                        <option value="QUAN_2">2</option>
                                        <option value="QUAN_3">3</option>
                                        <option value="QUAN_4">4</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="ward"> Phường
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="ward" name="ward" class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="street"> Đường
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="street" name="street" class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="numberOfBasement"> Số
                                    tầng hầm
                                </label>
                                <div class="col-sm-9">
                                    <input type="number" id="numberOfBasement" name="numberOfBasement"
                                        class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"> Loại tòa
                                    nhà
                                </label>
                                <div class="col-sm-9">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="buildingTypes" name="buildingTypes"
                                            value="TANG_TRET">
                                        Tầng trệt
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="buildingTypes" name="buildingTypes"
                                            value="NGUYEN_CAN">
                                        Nguyên căn
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="buildingTypes" name="buildingTypes" value="NOI_THAT">
                                        Nội thất
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="areaRent">
                                    Diện tích thuê
                                </label>
                                <div class="col-sm-9">
                                    <input type="number" id="areaRent" name="buildingArea" class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="costRent">
                                    Giá thuê
                                </label>
                                <div class="col-sm-9">
                                    <input type="number" id="costRent" name="costRent" class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="costDescription">
                                    Mô tả giá
                                </label>
                                <div class="col-sm-9">
                                    <textarea rows="4" id="costDescription" name="costDescription"
                                        class="col-xs-10 col-sm-5"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="serviceCost">
                                    Phí dịch vụ
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="serviceCost" name="serviceCost" class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="carCost">
                                    Phí ô tô
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="carCost" name="carCost" class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="motorbikeCost">
                                    Phí mô tô
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="motorbikeCost" name="motorbikeCost"
                                        class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="overtimeCost">
                                    Phí ngoài giờ
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="overtimeCost" name="overtimeCost" class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="electricityCost">
                                    Tiền điện
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="electricityCost" name="electricityCost"
                                        class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="deposit">
                                    Đặt cọc
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="deposit" name="deposit" class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="payment">
                                    Thanh toán
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="payment" name="payment" class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="timeRent">
                                    Thời hạn thuê
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="timeRent" name="timeRent" class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="timeDecorator">
                                    Thời gian trang trí
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="timeDecorator" name="timeDecorator"
                                        class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">

                                </label>
                                <div class="col-sm-9">
                                    <button type="submit" class="btn btn-primary" id="btnAddBuilding">Thêm tòa
                                        nhà</button>
                                    <button type="button" class="btn btn-danger">Hủy</button>
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