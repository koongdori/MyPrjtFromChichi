<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><title>updateBoard.jsp</title></head>
<body>
<h3>게시글 수정</h3>
<form action="./updateBoard" method="post">
	<input type="text" name="title" value="${board.title}"> <!-- sessionScope.board.title 을 간략히 한 것 -->
	<input type="text" name="content" value="${board.content}">
	<input type="text" name="writer" value="${board.writer}">
 	<input type="submit" value="등록"/>
</form>
${board}
</body>
</html>