<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	int row = (int)request.getAttribute("row");

	if(row == 1){

%>

<script>
	alert("수정되었습니다.")
	location.href="board_list.do?page=${page}";
</script>
<%
	}
	else{
%>
<script>
	alert("수정 실패!! 올바른 비밀번호를 입력하세요");
	history.back();
</script>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>