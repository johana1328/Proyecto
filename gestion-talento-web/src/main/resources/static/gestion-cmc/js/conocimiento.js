var form = $("#conocimiento");

function validacionFormularioCon(){
	form.validate({
		 errorContainer: "#messageBox1",
         errorLabelContainer: "#messageBox1 ul",
         wrapper: "li",
		rules:{
			frontEnd:{
				required: true,
				
			},
			backEnd:{
				required: true
			}
			
		},
		messages:{
			frontEnd:{
				required:"El campo Front End es requerido"
			},
			backEnd:{
				required:"El campo Back End es requerido"
			}
			
		}
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){

		stepper.next();
	}
}

