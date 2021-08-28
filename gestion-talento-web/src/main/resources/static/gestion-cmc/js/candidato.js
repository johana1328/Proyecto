
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
				noSpace: true
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
			
			
			
			
			
			
			
		}
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){
		stepper.next();
	}
}









