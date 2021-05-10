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
			numDoc:{
				required: true,
				alphanumeric: true,
				rangelength: [3, 20]
			},
			nombre1:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			nombre2:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			apellido1:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			apellido2:{
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
			codidoUsario:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			}
		},
		messages:{
			tipoDocumento:{
				required:"Seleccione una opcion valida"
			},
			numDoc:{
				required: "El camo Numero documento nombre es requerido",
				alphanumeric:"El campo Numero documento solo puede contener letras o numeros",
				rangelength:" Campo Numero documento Longitud no permitida"
			},
			nombre1:{
				required: "El camo Primer nombre es requerido",
				alphanumeric:"El campo Primer nombre solo puede contener letras o numeros",
				rangelength:" Campo Primer nombre Longitud no permitida"
			},
			nombre2:{
				required: "El camo Segundo nombre es requerido",
				alphanumeric:"El campo Segundo nombre solo puede contener letras o numeros",
				rangelength:" Campo Segundo nombre Longitud no permitida"
			},
			apellido1:{
				required: "El camo Primer apellido es requerido",
				alphanumeric:"El campo Primer apellido solo puede contener letras o numeros",
				rangelength:" Campo Primer apellido Longitud no permitida"
			},
			apellido2:{
				required: "El camo Segundo apellido es requerido",
				alphanumeric:"El campo Segundo apellido solo puede contener letras o numeros",
				rangelength:" Campo Segundo apellido Longitud no permitida"
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
			},
			codidoUsario:{
				required: "El camo Código usuario nombre es requerido",
				alphanumeric:"El campo Código usuario solo puede contener letras o numeros",
				rangelength:" Campo Código usuario Longitud no permitida"
			}
		}
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){
		stepper.next();
	}
}

function stepInformacionLaboral(){}
