function loginCheck() {
	if (document.frm.emp_id.value.length == 0) {
		alert("아이디를 써주세요");
		frm.emp_id.focus();
		return false;
	}
	if (document.frm.emp_pass.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.emp_pass.focus();
		return false;
	}
	return true;
}

function idCheck() {
	if (document.frm.emp_id.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.formm.emp_id.focus();
		return;
	}
	var url = "idCheck.do?emp_id=" + document.frm.emp_id.value;
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok(emp_id) {
	opener.frm.emp_id.value = document.frm.emp_id.value;
	opener.frm.reid.value = document.frm.emp_id.value;
	self.close();
}

function joinCheck() {
	if (document.frm.emp_name.value.length == 0) {
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	else if (document.frm.emp_id.value.length == 0) {
		alert("아이디를 써주세요");
		frm.emp_id.focus();
		return false;
	}
	else if (document.frm.emp_id.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.");
		frm.emp_id.focus();
		return false;
	}
	else if (document.frm.emp_pass.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.emp_pass.focus();
		return false;
	}
	else if (document.frm.emp_dept.value == "") {
		alert("부서는 반드시 입력해야 합니다.");
		frm.emp_dept.focus();
		return false;
	}
	else if (document.frm.emp_pass.value != document.frm.emp_pass_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.emp_pass.focus();
		return false;
	}
	else if (document.frm.reid.value.length == 0) {
		alert("중복 체크를 하지 않았습니다.");
		frm.emp_id.focus();
		return false;
	}
	return true;
}