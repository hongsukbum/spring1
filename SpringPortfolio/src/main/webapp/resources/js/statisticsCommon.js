/**
 * 
 */

function goStatistics(state){
	
	var url = "/statistics";
	
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post");
	form.setAttribute("action", url);
	
	var field = document.createElement("input");
	field.setAttribute("type", "hidden");
	field.setAttribute("name", "state");
	field.setAttribute("value", state);
	form.appendChild(field);
	
	document.body.appendChild(form);
	
	form.submit();
	
}


