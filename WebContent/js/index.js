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
	if (getCokokie("userID") != null) {
		return true;
	}
	return false;
}

//index.jsp的window.onload
window.onload = function() {
	
}