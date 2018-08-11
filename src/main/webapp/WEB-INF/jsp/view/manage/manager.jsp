<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">

    <div class="card mb-3">
        <div class="card-header">
            <i class="fas fa-table"></i>
            Manager
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Username</th>
                        <th>UseYn</th>
                        <th>RoleName</th>
                        <th>RoleUseYn</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Name</th>
                        <th>Username</th>
                        <th>UseYn</th>
                        <th>RoleName</th>
                        <th>RoleUseYn</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>${user.name}</td>
                            <td>${user.username}</td>
                            <td>${user.useYn}</td>
                            <td>${user.role.name}</td>
                            <td>${user.role.useYn}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
    </div>

</div>