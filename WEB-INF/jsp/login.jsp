<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/userLogin/user/checkLogin" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input id="username" name="username" type="text"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input id="password" name="password" type="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录" id="submitBtn"><br><a href="/userLogin/user/regist">注册</a></td>
			</tr>
			
		</table>
	</form>
</body>
<script>
$("#submitBtn").on("click", function(){	
	var datas = '{"username":"' + $('#username').val() + '","password":"' + $('#password').val() + '"}';
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "${pageContext.request.contextPath}/checkLogin",
        processData : false,
        dataType : "json",
        data : datas,
        error : function() {
            alert('登录失败 ，用户名或密码错误');
            return;
        },
        success : function(data) {
        	alert("登录成功！");
        	success(3);	
        }
    });
});
</script>

</html>