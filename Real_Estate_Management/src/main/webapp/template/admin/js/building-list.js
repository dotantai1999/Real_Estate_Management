function assignmentBuilding(id) {
    // Delete all markup
    document.querySelector('#assignmentBuildingTable').innerHTML = '';

    // Call Api
    const data = {
        id: `${id}`,
    };
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/Real_Estate_Management/AssignBuildingAPI',
        data: JSON.stringify(data),
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            //const {list, listAll} = data;
            let markup;
			console.log(data);
            //let checked;
            data.forEach((staff) => {
                //list.includes(staff);
                markup = `<tr>
                <th scope="row">${staff.id}</th>
                <td>${staff.fullName}</td>
                <td class="text-center"><input checked=false type="checkbox" value="${staff.id}" id="checkbox_staff_${staff.id}"></td>
            </tr>`;

                document
                    .querySelector('#assignmentBuildingTable')
                    .insertAdjacentHTML('beforeend', markup);
            });
        },
        error: function (response) {
            console.log(response);
        },
    });

    // Save buildingId in Modal input
    openModalAssignmentBuilding();
    $('#buildingId').val(id);
}

function openModalAssignmentBuilding() {
    $('#assignmentBuildingModal').modal();
}

$('#btnAssignBuilding').click(function (e) {
    e.preventDefault();
    let data = {};

    // Get buildingId
    data.idBuilding = $('#buildingId').val();

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

    data.staffIds = staffs;
    console.log(data);
    assignStaff(data);
});

function assignStaff(data) {
    // Call api
    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/Real_Estate_Management/AssignBuildingAPI',
        data: JSON.stringify(data), // Du lieu gui di
        contentType: 'application/json', // Dinh nghia kieu du lieu gui di
        success: function (response) {
            $('#assignmentBuildingModal').modal('hide');
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
    deleteBuilding(data);
});

function deleteBuilding(data) {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/Real_Estate_Management/admin-building?action=DELETE',
        data: JSON.stringify(data), // Du lieu gui di
        contentType: 'application/json', // Dinh nghia kieu du lieu gui di
        success: function (response) {
            location.replace(
                'http://localhost:8080/Real_Estate_Management/admin-building?action=LIST'
            );
        },
        error: function (response) {
            console.log(response);
        },
    });
}

$('#searchSubmit').click(function (e) {
    e.preventDefault();
    $('#searchForm').submit();
});
