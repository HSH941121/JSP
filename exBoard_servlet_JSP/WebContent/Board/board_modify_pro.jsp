<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	int row = (int)request.getAttribute("row");

	if(row == 1){

%>

<script>
	alert("�����Ǿ����ϴ�.")
	location.href="board_list.do?page=${page}";
</script>
<%
	}
	else{
%>
<script>
	alert("���� ����!! �ùٸ� ��й�ȣ�� �Է��ϼ���");
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