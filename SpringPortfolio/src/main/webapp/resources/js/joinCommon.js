/**
 * 
 */

var popupName;

function checkId(strPopupName){
	
	popupName = strPopupName;
	var parentForm = document.joinForm;
	var str = parentForm.uid.value.trim();
	var popup;
	
	if(str == ""){
		alert("중복 체크할 아이디를 입력해주세요.");
	}else{
		
		var url = "/checkUserId";
		
		popup = window.open("", popupName,"width=500, height=300, scrollbars=no");
		
		popup.focus();
		
		parentForm.uid.value = str;
		
		parentForm.action = url;
		parentForm.method = "post";
		parentForm.target=popupName;
		
		parentForm.submit();
			
	}
	
}


function usedId(sendUrl){
	
	var form = document.joinForm;
	var str = form.uid.value.trim();
	var url = sendUrl;
	
	form.uid.value = str;
	form.checkIdPopupReturn.value = true;
	
	form.action = url;
	form.method = "post";
	
	if(sendUrl == "/join"){
		form.target = "joinPage";	// 부모창 이름 지정하고 그리로 데이터 전송..
	}else if(sendUrl == "/userinfoModifyPage"){
		form.target = "modifyPage";
	}else if(sendUrl == "/adminAddAccount"){
		form.target = "addAdmin";
	}
	
	form.submit();
	
	self.close();
	
}


function checkNick(strPopupName){
	
	popupName = strPopupName;
	var parentForm = document.joinForm;
	var str = parentForm.unick.value.trim();
	var popup;
	
	if(str == ""){
		alert("중복 체크할 닉네임을 입력해주세요.");
	}else{
		
		var url = "/checkUserNick";
		
		popup = window.open("", popupName,"width=500, height=300, scrollbars=no");
		
		popup.focus();
		
		parentForm.unick.value = str;
		
		parentForm.action = url;
		parentForm.method = "post";
		parentForm.target = popupName;
		
		parentForm.submit();
			
	}
	
}


function usedNick(sendUrl){
	
	var form = document.joinForm;
	var str = form.unick.value;
	var url = sendUrl;
	
	form.unick.value = str;
	form.checkNickPopupReturn.value = true;
	
	form.action = url;
	form.method = "post";
	
	if(sendUrl == "/join"){
		form.target = "joinPage";	// 부모창 이름 지정하고 그리로 데이터 전송..
	}else if(sendUrl == "/userinfoModifyPage"){
		form.target = "modifyPage";
	}
	
	form.submit();
	
	self.close();
	
}


function joinConfirm(){
	
	var form = document.joinForm;
	
	if(form.uid.value.trim() == ""){
		alert("아이디를 입력해주세요.");
		return;
	}
	
	if(form.tmpCheckId.value.trim() == ""){
		alert("아이디 중복체크를 해주세요.");
		return;
	}
	
	if(form.upw.value.trim() == ""){
		alert("비밀번호를 입력하세요.");
		return;
	}
	
	if(form.upw.value.trim() != form.upw_check.value.trim()){
		alert("비밀번호를 확인해주세요.");
		return;
	}
	
	if(form.unick.value.trim() == ""){
		alert("닉네임을 입력해주세요.");
		return;
	}
	
	if(form.tmpCheckNick.value.trim() == ""){
		alert("닉네임 중복체크를 해주세요.");
		return;
	}
	
	if(form.phone2.value.trim() == "" || form.phone3.value.trim() == ""){
		alert("휴대폰 번호를 해주세요.");
		return;
	}
	
	if(form.uaddr.value.trim() == ""){
		alert("주소를 해주세요.");
		return;
	}
	
	if(form.ubirth.value.trim() == "" || form.ubirth.value.length < 6 ){
		alert("생년월일을 해주세요.(6자리)");
		return;
	}
	
	if(form.ugender.value.trim() == ""){
		alert("성별을 체크해주세요.");
		return;
	}
	
	var url = "/joinConfirm";
	
	form.action = url;
	form.method = "post";
	
	form.submit();
	
	
}


function modifyConfirm(prevNick, nickCheck){
	
	var form = document.joinForm;
	
	var nowNick = form.unick.value.trim();
	
	//alert("check :: " + prevNick + " :: " + nowNick + " :: " + nickCheck);
	
	if(prevNick != nowNick && nickCheck == ""){
		
		alert("닉네임 중복체크를 해주세요.");
		return;
		
	}
	
	if(form.upw.value.trim() == "" ){
		alert("비밀번호를 입력하세요.");
		return;
	}
	
	if(form.upw.value.trim() != form.upw_check.value.trim()){
		alert("비밀번호를 확인해주세요.");
		return;
	}
	
	var url = "/userModifyConfirm";
	
	form.action = url;
	form.method = "post";
	
	form.submit();
	
}


function adminConfirm(){
	
	var form = document.joinForm;
	
	if(form.uid.value.trim() == ""){
		alert("아이디를 입력해주세요.");
		return;
	}
	
	if(form.tmpCheckId.value.trim() == ""){
		alert("아이디 중복체크를 해주세요.");
		return;
	}
	
	if(form.upw.value.trim() == ""){
		alert("비밀번호를 입력하세요.");
		return;
	}
	
	if(form.upw.value.trim() != form.upw_check.value.trim()){
		alert("비밀번호를 확인해주세요.");
		return;
	}
	
	if(form.unick.value.trim() == ""){
		alert("닉네임을 입력해주세요.");
		return;
	}
	
	var url = "/adminAccountConfirm";
	
	form.action = url;
	form.method = "post";
	
	form.submit();
	
}










