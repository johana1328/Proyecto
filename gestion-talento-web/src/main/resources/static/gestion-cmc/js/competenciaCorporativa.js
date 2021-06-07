/**Variables globales */
const URL_TARIFA="../administracion/competencia-corporativa";
/** Datatable */
$(document).ready(function() {
	var tableOtions={
		urlAxax:URL_TARIFA+"/getAll", 
		colums:[
				 { "data": "id" },
			     { "data": "nombre" },
			     { "data": "descripcion" }
		       ]
	    }
	
	$("#tablaCompetenciaCorporativa").crudDataTable(tableOtions)
	.on( "crear", function(){
		$('#modCrear').modal();
	}).on( "modificar", function(event,id,tabla){
		  obtenerCompetenciaCorporativa(id);
	}).on( "eliminar", function(event,id,tabla){
		$("#valorCompetenciaCorporativaEliminar").val(id);
		$('#confirmDelete').modal();
	});
});

/**Creacion de Competencia Corporativa*/
function crearCompetenciaCorporativa(){
	let nombreCrear=$("#nomCompetenciaCorporativa").val();
	let descCrear=$("#desCompetenciaCorporativa").val();
	let form={id:0, nombre:nombreCrear, descripcion:descCrear}
	let dataResp=ajaxRequest(`${URL_TARIFA}/create`, form, "modCrear");
	if(!isEmptyObject(dataResp)){
		$('#tablaCompetenciaCorporativa').DataTable().ajax.reload();
	    $("#nombreCrear").val("");
	    $("#descCrear").val("");
	}
}
/**Modificar de Competencia Corporativa*/
function modificarCompetenciaCorporativa(){
	let idCompetenciaCorporativa=$('#idMod').val();
	let nombreCompetenciaCorporativa=$('#nomCompetenciaCorporativamod').val();
	let descripcionCompetenciaCorporativa=$('#desCompetenciaCorporativamod').val();
	let form={id:idCompetenciaCorporativa,  nombre:nombreCompetenciaCorporativa, descripcion:descripcionCompetenciaCorporativa}
	let dataResp=ajaxRequest(`${URL_TARIFA}/${idCompetenciaCorporativa}/update`, form, "modModificar");
	if(!isEmptyObject(dataResp)){
		$('#tablaTipoPerfil').DataTable().ajax.reload();
	}
}
/**Obtener Competencia Corporativa*/
function obtenerCompetenciaCorporativa(id){
	let form={};
	let dataResp=ajaxRequest(`${URL_TARIFA}/${id}/get`, form);
	if(!isEmptyObject(dataResp)){
		let competenciaCorporativa = dataResp.data;	
		$('#idMod').val(competenciaCorporativa.id);
		$('#nomCompetenciaCorporativamod').val(competenciaCorporativa.nombre);
		$('#desCompetenciaCorporativamod').val(competenciaCorporativa.descripcion);
	}
	$('#modModificar').modal();
}

/**Eliminar Competencia Corporativa  */
function eliminarCompetenciaCorporativa (){
	let valorEliminar=$("#valorCompetenciaCorporativaEliminar").val();
	let form={}
	let dataResp=ajaxRequest(`${URL_TARIFA}/${valorEliminar}/delete`, form);
	if(!isEmptyObject(dataResp)){
		$('#tablaCompetenciaCorporativa').DataTable().ajax.reload();
	    $("#valorCompetenciaCorporativaEliminar").val("");
	    $('#confirmDelete').modal('hide');
	}
}