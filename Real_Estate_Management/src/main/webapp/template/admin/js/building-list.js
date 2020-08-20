function assignmentBuilding(id) {
    openModalAssignmentBuilding();
    // Save buildingId in Modal input
    $('#buildingId').val(id);
}

function openModalAssignmentBuilding() {
    $('#assignmentBuildingModal').modal();
}

$('#btnAssignBuilding').click(function (e) {
    e.preventDefault();
    let data = {};

    // Get buildingId
    data.buildingId = $('#buildingId').val();

    // Get array of checked staff id
    // Plain javascript
    // const checkbox = document.querySelectorAll('#staffList input[type=checkbox]:checked');
    // checkbox.forEach(el => {
    //     staffs.push(el.value);
    // })
    // console.log(staffs);

    const staffs = $('#staffList')
        .find('tbody input[type=checkbox]:checked')
        .map(function () {
            return $(this).val();
        })
        .get();

    data.staffs = staffs;
    console.log(data);
    //assignStaff(data);
});

function assignStaff(data) {
    // Call api
    $.ajax({
        type: 'POST',
        url: '',
        data: JSON.stringify(data), // Du lieu gui di
        dataType: 'json', // Dinh nghia kieu du lieu tra ve tu server
        contentType: 'application/json', // Dinh nghia kieu du lieu gui di
        success: function (response) {
            console.log('oke');
        },
        error: function (response) {
            console.log('fail');
        },
    });
}

$('#deleteBuilding').click(function (e) {
    e.preventDefault();
    let data = {};

    // Get all checked building
    const buildingIds = $('#buildingList')
        .find('input[type=checkbox]:checked')
        .map(function () {
            return $(this).val();
        })
        .get();

    data.buildingIds = buildingIds;
    console.log(data);
    //deleteBuilding(data);
});

function deleteBuilding(data) {
    $.ajax({
        type: 'POST',
        url: '',
        data: JSON.stringify(data), // Du lieu gui di
        dataType: 'json', // Dinh nghia kieu du lieu tra ve tu server
        contentType: 'application/json', // Dinh nghia kieu du lieu gui di
        success: function (response) {
            console.log('oke');
        },
        error: function (response) {
            console.log('fail');
        },
    });
}

$('#searchSubmit').click(function (e) {
    e.preventDefault();
    $('#searchForm').submit();
});
