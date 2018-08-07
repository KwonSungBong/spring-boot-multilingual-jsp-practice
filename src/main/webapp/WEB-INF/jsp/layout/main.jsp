<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<tiles:importAttribute name="title"/>
<tiles:importAttribute name="stylesheets"/>
<tiles:importAttribute name="javascripts"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title}</title>

    <!-- Bootstrap core CSS-->
    <link href="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/static/lib/sb-admin/css/sb-admin.css" rel="stylesheet">

    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
</head>
<body id="page-top">

<tiles:insertAttribute name="header" />
<div id="wrapper">
    <tiles:insertAttribute name="sidebar" />
    <div id="content-wrapper">
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" />
    </div>
</div>

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <button id="logout-btn" class="btn btn-primary">Logout</button>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/chart.js/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/datatables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/static/lib/sb-admin/js/sb-admin.min.js"></script>

<script>
    $("#logout-btn").click(function() {
        $.ajax({
            method: "POST",
            url: "/rest/auth/logout",
            data: {}
        })
        .done(function(data) {
            if(data === "1") {
                location.href = "/login";
            } else {
                alert("로그아웃에 실패하였습니다.");
            }
        });
    });
</script>

<c:forEach var="script" items="${javascripts}">
    <script src="<c:url value="${script}"/>"></script>
</c:forEach>

</body>
</html>