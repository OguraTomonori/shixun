/*
 * index.jsp要包含的文件
 * 
 * 
 * 
 */

//index.jsp的window.onload
window.onload = function() {
	//login button
	document.getElementById("login_btn").onclick = function() {
		var username = document.getElementById("username").value;
		var passwd=  document.getElementById("passwd").value;
		$.post({
			"url": "LoginServlet",
			"data": {
				"username": username,
				"passwd": passwd
			},
			"success": function(response, status, xhr) {
				//这时cookie已经被设置如果登录成功
				if (response == "1") //登录失败，密码不正确
					alert("密码不正确！");
				else if (response == "2")//用户不存在
					alert("用户不存在！");
				
				location.reload(); //重定向，登录后会跳转，未登录则刷新
			} 
		});
	}
}