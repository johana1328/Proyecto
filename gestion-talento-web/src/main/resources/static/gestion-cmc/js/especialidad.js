/**Variables globales */
const URL_TARIFA="../administracion/especialidad";

/** Datatable */
$(document).ready(function() {
	var tableOtions={
		urlAxax:URL_TARIFA+"/getAll", 
		colums:[
				 { "data": "id" },
			     { "data": "especialidad" }
		       ]
	    }
	
	$("#tablaEspecialidad").crudDataTable(tableOtions)
	.on( "crear", function(){
		$('#modCrear').modal();
	}).on( "modificar", function(event,id,tabla){
	  obtenerEspecialidad(id);
	}).on( "eliminar", function(event,id,tabla){
		$("#valorEspecialidadEliminar").val(id);
		$('#confirmDelete').modal();
	});
});

function crearEspecialidad(){
	let valorCrear=$("#valorEspecialidad").val();
	let form={id:0, especialidad:valorCrear}
	let dataResp=ajaxRequest(`${URL_TARIFA}/create`, form, "modCrear");
	if(!isEmptyObject(dataResp)){
		$('#tablaEspecialidad').DataTable().ajax.reload();
	    $("#valorEspecialidad").val("");
	}
}

function modificarEspecialidad(){
	
	let idEspecialidad=$('#idMod').val();
	let valorEspecialidad=$('#valorEspecialidadmod').val();
	let form={id:idEspecialidad, especialidad:valorEspecialidad}
	let dataResp=ajaxRequest(`${URL_TARIFA}/${idEspecialidad}/update`, form, "modModificar");
	if(!isEmptyObject(dataResp)){
		$('#tablaEspecialidad').DataTable().ajax.reload();
	}
	
}

function obtenerEspecialidad(id){
	
	let form={};
	let dataResp=ajaxRequest(`${URL_TARIFA}/${id}/get`, form);
	if(!isEmptyObject(dataResp)){
		let especialidad = dataResp.data;	
		$('#idMod').val(especialidad.id);
		$('#valorEspecialidadmod').val(especialidad.especialidad);
	}
	$('#modModificar').modal();
}

function eliminarEspecialidad(){
	
	let valorEliminar=$("#valorEspecialidadEliminar").val();
	let form={}
	let dataResp=ajaxRequest(`${URL_TARIFA}/${valorEliminar}/delete`, form);
	if(!isEmptyObject(dataResp)){
		$('#tablaEspecialidad').DataTable().ajax.reload();
	    $("#valorEspecialidadEliminar").val("");
	    $('#confirmDelete').modal('hide');
	}
}

