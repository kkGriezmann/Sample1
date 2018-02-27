<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
  //요청용
  var xmlRequest;
  function idCheck(s){
  	xmlRequest=new XMLHttpRequest();
  	xmlRequest.onreadystatechange=x;	
  	// test.jsp에 요청
  	xmlRequest.open("get","MemberIdCheckServlet?userid="+s, true );
  	xmlRequest.send(null); // null은 get일때
  }//end req
  // 응답용
  function x(){
  	if(xmlRequest.readyState==4 && 
  			xmlRequest.status == 200){
  		var time = xmlRequest.responseText;
  		document.querySelector("#result").innerText=time;
  	} //end if
  }//end response()
  
  function pwCheck(pw){
	  var passwd = document.querySelector("#passwd").value;
	  var mesg = "비번일치";
	  if(passwd != pw){
		  mesg = "비번 불일치";
	  }
	  document.querySelector("#result2").innerText=mesg;
  }
  
  //
  function formCheck(e){
	  var username = document.querySelector("#username").value;
	  if(username.length == 0){
		  alert("이름 입력하세요")
		  document.querySelector("#username").focus();
		  e.preventDefault();
	  }else if(document.querySelector("#email1").value.length==0){
		  alert("email1 입력하세요")
		  document.querySelector("#email1").focus();
		  e.preventDefault();
	  }
  }//
  function emailSelect(xx){
	  document.querySelector("#email2").value=xx;
  }
</script>
<form action="MemberAddServlet" method="post" 
onsubmit="formCheck(event)">
아이디<input type="text" name="userid" onkeyup="idCheck(this.value)">
<span id="result"></span>
<br>
비밀번호<input type="text" name="passwd" id="passwd"><br>
비밀번호<input type="text" name="passwd2" onkeyup="pwCheck(this.value)">
<span id="result2"></span><br>
이름<input type="text" name="username" id="username"><br>

<input type="text" name="post" id="sample6_postcode" placeholder="우편번호">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" name="addr1" id="sample6_address" placeholder="주소">
<input type="text" name="addr2" id="sample6_address2" placeholder="상세주소"><br>
휴대폰<select name="phone1">
       <option value="010">010</option>
       <option value="011">011</option>
     </select>-
    <input type="text" name="phone2">-
    <input type="text" name="phone3"><br>
이메일<input type="text" name="email1" id="email1">@
    <input type="text" name="email2" id="email2" placeholder="직접입력">
    <select onchange="emailSelect(this.value)">
       <option value="daum.net">daum.net</option>
       <option value="naver.com">naver.com</option>
     </select>
    <br> 

<input type="submit" value="회원가입">
<input type="reset" value="취소">

</form>


<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
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
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>


