<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>회원등록</title>
<STYLE TYPE="text/css">
<!--
body {
	font-family: 돋움, Verdana;
	font-size: 9pt
}
td {
	font-family: 돋움, Verdana;
	font-size: 9pt;
	text-decoration: none;
	color: #000000;
	BACKGROUND-POSITION: left top;
	BACKGROUND-REPEAT: no-repeat;
}
-->
.formbox {
	BACKGROUND-COLOR: #F0F0F0;
	FONT-FAMILY: "Verdana", "Arial", "Helvetica", "돋움";
	FONT-SIZE: 9pt
}
-
-->
</STYLE>
</head>
<script>
	function idcheck() {
		var url = "user_idcheck?userid=" + users.userid.value;
		window.open(url, "useridCheck", "width=350, height=500");
	}
	function send() {
		if (users.name.value == "") {
			alert("이름을 입력해주세요");
			users.name.focus();
			return;
		}
		if (users.userid.value == "") {
			alert("아이디를 입력해주세요");
			users.userid.focus();
			return;
		}
		if (users.passwd.value == "") {
			alert("비밀번호를 입력해주세요");
			users.passwd.focus();
			return;
		}
		
		if(users.repasswd.value == ""){
			alert("비밀번호를 입력해주세요");
			users.repasswd.focus();
			return;
		}
		
		if (passCheck()) {
			return;
		}
		if (users.tel.value == "") {
			alert("전화번호를 입력해주세요");
			users.tel.focus();
			return;
		}
		if (users.email1.value == "") {
			alert("이메일을 입력해주세요");
			users.email1.focus();
			return;
		}
		users.submit();
	}
	function passCheck(){
		if(users.passwd.value != users.repasswd.value){
			alert("입력된 비밀번호가 일치하지 않습니다!");
			Member.passwd.focus;
			return true;
		}
	}
	 
	function emailChk() {
		if (users.email2.selectedIndex==0) {
			document.getElementById("emailread").readOnly = false;
			users.email2.value = "";
		} else {
			document.getElementById("emailread").readOnly = true;
			users.email2.value = users.email3.value;
		}
	}
</script>
<body bgcolor="#FFFFFF" LEFTMARGIN=0 TOPMARGIN=0>
	<!-- 탑 메뉴 영역 삽입-->
	<table border="0" width="800">
		<tr>
			<td width="20%" bgcolor="#ecf1ef" valign="top"
				style="padding-left: 0;">
				<!--로그인 영역 삽입-->
			</td>
			<td width="80%" valign="top">&nbsp;<img
				src="Users/img/title1.gif"><br>
				<form name=users method=post action=user_insert>
					<table border=0 cellpadding=0 cellspacing=0 border=0 width=730
						valign=top>
						<tr>
							<td align=center><br>
								<table cellpadding=0 cellspacing=0 border=0 width=650
									align=center>
									<tr>
										<td bgcolor="#7AAAD5">
											<table cellpadding=0 cellspacing=0 border=0 width=100%>
												<tr bgcolor=#7AAAD5>
													<td align=left BORDER="0" HSPACE="0" VSPACE="0"><img
														src="Users/img/u_b02.gif"></td>
													<td align=center bgcolor="#7AAAD5"><FONT
														COLOR="#FFFFFF"><b>사용자등록&nbsp;</b><font color=black>(</font><font
															color=red>&nbsp;*&nbsp;</font><font color=black>표시항목은
																반드시 입력하십시요.)</font></FONT></td>
													<td align=right BORDER="0" HSPACE="0" VSPACE="0"><img
														src="Users/img/u_b03.gif"></td>
												</tr>
											</table>
											<table cellpadding=3 cellspacing=1 border=0 width=100%>
												<tr>
													<td width=110 bgcolor=#EFF4F8>&nbsp;회원 성명<font
														color=red>&nbsp;*</font></td>
													<TD BGCOLOR=WHITE><input type=text name=name size=16
														maxlength=20 value="">성명은 빈칸없이 입력하세요.</td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;회원 ID<font color=red>&nbsp;*</font></td>
													<TD BGCOLOR=WHITE>
														<table cellspacing=0 cellpadding=0>
															<tr>
																<td align=absmiddle><input type=text name=userid
																	size=12 maxlength=16 value="" style="width: 120" readOnly>
																</td>
																<td><a href="javascript:idcheck()"><img
																		src="Users/img/u_bt01.gif" hspace=2 border=0 name=img1
																		align=absmiddle></a> 5~16자 이내의 영문이나 숫자만 가능합니다.</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;비밀번호<font color=red>&nbsp;*</font></td>
													<TD BGCOLOR=WHITE><input type=password name=passwd
														size=8 maxlength=12 style="width: 80"> 6~12자 이내의
														영문이나 숫자만 가능합니다.</td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;비밀번호확인<font color=red>&nbsp;*</font></td>
													<TD BGCOLOR=WHITE><input type=password name=repasswd
														size=8 maxlength=12 value="" style="width: 80">비밀번호
														확인을 위해서 비밀번호를 한번 더 입력해주세요.</td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;전화번호<font color=red>&nbsp;*</font></td>
													<TD BGCOLOR=WHITE><input type=text name=tel size=13
														maxlength=13 value=""></td>
												</tr>
												<tr>
													<TD BGCOLOR="#EFF4F8">&nbsp;E-mail <font color=red>&nbsp;</font>
													</td>
													<td bgcolor=WHITE valign=middle><input type="text"
														name="email1" maxlength="15"> @ <input type="text"
														id="emailread" name="email2" maxlength="15"> <select
														name="email3" id="sel" onChange="emailChk()">
															<option value="0">직접입력</option>
															<option value="naver.com">naver.com</option>
															<option value="daum.net">daum.net</option>
															<option value="nate.com">nate.com</option>
															<option value="gmail.com">gmail.com</option>
													</select> <input type="button" value="인증하기"></td>
												</tr>
											</table>
											<table cellpadding=0 cellspacing=0 border=0 width=100%>
												<tr bgcolor=#7AAAD5>
													<td valign=bottom><img src="Users/img/u_b04.gif"
														align=left hspace=0 vspace=0 border=0></td>
													<td align=center></td>
													<td valign=bottom><img src="Users/img/u_b05.gif"
														align=right hspace=0 vspace=0 border=0></td>
												</tr>
												<tr bgcolor=#ffffff>
													<td colspan=3 align=center><img
														src="Users/img/u_bt06.gif" vspace=3 border=0 name=img3
														onClick="send()"> <img src="Users/img/u_bt05.gif"
														border=0 hspace=10 vspace=3 name=img4></td>
												</tr>
											</table>
										</td>
									</tr>
									</td>
									</tr>
								</table>
								</form></td>
						</tr>
					</table>
					<!-- copyright 영역 삽입-->
</body>
</html>