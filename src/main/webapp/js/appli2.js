(function() {

function init() {
	$( "#accordion" ).accordion();
}

typeof $script !== "undefined" ? $script.ready("jqui", function() { $(init); }) : $(init);

})();
