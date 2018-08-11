<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">

    <div class="card mb-3">
        <div class="card-header">
            <i class="fas fa-table"></i>
            Menu
        </div>
        <div class="card-body">
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
                    <c:forEach var="menu" items="${menuList}">
                        <tr>
                            <td>
                                <c:forEach var="i" begin="1" end="${menu.depth}" step="1">
                                    &nbsp;&nbsp;
                                </c:forEach>
                                ${menu.name}
                            </td>
                            <td>${menu.depth}</td>
                            <td>${menu.menuType}</td>
                            <td>${menu.useYn}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
    </div>

</div>