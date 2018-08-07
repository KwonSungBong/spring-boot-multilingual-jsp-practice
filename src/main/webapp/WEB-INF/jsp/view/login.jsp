<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>${title}</title>

    <!-- Bootstrap core CSS-->
    <link href="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/static/lib/sb-admin/css/sb-admin.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
            <form>
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="required" autofocus="autofocus" value="rnjstjdqhd39@naver.com">
                        <label for="inputEmail">Email address</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="required" value="password">
                        <label for="inputPassword">Password</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me">
                            Remember Password
                        </label>
                    </div>
                </div>
                <button id="login-btn" class="btn btn-primary btn-block">Login</button>
            </form>
            <div class="text-center">
                <a class="d-block small mt-3" href="#">Register an Account</a>
                <a class="d-block small" href="#">Forgot Password?</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/static/lib/sb-admin/vendor/jquery-easing/jquery.easing.min.js"></script>
<script>

    $("#login-btn").click(function() {
        $.ajax({
            method: "POST",
            url: "/rest/auth/login",
            data: { email: $("#inputEmail").val(), password: $("#inputPassword").val() }
        })
        .done(function(data) {
            console.log(data);
            if(data === "1") {
                location.href = "/";
            } else {
                alert("로그인에 실패하였습니다.");
            }
        });
    });

</script>
</body>
</html>
