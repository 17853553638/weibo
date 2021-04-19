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

</head>
<body>
<div class="register w3layouts agileits" style="margin-left:900px ;margin-top:100px">
		<h2>修改密码</h2>
		<span style="color: red">${msg2} </span>
		<form action="forgetpwd.do" method="post">
			<input type="password" name="password" placeholder="新密码" required="">
			<input type="password" name="password1" placeholder="确认密码" required="">
			<input type="text" name="phone" placeholder="手机号码" required="">

			<div class="send-button w3layouts agileits">
				<input type="submit" value="修改成功">
				<a href="index.jsp"><input type="button" value="返回登陆" ></a>
		</form>
	</div>
</body>
</html>