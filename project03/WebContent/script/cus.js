function cusCheck() {
	if (document.frm.cname.value.length == 0) {
		alert("이름을 입력하세요.");
		return false;
	}
	if (document.frm.cname.value.length > 20) {
		alert("이름을 다시 입력하세요.");
		return false;
	}
	if (document.frm.cphone.value.length == 0) {
		alert("전화번호를 입력하세요.");
		return false;
	}
	if (document.frm.cphone.value.length > 11) {
		alert("전화번호를 '-'를 빼고 입력하세요.");
		return false;
	}	
	if (document.frm.cemail.value.length == 0) {
		alert("이메일을 입력하세요.");
		return false;
	}
	if (document.frm.cemail.value.length > 30) {
		alert("이메일이 너무 깁니다.");
		return false;
	}
	if (document.frm.cpost.value.length == 0) {
		alert("우편번호을 입력하세요.");
		return false;
	}
	if (document.frm.caddr1.value.length == 0) {
		alert("주소를 입력하세요.");
		return false;
	}
	if (document.frm.caddr.value.length > 100) {
		alert("주소가 너무 깁니다");
		return false;
	}
	
	return true;
}
function open_win(url, name) {
	window.open(url, name, "width=600, height=500");
}
function passCheck() {
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}
function displayBytes( sz, id )  // sz 는 String Size로서 제한할 문자 byte수,id는 해당 input박스의 id이다.
{
 var obj = document.getElementById( id );
 var e_index = 0;
 if (obj.value.bytes() > sz) // 제한량을 넘겼을시.
 { 
  if (event.keyCode != '8') //백스페이스는 지우기작업시 바이트 체크하지 않기 위해서
  {
	  var chkdgsoweg =  ( sz / 2 ); // 한글은 2byte,영문은 1byte이다.
	  alert('한글은 ' + chkdgsoweg + '자 , 영문은 ' + sz + '자 까지 입력이 가능합니다.');
  }
  //  sz자 까지 만든다.
  obj.value = fnCut(obj.value , sz);
 }
}

//숫자만 입력
function onlyNumber(loc) {
   if(/[^0123456789]/g.test(loc.value)) {
      alert("숫자가 아닙니다.\n\n0-9의 정수만 허용합니다.");
      loc.value = "";
      loc.focus();
   }
}

function daumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;

            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.frm.cpost.value = data.zonecode; //5자리 새우편번호 사용
            document.frm.caddr1.value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.frm.caddr2.focus();
        }
    	
    }
    ).open({
    	autoClose:true
    });
}

function call()
{
 if(document.frm.caddr1.value && document.frm.caddr2.value){
	 document.frm.caddr.value =document.frm.caddr1.value + " " +document.frm.caddr2.value;
 }
}
function cancelreadonly() {
	document.frm.caddr2.readOnly = false;
}