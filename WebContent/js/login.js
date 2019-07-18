function isLogined() {
	//假设cookie为
	//userID:string
	//sessionID:string
	//permission:int 0 1 2
	if (getCookie("sessionID") != null) {
		return true;
	}
	return false;
}


