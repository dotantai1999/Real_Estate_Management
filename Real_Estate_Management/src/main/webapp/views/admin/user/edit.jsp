<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>
<c:url var="userURL" value="/admin-user?action=EDIT" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Edit User</title>
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
                        <h2 class="header blue text-center">Chỉnh sửa người dùng </h2>
                        <form class="form-horizontal" id="formEdit" role="form" method="POST" action="${userURL}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="userName"> Tên đăng nhập
                                </label>
                                <div class="col-sm-9">
                                    <input value="${user.userName}" type="text" id="userName" name="userName"
                                        class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="fullName"> Họ và Tên
                                </label>
                                <div class="col-sm-9">
                                    <input value="${user.fullName}" type="text" id="fullName" name="fullName"
                                        class="col-xs-10 col-sm-5">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">

                                </label>
                                <div class="col-sm-9">
                                    <button type="submit" class="btn btn-primary">Cập nhật người dùng</button>
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