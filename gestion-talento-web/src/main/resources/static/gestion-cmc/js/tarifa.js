/** Datatable */

$(document).ready(function() {
	 $('#tablaTarifa').DataTable( {
		"ajax": {
            "url": "../administracion/tarifa/getAll",
            "dataSrc": ""
        },
		  "columns": [
			 {"data": "id" },
			 {"data": "valor" },
			 {"data":null, "render":function (data,type,row ){
				let botonEditar =`<button type="button" class="btn btn-primary" >
				                   		<i class="fas fa-trash-alt"></i>
				                   </button>`;
				let botonEliminar =`<button type="button" class="btn btn-primary">
				                   		<i class="fas fa-edit"></i>
				                    </button>`;
				
				return botonEditar+botonEliminar;
			}}
		] 
	});
});



	


	
