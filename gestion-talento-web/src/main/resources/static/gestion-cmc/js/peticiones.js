var form = $("#formCrearPeticion");

function validacionFormularioP(){
	form.validate({
		 errorContainer: "#messageBox1",
         errorLabelContainer: "#messageBox1 ul",
         wrapper: "li",
		rules:{
			areaSolicitante:{
				required: true
			},
			cliente:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			responsableCliente:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			tarifa:{
				required: true
			},
			areaTrabajo:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			cantVacante:{
				required: true,
				alphanumeric: true,
	            rangelength: [1, 9]
			},
			horasApagar:{
				required: true,
				alphanumeric: true,
	            rangelength: [1,50]
			},
			perfilSolicitado:{
				required: true
			},
			especialidad:{
				required: true
			},
			expAnos:{
				required: true,
				
			},
			pSolicitado:{
				required: true
			},
			ambiente:{
				required: true
			},
			escolaridad:{
				required: true
			},
			
			descripcion:{
				required: true,
				alphanumeric: true,
	            rangelength: [1, 20]
			},
			tipoContracto:{
				required: true
			},
			fecha:{
				required: true,
			},
			observaciones:{
				
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			salario:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			equipoCom:{
				required: true
			},
			caracteristica:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			
		},
		messages:{
			areaSolicitante:{
				required: "El proyecto o area solicitante es requerido. "
			},
			cliente:{
				required: "El campo cliente es requerido",
				alphanumeric:"El campo cliente solo puede contener letras o numeros",
				rangelength:" Campo cliente longitud no permitida"
			},
			responsableCliente:{
				required: "El campo responsable cliente es requerido",
				alphanumeric:"El campo Responsable cliente solo puede contener letras o numeros",
				rangelength:" Campo responsable cliente longitud no permitida"
			},
			tarifa:{
				required:"La tarifa es requerida"
			},
			areaTrabajo:{
				required: "La area trabajo es requerida.",
				alphanumeric:"El campo area trabajo solo puede contener letras o numeros",
				rangelength:" Campo area trabajo longitud no permitida"
			},
			cantVacante:{
				required: "El campo cantidad vacante es requerido",
				alphanumeric:"El campo cantidad vacante solo puede contener letras o numeros",
				rangelength:" Campo cantidad vacante longitud no permitida"
			},
			horasApagar:{
				required: "El campo horas a pagar es requerido",
				alphanumeric:"El campo horas a pagar solo puede contener letras o numeros",
				rangelength:" Campo horas a pagar longitud no permitida"
			},
			perfilSolicitado:{
				required:"El perfil solicitado es requerido."
			},
			especialidad:{
				required:"La especialidad es reuqerida."
			},
			expAnos:{
				required: "El campo Experiencia maxima es requerido",
			},
			pSolicitado:{
				required:"El perfil solicitado funcionalmente que va realizar es requerido."
			},
			ambiente:{
				required:"El ambiente es requerido."
			},
			escolaridad:{
				required:"La escolaridad es requerida."
			},
			
			descripcion:{
				required: "El campo descripcion detallada  es requerido",
				alphanumeric:"El campo descripcion detallada  solo puede contener letras o numeros",
				rangelength:" Campo descripcion detallada Longitud no permitida"
			},
			tipoContracto:{
				required:"El tipo de contrato es requerido"
			},
			fecha:{
				required: "La fecha  es requerida.",
			},
			observaciones:{
				
				alphanumeric:"El campo observaciones generales  solo puede contener letras o numeros",
				rangelength:" Campo observaciones generales Longitud no permitida"
			},
			salario:{
				required: "El campo salario asignado  es requerido",
				alphanumeric:"El campo salario asignado  solo puede contener letras o numeros",
				rangelength:" Campo salario asignado Longitud no permitida"
			},
			equipoCom:{
				required:"El equipo de computo es requerido."
			},
			caracteristica:{
				required: "El campo caracteristica  es requerido",
				alphanumeric:"El campo caracteristica  solo puede contener letras o numeros",
				rangelength:" Campo caracteristica Longitud no permitida"
			}
			
		}
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){
		stepper.next();
	}
}