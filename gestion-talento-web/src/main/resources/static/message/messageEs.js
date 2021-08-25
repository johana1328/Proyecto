jQuery.extend(jQuery.validator.messages, {
	required: function(_, el) {
		let nombre = $('.form-group label[for="'+ el.id+'"]').text();
		return `El campo ${nombre} es requerido`;
	},
	alphanumeric: function(_, el) {
       let nombre = $('.form-group label[for="'+ el.id+'"]').text();
	  return `El campo ${nombre} solo puede contener letras o numeros`;
	},
	rangelength:  function(_, el) {
		let nombre = $('.form-group label[for="'+ el.id+'"]').text();
		return ` Campo ${nombre} longitud no permitida`;
	},
	email:function(_, el) {
		let nombre = $('.form-group label[for="'+ el.id+'"]').text();
		return `Campo ${nombre} formato no valido`;
	},
	number:function(_, el) {
		let nombre = $('.form-group label[for="'+ el.id+'"]').text();
		return `El campo ${nombre} solo puede contener numeros`;
	},
	minlength:function(_, el) {
		let nombre = $('.form-group label[for="'+ el.id+'"]').text();
		return `Campo ${nombre} longitud no permitida`;
	},
	maxlength:function(_, el) {
		let nombre = $('.form-group label[for="'+ el.id+'"]').text();
		return `Campo ${nombre} longitud no permitida`;
	}
});
