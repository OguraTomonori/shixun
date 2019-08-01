<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <tags:head 
  css="${pageContext.request.contextPath }/css/index.css"
  js="${pageContext.request.contextPath }/js/cookie.js"/>
 <body>
  	<div id="loginer">
    	<div class="container">
    		<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<div id="login">
						<img src="${pageContext.request.contextPath }/login.jpg" style="width:100%"/>
						<div class="input-group input-group-lg">
  							<input type="text" id="username" class="form-control login_input" placeholder="用户名" aria-describedby="basic-addon1">
							<input type="password" id="passwd" class="form-control login_input" placeholder="密码" aria-describedby="sizing-addon1">
						</div>
						<div class="btn-group btn-group-lg" role="group" id="login_div">
							<button class="btn btn-default" id="login_btn">继续</button>
						</div>
					</div>
				</div>
			</div>
    	</div>
    </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script>
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
    				if (response == "1" || response == "2") {
    					//登录失败
    					alert("用户名或密码错误");
    				} 
    				
    				var permission = parseInt(getCookie("permission"));
    		    	var str = "${pageContext.request.contextPath }"
    		    	if (permission == 0) {
    		    		str += "/admin/admin.jsp";
    		    	}
    		    	else if (permission == 1) {
    		    		str += "/teacher/teacher.jsp";
    		    	}
    		    	else {
    		    		str += "/student/student.jsp";
    		    	}
    		    	document.location.href = str;
    			} 
    		});
    	}
    }
    </script>
   
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/index.js"></script>
  </body>
</html>
