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
		return ` Length field ${nombre} not allowed `;
	},
	email:function(_, el) {
		let nombre = $('.form-group label[for="'+ el.id+'"]').text();
		return ` ${nombre} field invalid format`;
	},
	number:function(_, el) {
		let nombre = $('.form-group label[for="'+ el.id+'"]').text();
		return `The ${nombre} field can only contain numbers`;
	},
	minlength:function(_, el) {
		let nombre = $('.form-group label[for="'+ el.id+'"]').text();
		return ` ${nombre} field length not allowed`;
	},
	maxlength:function(_, el) {
		let nombre = $('.form-group label[for="'+ el.id+'"]').text();
		return ` ${nombre} field length not allowed`;
	}
});
