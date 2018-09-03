/**
 * 
 */

function productSelect(cate, url){
	
	var id = document.getElementById(cate);
	var selectValue = id.options[id.selectedIndex].value;
	var selectText = id.options[id.selectedIndex].text;
	
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post");
	form.setAttribute("action", url);
	
	var field = document.createElement("input");
	field.setAttribute("type", "hidden");
	field.setAttribute("name", cate);
	field.setAttribute("value", selectValue);
	
	form.appendChild(field);
	document.body.appendChild(form);
	
	form.submit();
	
	//alert("value : " + selectValue + " / test : "  + selectText);
	
}


function productEnrollment(){
	
	var form = document.productForm;
	var url = "/product_enrollmentConfirm";
	
	var pd_pdc_idx = form.pd_pdc_idx.value;
	var pd_name = form.pd_name.value;
	var pd_title = form.pd_title.value;
	var pd_content = form.pd_content.value;
	var pd_image = form.pd_image.value;
	var pd_charge = form.pd_charge.value;
	var pd_count = form.pd_count.value;
	
	var pd_image_tmp = pd_image.split(".");
	
	if(pd_pdc_idx == 0){
		alert("카테고리를 선택하세요.");
		return;
	}
	
	if(pd_name == ""){
		alert("상품 이름을 등록하세요.");
		return;
	}
	
	if(pd_title == ""){
		alert("상품 기본 설명을 등록하세요.");
		return;
	}
	
	if(pd_content == ""){
		alert("상품 상세 설명을 등록하세요.");
		return;
	}
	
	if(pd_image == ""){
		alert("상품 이미지를 등록하세요.");
		return;
	}
	
	if(pd_image_tmp[1] != "png" && pd_image_tmp[1] != "jpg" && pd_image_tmp[1] != "PNG"){
		alert("png 나 jpg 파일을 등록해주세요.");
		return;
	}
	
	if(pd_charge == ""){
		alert("상품 가격을 등록하세요.");
		return;
	}
	
	if(pd_count == ""){
		alert("상품 수량을 등록하세요.");
		return;
	}
	
	form.action = url;
	form.method = "post";
	form.encoding = "multipart/form-data";

	form.submit();
	
}


function productModifyConfirm(){

	var form = document.productForm;
	var url = "/productModifyConfirm"
	
	var pd_name = form.pd_name.value;
	var pd_title = form.pd_title.value;
	var pd_content = form.pd_content.value;
	var pd_image = form.pd_image.value;
	var pd_charge = form.pd_charge.value;
	var pd_count = form.pd_count.value;
	
	var pd_image_tmp = pd_image.split(".");
	
	if(pd_name == ""){
		alert("상품 이름을 등록하세요.");
		return;
	}
	
	if(pd_title == ""){
		alert("상품 기본 설명을 등록하세요.");
		return;
	}
	
	if(pd_content == ""){
		alert("상품 상세 설명을 등록하세요.");
		return;
	}
	
	if(pd_image == ""){
		alert("상품 이미지를 등록하세요.");
		return;
	}
	
	if(pd_image_tmp[1] != "png" && pd_image_tmp[1] != "jpg" && pd_image_tmp[1] != "PNG"){
		alert("png 나 jpg 파일을 등록해주세요.");
		return;
	}
	
	if(pd_charge == ""){
		alert("상품 가격을 등록하세요.");
		return;
	}
	
	if(pd_count == ""){
		alert("상품 수량을 등록하세요.");
		return;
	}
	
	form.action = url;
	form.method = "post";
	form.encoding = "multipart/form-data";

	form.submit();
	
}



var isDelete = false;

function productDelete(pd_idx){
	
	isDelete = true;
	
	var url = "/productDelete";
	var form = document.createElement("form");
	
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post");
	form.setAttribute("action", url);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "pd_idx");
	hiddenField.setAttribute("value", pd_idx);
	
	form.appendChild(hiddenField);
	document.body.appendChild(form);
	
	form.submit();
	
}

var isModify = false;

function productModify(pd_idx){

	isModify = true;
	
	var url = "/product_enrollment";
	var form = document.createElement("form");
	
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post");
	form.setAttribute("action", url);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "pd_idx");
	hiddenField.setAttribute("value", pd_idx);
	form.appendChild(hiddenField);
	
	document.body.appendChild(form);
	
	form.submit();
	
}


var isBagDelete = false;
function productUserBagDelete(index, pd_idx){
	
	isBagDelete = true;
	
	var url = "/productUserBagDelete";
	var form = document.createElement("form");
	
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post");
	form.setAttribute("action", url);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "pd_idx");
	hiddenField.setAttribute("value", pd_idx);
	form.appendChild(hiddenField);
	
	var hiddenField2 = document.createElement("input");
	hiddenField2.setAttribute("type", "hidden");
	hiddenField2.setAttribute("name", "index");
	hiddenField2.setAttribute("value", index);
	form.appendChild(hiddenField2);
	
	document.body.appendChild(form);
	
	form.submit();
	
}


