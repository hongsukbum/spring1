/**
 * 
 */

function popupError(str){
	
	if(str == "Bad credentials"){
		alert("아이디 및 비밀번호를 확인해주세요.")	
	}
	
	if(str == "User is disabled"){
		alert("정지된 아이디입니다. 관리자에게 문의해주세요.")
	}
	
}