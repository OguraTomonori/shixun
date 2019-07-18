function isLogined() {
	//假设cookie为
	//userID:string
	//sessionID:string
	//permission:int 0 1 2
	if (getCookie("sessionID") != null) {
		alert("aru!");
		return true;
	}
	return false;
}
if (isLogined()) { 
	alert("done");
	//如果登录，则取消模糊，不再display登录界面
	document.getElementById("loginer").style["display"] = "none";
	document.getElementById("main_page").style["filter"] = null;

}
window.onload = function() {
	document.getElementById("login_btn").onclick = function() {
		var username = document.getElementById("username").value;
		var passwd=  document.getElementById("passwd").value;
		$.post({
			"url": "LoginServlet",
			"data": {
				"username": username,
				"passwd": passwd
			},
			"success": function(response) {
				alert("登陆rua");
				location.reload();
			} 
		})
	}
}
