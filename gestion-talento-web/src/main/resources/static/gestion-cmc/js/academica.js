var form = $("#academica");

function validacionFormularioAca(){
	form.validate({
		 errorContainer: "#messageBox1",
         errorLabelContainer: "#messageBox1 ul",
         wrapper: "li",
		rules:{
			nombre:{
				required: true,
				alphanumeric: true
			},
			lugEst:{
				required: true,
				alphanumeric: true
			},
			ciudad:{
				required: true,
				alphanumeric: true
			},
			anoFinalizacion:{
				required: true,
				alphanumeric: true
			},
			certificados:{
				
			},
			pais:{
				required: true
			}
			
		},
		messages:{
			nombre:{
				required:"El campo  Nombre es requerido"
			},
			lugNac:{
				required:"El campo Lugar Nacimiento es requerido"
			},
			ciudad:{
				required:"El campo Ciudad es requerido"
			},
			anoFinalizacion:{
				required:"El campo Año Finalizacion es requerido"
			},
			certificados:{
				required: "El campo Certificados es requerido",
			},
			pais:{
				required:"El campo Pais es requerido"
			}
			
		}
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){

		stepper.next();
	}
}

