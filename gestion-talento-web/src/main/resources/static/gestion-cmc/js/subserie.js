/**Variables globales */
const URL_SUBSERIE="../administracion/subserie";

/** Datatable */
$(document).ready(function() {
	var tableOtions={
		urlAxax:URL_SUBSERIE+"/getAllSubserie", 
		colums:[
				 { "data": "id" },
			     { "data": "nombre" },
			     { "data": "descripcion" },
			     { "data": "proceso" },
			     { "data": "procedimiento" },
			     { "data": "archivoGestion" },
			     { "data": "archivoCentral" },
			     { "data": "serieDto" }
			     
		       ]
	    }
	    
	    $("#tablaSubserie").crudDataTable(tableOtions)
	.on( "crear", function(){
		$('#modCrear').modal();
	}).on( "modificar", function(event,id,tabla){
		  obtenerSubserie(id);
	}).on( "eliminar", function(event,id,tabla){
		$("#id").val(id);
		$('#confirmDelete').modal();
	});
	  });
	  
/**Creacion de Subserie*/
function crearSubserie(){
	let nombreCrear=$("#nombreCrear").val();
	let proceCrear=$("#procCrear").val();
	let archgesCrear=$("#arcgesCrear").val();
	let archcenCrear=$("#arccenCrear").val();
	let seriCrear=$("#seriCrear").val();
	let descCrear=$("#descCrear").val();
	let procediCrear=$("#procediCrear").val();
	let form={id:0, nombre:nombreCrear,  descripcion:descCrear, proceso:procCrear,procedimiento:procediCrear,
	archivoGestion:arcgesCrear,archivoCentral:arccenCrear, serieDto:seriCrear  }
	let dataResp=ajaxRequest(`${URL_SUBSERIE}/create`, form, "modCrear");
	if(!isEmptyObject(dataResp)){
		$('#tablaSubserie').DataTable().ajax.reload();
	    $("#nombreCrear").val("");
	    $("#descCrear").val("");
	    $("#procCrear").val("");
	    $("#procediCrear").val("");
	    $("#arcgesCrear").val("");
	    $("#arccenCrear").val("");
	    $("#seriCrear").val("");
	}
}

/**Obtener Subserie */
function obtenerSubserie(id){
	let form={};
	let dataResp=ajaxRequest(`${URL_SUBSERIE}/${id}/get`, form);
	if(!isEmptyObject(dataResp)){
		let subserie = dataResp.data;
		$("#idMod").val(subserie.id);	
		$("#nombreCrear").val(subserie.nombre);
	    $("#descCrear").val(subserie.descripcion);
	    $("#procCrear").val(subserie.proceso);
	    $("#procediCrear").val(subserie.procedimiento);
	    $("#arcgesCrear").val(subserie.archivoGestion);
	    $("#arccenCrear").val(subserie.archivoCentral);
	    $("#seriCrear").val(subserie.serieDto);
	}
	$('#modModificar').modal();
}

/**Modificar serie */
function modificarSubserie(){
	let idSubserie=$('#idMod').val();
	let nombreCrear=$("#nombreCrear").val();
	let proceCrear=$("#procCrear").val();
	let archgesCrear=$("#arcgesCrear").val();
	let archcenCrear=$("#arccenCrear").val();
	let seriCrear=$("#seriCrear").val();
	let descCrear=$("#descCrear").val();
	let procediCrear=$("#procediCrear").val();
	let form={id:idSubserie, nombre:nombreCrear,  descripcion:descCrear, proceso:procCrear,procedimiento:procediCrear,
	archivoGestion:arcgesCrear,archivoCentral:arccenCrear, serieDto:seriCrear }
	let dataResp=ajaxRequest(`${URL_SUBSERIE}/${id}/update`, form, "modModificar");
	if(!isEmptyObject(dataResp)){
		$('#tablaSubserie').DataTable().ajax.reload();
	}
}

/**Eliminar Subserie */
function eliminarSubserie(){
	let idSubserie=$("#idSubserie").val();
	let form={}
	let dataResp=ajaxRequest(`${URL_SUBSERIE}/${id}/delete`, form);
	if(!isEmptyObject(dataResp)){
		$('#tablaSubserie').DataTable().ajax.reload();
	    $("#idSubserie").val("");
	    $('#confirmDelete').modal('hide');
	}
}


