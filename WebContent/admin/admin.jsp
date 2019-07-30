<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <tags:head 
  css="${pageContext.request.contextPath }/css/navbar.css,
  ${pageContext.request.contextPath }/css/main.css"
  js="${pageContext.request.contextPath }/js/cookie.js"/>
 <body>
 <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
 	<nav class="navbar navbar-default navbar-fixed-top" id="titlebar">
	      <div class="container">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="#">学生管理系统</a>
	        </div>
	        <div id="navbar" class="navbar-collapse collapse">
	          <ul class="nav navbar-nav">
	            <li class="active"><a href="admin.jsp">个人信息</a></li>
	            <li><a href="${pageContext.request.contextPath }/admin/studInfoSearch.jsp">学生信息查询</a></li>
	            <li><a href="${pageContext.request.contextPath }/admin/teacInfoSearch.jsp">教师信息查询</a></li>
	            <li><a href="${pageContext.request.contextPath }/admin/courInfoSearch.jsp">课程信息查询</a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他 <span class="caret"></span></a>
	              <ul class="dropdown-menu">

	                <li><a href="${pageContext.request.contextPath }/logout.jsp">登出</a></li>
	              </ul>
	            </li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right">
	            <li id="name"><a href="#">管理员<span id="username"></span>,你好</a></li>
	            
	            <li class="dropdown active">
	              <a href="${pageContext.request.contextPath }/admin/commit.jsp">修改清单 </a>
	            </li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>
	    <script>
	    	document.getElementById("username").innerHTML = getCookie("username");
	    </script>
 	<div class="container-fluid" id="main">
 		<div class="row content">
 			<div class="col-md-2"></div>
 			<div class="col-md-8">
		  		<table class="table table-striped" id="admintable">
					<tbody>
					  	
					</tbody>
				
				</table>
				<script>
					$.post({
						"data":{"user_id": getCookie("userID"), "asdd": "ASDsada", "你好":"suck"},
						"url":"${pageContext.request.contextPath }/SearchAdminServlet",// TODO
						"success": function(response, status, xhr) {
							var obj = document.getElementById("admintable");
							//response为一个json
							for (var key in response) {
								var target_str = "<tr onclick=\"alert(\'rua\');\"><th class=\"text-center\">" + key + "</th><th class=\"text-center\">" + response[key]  + "</th></tr>";
								obj.innerHTML += target_str;
							}
						},
						"dataType":"json"
					});
				</script>
 			</div>
 		</div>
 	</div>
 	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>