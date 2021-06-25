/**Variables globales */
const URL_SERIE="../administracion/serie";

/** Datatable */
$(document).ready(function() {
	var tableOtions={
		urlAxax:URL_SERIE+"/getAllSerie", 
		colums:[
				 { "data": "id" },
			     { "data": "nombre" },
			     { "data": "descripcion" },
			     { "data": "estado" }
		       ]
	    }
	
	$("#tablaSerie").crudDataTable(tableOtions)
	.on( "crear", function(){
		$('#modCrear').modal();
	}).on( "modificar", function(event,id,tabla){
		  obtenerSerie(id);
	}).on( "eliminar", function(event,id,tabla){
		$("#idSerie").val(id);
		$('#confirmDelete').modal();
	});
});

/**Creacion de Serie*/
function crearSerie(){
	let nombreCrear=$("#nombreCrear").val();
	let descCrear=$("#descCrear").val();
	let form={id:0, nombre:nombreCrear, descripcion:descCrear}
	let dataResp=ajaxRequest(`${URL_SERIE}/create`, form, "modCrear");
	if(!isEmptyObject(dataResp)){
		$('#tablaSerie').DataTable().ajax.reload();
	    $("#nombreCrear").val("");
	    $("#descCrear").val("");
	}
}

/**Obtener serie */
function obtenerSerie(idSerie){
	let form={};
	let dataResp=ajaxRequest(`${URL_SERIE}/${idSerie}/get`, form);
	if(!isEmptyObject(dataResp)){
		let serie = dataResp.data;	
		$('#idMod').val(serie.idSerie);
		$('#nomMod').val(serie.nombre);
		$('#desMod').val(serie.descripcion);
		$('#estMod').val(serie.estado);
	}
	$('#modModificar').modal();
}

/**Modificar serie */
function modificarSerie(){
	let idSerie=$('#idMod').val();
	let nombreSerie=$('#nomMod').val();
	let descripSerie=$('#descMod').val();
	let estaSerie=$('#estMod').val();
	let form={idSerie:idSerie, nombre:nombreSerie, descripcion:descripSerie, estado:estaSerie}
	let dataResp=ajaxRequest(`${URL_SERIE}/${idSerie}/update`, form, "modModificar");
	if(!isEmptyObject(dataResp)){
		$('#tablaSerie').DataTable().ajax.reload();
	}
}

/**Eliminar Serie */
function eliminarSerie(){
	let idSerie=$("#idSerie").val();
	let form={}
	let dataResp=ajaxRequest(`${URL_SERIE}/${idSerie}/delete`, form);
	if(!isEmptyObject(dataResp)){
		$('#tablaSerie').DataTable().ajax.reload();
	    $("#idSerie").val("");
	    $('#confirmDelete').modal('hide');
	}
}