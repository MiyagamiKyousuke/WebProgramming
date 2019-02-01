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
<link rel="stylesheet" href="user_detail.css">
<title>Insert title here</title>
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
		<div class="user_detail">
			<div class="he">
				<h1 class="text-center">ユーザー情報詳細情報</h1>
			</div>

			<p class="row">
				<span class="col"></span><span class="col text-left">ログインID</span><span
					class="col">${user.login_id}</span> <span class="col"></span>
			</p>

			<p class="row">
				<span class="col"></span><span class="col text-left"> ユーザー名</span><span
					class="col">${user.login_id}</span><span class="col"></span>
			</p>
			<p class="row">
				<span class="col"></span><span class="col text-left">生年月日</span><span
					class="col">${user.birth_date}</span><span class="col"></span>
			</p>
			<p class="row">
				<span class="col"></span><span class="col text-left">登録日時</span><span
					class="col">${user.create_date}</span><span class="col"></span>
			</p>
			<p class="row">
				<span class="col"></span><span class="col text-left">更新日時</span><span
					class="col">${user.update_date}</span><span class="col"></span>
			</p>
		</div>




	</div>
	<a href="http://localhost:8080/Test/user_people.jsp">戻る</a>
</body>
</html>