/*
 * index.jsp要包含的文件
 * 
 * 
 * 
 */
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
if (!isLogined()) { //未登录则跳转到登录界面
	window.location.href="login.jsp";
}

//index.jsp的window.onload
window.onload = function() {
	
	
	//登陆后——
}