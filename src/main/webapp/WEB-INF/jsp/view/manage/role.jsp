<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">

    <div class="card mb-3">
        <div class="card-header">
            <i class="fas fa-table"></i>
            Role
            <button type="button" class="btn btn-primary float-right" data-toggle="modal" data-target="#roleFormModal">
                등록
            </button>
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
                        <th>읽기</th>
                        <th>추가</th>
                        <th>수정</th>
                        <th>삭제</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Name</th>
                        <th>Depth</th>
                        <th>menuType</th>
                        <th>읽기</th>
                        <th>추가</th>
                        <th>수정</th>
                        <th>삭제</th>
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
                            <td>
                                <select class="form-control" value="${roleMenu.useYn}">
                                    <option value="Y">Y</option>
                                    <option value="N">N</option>
                                </select>
                            </td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <button type="button" class="btn btn-primary btn-lg btn-block">저장</button>
            </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
    </div>

</div>

<!-- Modal -->
<div class="modal fade" id="roleFormModal" tabindex="-1" role="dialog" aria-labelledby="roleFormModalTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="roleFormModalTitle">등록</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="name">Names</label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="Enter name">
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
