var form = $("#formCrearPeticion");

function validacionFormularioP(){
	form.validate({
		 errorContainer: "#messageBox1",
         errorLabelContainer: "#messageBox1 ul",
         wrapper: "li",
		rules:{
			proyecto:{
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
			expMaAnos:{
				required: true,
				alphanumeric: true,
	            rangelength: [1, 20]
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
			expMiAnos:{
				required: true,
				alphanumeric: true,
	            rangelength: [1, 50]
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
				required: true,
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
			proyecto:{
				required:"Seleccione una opcion valida"
			},
			cliente:{
				required: "El campo Cliente es requerido",
				alphanumeric:"El campo Cliente solo puede contener letras o numeros",
				rangelength:" Campo Cliente Longitud no permitida"
			},
			responsableCliente:{
				required: "El campo Responsable Cliente es requerido",
				alphanumeric:"El campo Responsable Cliente solo puede contener letras o numeros",
				rangelength:" Campo Responsable Cliente Longitud no permitida"
			},
			tarifa:{
				required:"Seleccione una opcion valida"
			},
			areaTrabajo:{
				required: "El campo Area Trabajo es requerido",
				alphanumeric:"El campo Area Trabajo solo puede contener letras o numeros",
				rangelength:" Campo Area Trabajo Longitud no permitida"
			},
			cantVacante:{
				required: "El campo Cantidad Vacante es requerido",
				alphanumeric:"El campo Cantidad Vacante solo puede contener letras o numeros",
				rangelength:" Campo Cantidad Vacante Longitud no permitida"
			},
			horasApagar:{
				required: "El campo Horas Apagar es requerido",
				alphanumeric:"El campo Horas Apagar solo puede contener letras o numeros",
				rangelength:" Campo Horas Apagar Longitud no permitida"
			},
			perfilSolicitado:{
				required:"Seleccione una opcion valida"
			},
			especialidad:{
				required:"Seleccione una opcion valida"
			},
			expMaAnos:{
				required: "El campo Experiencia maxima es requerido",
				alphanumeric:"El campo Experiencia maxima solo puede contener letras o numeros",
				rangelength:" Campo Experiencia maxima Longitud no permitida"
			},
			pSolicitado:{
				required:"Seleccione una opcion valida"
			},
			ambiente:{
				required:"Seleccione una opcion valida"
			},
			escolaridad:{
				required:"Seleccione una opcion valida"
			},
			expMiAnos:{
				required: "El campo Experiencia minima  es requerido",
				alphanumeric:"El campo Experiencia minima  solo puede contener letras o numeros",
				rangelength:" Campo Experiencia minima  Longitud no permitida"
			},
			descripcion:{
				required: "El campo Descripcion detallada  es requerido",
				alphanumeric:"El campo Descripcion detallada  solo puede contener letras o numeros",
				rangelength:" Campo Descripcion detallada Longitud no permitida"
			},
			tipoContracto:{
				required:"Seleccione una opcion valida"
			},
			fecha:{
				required: "El campo Fecha  es requerido",
			},
			observaciones:{
				required: "El campo Observaciones generales  es requerido",
				alphanumeric:"El campo Observaciones generales  solo puede contener letras o numeros",
				rangelength:" Campo Observaciones generales Longitud no permitida"
			},
			salario:{
				required: "El campo Salario Asignado  es requerido",
				alphanumeric:"El campo Salario Asignado  solo puede contener letras o numeros",
				rangelength:" Campo Salario Asignado Longitud no permitida"
			},
			equipoCom:{
				required:"Seleccione una opcion valida"
			},
			caracteristica:{
				required: "El campo caracteristica  es requerido",
				alphanumeric:"El campo caracteristica  solo puede contener letras o numeros",
				rangelength:" Campo caracteristica Longitud no permitida"
			}
			
		},
		errorPlacement:function( error, element ){
			//alert($(error[0]).text());
			$('.alert').show();
			$('.msg').text($(error[0]).text());
		},
		success: function(label) {
			//alert("OK");
          //   $('.alert').hide();
        }
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){
		stepper.next();
	}
}