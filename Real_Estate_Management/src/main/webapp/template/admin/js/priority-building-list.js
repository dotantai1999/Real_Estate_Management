$('#deletePriorityBuilding').click(function (e) {
    e.preventDefault();
    let data = {};

    const priorityBuildingIds = $('#priorityBuildingList')
        .find('input[type=checkbox]:checked')
        .map(function () {
            return $(this).val();
        })
        .get();

    data.buildingIds = priorityBuildingIds;
    deleteBuilding(data);
});

function deleteBuilding(data) {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/Real_Estate_Management/admin-building/priority-list?action=DELETE',
        data: JSON.stringify(data), // Du lieu gui di
        contentType: 'application/json', // Dinh nghia kieu du lieu gui di
        success: function (response) {
            location.replace('http://localhost:8080/Real_Estate_Management/admin-building/priority-list');
        },
        error: function (response) {
            console.log(response);
        },
    });
}
