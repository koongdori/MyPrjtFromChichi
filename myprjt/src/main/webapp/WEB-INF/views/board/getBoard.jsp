<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
등록 후 확인<br>
${vo}
<hr>
	제목 :${board.title}<br>
	작성자:${board.writer}<br>
	내용 : ${board.content}
	
	<a href="../updateBoard">수정</a>
</body>
</html>