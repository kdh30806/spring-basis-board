<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/board.js"></script>
<title>Insert title here</title>
</head>
<body>
<form id="frm">
제목 : <input type="text" placeholder="제목" id="subject" name="subject" value="${view.subject}">
작성자 : <input type="text" placeholder="작성자" id="name" name="name" value="${view.name}">
내용 : <input type="text" placeholder="내용" id="content" name="content" value="${view.content}"> 
<button type="button" onclick="fn_boardRegi();">등록</button>
</form>
</body>
</html>