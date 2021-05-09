/** Validaciones de formulario paso a paso*/
var form = $("#formCrearUsuario");

function stepDataosBasicos(){
	form.validate({
		onclick: false,
		rules:{
			tipoDocumento:{
				required: true
			},
			nombre1:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			}
		},
		messages:{
			nombre1:{
				required: "El camo Primer nombre es requerido",
				alphanumeric:"El campo Primer nombre solo puede contener letras o numeros",
				rangelength:" Campo Primer nombre Longitud no permitida"
			},
			tipoDocumento:{
				required:"Seleccione una opcion valida"
			}
		},
		errorPlacement:function( error, element ){
			$('.alert').show();
			$('.msg').text($(error[0]).text());
		},
		success: function(label) {
             $('.alert').hide();
        }
	});
	
	if (form.valid() == true){
		stepper.next();
	}
}
