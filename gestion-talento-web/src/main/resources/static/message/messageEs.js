jQuery.extend(jQuery.validator.messages, {
    required: function(_, el) {
	    return `El campo ${el.name} es requerido`
      }
});

/*$.validator.messages.required = 'required';
$.validator.message.required = function(_, el) {
    return `El campo ${el.name} es requerido`
}*/