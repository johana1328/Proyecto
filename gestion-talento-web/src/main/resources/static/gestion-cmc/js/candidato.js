
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
			},
			aspiracion:{
				required:true,
			},
			disponibilidad:{
				required:true,
			},
			horario:{
				required:true,
			},
			observacion:{
				required:true,
			}
		},
		messages:{
			tipoDocumento:{
				required: "El campo tipo de documento es requerido",
			},
			documento:{
				required:"El campo documento es requerido",
				number: "En el documento es requerido escribir el numero de documento"
				
			},
			nombre1:{
				required: "El campo nombre es requerido",
				alphanumeric: "El campo primer nombre solo recibe letras",
	            rangelength: "En el campo primer nombre el rango no es permitido"
			},
			nombre2:{
				alphanumeric: "El campo segundo nombre solo recibe letras",
			},
			apellido1:{
				required: "El campo primer apellido",
				alphanumeric: "El campo primer apellido solo recibe letras",
				rangelength: "En el campo primer apellido el rango no es permitido"
			},
			apellido2:{
				required: "El Campo segundo apellido es requerido",
				alphanumeric: "El campo segundo apellido solo recibe letras",
				rangelength: "En el campo segundo apellido el rango no es permitido"
			},
			correo:{
				required: "El campo correo es requerido",
				email: "El campo correo admite solo correos electronicos"
			},
			telefono:{
				required: "El campo telefono es requerido",
				number: "El campo telefono solo recibe numeros"
                
			},
			titulo:{
				required:"El campo titulo es requerido",	
			},
			objetivo:{
				required:"El campo objetivo es requerido",
				
			},
			trabajo:{
				required:"El campo trabajo es requerido",
				
			},
			contrato:{
				required:"El campo contrato es requerido",
			},
			origen:{
				required:"El campo origen es requerido",
			},
			sueldoActual:{
				required:"El campo sueldo es requerido",
				number: "El campo sueldo solo recibe"
			},
			aspiracion:{
				required:"El campo de aspiracion es requerido",
			},
			disponibilidad:{
				required:"El campo disponibilidad es requerido",
			},
			horario:{
				required:"El campo horario es requerido",
			},
			observacion:{
				required:"El campo de observacion es requerido",
			}
		}
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){
		stepper.next();
	}
}









