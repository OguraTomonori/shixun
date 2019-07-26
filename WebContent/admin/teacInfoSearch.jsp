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
	            <li><a href="${pageContext.request.contextPath }/admin/admin.jsp">个人信息</a></li>
	            <li><a href="${pageContext.request.contextPath }/admin/studInfoSearch.jsp">学生信息查询</a></li>
	            <li class="active"><a href="${pageContext.request.contextPath }/admin/teacInfoSearch.jsp">教师信息查询</a></li>
	            <li><a href="${pageContext.request.contextPath }/admin/courInfoSearch.jsp">课程信息查询</a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他 <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	              	<li><a href="${pageContext.request.contextPath }/admin/addStudent.jsp">添加学生</a></li>
	              	<li><a href="${pageContext.request.contextPath }/admin/studInfoSearch.jsp">添加老师</a></li>
	              	<li><a href="${pageContext.request.contextPath }/admin/studInfoSearch.jsp">添加课程</a></li>
	              	<li><a href="${pageContext.request.contextPath }/admin/studInfoSearch.jsp">添加成绩</a></li>
	              	<li role="separator" class="divider"></li>
	                <li><a href="${pageContext.request.contextPath }/logout.jsp">登出</a></li>
	              </ul>
	            </li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right">
	            <li id="name"><a href="#">管理员<span id="username"></span>,你好</a></li>
	            
	            <li class="dropdown active">
	              <a href="${pageContext.request.contextPath }/admin/updateList.jsp">修改清单 </a>
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
		  	<div class="col-lg-3"></div>
			 <div class="col-lg-6">
			    <div class="input-group input-group-lg">
			      <div class="input-group-btn">
			        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">按姓名搜索 <span class="caret"></span></button>
			        <ul class="dropdown-menu" id="search_option">
			          <li><a href="#">按姓名搜索</a></li>
			          <li><a href="#">按教师号搜索</a></li>
					  <li><a href="#">按班级搜索</a></li>
					  <li><a href="#">按系别搜索</a></li>
			        </ul>
			      </div><!-- /btn-group -->
			      <input type="text" class="form-control" aria-label="..." id="search_text">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button" id="search_btn">搜索</button>
			      </span>
			    </div><!-- /input-group -->
			    
			    <div class="btn-group content" role="group">
				    <button type="button" class="btn btn-default" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="more_option_btn">
				      更多选项
				      <span class="caret"></span>
				    </button>
				  </div>
				<div class="content" id="more_option">
					<div class="btn-group" role="group" aria-label="...">
					  <button type="button" class="btn btn-default">全部</button>
					  <button type="button" class="btn btn-default">男</button>
					  <button type="button" class="btn btn-default">女</button>
					</div>

				    <div class="input-group">
				      <input type="text" class="form-control" placeholder="从YYYY-MM-DD">
				    </div><!-- /input-group -->
				
				    <div class="input-group">
				      <input type="text" class="form-control" placeholder="到YYYY-MM-DD">
				    </div>
					
				</div>
							    
			  </div><!-- /.col-lg-6 -->
		</div><!-- row content -->
		
		<div class="row content">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<!--  搜索结果   -->
				<table class="table table-striped" id="result">

				 	<tr>
				 		<th>姓名</th>
				 		<th>教师号</th>
				 		<th>院系</th>
				 		<th></th>
				 		<th></th>
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
		<div class="modal fade" id="course" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">课程</h4>
					</div>
					<div class="modal-body" id="course-content">
						<table class="table">
							
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">更新</h4>
					</div>
					<div class="modal-body" id="update-content">
						<table class="table">
							
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal" id="deleteTeacher">删除</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="saveChange">保存</button>
					</div>
				</div>
			</div>
		</div>
		
 	</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>
		/*
			点击时调用，更新model
		*/
		
		function teacher(teacherID) { 
			var content = document.getElementById("teacher-content").getElementsByClassName("table")[0];
			content.innerHTML = "";
			$.post({
				"url":"${pageContext.request.contextPath }/SearchTeacherServlet",
				"data":{
					"t_id": teacherID
				},
				"dataType":"json",
				"success": function(response, status, xhr) {
					response = response["data"][0];
					var res = {
							"姓名": response["name"],
							"工号": response["id"],
							"职位": response["jobtitle"],
							"院系": response["dp"],
							"性别": response["sex"],
							"薪水": response["salary"],
							"状态": response["state"],
							"入学时间": response["entertime"],
							"办公室": response["office"],
							"email": response["email"]
					};
					for (key in res) {
						content.innerHTML = content.innerHTML +
						"<tr><th>" + key + "</th><td>" + res[key] + "</td></tr>";
					}
				}
			});
		}
		function course(teacherID) { 
			//获取该老师执教课程
			var content = document.getElementById("course-content").getElementsByClassName("table")[0];
			content.innerHTML = "<tr><th>课程名称</th><th>课程号</th><th>学分</th><th>院系</th><th>院系</th></tr>";
			$.post({
				"url":"${pageContext.request.contextPath }/SearchCourseServlet",
				"data":{
					"t_id": teacherID
				},
				"dataType":"json",
				"success": function(response, status, xhr) {
					//TODO
					var res = {
						"课程名称": response["name"],
						"课程号": response["id"],
						"学分": response["score"],
						"院系": response["dp"],
						"": response["percentage"]
					};
					for (var key in res) {
						content.innerHTML = content.innerHTML +
						"<tr><th>" + key + "</th><td>" + res[key] + "</td></tr>";
					}
				}});


		}
		function update(teacherID) { 
			
			
			var content = document.getElementById("update-content").getElementsByClassName("table")[0];
			content.innerHTML = "";
			//首先获取信息，更新页面
			$.post({
				"url":"${pageContext.request.contextPath }/SearchTeacherServlet",
				"data":{
					"t_id": teacherID
				},
				"dataType":"json",
				"success": function(response, status, xhr) {
					response = response["data"][0];
					var res = {
							"姓名": response["name"],
							"工号": response["id"],
							"职位": response["jobtitle"],
							"院系": response["dp"],
							"性别": response["sex"],
							"薪水": response["salary"],
							"状态": response["state"],
							"入学时间": response["entertime"],
							"办公室": response["office"],
							"email": response["email"]
					};
					for (var key in res) {
						var item = "<div class=\"input-group\"><input type=\"text\" key='" + key + "'class=\"form-control\" aria-describedby=\"basic-addon1\" value=\"" + res[key] + "\"/></div>";
						if (key == "工号")
							item = res[key];
						content.innerHTML = content.innerHTML +
						"<tr><th>" + key + "</th><td>" + 
						item + 
						"</td></tr>";
					}
					document.getElementById("deleteTeacher").onclick = function() {
						//删除学生操作添加到清单
						stor.put("delete", "student", {"studentID": studentID});
						
					}
					document.getElementById("saveChange").onclick = function() {
						//根据现在信息添加到清单
						var inputs = content.getElementsByTagName("input");
						for (var i = 0; i < inputs.length; i++)
							res[inputs[i].getAttribute("key")] = inputs[i].value;
						res["id"] = res["学号"];
						stor.put("update", "student", res);
						alert(JSON.stringify(stor.get("student")));
					}
					
				}
			});
		}
		</script>
    <script>
		var optionObj = document.getElementById("search_option").getElementsByTagName("a");
		var option = 0;
	
		for (var i = 0; i < optionObj.length; i++) {
			let Obj = optionObj[i];
			Obj.onclick = function() {
				option = i;
				document.getElementById("option_btn").innerHTML = Obj.innerHTML;
			}
		}
    	document.getElementById("search_btn").onclick = function() {

			//根据option进行处理……
			$.post({
				"url":"${pageContext.request.contextPath }/SearchTeacherServlet",
				"data":{
					"search_option": option,
					"search_text": document.getElementById("search_text").value
				},
				"dataType":"json",
				"success": function(response, status, xhr) {
					//response应该是一个json包装的字典的数组
					//{"data":[ {} ... ]}
					//字典结构
					//{
					//	"id":学号
					//	"name"
					//	"class"
					//	"dp"
					//	"sex"
					//	"major"
					//	"entertime"
					//}
					/**
						{
							"name"
							"id"
							"dp"
						}
					*/
					var res = response["data"];
					console.log(res);
					var result = document.getElementById("result");
					for (var i = 0; i < res.length; i++) {
						var id_ = res[i]["id"];
						var name = res[i]["name"];
						var dp = res[i]["dp"];

						result.innerHTML = 
							result.innerHTML + "<tr>" + 
							"<td>" + name + "</td>" + 
							"<td>" + id_ + "</td>" + 
							"<td>" + dp + "</td>" + 
							"<td><a href='#' data-toggle=\"modal\" data-target=\"#teacher\" onclick='teacher(\"" +
							id_ + "\")'>详情</a></td>" + 
							"<td><a href='#' data-toggle=\"modal\" data-target=\"#course\" onclick='course(\"" +
							id_ + "\")'>课程</a></td>" + 
							"<td><a href='#' data-toggle=\"modal\" data-target=\"#update\" onclick='update(\"" +
							id_ + "\")'>更新</a></td></tr>";
					}
				}
			});
		}
    </script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>