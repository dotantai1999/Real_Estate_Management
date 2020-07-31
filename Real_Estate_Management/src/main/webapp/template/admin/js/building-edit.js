$('#btnAddBuilding').click(function () {
            let data = {};
            let buildingTypes = [];
            const formData = $('#formEdit').serializeArray();
            $.each(formData, function (i, v) {
                if (v.name === 'buildingTypes') {
                    buildingTypes.push(v.value);
                } else {
                    data[v.name] = v.value;
                }
            })
            data['buildingTypes'] = buildingTypes;

            console.log(data);
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
                }
            })
        })