function productDetail(pd_idx, isCheck, index){

	if(isDelete == true) return;
	if(isModify == true) return;
	if(isBagDelete == true) return;
	
	var url = "/productDetail";
	var form = document.createElement("form");
	
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post");
	form.setAttribute("action", url);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "pd_idx");
	hiddenField.setAttribute("value", pd_idx);
	form.appendChild(hiddenField);
	
	if(isCheck == true){
		
		var hiddenField2 = document.createElement("input");
		hiddenField2.setAttribute("type", "hidden");
		hiddenField2.setAttribute("name", "isCheck");
		hiddenField2.setAttribute("value", isCheck);
		form.appendChild(hiddenField2);
	
		var hiddenField3 = document.createElement("input");
		hiddenField3.setAttribute("type", "hidden");
		hiddenField3.setAttribute("name", "index");
		hiddenField3.setAttribute("value", index);
		form.appendChild(hiddenField3);
		
	}else if(isCheck == 'purchaseBag'){

		var hiddenField2 = document.createElement("input");
		hiddenField2.setAttribute("type", "hidden");
		hiddenField2.setAttribute("name", "isCheck");
		hiddenField2.setAttribute("value", isCheck);
		form.appendChild(hiddenField2);
	
		var hiddenField3 = document.createElement("input");
		hiddenField3.setAttribute("type", "hidden");
		hiddenField3.setAttribute("name", "index");
		hiddenField3.setAttribute("value", index);
		form.appendChild(hiddenField3);
	}
	
	document.body.appendChild(form);
	
	form.submit();
	
	
}


function productPurchase(pd_idx, pd_count, isCheck, isBag, pd_charge, index){
	
	var pd_purchase_count = 0;
	
	if(isCheck == true){
		pd_purchase_count = document.getElementById("pd_purchase_count").value; 
		
		if(isBag != "true" && isBag != "" && isBag != "purchaseBag"){
			pd_purchase_count = document.getElementsByName("pd_purchase_count")[isBag].value;
		}

		if(pd_count == 0){
			alert("구매 불가능한 상품입니다.");
			return;
		}
		
		if(pd_purchase_count == "" || parseInt(pd_purchase_count) > parseInt(pd_count) || parseInt(pd_purchase_count) <= 0){
			alert("구매 수량을 확인해주세요.");
			return;
		}
		
	}
	
	var url;	
	var form = document.createElement("form");
	
	if(isCheck == true){
		url = "/productPurchaseCheck";
	}else{
		url = "/productPurchase";
	}
	
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post");
	form.setAttribute("action", url);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "pd_idx");
	hiddenField.setAttribute("value", pd_idx);
	form.appendChild(hiddenField);
	
	if(isCheck == false){
		var hiddenField2 = document.createElement("input");
		hiddenField2.setAttribute("type", "hidden");
		hiddenField2.setAttribute("name", "pd_purchase_count");
		hiddenField2.setAttribute("value", pd_count);
		form.appendChild(hiddenField2);
	}else{
		var hiddenField2 = document.createElement("input");
		hiddenField2.setAttribute("type", "hidden");
		hiddenField2.setAttribute("name", "pd_purchase_count");
		hiddenField2.setAttribute("value", pd_purchase_count);
		form.appendChild(hiddenField2);
	}
	
	var hiddenField3 = document.createElement("input");
	hiddenField3.setAttribute("type", "hidden");
	hiddenField3.setAttribute("name", "isBag");
	hiddenField3.setAttribute("value", isBag);
	form.appendChild(hiddenField3);
	
	var hiddenField4 = document.createElement("input");
	hiddenField4.setAttribute("type", "hidden");
	hiddenField4.setAttribute("name", "pd_charge");
	hiddenField4.setAttribute("value", pd_charge);
	form.appendChild(hiddenField4);
	
	var hiddenField5 = document.createElement("input");
	hiddenField5.setAttribute("type", "hidden");
	hiddenField5.setAttribute("name", "index");
	hiddenField5.setAttribute("value", index);
	form.appendChild(hiddenField5);
	
	document.body.appendChild(form);
	
	form.submit();
}


function productInputBag(pd_idx){
	
	var url = "/productInputBag";
	var form = document.createElement("form");
	
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post");
	form.setAttribute("action", url);
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "pd_idx");
	hiddenField.setAttribute("value", pd_idx);
	
	form.appendChild(hiddenField);
	document.body.appendChild(form);
	
	form.submit();
}


function purchaseStatusUpdate(pdb_idx){
	
	var id = document.getElementById('purchaseStatus');
	var selectValue = id.options[id.selectedIndex].value;
	var selectText = id.options[id.selectedIndex].text;
	alert("value :: " + selectValue);
	var url = "/purchaseStatusUpdate";
	
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post");
	form.setAttribute("action", url);
	
	var field = document.createElement("input");
	field.setAttribute("type", "hidden");
	field.setAttribute("name", "purchaseStatus");
	field.setAttribute("value", selectValue);
	form.appendChild(field);
	
	var field1 = document.createElement("input");
	field1.setAttribute("type", "hidden");
	field1.setAttribute("name", "pdb_idx");
	field1.setAttribute("value", pdb_idx);
	form.appendChild(field1);
	
	document.body.appendChild(form);
	
	form.submit();
	
}




