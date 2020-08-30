<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>
<c:url var="userURL" value="/admin-user?action=ADD" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Add User</title>
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
                        <h2 class="header blue text-center">Thêm tài khoản </h2>
                        <form class="form-horizontal" id="formEdit" role="form" method="POST" action="${userURL}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="username"> Tên tài khoản
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="username" name="username" class="col-xs-10 col-sm-5" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="password"> Mật khẩu
                                </label>
                                <div class="col-sm-9">
                                    <input type="password" id="password" name="password" class="col-xs-10 col-sm-5" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="fullname"> Tên đầy đủ
                                </label>
                                <div class="col-sm-9">
                                    <input type="text" id="fullname" name="fullname" class="col-xs-10 col-sm-5" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">

                                </label>
                                <div class="col-sm-9">
                                    <button type="submit" class="btn btn-primary" id="btnAddBuilding">Thêm tài
                                        khoản</button>
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