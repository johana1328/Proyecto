var form = $("#formDatosBasicos");

function validacionFormularioDB(){
	form.validate({
		 errorContainer: "#messageBox1",
         errorLabelContainer: "#messageBox1 ul",
         wrapper: "li",
		rules:{
			tpDoc:{
				required: true
			},
			Doc:{
				required: true,
				number : true,
	            rangelength: [1, 10]
			},
			fechaExp:{
				required: true
			},
			lugarExp:{
				required: true,
			},
			pNombre:{
				required: true,
				alphanumeric: true
			},
			sNombre:{
				required: true,
				alphanumeric: true
			},
			pApellido:{
				required: true,
				alphanumeric: true
			},
			sApellido:{
				required: true,
				alphanumeric: true
			},
			lugarNac:{
				required: true
			},
			fechaNac:{
				required: true
			},
			tel:{
				required: true,
				number : true,
	            rangelength: [1, 10]
			},
			correo:{
				required: true,
				email:true
			},
			direccionDom:{
				required: true
			},
			barrio:{
				required: true
			},
			localidad:{
				required: true
			},
			estadoCiv:{
				required: true,
				alphanumeric: true,
	            rangelength: [1, 50]
			},
			numeroHijos:{
				required: true,
	            rangelength: [1, 20]
			},
			nivelEst:{
				required: true
			},
			fecha:{
				required: true,
			},
			cesantias:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			afp:{
				required: true,
				alphanumeric: true,
	            rangelength: [3, 20]
			},
			rh:{
				required: true
			}
			
		},
		messages:{
			tpDoc:{
				required: "El campo Tipo Documento es requerido",
				alphanumeric:"El campo Cliente solo puede contener letras o numeros",
				rangelength:" Campo Cliente Longitud no permitida"
			},
			Doc:{
				required: "El campo Documento es requerido",
				number:"El campo Documento solo puede contener  numeros",
				rangelength:" Campo Documento Longitud no permitida"
			},
			fechaExp:{
				required:"Seleccione una opcion valida"
			},
			pNombre:{
				required:"El campo Primer Nombre es requerido"
			},
			sNombre:{
				required:"El campo Segundo Nombre es requerido"
			},
			pApellido:{
				required:"El campo Primer Apellido es requerido"
			},
			sApellido:{
				required:"El campo Segundo Apellido es requerido"
			},
			lugarNac:{
				required: "El campo Lugar Nacimiento es requerido",
			},
			fechaExp:{
				required:"Seleccione una opcion valida"
			},
			tel:{
				required: "El campo Telefono es requerido",
				number:"El campo Telefono solo puede contener  numeros",
				rangelength:" Campo Telefono Longitud no permitida"
			},
			correo:{
				required:"El campo Correo es requerido",
				email:"Formato inconrrecto"
			},
			direccionDom:{
				required:"El campo Direccion es requerido"
			},
			barrio:{
				required:"El campo Barrio es requerido"
			},
			localidad:{
				required: "El campo Localidad es requerido",
			},
			estadoCiv:{
				required:"El campo Estado Civil es requerido"
			},
			numeroHijos:{
				required:"El campo Numero Hijos es requerido",
				rangelength:" Campo Numero Hijos  Longitud no permitida"
			},
			nivelEst:{
				required:"El campo Nivel estudios es requerido"
			},
			cesantias:{
				required: "El campo Cesantias  es requerido",
				alphanumeric:"El campo Experiencia minima  solo puede contener letras o numeros",
				rangelength:" Campo Nivel estudios  Longitud no permitida"
			},
			afp:{
				required: "El campo Afp  es requerido",
				alphanumeric:"El campo Descripcion detallada  solo puede contener letras o numeros",
				rangelength:" Campo Descripcion detallada Longitud no permitida"
			},
			rh:{
				required:"El campo RH  es requerido"
			},
			fecha:{
				required: "El campo Fecha  es requerido",
			}
			
		}
	}).settings.ignore = ":disabled,:hidden";
	
	if (form.valid() == true){

		stepper.next();
	}
}

