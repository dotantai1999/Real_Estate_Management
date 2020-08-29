<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<div id="sidebar" class="sidebar responsive ace-save-state">
    <script type="text/javascript">
        try { ace.settings.loadState('sidebar') } catch (e) { }
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- /.sidebar-shortcuts -->

    <ul class="nav nav-list">
        <li class="active">
            <a href="<c:url value='/admin-building?action=LIST' />" class="dropdown-toggle">
                <i class="menu-icon fa fa-building"></i>
                <span class="menu-text"> QL Tòa Nhà </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>

            <ul class="submenu nav-hide" style="display: none;">
                <li class="">
                    <a href="<c:url value='/admin-building?action=LIST' />">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách tòa nhà
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-user"></i>
                <span class="menu-text">
                    QL Khách Hàng
                </span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu nav-hide" style="display: none;">
                <li class="">
                    <a href="<c:url value='/admin-customer?action=LIST' />">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách khách hàng
                    </a>

                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
        <c:if test="${sessionScope.role == 1}">
            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-users"></i>
                    <span class="menu-text">
                        QL Người Dùng
                    </span>

                    <b class="arrow fa fa-angle-down "></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu nav-hide" style="display: none;">
                    <li class="">
                        <a href="<c:url value='/admin-user?action=LIST'/>">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Danh sách người dùng
                        </a>

                    </li>
                </ul>
            </li>
        </c:if>
        <li class="">
            <a href="<c:url value='/admin-building/priority-list' />">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text">
                    DS Tòa Nhà Ưu Tiên
                </span>
            </a>

            <b class="arrow"></b>
        </li>
    </ul>


    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state"
            data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>