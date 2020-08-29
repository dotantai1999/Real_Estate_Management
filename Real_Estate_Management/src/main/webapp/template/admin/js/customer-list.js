$('#deleteCustomer').click(function (e) {
    e.preventDefault();
    let data = {};
    const customerIds = $('#customerList')
        .find('input[type=checkbox]:checked')
        .map(function () {
            return $(this).val();
        })
        .get();

    data.customerIds = customerIds;
    console.log(data);
    deleteCustomer(data);
});

function deleteCustomer(data) {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/Real_Estate_Management/admin-customer?action=DELETE',
        data: JSON.stringify(data), // Du lieu gui di
        contentType: 'application/json', // Dinh nghia kieu du lieu gui di
        success: function (response) {
            location.replace(
                'http://localhost:8080/Real_Estate_Management/admin-customer?action=LIST'
            );
        },
        error: function (response) {
            console.log(response);
        },
    });
}
