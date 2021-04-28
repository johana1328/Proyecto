/**Variables globales */
const URL_TARIFA="../administracion/tarifa";

/** Datatable */

$(document).ready(function() {
	
	$("#tablaTarifa").crudDataTable({urlAxax:URL_TARIFA+"/getAll"})
	.on( "crear", function(){
		$('#modCrear').modal();
	}).on( "modificar", function(event,id,tabla){
		//alert(id);
		$('#modModificar').modal();
	}).on( "eliminar", function(event,id,tabla){
		$("#valorEliminar").val(id);
		$('#confirmDelete').modal();
	});
	
});


function crearPeticion(){
	let valorCrear=$("#valorCrear").val();
	let form={id:0, valor:valorCrear}
	let dataResp=ajaxRequest(URL_TARIFA, form, "modCrear");
	if(!isEmptyObject(dataResp)){
		$('#tablaTarifa').DataTable().ajax.reload();
	    $("#valorCrear").val("");
	}
}

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

function obtenerPeticion(){
	
}

	


	
