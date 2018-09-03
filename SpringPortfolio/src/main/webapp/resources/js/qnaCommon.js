/**
 * 
 */
function move_qna_list(){
	//alert("move_qna_list()");	
	
	location.href = "/qnalist";
}

function qna_write_confirm(){
	//alert("qna_write_confirm()");
	
	var form = document.qnaWrite;
	
	if(form.select_cate.value.trim()== "0"){
		alert("카테고리를 선택하세요.");
		return;
	}
	
	if(form.qna_title.value.trim() == ""){
		alert("제목을 작성해 주세요.");
		return;
	}
	
	if(form.qna_content.value.trim() == ""){
		alert("내용을 작성해 주세요.");
		return;
	}
	
	var url = "/qnaWriteConfirm";
	
	form.action = url;
	form.method = "post";
	
	form.submit();
}

function qna_write(){
	location.href = "/qnaWrite";
}

function qna_view(qna_idx){
	
	var url = "/qnaView";
	var form = document.createElement("form");
	
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "post");
	form.setAttribute("action", url);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name","qna_idx");
	hiddenField.setAttribute("value",qna_idx);
	
	form.appendChild(hiddenField);
	document.body.appendChild(form);
	
	//alert(qna_idx);
	
	form.submit();
}

function qna_modify(qna_title,qna_content, qna_idx,qna_qnac_idx){

	var url = "/qnaWrite";
	var form = document.createElement("form");
	
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "post");
	form.setAttribute("action", url);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name","qna_title");
	hiddenField.setAttribute("value",qna_title);
	
	form.appendChild(hiddenField);
	
	var hiddenField2 = document.createElement("input");
	hiddenField2.setAttribute("type","hidden");
	hiddenField2.setAttribute("name","qna_content");
	hiddenField2.setAttribute("value",qna_content);
	
	form.appendChild(hiddenField2);
	
	var hiddenField3 = document.createElement("input");
	hiddenField3.setAttribute("type","hidden");
	hiddenField3.setAttribute("name","qna_idx");
	hiddenField3.setAttribute("value",qna_idx);
	
	form.appendChild(hiddenField3);
	
	var hiddenField4 = document.createElement("input");
	hiddenField4.setAttribute("type","hidden");
	hiddenField4.setAttribute("name","qna_qnac_idx");
	hiddenField4.setAttribute("value",qna_qnac_idx);
	
	form.appendChild(hiddenField4);
	
	document.body.appendChild(form);
	
	form.submit();
}

function qna_modify_confirm(qna_idx){

	var form = document.qnaWrite;
	
	if(form.qna_title.value.trim() == ""){
		alert("제목을 작성해 주세요.");
		return;
	}
	
	if(form.qna_content.value.trim() == ""){
		alert("내용을 작성해 주세요.");
		return;
	}
	
	var url = "/qnaModifyConfirm";
	form.action = url;
	form.method = "post";
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name","qna_idx");
	hiddenField.setAttribute("value",qna_idx);
	
	form.appendChild(hiddenField);
	
	form.submit();
}

function qna_remove(qna_idx){
	var form = document.createElement("form");
	
	var url = "/qnaRemove";

	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "post");
	form.setAttribute("action", url);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name","qna_idx");
	hiddenField.setAttribute("value",qna_idx);
	
	form.appendChild(hiddenField);
	document.body.appendChild(form);
	
	form.submit();
}

function admin_replyWrite(qna_idx){
	
	var form = document.createElement("form");
	
	var url = "/admin_replyWrite";
	
	form.setAttribute("charset","UTF-8");
	form.setAttribute("method","post");
	form.setAttribute("action",url);
	
	var hiddenField = document.createElement("input");
	
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name","qna_idx");
	hiddenField.setAttribute("value",qna_idx);
	
	form.appendChild(hiddenField);
	document.body.appendChild(form);
	
	form.submit();
}

function admin_replyWriteConfirm(qna_idx){
	
	//alert("replyWriteConfirm()");
	
	//replay form 받아오기
	var form = document.admin_replyWrite;
	
	//action 경로 설정
	var url = "/admin_replyWriteConfirm";
	
	form.action = url;
	
	//기본적으로 담긴 내용 확인
	if(form.ab_content.value.trim()==""){
		alert("내용을 입력해 주세요.");
		return;
	}
	
	//form에 담에 보낼 요소 추가
	var hiddenField = document.createElement("input");
	
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name","qna_idx");
	hiddenField.setAttribute("value",qna_idx);
	
	//요소를 form에 담아주기
	form.appendChild(hiddenField);
	
	//form을 지정된 경로로 전송
	form.submit();
}
function reply_confirm(pd_idx){
	
	var form = document.userReply;
	
	var url = "/userReply";
	
	form.setAttribute("action",url);
	form.setAttribute("method","post");
	form.setAttribute("charset","UTF-8");
	
	var hiddenField = document.createElement("input");
	
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name","pd_idx");
	hiddenField.setAttribute("value",pd_idx);
	
	if(form.product_reply.value.trim()==""){
		alert("내용을 입력해 주세요.");
		return;
	}
	
	form.appendChild(hiddenField);
	document.body.appendChild(form);
	
	form.submit();
}

function user_detail(uidx){
	
	var form = document.createElement("form");
	var url = "/userDetail";
	
	form.setAttribute("action",url);
	form.setAttribute("method","post");
	form.setAttribute("charset","UTF-8");
	
	var hiddenField = document.createElement("input");
	
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name","uidx");
	hiddenField.setAttribute("value",uidx);
	
	form.appendChild(hiddenField);
	document.body.appendChild(form);
	
	form.submit();
}

function userban(uidx){
	
	var form = document.createElement("form");
	var url = "/userBan";
	
	form.setAttribute("action",url);
	form.setAttribute("method","post");
	form.setAttribute("charset","UTF-8");
	
	var hiddenField = document.createElement("input");
	
	hiddenField.setAttribute("type","hidden");
	hiddenField.setAttribute("name","uidx");
	hiddenField.setAttribute("value",uidx);
	
	form.appendChild(hiddenField);
	document.body.appendChild(form);
	
	form.submit();
}

function userlist(){
	
	location.href = "redirect:/adminUserInfoList";
}