<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <tags:head 
  css="${pageContext.request.contextPath }/css/navbar.css,
  ${pageContext.request.contextPath }/css/main.css,
  ${pageContext.request.contextPath }/css/overlay.css"
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
	            <li class="active"><a href="${pageContext.request.contextPath }/admin/admin.jsp">学生信息查询</a></li>
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
		  	<div class="col-lg-3"></div>
			 <div class="col-lg-6">
			    <div class="input-group input-group-lg">
			      <div class="input-group-btn">
			        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="option_btn">按姓名搜索 <span class="caret"></span></button>
			        <ul class="dropdown-menu" id="search_option">
			          <li><a href="#">按姓名搜索</a></li>
			          <li><a href="#">按学号搜索</a></li>
					  <li><a href="#">按班级搜索</a></li>
			        </ul>
			      </div><!-- /btn-group -->
			      <input type="text" class="form-control" aria-label="..." id="search_text">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button" id="search_btn">搜索</button>
			      </span>
			    </div><!-- /input-group -->
			  </div><!-- /.col-lg-6 -->
		</div><!-- row content -->
		<div class="row content">
			<div class="col-md-2"></div>
			<div class="col-md-9">
				<!-- 搜索结果 -->
				<table class="table table-striped" id="result">
				 	<tr>
				 		<th>姓名</th>
				 		<th>学号</th>
				 		<th>班级</th>
				 		<th>性别</th>
				 		<th>院系</th>
				 		<th></th>
				 		<th></th>
				 		<th></th>
				 	</tr>
				</table>
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">添加</h4>
					</div>
					<div class="modal-body" id="teacher-content">
						<table class="table">
							<tr>
								<th>姓名</th>
								<td><div class="input-group">
									<input type="text" key="姓名" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
							<tr>
								<th>学号</th>
								<td><div class="input-group">
									<input type="text" key="学号" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
							<tr>
								<th>性别</th>
								<td><div class="input-group">
									<input type="text" key="性别" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
							<tr>
								<th>班级</th>
								<td><div class="input-group">
									<input type="text" key="班级" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
							<tr>
								<th>院系</th>
								<td><div class="input-group">
									<input type="text" key="院系" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
							<tr>
								<th>专业</th>
								<td><div class="input-group">
									<input type="text" key="专业" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
							<tr>
								<th>状态</th>
								<td><div class="input-group">
									<input type="text" key="状态" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
							<tr>
								<th>入学时间</th>
								<td><div class="input-group">
									<input type="text" key="入学时间" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="saveAdd">保存</button>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="student" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">详情</h4>
					</div>
					<div class="modal-body" id="student-content">
						<table class="table">
							
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="grade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">成绩</h4>
					</div>
					<div class="modal-body" id="grade-content">
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
						<button type="button" class="btn btn-danger" data-dismiss="modal" id="deleteStudent">删除</button>
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
		
		function student(studentID) { 
			var content = document.getElementById("student-content").getElementsByClassName("table")[0];
			content.innerHTML = "";
			$.post({
				"url":"${pageContext.request.contextPath }/AdminSearchStudentServlet",
				"data":{
					"s_id": studentID
				},
				"dataType":"json",
				"success": function(response, status, xhr) {
					response = response["data"][0];
					var res = {
							"姓名": response["name"],
							"学号": response["id"],
							"性别": response["sex"],
							"班级": response["class"],
							"院系": response["dp"],
							"专业": response["major"],
							"状态": response["state"],
							"入学时间": response["entertime"]
					};
					
					for (key in res) {
						content.innerHTML = content.innerHTML +
						"<tr><th>" + key + "</th><td>" + res[key] + "</td></tr>";
					}
				}});
		}
		function grade(studentID) { 
			var content = document.getElementById("grade-content").getElementsByClassName("table")[0];
			content.innerHTML = "<tr><th>课程名称</th><th>课程号</th><th>成绩</th><th>平时成绩</th><th>试卷成绩</th><th>评价</th></tr>";
			$.post({
				"url":"${pageContext.request.contextPath }/SearchGradeServlet",
				"data":{
					"s_id": studentID
				},
				"dataType":"json",
				"success": function(response, status, xhr) {
					var res = {
						"课程名称": response["name"],
						"课程号": response["id"],
						"成绩": response["grade"],
						"平时成绩": response["ordTimeGrade"],
						"试卷成绩": response["examPaperGrade"],
						"评价": response["eval"]
					};
					for (var key in res) {
						content.innerHTML = content.innerHTML +
						"<tr><th>" + key + "</th><td>" + res[key] + "</td></tr>";
					}
				}});
		}
		function update(studentID) { 
			
			
			var content = document.getElementById("update-content").getElementsByClassName("table")[0];
			content.innerHTML = "";
			//首先获取信息，更新页面
			$.post({
				"url":"${pageContext.request.contextPath }/SearchStudentServlet",
				"data":{
					"s_id": studentID
				},
				"dataType":"json",
				"success": function(response, status, xhr) {
					response = response["data"][0];
					var res = {
							"姓名": response["name"],
							"学号": response["id"],
							"性别": response["sex"],
							"班级": response["class"],
							"院系": response["dp"],
							"专业": response["major"],
							"状态": response["state"],
							"入学时间": response["entertime"]
					};
					for (var key in res) {
						var item = "<div class=\"input-group\"><input type=\"text\" key='" + key + "'class=\"form-control\" aria-describedby=\"basic-addon1\" value=\"" + res[key] + "\"/></div>";
						if (key == "学号")
							item = res[key];
						content.innerHTML = content.innerHTML +
						"<tr><th>" + key + "</th><td>" + 
						item + 
						"</td></tr>";
					}
					document.getElementById("deleteStudent").onclick = function() {
						//删除学生操作添加到清单
						stor.put("delete", "student", {"studentID": studentID});
						
					}
					document.getElementById("saveUpdate").onclick = function() {
						//根据现在信息添加到清单
						var inputs = content.getElementsByTagName("input");
						for (var i = 0; i < inputs.length; i++)
							res[inputs[i].getAttribute("key")] = inputs[i].value;
						res["id"] = res["学号"];
						stor.put("update", "student", res);
						alert(JSON.stringify(stor.get("student")));
					}
					
					
			}});
			
		}
		</script>
		<script>
		/*
			查询
		*/
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
				"url":"${pageContext.request.contextPath }/SearchStudentServlet",
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
					var res = response["data"];
					console.log(res);
					var result = document.getElementById("result");
					for (var i = 0; i < res.length; i++) {
						var id_ = res[i]["id"];
						var name = res[i]["name"];
						var class_ = res[i]["class"];
						var dp = res[i]["dp"];
						var sex = res[i]["sex"];
						var major = res[i]["major"];
						var entertime = res[i]["entertime"];
						result.innerHTML = 
							result.innerHTML + "<tr id='" + "student" + id_ + "'>" + 
							"<td>" + name + "</td>" + 
							"<td>" + id_ + "</td>" + 
							"<td>" + class_ + "</td>" + 
							"<td>" + sex + "</td>" + 
							"<td>" + dp + "</td>" + 
							"<td><a href='#' data-toggle=\"modal\" data-target=\"#student\" onclick='student(\"" +
							id_ + "\")'>详情</a></td>" + 
							"<td><a href='#' data-toggle=\"modal\" data-target=\"#grade\" onclick='grade(\"" +
							id_ + "\")'>成绩</a></td>" + 
							"<td><a href='#' data-toggle=\"modal\" data-target=\"#update\" onclick='update(\"" +
							id_ + "\")'>更新</a></td></tr>";
					}
					// TODO
					//查询后根据localStorage来更新每一tr状态
					
				}
			});
		}
    </script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>