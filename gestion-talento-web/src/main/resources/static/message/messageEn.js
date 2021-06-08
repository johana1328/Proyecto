jQuery.extend(jQuery.validator.messages, {
    required: function(_, el) {
	   let nombre = $('.form-group label[for="'+ el.id+'"]').text();
	    return `The field ${nombre} is required`;
      },
      alphanumeric: function(_, el) {
        var nombre = $('form-group label[for="' + el.id + '"]').text();
		return `The ${nombre} field can only contain letters or numbers`;
	},
	rangelength:  function(_, el) {
		let nombre = $('.form-group label[for="'+ el.id+'"]').text();
		return ` Campo ${nombre} Longitud no permitida`;
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
