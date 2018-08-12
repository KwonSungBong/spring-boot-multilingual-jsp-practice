<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <th></th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Name</th>
                        <th>Depth</th>
                        <th>menuType</th>
                        <th>UseYn</th>
                        <th></th>
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
                            <td>
                                <c:if test="${menu.menuType eq 'category'}">
                                    <button type="button" class="btn btn-primary"
                                            data-toggle="modal" data-target="#menuFormModal" data-id="${menu.id}">
                                        추가
                                    </button>
                                </c:if>
                                <button type="button" class="btn btn-primary"
                                        data-toggle="modal" data-target="#menuFormModal" data-id="${menu.id}"
                                        data-name="${menu.name}" data-use-yn="${menu.useYn}">
                                    수정
                                </button>
                                <button type="button" class="btn btn-primary"
                                        data-toggle="modal" data-target="#menuFormModal" data-id="${menu.id}">
                                    삭제
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
    </div>

</div>

<!-- Modal -->
<div class="modal fade" id="menuFormModal" tabindex="-1" role="dialog" aria-labelledby="menuFormModalTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="menuFormModalTitle"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <input type="hidden" name="id" id="id">
                    <div class="form-group">
                        <label for="name">Names</label>
                        <input type="text" class="form-control" name="name" id="name" aria-describedby="emailHelp" placeholder="Enter name">
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" name="username" id="username" aria-describedby="usernameHelp" placeholder="Enter username">
                        <small id="usernameHelp" class="form-text text-muted">We'll never share your username with anyone else.</small>
                    </div>
                    <div class="form-group">
                        <label for="roleId">Role</label>
                        <select class="form-control" name="roleId" id="roleId">
                            <option value="1">1</option>
                        </select>
                    </div>
                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" name="useYn" id="useYn">
                        <label class="form-check-label" for="useYn">use yn</label>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                <button type="button" class="btn btn-primary" id="saveButton">저장</button>
            </div>
        </div>
    </div>
</div>
