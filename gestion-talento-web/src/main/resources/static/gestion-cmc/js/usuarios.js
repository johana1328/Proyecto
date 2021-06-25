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
				number: true,
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
			},
			jefe:{
			required:true,
			
			},
			tipo:{
			required:true,
			},
			area:{
			required:true,
			}
		}
		
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){
		stepper.next();
	}
}

function stepInformacionLaboral(){}
