<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${row==1 }">
	<script>
		alert("수정성공");
		location.href = "user_login";
	</script>
</c:if>

<c:if test="${row==0 }">
	<script>
		alert("수정실패");
		history.back();
	</script>
</c:if>
</body>
</html>