/** Datatable */

$(document).ready(function() {
	
	$("#tablaTarifa").crudDataTable({urlAxax:"../administracion/tarifa/getAll"})
	.on( "crear", function(){
		$('#modCrear').modal();
	}).on( "modificar", function(event,id,tabla){
		//alert(id);
		$('#modModificar').modal();
	}).on( "eliminar", function(event,id,tabla){
		//alert(id);
		$('#confirmDelete').modal();
	});
	

});



	


	
