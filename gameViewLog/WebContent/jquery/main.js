

$("#left ul li").click(function() {
	
	$("#centroJstl").hide();
	$("#centroAngular").hide();
	$("#centroDetalhadoPartida").hide();
	
	
	switch ($(this).index()) {
    case 0:        
        $("#centroAngular").show();
        break;
    case 1:
    	$("#centroJstl").show();
        break;
    case 2:
    	$("#centroDetalhadoPartida").show();
        break;
        
	}
	
});


