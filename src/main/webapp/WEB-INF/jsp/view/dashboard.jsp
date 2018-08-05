<%@ include file="../include/taglibs.jsp"%>

<div class="container-fluid">

    <div class="row text-center"><strong> User Details</strong></div>
    <div class="row" style="border:1px solid green;padding:10px">
        <div class="col-md-4 text-center"><strong>Name</strong></div>
        <div class="col-md-4 text-center"><strong>Username</strong></div>
        <div class="col-md-4 text-center"><strong>Password</strong></div>
    </div>
    <c:forEach var="user" items="${users}">
        <div class="row" style="border:1px solid green;padding:10px">
            <div class="col-md-4 text-center">${user.name}</div>
            <div class="col-md-4 text-center" >${user.username}</div>
            <div class="col-md-4 text-center">${user.password}</div>
        </div>
    </c:forEach>

</div>