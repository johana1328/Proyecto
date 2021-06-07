/**Variables globales */
const URL_TARIFA="../administracion/clase-perfil";
/** Datatable */
$(document).ready(function() {
	var tableOtions={
		urlAxax:URL_TARIFA+"/getAll", 
		colums:[
				 { "data": "id" },
			     { "data": "claseperfil" }
		       ]
	    }
	
	$("#tablaClasePerfil").crudDataTable(tableOtions)
	.on( "crear", function(){
		$('#modCrear').modal();
	}).on( "modificar", function(event,id,tabla){
		  obtenerClasePerfil(id);
	}).on( "eliminar", function(event,id,tabla){
		$("#valorClasePerfilEliminar").val(id);
		$('#confirmDelete').modal();
	});
});

/**Creacion de Clase Perfil*/
function crearClasePerfil(){
	let valorCrear=$("#valorClasePerfil").val();
	let form={id:0, claseperfil:valorCrear}
	let dataResp=ajaxRequest(`${URL_TARIFA}/create`, form, "modCrear");
	if(!isEmptyObject(dataResp)){
		$('#tablaClasePerfil').DataTable().ajax.reload();
	    $("#valorClasePerfil").val("");
	}
}

/**Modificar de Clase Perfil*/
function modificarClasePerfil(){
	let idClasePerfil=$('#idMod').val();
	let valorClasePerfil=$('#valorClasePerfilmod').val();
	let form={id:idClasePerfil, claseperfil:valorClasePerfil}
	let dataResp=ajaxRequest(`${URL_TARIFA}/${idClasePerfil}/update`, form, "modModificar");
	if(!isEmptyObject(dataResp)){
		$('#tablaClasePerfil').DataTable().ajax.reload();
	}
}

/**Obtener Clase Perfil*/
function obtenerClasePerfil(id){
	let form={};
	let dataResp=ajaxRequest(`${URL_TARIFA}/${id}/get`, form);
	if(!isEmptyObject(dataResp)){
		let clasePerfil = dataResp.data;	
		$('#idMod').val(clasePerfil.id);
		$('#valorClasePerfilmod').val(clasePerfil.claseperfil);
	}
	$('#modModificar').modal();
}

/**Eliminar Clase Perfil */
function eliminarClasePerfil(){
	let valorEliminar=$("#valorClasePerfilEliminar").val();
	let form={}
	let dataResp=ajaxRequest(`${URL_TARIFA}/${valorEliminar}/delete`, form);
	if(!isEmptyObject(dataResp)){
		$('#tablaClasePerfil').DataTable().ajax.reload();
	    $("#valorClasePerfilEliminar").val("");
	    $('#confirmDelete').modal('hide');
	}
}