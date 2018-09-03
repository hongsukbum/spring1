/**
 * 
 */

function goJoinPage(){
	
	location.href = "join";
	
}


function pageBack(){
	
	history.back();
	
}


function pageMain(){
	
	location.href = "/";
	
}


function pageModify(){
	location.href = "userinfoPage";
}


//maxlength 체크
function maxLengthCheck(object){
	
	if (object.value.length > object.maxLength){
		object.value = object.value.slice(0, object.maxLength);
	}    
	
}


// 뒤로가기 막음.
function noneBack(){
	
	history.pushState(null, null, location.href);
    window.onpopstate = function () {
        history.go(1);
	};
	
}


// 돈 콤마 표시.
function addComma(x){
	return Number(x).toLocaleString('en');
}

