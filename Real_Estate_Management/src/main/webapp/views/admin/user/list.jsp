<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>
<c:url var="userURL" value="/admin-user" />

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
                <!-- Main Content -->
                <div class="row">
                    <!-- Search -->
                    <!-- <div class="widget-box widget-color-blue">
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
                                <form id="searchForm" action="${userURL}" method="GET">
                                    <div class="form-horizontal">
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <div>
                                                    <label for="userName">Tên tài khoản</label>
                                                    <input name="userName" type="text" id="userName"
                                                        class="form-control">
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div>
                                                    <label for="fullName">Họ và Tên</label>
                                                    <input name="fullName" type="text" id="fullName"
                                                        class="form-control">
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
                    </div> -->

                    <!-- Building Table -->
                    <div class="row">
                        <div class="col-xs-12">
                            <h2 class="header blue text-center margin-top-md">Danh sách người dùng </h2>

                            <c:if test="${sessionScope.role == 1}">
                                <!-- Buttons -->
                                <div class="clearfix">
                                    <div class="pull-right tableTools-container">
                                        <div class="dt-buttons btn-overlap btn-group">
                                            <a class="dt-button buttons-collection buttons-colvis btn btn-white btn-primary btn-bold"
                                                data-toggle="tooltip" title="Thêm"
                                                href="<c:url value='/admin-user?action=ADD'/>">
                                                <i class="fa fa-plus-circle bigger-110 blue" aria-hidden="true"></i>
                                            </a>
                                            <button
                                                class="dt-button buttons-collection buttons-colvis btn btn-white btn-primary btn-bold"
                                                data-toggle="tooltip" title="Xóa" id="deleteUser">
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
                                        <th>Tên tài khoản</th>
                                        <th>Họ và tên</th>
                                        <th>Thao tác</th>
                                    </tr>
                                </thead>

                                <tbody id="userList">
                                    <c:forEach var="item" items="${users}">
                                        <tr>
                                            <c:if test="${item.status == 1}">
                                                <td class="center">
                                                    <label class="pos-rel">
                                                        <input type="checkbox" class="ace" value="${item.id}"
                                                            id="checkbox_building_${item.id}">
                                                        <span class="lbl"></span>
                                                    </label>
                                                </td>
                                                <td>${item.userName}</td>
                                                <td>${item.fullName}</td>
                                                <td>
                                                    <div class="hidden-sm hidden-xs btn-group">
                                                        <a class="btn btn-xs btn-info" data-toggle="tooltip"
                                                            title="Nâng cấp"
                                                            href="<c:url value='/admin-user?action=EDIT&id=${item.id}'/>">
                                                            <i class=" ace-icon fa fa-edit bigger-120"></i>
                                                        </a>
                                                    </div>
                                                </td>
                                            </c:if>
                                            <c:if test="${item.status == 0}">
                                                <td class="center">

                                                </td>
                                                <td style="text-decoration-line: line-through;">${item.userName}</td>
                                                <td style="text-decoration-line: line-through;">${item.fullName}</td>
                                                <td>
                                                    <div class="hidden-sm hidden-xs btn-group">
                                                        <a class="btn btn-xs btn-danger" data-toggle="tooltip"
                                                            title="Khôi phục"
                                                            href="<c:url value='/admin-user?action=RESTORE&userId=${item.id}'/>">
                                                            <i class=" ace-icon fa fa-undo bigger-120"></i>
                                                        </a>
                                                    </div>
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>

</html>