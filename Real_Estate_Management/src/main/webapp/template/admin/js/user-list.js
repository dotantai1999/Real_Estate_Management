$('#deleteUser').click(function (e) {
    e.preventDefault();
    let data = {};

    const userIds = $('#userList')
        .find('input[type=checkbox]:checked')
        .map(function () {
            return $(this).val();
        })
        .get();

    data.userIds = userIds;
    console.log(data);
    deleteUser(data);
});

function deleteUser(data) {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/Real_Estate_Management/admin-user?action=DELETE',
        data: JSON.stringify(data), // Du lieu gui di
        contentType: 'application/json', // Dinh nghia kieu du lieu gui di
        success: function (response) {
            location.replace('http://localhost:8080/Real_Estate_Management/admin-user?action=LIST');
        },
        error: function (response) {
            console.log(response);
        },
    });
}
