<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">

    <div class="card mb-3">
        <div class="card-header">
            <i class="fas fa-table"></i>
            Role
        </div>
        <div class="card-body">
            <form class="form-inline">
                <label class="my-1 mr-2" for="roleId">Role</label>
                <select class="custom-select my-1 mr-sm-2" id="roleId">
                    <c:forEach var="role" items="${roleList}">
                        <option value="${role.id}">${role.name}</option>
                    </c:forEach>
                </select>
                <div class="custom-control custom-checkbox my-1 mr-sm-2">
                    <input type="text" class="form-control" id="roleName" placeholder="Role name">
                </div>
                <div class="custom-control custom-checkbox my-1 mr-sm-2">
                    <input type="checkbox" class="custom-control-input" id="useYn">
                    <label class="custom-control-label" for="useYn">Use yn</label>
                </div>
            </form>
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Depth</th>
                        <th>menuType</th>
                        <th>UseYn</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Name</th>
                        <th>Depth</th>
                        <th>menuType</th>
                        <th>UseYn</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="roleMenu" items="${roleMenuList}">
                        <tr>
                            <td>
                                <c:forEach var="i" begin="1" end="${roleMenu.depth}" step="1">
                                    &nbsp;&nbsp;
                                </c:forEach>
                                ${roleMenu.name}
                            </td>
                            <td>${roleMenu.depth}</td>
                            <td>${roleMenu.menuType}</td>
                            <td>${roleMenu.useYn}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
    </div>

</div>