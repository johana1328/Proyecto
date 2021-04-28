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


(function($) {
	$.fn.extend({
		crudDataTable: function(options) {
			options = $.extend({}, $.crudDataTable.defaults, options);

			this.each(function() {
				new $.crudDataTable(this, options);
			});
			return this;
		}
	});

	// ctl is the element, options is the set of defaults + user options
	$.crudDataTable = function(ctl, options) {
		let table = $(ctl).DataTable({
			"responsive": true, "lengthChange": false, "autoWidth": false,
			"ajax": {
				"url": options.urlAxax,
				"dataSrc": ""
			},
			"dom": 'Bfrtip',
			"buttons": [
				{
					"text": "Crear",
					"className": "btn btn-primary",
					init: function(api, node, config) {
						$(node).removeClass('btn-secondary')
					},
					"action": function(e, dt, node, config) {
						$(ctl).trigger("crear");
					}
				},
				"excel", "pdf"
			],
			"columns": [
				{ "data": "id" },
				{ "data": "valor" },
				{
					"data": null, "render": function(data, type, row) {
						let botonEditar = `<button type="button" data-id='${data.id}' class="btn btn-primary btn-del" >
				                   		<i class="fas fa-trash-alt"></i>
				                   </button>`;
						let botonEliminar = `<button type="button" data-id='${data.id}' class="btn btn-primary btn-edit">
				                   		<i class="fas fa-edit"></i>
				                    </button>`;

						return botonEditar + botonEliminar;
					}
				}
			]
		}).buttons().container().appendTo('#tablaTarifa_filter .col-md-6:eq(0)');

		$(ctl).on('click', 'button.btn-del', function() {
			let id = $(this).data('id');
			$(ctl).trigger("eliminar", [id, table]);
		});

		$(ctl).on('click', 'button.btn-edit', function() {
			let id = $(this).data('id');
			$(ctl).trigger("modificar", [id, table]);
		});
	};

	// option defaults
	$.crudDataTable.defaults = {

	};

})(jQuery);


