<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${row == 1 }">
<script>
	alert("삭제되었습니다.")
	opener.location.href="Board?cmd=board_list&page=${page}";
	self.close();
</script>
</c:if>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>