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
<link rel="stylesheet" href="user_people.css">
<title>ユーザ一覧</title>
</head>
<body>
	<div class="sample_head">
		<ul class="nav justify-content-end">

			<li class="nav-item"><a class="nav-link " href="#">${user.login_id}</a></li>
			<li class="nav-item"><a class="nav-link " href="Logout">ログアウト</a></li>
		</ul>
	</div>
	<div class="hd">
		<h1 class="text-center">ユーザ一覧</h1>
	</div>
	<div class="user_new">
		<a href="UserNew"> 新規登録 </a>
	</div>
	<form action="UserPeople" method="post">
		<p class="text-center">
			ログインID<input type="text" name="select_login">
		</p>
		<p class="text-center">
			ユーザー名<input type="text" name="select_name">
		</p>
		<p class="text-center">
			生年月日<input type="date" name="date_start">
		</p>
		<p class="text-center">~</p>
		<p class="text-center">
			<input type="date" name="date_end">
		</p>
		<div class="text-center">
			<button type="submit" value="検索" class="btn btn-primary form-submit">検索</button>
		</div>
	</form>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">ログインID</th>
				<th scope="col">ユーザー名</th>
				<th scope="col">生年月日</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${user.login_id == 'admin'}">
				<tbody>
					<c:forEach var="user" items="${userList}">
						<tr>
							<td>${user.login_id}</td>
							<td>${user.name}</td>
							<td>${user.birth_date}</td>
							<td>
								<div class="btn3">
									<a class="btn-primary" href="UserDetail?id=${user.id}">詳細</a> <a
										class="btn-primary" href="UserUpdate?id=${user.id}">更新</a> <a
										class="btn-primary" href="UserDelete?id=${user.id}">削除</a>
								</div>
						</tr>
					</c:forEach>

				</tbody>
			</c:when>
			<c:otherwise>
				<tbody>
					<c:forEach var="user" items="${userList}">
						<tr>
							<td>${user.login_id}</td>
							<td>${user.name}</td>
							<td>${user.birth_date}</td>
							<td>
								<div class="btn3">
									<a class="btn-primary" href="UserDetail?id=${user.id}">詳細</a>
									<c:if test="${sessionScope.user.login_id == user.login_id}">
										<a class="btn-primary" href="UserUpdate?id=${user.id}">更新</a>
									</c:if>
								</div>
						</tr>
					</c:forEach>
				</tbody>
			</c:otherwise>
		</c:choose>
	</table>

</body>
</html>