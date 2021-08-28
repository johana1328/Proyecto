var form = $("#formExperiencia");

function validacionFormularioE(){
	form.validate({
		 errorContainer: "#messageBox1",
         errorLabelContainer: "#messageBox1 ul",
         wrapper: "li",
		rules:{
			empresa:{
				required: true
			
			},
			rol:{
			
			required: true 
			
			},
			duracion:{
			required: true
			
			},
       },
		messages:{
			empresa:{
				required: "El campo empresa es requerido"
			
			},
			rol:{
			
			required: "El campo rol es requerido"
			
			},
			duracion:{
			required: "El campo duracion es requerido"
			
			},
		}
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){
		stepper.next();
	}
}
