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
<link rel="stylesheet" href="user_update.css">
<title>ユーザ情報更新</title>
</head>
<body>
	<div class="sample_head">
		<ul class="nav justify-content-end">

			<li class="nav-item"><a class="nav-link " href="#">ユーザー名 さん</a></li>
			<li class="nav-item"><a class="nav-link "
				href="Logout">ログアウト</a></li>
		</ul>
	</div>




	<div class="container">
		<div class="user_new">
			<div class="he">
				<h1 class="text-center">ユーザー情報更新</h1>
				<c:if test="${errMsg != null}">
					<div class="alert alert-danger" role="alert">${errMsg}</div>
				</c:if>
				<form action="/Test/UserUpdate" method="post">
			</div>
			<input type="hidden" name="id" value="${user.id}">

			<p class="row">
				<span class="col"></span><span class="col text-left">ログインID</span><span
					class="col"><input type="hidden" name ="login" value="${user.login_id}">${user.login_id}</span><span class="col"></span>
			</p>

			<p class="row">
				<span class="col"></span><span class="col text-left"> パスワード</span><input
					class="col" type="text" name="pass"><span class="col"></span>
			</p>
			<p class="row">
				<span class="col"></span><span class="col text-left">パスワード（確認)</span><input
					class="col" type="text" name="passCheck"><span class="col"></span>
			</p>
			<p class="row">
				<span class="col"></span><span class="col text-left">ユーザ名</span><input
					class="col" type="text" name="userName" value="${user.name}"><span
					class="col"></span>
			</p>
			<p class="row">
				<span class="col"></span><span class="col text-left">生年月日</span><input
					class="col" type="text" name="birth" value="${user.update_date}"><span
					class="col"></span>
			</p>
		</div>

		<div class="update_btn">
			<p class="text-center">
				<input type="submit" value="更新" class="aaa">
			</p>
		</div>
		</form>


	</div>
	<a href="http://localhost:8080/Test/user_people.jsp">戻る</a>
</body>
</html>