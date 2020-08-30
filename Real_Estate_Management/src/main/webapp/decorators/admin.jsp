<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>Dashboard - Ace Admin</title>

    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />">
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/font-awesome/4.5.0/css/font-awesome.min.css' />">
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/fonts.googleapis.com.css' />">
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet"
        id="main-ace-style" />
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/my-styles.css' />">
    <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>

</head>

<body class="no-skin">
    <!-- Header -->
    <%@ include file="/common/admin/header.jsp" %>
    <!-- Header -->

    <div class="main-container ace-save-state" id="main-container">
        <script type="text/javascript">
            try { ace.settings.loadState('main-container') } catch (e) { }
        </script>

        <!-- Menu -->
        <%@ include file="/common/admin/menu.jsp" %>
        <!-- Menu -->

        <dec:body />

        <!-- Footer -->
        <%@ include file="/common/admin/footer.jsp" %>
        <!-- Footer -->
    </div>


    <script src="<c:url value='/template/admin/assets/js/jquery-2.1.4.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
    <script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
    <script src="<c:url value='/template/admin/js/building-list.js' />"></script>
    <script src="<c:url value='/template/admin/js/building-edit.js' />"></script>
    <script src="<c:url value='/template/admin/js/customer-list.js' />"></script>
    <script src="<c:url value='/template/admin/js/user-list.js' />"></script>
    <script src="<c:url value='/template/admin/js/priority-building-list.js' />"></script>
</body>

</html>