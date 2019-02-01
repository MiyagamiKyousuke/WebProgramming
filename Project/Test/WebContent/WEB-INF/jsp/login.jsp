<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link rel="stylesheet" href="login.css">
<title>ログイン画面</title>
</head>
<body>


	<div class="hd">
		<h1 class="text-center">ログイン画面</h1>
	</div>
	<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>

	<form action="/Test/Login" method="post">
		<div class="pad">
			<p class="text-center">
				<label for="ID" class="log">ログインID</label><input id="ID" type="text"
					name="log_id">
			</p>
			<p class="text-center">
				<label for="pass" class="title">パスワード</label><input type="text"
					name="pass">
			</p>
		</div>

		<p class="text-center">
			<input type="submit" value="ログイン" class="log_btn">
		</p>
	</form>
</body>
</html>