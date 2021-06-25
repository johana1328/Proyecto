/**Variables globales */
const URL_TARIFA="../administracion/tipo-perfil";

/** Datatable */
$(document).ready(function() {
	var tableOtions={
		urlAxax:URL_TARIFA+"/getAll", 
		colums:[
				 { "data": "id" },
			     { "data": "perfil" }
		       ]
	    }
	
	$("#tablaTipoPerfil").crudDataTable(tableOtions)
	.on( "crear", function(){
		$('#modCrear').modal();
	}).on( "modificar", function(event,id,tabla){
		  obtenerTipoPerfil(id);
	}).on( "eliminar", function(event,id,tabla){
		$("#valorTipoPerfilEliminar").val(id);
		$('#confirmDelete').modal();
	});
});
/**Creacion de Tipo Perfil*/
function crearTipoPerfil(){
	let valorCrear=$("#valorTipoPerfil").val();
	let form={id:0, perfil:valorCrear}
	let dataResp=ajaxRequest(`${URL_TARIFA}/create`, form, "modCrear");
	if(!isEmptyObject(dataResp)){
		$('#tablaTipoPerfil').DataTable().ajax.reload();
	    $("#valorTipoPerfil").val("");
	}
}
/**Modificar de Tipo Perfil*/
function modificarTipoPerfil(){
	let idTipoPerfil=$('#idMod').val();
	let valorTipoPerfil=$('#valorTipoPerfilmod').val();
	let form={id:idTipoPerfil, perfil:valorTipoPerfil}
	let dataResp=ajaxRequest(`${URL_TARIFA}/${idTipoPerfil}/update`, form, "modModificar");
	if(!isEmptyObject(dataResp)){
		$('#tablaTipoPerfil').DataTable().ajax.reload();
	}
}

/**Obtener Tipo Perfil*/
function obtenerTipoPerfil(id){
	let form={};
	let dataResp=ajaxRequest(`${URL_TARIFA}/${id}/get`, form);
	if(!isEmptyObject(dataResp)){
		let tipoPerfil = dataResp.data;	
		$('#idMod').val(tipoPerfil.id);
		$('#valorTipoPerfilmod').val(tipoPerfil.perfil);
	}
	$('#modModificar').modal();
}
/**Eliminar Tipo Perfil */
function eliminarTipoPerfil(){
	let valorEliminar=$("#valorTipoPerfilEliminar").val();
	let form={}
	let dataResp=ajaxRequest(`${URL_TARIFA}/${valorEliminar}/delete`, form);
	if(!isEmptyObject(dataResp)){
		$('#tablaTipoPerfil').DataTable().ajax.reload();
	    $("#valorTipoPerfilEliminar").val("");
	    $('#confirmDelete').modal('hide');
	}
}