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
<link rel="stylesheet" href="user_delete.css">
<title>ユーザ削除確認</title>
</head>
<body>
	<div class="sample_head">
		<ul class="nav justify-content-end">

			<li class="nav-item"><a class="nav-link " href="#">ユーザー名 さん</a></li>
			<li class="nav-item"><a class="nav-link "
				href="Logout">ログアウト</a></li>
		</ul>
	</div>
	<div class="he">
		<h1 class="text-center">ユーザー削除確認</h1>
	</div>
	<form action="/Test/UserDelete" method="post">
		<div class="del_write">
			<p>
				<input type="hidden" name="login" value="${user.login_id}">ログインID：${user.login_id}<br>
				を本当に削除してよろしいでしょうか
			</p>
		</div>
		<div class="delete_btn">
			<input type="submit" value="キャンセル" name="btn"> <input type="submit"
				value="OK" name="btn">
		</div>
	</form>
</body>
</html>