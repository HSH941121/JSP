<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>exUserSerlvetJSTL ȸ������ ���α׷�</h1>
	<h3><a href="user_insert">ȸ������</a></h3>
	<c:if test="${empty userid }">
	<h3><a href="user_login">�α���</a></h3>
	</c:if>
	<c:if test="${!empty userid }">
	<h3><a href="user_logout">�α׾ƿ�</a></h3>
	</c:if>
	<h3><a href="user_list">ȸ�����</a></h3>
</body>
</html>