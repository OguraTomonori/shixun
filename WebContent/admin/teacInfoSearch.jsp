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
	            <li><a href="${pageContext.request.contextPath }/admin/admin.jsp">学生信息查询</a></li>
	            <li class="active"><a href="${pageContext.request.contextPath }/admin/teacInfoSearch.jsp">教师信息查询</a></li>
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
		  	<div class="col-lg-3"></div>
			 <div class="col-lg-6">
			    <div class="input-group input-group-lg">
			      <div class="input-group-btn">
			        <button type="button" id="option_btn" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" opt="0">按姓名搜索 <span class="caret"></span></button>
			        <ul class="dropdown-menu" id="search_option">
			          <li><a href="#">按姓名搜索</a></li>
			          <li><a href="#">按教师号搜索</a></li>
					  <li><a href="#">按系别搜索</a></li>
			        </ul>
			      </div><!-- /btn-group -->
			      <input type="text" class="form-control" aria-label="..." id="search_text">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button" id="search_btn">搜索</button>
			      </span>
			    </div><!-- /input-group -->
			    
							    
			  </div><!-- /.col-lg-6 -->
		</div><!-- row content -->
		<script>
		var optionObj = document.getElementById("search_option").getElementsByTagName("a");
		for (let i = 0; i < optionObj.length; i++) {
			optionObj[i].onclick = function() {
				document.getElementById("option_btn").setAttribute("opt", i);
				document.getElementById("option_btn").innerHTML = this.innerHTML;
			}
			
		}
		</script>
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
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="saveUpdate">保存</button>
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
				"url":"${pageContext.request.contextPath }/AdminSearchTeacherServlet",
				"data":{
					"search_text": teacherID,
					"search_option": "1"
				},
				"dataType":"json",
				"success": function(response, status, xhr) {
					response = response["data"][0];
					var res = {
							"姓名": response["t_name"],
							"工号": response["t_id"],
							"职位": response["t_jobtitle"],
							"院系": response["t_dp"],
							"薪水": response["t_salary"],
							"状态": response["t_state"],
							"入学时间": response["t_entertime"],
							"办公室": response["t_office"],
							"email": response["t_email"]
					};
					console.log(res);
					for (let key in res) {
						content.innerHTML = content.innerHTML +
						"<tr><th>" + key + "</th><td>" + res[key] + "</td></tr>";
					}
				}
			});
		}
		function course(teacherID) { 
			//获取该老师执教课程
			var content = document.getElementById("course-content").getElementsByClassName("table")[0];
			content.innerHTML = "<tr><th>课程名称</th><th>课程号</th><th>学分</th><th>平时分占比</th><th>院系</th><th>状态</th></tr>";
			$.post({
				"url":"${pageContext.request.contextPath }/AdminSearchTeacherCourseServlet",
				"data":{
					"teacherID": teacherID,
				},
				"dataType":"json",
				"success": function(response, status, xhr) {
					//TODO
					var cour = response["data"];
					for (let i = 0; i < cour.length; i++) {
						var str = content.innerHTML + "<tr>" + 
						"<td>" + cour[i]["c_name"] + "</td>" + 
						"<td>" + cour[i]["c_id"] + "</td>" + 
						"<td>" + cour[i]["c_score"] + "</td>" + 
						"<td>" + cour[i]["c_percentage"] + "</td>" + 
						"<td>" + cour[i]["c_opendp"] + "</td>" + 
						"<td>" + cour[i]["c_classstate"] + "</td></tr>";
						content.innerHTML = str;
					}
				}});


		}
		function update(teacherID) { 
			var content = document.getElementById("update-content").getElementsByClassName("table")[0];
			content.innerHTML = "";
			//首先获取信息，更新页面
			$.post({
				"url":"${pageContext.request.contextPath }/AdminSearchTeacherServlet",
				"data":{
					"search_text": teacherID,
					"search_option":"1"
				},
				"dataType":"json",
				"success": function(response, status, xhr) {
					response = response["data"][0];
					console.log(JSON.stringify(response));
					var res = {
							"姓名": response["t_name"],
							"工号": response["t_id"],
							"职位": response["t_jobtitle"],
							"院系": response["t_dp"],
							"手机号": response["t_phonenum"],
							"薪水": response["t_salary"],
							"状态": response["t_state"],
							"入学时间": response["t_entertime"],
							"办公室": response["t_office"],
							"email": response["t_email"]
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
						stor.put("teacher", "delete",  {"t_id": teacherID});
						
					}
					document.getElementById("saveUpdate").onclick = function() {
						//根据现在信息添加到清单
						var inputs = content.getElementsByTagName("input");
						var before = {
								"t_id": res["工号"],
								"t_name": res["姓名"],
								"t_jobtitle": res["职位"],
								"t_dp": res["院系"],
								"t_phonenum": res["手机号"],
								"t_salary": res["薪水"],
								"t_state": res["状态"],
								"t_entertime": res["入学时间"],
								"t_office": res["办公室"],
								"t_email": res["email"]
						}
						for (var i = 0; i < inputs.length; i++)
							res[inputs[i].getAttribute("key")] = inputs[i].value;
						var after = {
								"t_id": res["工号"],
								"t_name": res["姓名"],
								"t_jobtitle": res["职位"],
								"t_dp": res["院系"],
								"t_phonenum": res["手机号"],
								"t_salary": res["薪水"],
								"t_state": res["状态"],
								"t_entertime": res["入学时间"],
								"t_office": res["办公室"],
								"t_email": res["email"]
						}
						console.log(JSON.stringify(before));
						console.log(JSON.stringify(after));
						stor.put("teacher","update" , before, after);
						
					}
					
				}
			});
		}
		</script>
    <script>
		var optionObj = document.getElementById("search_option").getElementsByTagName("a");
		var option = 0;
	
		for (let i = 0; i < optionObj.length; i++) {
			let Obj = optionObj[i];
			Obj.onclick = function() {
				document.getElementById("option_btn").setAttribute("opt", i);
				document.getElementById("option_btn").innerHTML = Obj.innerHTML;
			}
		}
		var result = document.getElementById("result");
		var ori = result.innerHTML;
    	document.getElementById("search_btn").onclick = function() {

			//根据option进行处理……
			$.get({
				"url":"${pageContext.request.contextPath }/AdminSearchTeacherServlet",
				"data":{
					"search_option": document.getElementById("option_btn").getAttribute("opt"),
					"search_text": document.getElementById("search_text").value
				},
				"dataType":"json",
				"success": function(response, status, xhr) {
					//response应该是一个json包装的字典的数组
					//{"data":[ {} ... ]}
					//字典结构
					//		{
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
					if (res == "err") {
						alert("登录信息错误！");
						location.href="${pageContext.request.contextPath }/index.jsp";
					}
					var result = document.getElementById("result");
					result.innerHTML = ori;
					for (var i = 0; i < res.length; i++) {
						var id_ = res[i]["t_id"];
						var name = res[i]["t_name"];
						var dp = res[i]["t_dp"];
						
						var str = 
							result.innerHTML + "<tr>" + 
							"<td>" + name + "</td>" + 
							"<td>" + id_ + "</td>" + 
							"<td>" + dp + "</td>";
							console.log(id_);
							if (stor.has("teacher", id_))
								str += 
									"<td><span class='glyphicon glyphicon-paperclip'></span></td>"
							else
								str += "<td><a href='#' data-toggle=\"modal\" data-target=\"#teacher\" onclick='teacher(\"" +
								id_ + "\")'>详情</a></td>" + 
								"<td><a href='#' data-toggle=\"modal\" data-target=\"#course\" onclick='course(\"" +
								id_ + "\")'>课程</a></td>" + 
								"<td><a href='#' data-toggle=\"modal\" data-target=\"#update\" onclick='update(\"" +
								id_ + "\")'>更新</a></td>";
							str += "</tr>";
							result.innerHTML = str;
					}
				}
			});
		}
    </script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  	<script>
  	</script>
  </body>
</html>