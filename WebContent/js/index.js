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
				//这时cookie已经被设置
				location.reload();
			} 
		});
	}
}