// Call the dataTables jQuery plugin
$(document).ready(function() {
    $('#dataTable').DataTable({
        searching: false,
        ordering:  false,
        paging: false,
        scrollY: 400
    });
});
