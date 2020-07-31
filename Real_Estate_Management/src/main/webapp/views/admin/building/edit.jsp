<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
                            <form class="form-horizontal" id="formEdit" role="form">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="name"> Tên tòa
                                        nhà
                                    </label>
                                    <div class="col-sm-9">
                                        <input type="text" id="name" name="name" class="col-xs-10 col-sm-5">
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
                                            <input type="checkbox" id="buildingTypes" name="buildingTypes"
                                                value="NOI_THAT">
                                            Nội thất
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="areaRent">
                                        Diện tích thuê
                                    </label>
                                    <div class="col-sm-9">
                                        <input type="number" id="areaRent" name="areaRent" class="col-xs-10 col-sm-5">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">

                                    </label>
                                    <div class="col-sm-9">
                                        <button type="button" class="btn btn-primary" id="btnAddBuilding">Thêm tòa
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