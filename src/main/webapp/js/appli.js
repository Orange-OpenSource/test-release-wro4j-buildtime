(function() {

function init() {
	$("#tabs").tabs();
}

typeof $script !== "undefined" ? $script.ready("jqui", function() { $(init); }) : $(init);

})();
