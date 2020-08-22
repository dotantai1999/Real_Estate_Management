<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>
<c:url var="buildingURL" value="/admin-building" />

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Danh sách tòa nhà</title>
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
                <!-- <div class="page-header">
                    <h1>
                        Dashboard
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            overview &amp; stats
                        </small>
                    </h1>
                </div> -->

                <!-- Main Content -->
                <div class="row">
                    <!-- Search -->
                    <div class="widget-box widget-color-blue">
                        <div class="widget-header">
                            <h4 class="widget-title">Tìm kiếm</h4>

                            <div class="widget-toolbar">
                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>
                        <div class="widget-body">
                            <div class="widget-main">
                                <form id="searchForm" action="${buildingURL}" method="GET">
                                    <div class="form-horizontal">
                                        <div class="form-group">
                                            <div class="col-sm-2">
                                                <div>
                                                    <label for="name">Tên tòa nhà</label>
                                                    <input name="name" type="text" id="name" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-2">
                                                <div>
                                                    <label for="buildingArea">Diện tích sàn</label>
                                                    <input name="buildingArea" type="number" id="buildingArea"
                                                        class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-2">
                                                <div>
                                                    <label for="district">Quận hiện có</label>
                                                    <select name="district" id="district"
                                                        class="chosen-select form-control">
                                                        <option value="" selected disabled>Chọn quận</option>
                                                        <option value="QUAN_1">1</option>
                                                        <option value="QUAN_2">2</option>
                                                        <option value="QUAN_3">3</option>
                                                        <option value="QUAN_4">4</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-sm-2">
                                                <div>
                                                    <label for="ward">Phường</label>
                                                    <input name="ward" type="text" id="ward" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-2">
                                                <div>
                                                    <label for="direction">Hướng</label>
                                                    <input type="text" id="direction" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-2">
                                                <div>
                                                    <label for="rank">Hạng</label>
                                                    <input type="number" id="rank" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-2">
                                                <div>
                                                    <label for="street">Đường</label>
                                                    <input name="street" type="text" id="street" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-2">
                                                <div>
                                                    <label for="baseNumber">Số tầng hầm </label>
                                                    <input name="numberOfBasement" type="number" id="baseNumber"
                                                        class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-2">
                                                <div>
                                                    <label for="areaFrom">Diện tích từ </label>
                                                    <input name="areaRentFrom" type="number" id="areaFrom"
                                                        class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-2">
                                                <div>
                                                    <label for="areaTo">Diện tích đến </label>
                                                    <input name="areaRentTo" type="number" id="areaTo"
                                                        class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-2">
                                                <div>
                                                    <label for="priceFrom">Giá thuê từ </label>
                                                    <input name="costRentFrom" type="number" id="priceFrom"
                                                        class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-2">
                                                <div>
                                                    <label for="priceTo">Giá thuê đến </label>
                                                    <input name="costRentTo" type="number" id="priceTo"
                                                        class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="manager">Tên quản lý</label>
                                                    <input type="text" id="manager" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="managerPhone">Điện thoại quản lý</label>
                                                    <input type="number" id="managerPhone" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="staff">Chọn nhân viên phụ trách</label>
                                                    <select name="staffId" id="staff"
                                                        class="chosen-select form-control">
                                                        <option value="" selected disabled>Chọn nhân viên phụ trách
                                                        </option>
                                                        <option value="">1</option>
                                                        <option value="">2</option>
                                                        <option value="">3</option>
                                                        <option value="">4</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-2">
                                                <input type="checkbox" class="margin-right-xs" name="type1" id="type1">
                                                <label for="type1">Tầng trệt</label>
                                            </div>
                                            <div class="col-sm-2">
                                                <input type="checkbox" class="margin-right-xs" name="type2" id="type2">
                                                <label for="type2">Nguyên căn</label>
                                            </div>
                                            <div class="col-sm-2">
                                                <input type="checkbox" class="margin-right-xs" name="type3" id="type3">
                                                <label for="type3">Nội thất</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-2">
                                                <button class="btn btn-primary" type="button" id="searchSubmit">
                                                    <i class="ace-icon fa fa-search bigger-110"></i>
                                                    Tìm kiếm
                                                </button>
                                            </div>
                                        </div>
                                        <input type="hidden" value="LIST" name="action">
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>

                    <!-- Building Table -->
                    <div class="row">
                        <div class="col-xs-12">
                            <h2 class="header blue text-center margin-top-md">Danh sách tòa nhà</h2>

                            <!-- Buttons -->
                            <div class="clearfix">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a class="dt-button buttons-collection buttons-colvis btn btn-white btn-primary btn-bold"
                                            data-toggle="tooltip" title="Thêm"
                                            href="<c:url value='/admin-building?action=ADD'/>">
                                            <i class="fa fa-plus-circle bigger-110 blue" aria-hidden="true"></i>
                                        </a>
                                        <button
                                            class="dt-button buttons-collection buttons-colvis btn btn-white btn-primary btn-bold"
                                            data-toggle="tooltip" title="Xóa" id="deleteBuilding">
                                            <i class=" fa fa-trash bigger-110 red"></i>
                                        </button>
                                    </div>
                                </div>
                            </div>

                            <!-- Results Search
                            <div class="table-header">
                                Results for "Latest Registered Domains"
                            </div> -->

                            <!-- Table -->
                            <table id="simple-table" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th class="center">
                                            <label class="pos-rel">
                                                <input type="checkbox" class="ace">
                                                <span class="lbl"></span>
                                            </label>
                                        </th>
                                        <th>Tên sản phẩm</th>
                                        <th>Địa chỉ</th>
                                        <th>Tên quản lý</th>
                                        <th>Số điện thoại</th>
                                        <th>Diện tích sàn</th>
                                        <th>Giá thuê</th>
                                        <th>Phí dịch vụ</th>
                                        <th>Thao tác</th>
                                    </tr>
                                </thead>

                                <tbody id="buildingList">
                                    <c:forEach var="item" items="${buildings}">
                                        <tr>
                                            <td class="center">
                                                <label class="pos-rel">
                                                    <input type="checkbox" class="ace" value="${item.id}"
                                                        id="checkbox_building_${item.id}">
                                                    <span class="lbl"></span>
                                                </label>
                                            </td>
                                            <td>${item.name}</td>
                                            <td>${item.street}</td>
                                            <td>${item.managerName}</td>
                                            <td>${item.managerPhone}</td>
                                            <td>${item.buildingArea}</td>
                                            <td>${item.costRent}</td>
                                            <td>${item.serviceCost}</td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <a class="btn btn-xs btn-success" data-toggle="tooltip"
                                                        title="Xem chi tiết"
                                                        href="<c:url value='/admin-building?action=VIEW&id=${item.id}'/>">
                                                        <i class="ace-icon fa fa-eye bigger-120"></i>
                                                    </a>

                                                    <a class="btn btn-xs btn-info" data-toggle="tooltip"
                                                        title="Chỉnh sửa"
                                                        href="<c:url value='/admin-building?action=EDIT&id=${item.id}'/>">
                                                        <i class=" ace-icon fa fa-edit bigger-120"></i>
                                                    </a>

                                                    <button class="btn btn-xs btn-danger" data-toggle="tooltip"
                                                        title="Giao tòa nhà" onclick="assignmentBuilding(${item.id})">
                                                        <i class=" ace-icon fa fa-bars bigger-120"></i>
                                                    </button>

                                                    <button class="btn btn-xs btn-warning" data-toggle="tooltip"
                                                        title="Thêm vào danh sách ưu tiên">
                                                        <i class="ace-icon fa fa-plus bigger-120"></i>
                                                    </button>
                                                </div>

                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="modal fade" id="assignmentBuildingModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Danh sách nhân viên</h4>
                    </div>
                    <div class="modal-body">
                        <table class="table table-hover" id="staffList">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th>Tên nhân viên</th>
                                    <th style="text-align: center">Chọn nhân viên</th>
                                </tr>
                            </thead>
                            <tbody id="assignmentBuildingTable">

                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" id="btnAssignBuilding">Giao tòa nhà</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                    </div>
                    <input type="hidden" id="buildingId">
                </div>

            </div>
        </div>
    </div>
</body>

</html>