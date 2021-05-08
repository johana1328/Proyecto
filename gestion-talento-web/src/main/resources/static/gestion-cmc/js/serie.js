/**Variables globales */
const URL_TARIFA="../administracion/serie";

/** Datatable */
$(document).ready(function() {
	var tableOtions={
		urlAxax:URL_TARIFA+"/getAllSerie", 
		colums:[
				 { "data": "idSerie" },
			     { "data": "nombre" },
			     { "data": "descripcion" }
		       ]
	    }
	
	$("#tablaSerie").crudDataTable(tableOtions)
	.on( "crear", function(){
		$('#modCrear').modal();
	}).on( "modificar", function(event,id,tabla){
		  obtenerTarifa(id);
	}).on( "eliminar", function(event,id,tabla){
		$("#valorEliminar").val(id);
		$('#confirmDelete').modal();
	});
});

/**Creacion de Tarifa*/
function crearTarifa(){
	let valorCrear=$("#valorCrear").val();
	let form={id:0, valor:valorCrear}
	let dataResp=ajaxRequest(`${URL_TARIFA}/create`, form, "modCrear");
	if(!isEmptyObject(dataResp)){
		$('#tablaTarifa').DataTable().ajax.reload();
	    $("#valorCrear").val("");
	}
}

/**Obtener tarifa */
function obtenerTarifa(id){
	let form={};
	let dataResp=ajaxRequest(`${URL_TARIFA}/${id}/get`, form);
	if(!isEmptyObject(dataResp)){
		let tarifa = dataResp.data;	
		$('#idMod').val(tarifa.id);
		$('#valorMod').val(tarifa.valor);
	}
	$('#modModificar').modal();
}

/**Modificar tarifa */
function modificarTarifa(){
	let idTarifa=$('#idMod').val();
	let valorTarifa=$('#valorMod').val();
	let form={id:idTarifa, valor:valorTarifa}
	let dataResp=ajaxRequest(`${URL_TARIFA}/${idTarifa}/update`, form, "modModificar");
	if(!isEmptyObject(dataResp)){
		$('#tablaTarifa').DataTable().ajax.reload();
	}
}

/**Eliminar tarifa */
function eliminarTarifa(){
	let valorEliminar=$("#valorEliminar").val();
	let form={}
	let dataResp=ajaxRequest(`${URL_TARIFA}/${valorEliminar}/delete`, form);
	if(!isEmptyObject(dataResp)){
		$('#tablaTarifa').DataTable().ajax.reload();
	    $("#valorEliminar").val("");
	    $('#confirmDelete').modal('hide');
	}
}