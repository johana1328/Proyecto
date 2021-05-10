
var form = $("#formCrearCandidato");

function validacionFormulario(){
	form.validate({
		 errorContainer: "#messageBox1",
         errorLabelContainer: "#messageBox1 ul",
         wrapper: "li",
		rules:{
			tipoDocumento:{
				required: true
			},
			documento:{
				required:true,
				number : true,
				
			},
			nombre1:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			nombre2:{
				alphanumeric: true,
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
				email: true,
			},
			telefono:{
				required: true,
				number: true,
                minlength:7,
                maxlength:10
			},
			titulo:{
				required:true,	
			},
			objetivo:{
				required:true,
				
			},
			trabajo:{
				required:true,
				
			},
			contrato:{
				required:true,
			},
			origen:{
				required:true,
			},
			sueldoActual:{
				required:true,
				number:true,
			}
		},
		messages:{
			nombre1:{
				required: "El campo Primer nombre es requerido",
				alphanumeric:"El campo Primer nombre solo puede contener letras o numeros",
				rangelength:" En el campo primer nombre minimo 3 caracteres maximo 20 caracteres "
			},
			nombre2:{
				alphanumeric:"El campo segundo nombre solo puede contener letras o numeros",
			},
			apellido1:{
				required: "El campo primer apellido es requerido",
				rangelength: "En el campo primer apellido minimo 3 caracteres maximo 20 caracteres "
			},
			apellido2:{
				required: "El campo segundo apellido es requerido",
				rangelength: "En el campo segundo apellido minimo 3 caracteres maximo 20 caracteres "
			
			},
			tipoDocumento:{
				required:"Seleccione una opcion valida en el campo tipo documento"
			},
			documento:{
				required:"Escriba su numero de documento",
				number:"En el campo documento debe digitar solo numeros"
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
			titulo:{
				required:"El campo titulo universitario es requerido",
			},
			objetivo:{
				required:"El campo objetivos es requerido",
			},
			trabajo:{
				required:"El campo trabaja actualmente es requerido"
			},
			contrato:{
				required:"El campo que tipo de contrato es requerido",
				
			},
			origen:{
				required:"El campo origen de la hoja de vida es requerido",
			},
			sueldoActual:{
				required:"El campo sueldo actual es requerido",
				number:"En el campo sueldo actual solo admite numeros"
			},
		}
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){
		stepper.next();
	}
}









