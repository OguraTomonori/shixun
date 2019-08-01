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
	            <li><a href="${pageContext.request.contextPath }/student/student.jsp">个人信息</a></li>
	            <li class="active"><a href="${pageContext.request.contextPath }/student/studentCourseInfo.jsp">选课信息</a></li>
	            <li><a href="${pageContext.request.contextPath }/student/studentGradeInfo.jsp">成绩信息</a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他 <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	                <li><a href="${pageContext.request.contextPath }/logout.jsp">登出</a></li>
	              </ul>
	            </li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right">
	            <li id="name"><a href="#"><span id="username"></span>同学,你好</a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
		</nav>
		<script>
	    	document.getElementById("username").innerHTML = getCookie("username");
	    </script>
 	<div class="container" id="main">
 		<div class="content">
		  	<table class="table table-hover content" id="table">
					 	<tr>
					 		<th>名称</th>
					 		<th>课程号</th>
					 		<th>院系</th>
							<th>学分</th>
							<th>状态</th>
					 		<th>占比</th>
					 		<th>教师</th>
					 		<th></th>
					 	</tr>
					</table>
 		</div>
 	</div>
 	<div class="modal fade" id="teacher" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">详情</h4>
					</div>
					<div class="modal-body" id="teacher-content">
						<table class="table">
							
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script>
		
	</script>
	<script>
		function teacher(response) {
			var dict = {
					"姓名": response["t_name"],
					"工号": response["t_id"],
					"职位": response["t_jobtitle"],
					"院系": response["t_dp"],
					"薪水": response["t_salary"],
					"状态": response["t_state"],
					"入学时间": response["t_entertime"],
					"办公室": response["t_office"],
					"email": response["t_email"]
			}
			var str = "";
			for (var key in dict) 
				str += "<tr><th>" + key + "</th><td>" + dict[key] + "</td></tr>";
			$("#teacher")[0].getElementsByClassName("table")[0].innerHTML = str;
		}
		$.post({
			"url":"${pageContext.request.contextPath }/StudentSearchCourseServlet",
			"data": {
				"studentID": getCookie("userID"),
			},
			"dataType":"json",
			"success": function(response, status, xhr) {
				var res = response["data"];
				if (res == "err") {
					alert("登录信息错误！");
					location.href="${pageContext.request.contextPath }/index.jsp";
				}
				var teachers = response["teac"]
				var info = $("#table")[0];
				for (var i in res) {
					var arr = [
						res[i]["c_id"],
						res[i]["c_name"],
						res[i]["c_opendp"],
						res[i]["c_score"],
						res[i]["c_classstate"],
						res[i]["c_percentage"]
					]
					var str = info.innerHTML + 
					"<tr>";

					for (var j in arr) {
						str += 
							"<td>" + arr[j] + "</td>"
					}
					str += 
						"<td><a href='#' data-toggle=\"modal\" data-target=\"#teacher\" onclick=\'teacher(" + JSON.stringify(teachers[i]) + ")\'>" + teachers[i]["t_name"] + "</a>" //教师a标签
						+ "</td></tr>";
					info.innerHTML = str;
				}
			}
		});
	</script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>