$('#userFormModal').on('show.bs.modal', function (event) {
    var user = $(event.relatedTarget).data();
    var modalEl = $(event.target);

    if(user.id) {
        modalEl.find("#userFormModalTitle").text("수정");
        modalEl.find("input[name=id]").val(user.id);
        modalEl.find("input[name=name]").val(user.name);
        modalEl.find("input[name=username]").val(user.username);
        modalEl.find("select[name=roleId]").val(user.roleId);
        modalEl.find("input[name=useYn]").prop("checked",user.useYn === 'Y' ? true : false);
    } else {
        modalEl.find("#userFormModalTitle").text("등록");
    }
});

$('#userFormModal').on('hidden.bs.modal', function (event) {
    var modalEl = $(event.target);
    modalEl.find("input[name=id]").val('');
    modalEl.find("input[name=name]").val('');
    modalEl.find("input[name=username]").val('');
    modalEl.find("select[name=roleId]").val(modalEl.find("select[name=roleId] option:first").val());
    modalEl.find("input[name=useYn]").prop("checked",false);
});

$('#saveButton').on('click', function (event) {
    var modalEl = $(this).closest("#userFormModal");
    var id = modalEl.find("input[name=id]").val();
    var name = modalEl.find("input[name=name]").val();
    var username = modalEl.find("input[name=username]").val();
    var roleId = modalEl.find("select[name=roleId]").val();
    var useYn = modalEl.find("input[name=useYn]").val() ? 'Y' : 'N';

    if(id) {
        var user = {id:id,name:name,username:username,useYn:useYn,role:{id:roleId}};
        console.log("update", user);
        $.ajax({
            method: "PUT",
            url: "/rest/user",
            dataType : "json",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(user)
        })
        .done(function( msg ) {
            console.log(msg);
            // location.href = "/manage/manager";
        });
    } else {
        var user = {name:name,username:username,useYn:useYn,role:{id:roleId}};
        console.log("insert", user);
        $.ajax({
            method: "POST",
            url: "/rest/user",
            dataType : "json",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(user)
        })
        .done(function( msg ) {
            console.log(msg);
            // location.href = "/manage/manager";
        });
    }
});

$(document).ready(function() {
    $('#dataTable').DataTable();
});
