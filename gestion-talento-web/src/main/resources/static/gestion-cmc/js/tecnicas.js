var form = $("#formLenguajes");

function validacionFormularioE(){
	form.validate({
		 errorContainer: "#messageBox1",
         errorLabelContainer: "#messageBox1 ul",
         wrapper: "li",
		rules:{
			perfilPro:{
				required: true
			
			},
			experiencia:{
			required: true 
			
			},
			
       },
		messages:{
			perfilPro:{
				required: "El campo perfil profesional es requerido"
			
			},
			experiencia:{
			required: "El campo experiencia profesional es requerido"
			
			},
		}
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){
		stepper.next();
	}
}
