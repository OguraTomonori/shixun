function setCookie(name,value) { 
    var Days = 30; 
    var exp = new Date(); 
    exp.setTime(exp.getTime() + Days*24*60*60*1000); 
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString(); 
}


function getCookie(cookieName){
	  //将document.cookie保存在变量cookie中
	  var cookie=document.cookie;
	  //在cookie中查找cookieName的位置保存在i中
	  var i=cookie.indexOf(cookieName);
	  //如果i等于-1,就返回null
	  if(i==-1){return null}
	  else{//否则  
	    //i+cookieName的长度+1,保存在变量starti中
	    var starti=i+cookieName.length+1;
	    //从starti开始查找cookie中下一个;的位置endi
	    var endi=cookie.indexOf(";",starti);
	    if(endi==-1){//如果endi是-1
	      //截取cookie中starti到结尾的剩余内容,返回
	      return cookie.slice(starti);
	    }else{//否则
	      //截取cookie中starti到endi的内容，返回
	      return cookie.slice(starti,endi);
	    }
	}
}
function delCookie(name) 
{ 
    var exp = new Date(); 
    exp.setTime(exp.getTime() - 1); 
    var cval=getCookie(name); 
    if(cval!=null) 
        document.cookie= name + "="+cval+";expires="+exp.toGMTString(); 
}