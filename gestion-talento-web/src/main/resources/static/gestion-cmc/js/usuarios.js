/** Validaciones de formulario paso a paso*/
var form = $("#formCrearUsuario");

function validacionFormulario(){
	form.validate({
		 errorContainer: "#messageBox1",
         errorLabelContainer: "#messageBox1 ul",
         wrapper: "li",
		rules:{
			tipoDocumento:{
				required: true
			},
			nombre1:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			correo:{
				required: true,
				email: true
			},
			telefono:{
				required: true,
				number: true,
                minlength:7,
                maxlength:10
			},
		},
		messages:{
			nombre1:{
				required: "El camo Primer nombre es requerido",
				alphanumeric:"El campo Primer nombre solo puede contener letras o numeros",
				rangelength:" Campo Primer nombre Longitud no permitida"
			},
			tipoDocumento:{
				required:"Seleccione una opcion valida"
			},
			correo:{
				required:"El campo correo es requerido",
				email: "Campo correo formato no valido"
			},
			telefono:{
				required:"El campo telefono es requerido",
				number:"El campo telefono solo puede contener numeros",
				minlength:"Campo telefono longitud no permitida",
				maxlength:"Campo telefono longitud no permitida"
			}
		}
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){
		stepper.next();
	}
}

function stepInformacionLaboral(){}
