// 모든 체크박스를 체크하는 기능
function allChk(obj) {
	var chkObj = document.getElementsByName("RowCheck");
	var rowCnt = chkObj.length - 1;
	var check = obj.checked;
	if (check) {
		for (var i = 0; i <= rowCnt; i++) {
			if (chkObj[i].type == "checkbox")
				chkObj[i].checked = true;
		}
	} else {
		for (var i = 0; i <= rowCnt; i++) {
			if (chkObj[i].type == "checkbox") {
				chkObj[i].checked = false;
			}
		}
	}
}

// 체크박스 선택된 것 삭제처리(n개)
function ordDel(){

	  var ordNo = null;
	  var ordChk = document.frm.("RowCheck");
	  var chked = false;
	  var indexid = false;
	  for(i=0; i < memberChk.length; i++){
	   if(memberChk[i].checked){
	    if(indexid){
	      userid = userid + '-';
	    }
	    userid = userid + memberChk[i].value;
	    indexid = true;
	   }
	  }
	  
	  if(!indexid){
	   alert("삭제할 사용자를 체크해 주세요");
	   return;
	  }
	  document.userForm.delUserid.value = userid;       // 체크된 사용자 아이디를 '-'로 묶은
														// userid를 document.userForm.delUserid 의 value로 저장 
	  
	  var agree=confirm("삭제 하시겠습니까?");
	  if (agree){
	   document.userForm.execute.value = "userDel";
	     document.userForm.submit();
	     }
	  }﻿