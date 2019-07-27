function eval(str) {
	//" ...:... ...:... "如此的字符串的解析
	var res = {}
	var strs = str.split(" ");
	for (var i in strs) {
		var t = strs.split(":");
		if (!(t[0] && t[1]))
			return null;
		res[t[0]] = t[1];
	}
	return res;
}