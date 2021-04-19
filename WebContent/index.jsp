<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房浩博客</title>

<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //Meta-Tags -->

<!-- Style -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">

<script type="text/javascript">
	function url() {

		var users = "${cookie.u.value}";
		var userlogin = decodeURI(users);
		document.getElementById("username").value = userlogin;
	}
</script>
</head>
<body onload="url()">
	<p style="margin-top:20px;font-size:50px;font-weight:3px;text-align:left; color:#fff ; text-shadow:5px 5px 2px yellow; font-family:仿宋;">房浩Blog</p>

	<div class="container w3layouts agileits" style="margin-top:80px">

		<div class="login w3layouts agileits">
			<h2>登 录</h2>
			<span style="color: red">${msg} </span>
			<form action="login.do" method="post">
				<input type="text" placeholder="用户名" required="" name="username"
					id="username"> <input type="password" placeholder="密码"
					required="" value="${cookie.p.value }" name="password">

				<ul class="tick w3layouts agileits">
					<li><input type="checkbox" id="brand1" value="1" name="rempwd">
						<label for="brand1"><span></span>记住我</label></li>
				</ul>
				<div class="send-button w3layouts agileits">
					<input type="submit" value="登 录" >
			</form>
		</div>
		<a href="forgetpwd.jsp">忘记密码?</a>
		<div class="social-icons w3layouts agileits">
			<p>- 其他方式登录 -</p>
			<ul>
				<li class="qq"><a href="#"> <span
						class="icons w3layouts agileits"></span> <span
						class="text w3layouts agileits">QQ</span></a></li>
				<li class="weixin w3ls"><a href="#"> <span
						class="icons w3layouts"></span> <span
						class="text w3layouts agileits">微信</span></a></li>
				<li class="weibo aits"><a href="#"> <span
						class="icons agileits"></span> <span
						class="text w3layouts agileits">微博</span></a></li>
				<div class="clear"></div>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
	<div class="register w3layouts agileits">
		<h2>注 册</h2>
		<span style="color: red">${msg1} </span>
		<form action="register.do" method="post">
			<input type="text" name="username" placeholder="用户名" required="">
			<input type="password" name="password" placeholder="密码" required="">
			<input type="password" name="password1" placeholder="确认密码" required="">
			<input type="text" name="phone" placeholder="手机号码" required="">

			<div class="send-button w3layouts agileits">
				<input type="submit" value="免费注册">
		</form>
	</div>
	<div class="clear"></div>
	</div>

	<div class="clear"></div>

	</div>
</body>
</html>