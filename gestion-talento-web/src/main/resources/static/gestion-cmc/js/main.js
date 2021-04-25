function ajaxRequest(urlAction, data) {
	$.ajax({
		type: 'POST',
		url: urlAction,
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify(data),
		beforeSend: function() {
			$("#loading-overlay").show();
		},
		success: function(data, textStatus, jqXHR) {
			$("#loading-overlay").hide();
		},
		error: function(jqXHR, textStatus, errorThrown) {
			$("#loading-overlay").hide();
			 toastr.error('Error al realizar transacción , Consulte al administrador.')
		}
	});
}


Inputmask.extendAliases({
		  pesos: {
		            prefix: "$ ",
		            groupSeparator: ".",
		            alias: "numeric",
		            placeholder: "0",
		            autoGroup: true,
		            digits: 2,
		            digitsOptional: false,
		            clearMaskOnLostFocus: false
		        }
		});