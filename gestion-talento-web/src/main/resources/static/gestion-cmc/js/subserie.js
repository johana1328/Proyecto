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
			     { "data": "serieDto.nombre" }
			     
		       ]
	    }
	    
	    $("#tablaSubserie").crudDataTable(tableOtions)
	.on( "crear", function(){
		$('#modCrear').modal();
	}).on( "modificar", function(event,id,tabla){
		  obtenerSubserie(id);
	}).on( "eliminar", function(event,id,tabla){
		$("#idSubserie").val(id);
		$('#confirmDelete').modal();
	});
	  });
	  
/**Creacion de Subserie*/
function crearSubserie(){
	let nombreCrear=$("#nombreCrear").val();
	let proceCrear=$("#procCrear").val();
	let archgesCrear=parseInt($("#arcgesCrear").val());
	let archcenCrear=parseInt($("#arccenCrear").val());
	let seriCrear=parseInt($("#seriCrear").val());
	let descCrear=$("#descCrear").val();
	let procediCrear=$("#procediCrear").val();
	let form={id:0, nombre:nombreCrear,  descripcion:descCrear, proceso:proceCrear,procedimiento:procediCrear,
	archivoGestion:archgesCrear,archivoCentral:archcenCrear, serieDto:{idSerie:seriCrear,nombre:"1"}}
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
		$("#nombreMod").val(subserie.nombre);
	    $("#descMod").val(subserie.descripcion);
	    $("#procMod").val(subserie.proceso);
	    $("#procediMod").val(subserie.procedimiento);
	    $("#arcgesMod").val(subserie.archivoGestion);
	    $("#arccenMod").val(subserie.archivoCentral);
	    $("#seriMod").val(subserie.serieDto.id);
	}
	$('#modModificar').modal();
}

/**Modificar serie */
function modificarSubserie(){
	let idSubserie=$('#idMod').val();
	let nombreMod=$("#nombreMod").val();
	let proceMod=$("#procMod").val();
	let archgesMod=$("#arcgesMod").val();
	let archcenMod=$("#arccenMod").val();
	let seriMod=$("#seriMod").val();
	let descMod=$("#descMod").val();
	let procediMod=$("#procediMod").val();
	let form={id:idSubserie, nombre:nombreMod,  descripcion:descMod, proceso:proceMod,procedimiento:procediMod,
	archivoGestion:archgesMod,archivoCentral:archcenMod, serieDto:{idSerie:seriMod,nombre:"1"}}
	let dataResp=ajaxRequest(`${URL_SUBSERIE}/${idSubserie}/update`, form, "modModificar");
	if(!isEmptyObject(dataResp)){
		$('#tablaSubserie').DataTable().ajax.reload();
	}
}

/**Eliminar Subserie */
function eliminarSubserie(){
	let idSubserie=$("#idSubserie").val();
	let form={}
	let dataResp=ajaxRequest(`${URL_SUBSERIE}/${idSubserie}/delete`, form);
	if(!isEmptyObject(dataResp)){
		$('#tablaSubserie').DataTable().ajax.reload();
	    $("#idSubserie").val("");
	    $('#confirmDelete').modal('hide');
	}
}


