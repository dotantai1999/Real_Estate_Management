<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>
<c:url var="customerURL" value="/admin-customer" />

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Danh sách khách hàng</title>
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
                                <form id="searchForm" action="${customerURL}" method="GET">
                                    <div class="form-horizontal">
                                        <div class="form-group">
                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="name">Tên khách hàng</label>
                                                    <input name="name" type="text" id="name" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="phone">Di động</label>
                                                    <input name="phone" type="text" id="phone" class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div>
                                                    <label for="email">Email</label>
                                                    <input name="email" type="email" id="email" class="form-control">
                                                </div>
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
                            <h2 class="header blue text-center margin-top-md">Danh sách khách hàng </h2>

                            <c:if test="${sessionScope.role == 1}">
                                <!-- Buttons -->
                                <div class="clearfix">
                                    <div class="pull-right tableTools-container">
                                        <div class="dt-buttons btn-overlap btn-group">
                                            <a class="dt-button buttons-collection buttons-colvis btn btn-white btn-primary btn-bold"
                                                data-toggle="tooltip" title="Thêm"
                                                href="<c:url value='/admin-customer?action=ADD'/>">
                                                <i class="fa fa-plus-circle bigger-110 blue" aria-hidden="true"></i>
                                            </a>
                                            <button
                                                class="dt-button buttons-collection buttons-colvis btn btn-white btn-primary btn-bold"
                                                data-toggle="tooltip" title="Xóa" id="deleteCustomer">
                                                <i class=" fa fa-trash bigger-110 red"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

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
                                        <th>Tên</th>
                                        <th>Địa chỉ</th>
                                        <th>Số Điện Thoại</th>
                                        <th>Email</th>
                                        <th>Thao tác</th>
                                    </tr>
                                </thead>

                                <tbody id="customerList">
                                    <c:forEach var="item" items="${customers}">
                                        <tr>
                                            <td class="center">
                                                <label class="pos-rel">
                                                    <input type="checkbox" class="ace" value="${item.id}"
                                                        id="checkbox_building_${item.id}">
                                                    <span class="lbl"></span>
                                                </label>
                                            </td>
                                            <td>${item.name}</td>
                                            <td>${item.address}</td>
                                            <td>${item.phone}</td>
                                            <td>${item.email}</td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <a class="btn btn-xs btn-success" data-toggle="tooltip"
                                                        title="Xem chi tiết"
                                                        href="<c:url value='/admin-customer?action=VIEW&id=${item.id}'/>">
                                                        <i class="ace-icon fa fa-eye bigger-120"></i>
                                                    </a>
                                                    <c:if test="${sessionScope.role == 1}">
                                                        <a class="btn btn-xs btn-info" data-toggle="tooltip"
                                                            title="Chỉnh sửa"
                                                            href="<c:url value='/admin-customer?action=EDIT&id=${item.id}'/>">
                                                            <i class=" ace-icon fa fa-edit bigger-120"></i>
                                                        </a>
                                                        <button class="btn btn-xs btn-danger" data-toggle="tooltip"
                                                            title="Giao tòa nhà"
                                                            onclick="assignmentBuilding(${item.id})">
                                                            <i class=" ace-icon fa fa-bars bigger-120"></i>
                                                        </button>
                                                    </c:if>
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
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Nguyễn Văn A</td>
                                    <td class="text-center"><input type="checkbox" value="1" id="checkbox_staff_1"></td>
                                </tr>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Nguyễn Văn A</td>
                                    <td class="text-center"><input type="checkbox" value="2" id="checkbox_staff_2"></td>
                                </tr>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Nguyễn Văn A</td>
                                    <td class="text-center"><input type="checkbox" value="3" id="checkbox_staff_3"></td>
                                </tr>

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