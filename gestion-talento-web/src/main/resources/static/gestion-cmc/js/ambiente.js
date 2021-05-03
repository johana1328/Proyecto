/**Variables globales */
const URL_TARIFA="../administracion/ambientacion";

/** Datatable */
$(document).ready(function() {
	var tableOtions={
		urlAxax:URL_TARIFA+"/getAll", 
		colums:[
				 { "data": "id" },
			     { "data": "ambiente" }
		       ]
	    }
	
	$("#tablaAmbiente").crudDataTable(tableOtions)
	.on( "crear", function(){
		$('#modCrear').modal();
	}).on( "modificar", function(event,id,tabla){
	  obtenerAmbiente(id);
	}).on( "eliminar", function(event,id,tabla){
		$("#valorAmbienteEliminar").val(id);
		$('#confirmDelete').modal();
	});
});

function crearAmbiente(){
	let valorCrear=$("#valorAmbiente").val();
	let form={id:0, ambiente:valorCrear}
	let dataResp=ajaxRequest(`${URL_TARIFA}/create`, form, "modCrear");
	if(!isEmptyObject(dataResp)){
		$('#tablaAmbiente').DataTable().ajax.reload();
	    $("#valorAmbiente").val("");
	}
}

function modificarAmbiente(){
	
	let idAmbiente=$('#idMod').val();
	let valorAmbiente=$('#valorAmbientemod').val();
	let form={id:idAmbiente, ambiente:valorAmbiente}
	let dataResp=ajaxRequest(`${URL_TARIFA}/${idAmbiente}/update`, form, "modModificar");
	if(!isEmptyObject(dataResp)){
		$('#tablaAmbiente').DataTable().ajax.reload();
	}
	
}

function obtenerAmbiente(id){
	
	let form={};
	let dataResp=ajaxRequest(`${URL_TARIFA}/${id}/get`, form);
	if(!isEmptyObject(dataResp)){
		let ambiente = dataResp.data;	
		$('#idMod').val(ambiente.id);
		$('#valorAmbientemod').val(ambiente.ambiente);
	}
	$('#modModificar').modal();
}

function eliminarAmbiente(){
	
	let valorEliminar=$("#valorAmbienteEliminar").val();
	let form={}
	let dataResp=ajaxRequest(`${URL_TARIFA}/${valorEliminar}/delete`, form);
	if(!isEmptyObject(dataResp)){
		$('#tablaAmbiente').DataTable().ajax.reload();
	    $("#valorAmbienteEliminar").val("");
	    $('#confirmDelete').modal('hide');
	}
}

