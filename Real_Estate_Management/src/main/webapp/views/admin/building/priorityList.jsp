<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Priority Buildings</title>
</head>

<body>
    <div class="main-content">
        <div class="main-content-inner">

            <div class="page-content">

                <div class="row">
                    <div class="col-xs-12">
                        <h2 class="header blue text-center margin-top-md">Danh Sách Tòa Nhà Ưu Tiên</h2>

                        <!-- Buttons -->
                        <div class="clearfix">
                            <div class="pull-right tableTools-container">
                                <div class="dt-buttons btn-overlap btn-group">
                                    <button
                                        class="dt-button buttons-collection buttons-colvis btn btn-white btn-primary btn-bold"
                                        data-toggle="tooltip" title="Xóa" id="deletePriorityBuilding">
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
                                    <th>Diện tích sàn</th>
                                    <th>Giá thuê</th>
                                    <th>Phí dịch vụ</th>
                                    <th>Thao tác</th>
                                </tr>
                            </thead>

                            <tbody id="priorityBuildingList">
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
                                        <td>${item.street} ${item.ward} ${item.district}</td>
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
</body>

</html>