<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${row == 1 }">
	<script>
		alert("삭제성공");
		location.href="pds_list?page=${page}";
	</script>
</c:if>
<c:if test="${row == 0 }">
	<script>
		alert("삭제실패");
		history.back();
	</script>
</c:if>
</body>
</html>