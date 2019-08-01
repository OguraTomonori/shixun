<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <tags:head 
  css="${pageContext.request.contextPath }/css/navbar.css,
  ${pageContext.request.contextPath }/css/main.css"
  js="${pageContext.request.contextPath }/js/cookie.js,
  ${pageContext.request.contextPath }/js/storage.js"/>
 <body>
	<div class="container" style="padding-top:50px">
		<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<table class="table">
				<tr>
					<th>旧密码</th>
					<td>
						<div class="input-group">
						  <input id="old" type="password" class="item" aria-label="">
						</div>
					</td>
				</tr>
				<tr>
					<th>新密码</th>
					<!--  -->
					<td>
						<div class="input-group">
						  <input id="new" type="password" class="item" aria-label="">
						</div>
					</td>
				</tr>
				<tr>
					<th>重复新密码</th>
					<!--  -->
					<td>
						<div class="input-group">
						  <input id="repeat" type="password" class="item" aria-label="">
						</div>
					</td>
				</tr>
			</table>
		</div>
		</div>
		<div class="row">
			<div class="col-md-9"></div>
			<div class="col-md-1">
				<div class="btn-group" role="group" aria-label="...">
				  <button type="button" class="btn btn-default commit-btn">提交</button>
				</div>
			</div>
			
		</div>
	</div>

 	<script>
 		document.getElementsByClassName("commit-btn")[0].onclick = function() {
 			$.post({
    			"url": "ChangePasswdServlet",
    			"dataType":"json",
    			"data": {
    				"id": getCookie("userID"),
    				"oldpw": document.getElementById("old").value,
    				"newpw": document.getElementById("new").value
    			},
    			"success": function(response, status, xhr) {
    				//这时cookie已经被设置如果登录成功
    				var res = response["result"];
    				if (res == "success") {
    					alert("更改密码成功");
    					location.href="${pageContext.request.contextPath }/logout.jsp";
    				}
    				else {
    					alert("更改密码失败");
    				}
    			} 
    		});
 		}
 	</script>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>