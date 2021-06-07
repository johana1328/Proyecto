jQuery.extend(jQuery.validator.messages, {
    required: function(_, el) {
	  return  `The field ${el.name} is required`
      }
});