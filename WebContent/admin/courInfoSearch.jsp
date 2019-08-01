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
	            <li><a href="${pageContext.request.contextPath }/admin/admin.jsp">学生信息查询</a></li>
	            <li><a href="${pageContext.request.contextPath }/admin/teacInfoSearch.jsp">教师信息查询</a></li>
	            <li class="active"><a href="${pageContext.request.contextPath }/admin/courInfoSearch.jsp">课程信息查询</a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他 <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	              	
	                <li><a href="${pageContext.request.contextPath }/logout.jsp">登出</a></li>
	              </ul>
	            </li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right">
	            <li id="name"><a href="#">管理员<span id="username"></span>,你好</a></li>
	            <li class="active" id="updateList_btn"><a href="${pageContext.request.contextPath }/admin/commit.jsp">修改清单</a></li>
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
			        <button type="button" id="option_btn" opt="0" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">按课程名搜索 <span class="caret"></span></button>
			        <ul class="dropdown-menu" id="search_option">
			          <li><a href="#">按课程名搜索</a></li>
			          <li><a href="#">按课程号搜索</a></li>
					  <li><a href="#">按系别搜索</a></li>
			        </ul>
			      </div><!-- /btn-group -->
			      <input type="text" id="search_text" class="form-control" aria-label="...">
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
				<!-- 搜索结果 -->
				<table class="table table-hover" id="result">
				 	<tr>
				 		<th>名称</th>
				 		<th>课程号</th>
				 		<th>院系</th>
				 		<th>学分</th>
				 		<th>平时分占比</th>
				 		<th>状态</th>
				 		<th>教师</th>
				 		<th></th>
				 	</tr>
				</table>
			</div>
		</div>
		<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">添加</h4>
					</div>
					<div class="modal-body" id="add-content">
						<table class="table">
							<tr>
								<th>名称</th>
								<td><div class="input-group">
									<input type="text" key="名称" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
							<tr>
								<th>课程号</th>
								<td><div class="input-group">
									<input type="text" key="课程号" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
							<tr>
								<th>院系</th>
								<td><div class="input-group">
									<input type="text" key="院系" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
							<tr>
								<th>学分</th>
								<td><div class="input-group">
									<input type="text" key="学分" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
							<tr>
								<th>占比</th>
								<td><div class="input-group">
									<input type="text" key="占比" class="form-control" aria-describedby="basic-addon1" >
								</div></td>
							</tr>
							<tr>
								<th>教师工号</th>
								<td><div class="input-group">
									<input type="text" key="教师工号" class="form-control" aria-describedby="basic-addon1" >
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
						<button type="button" class="btn btn-danger" data-dismiss="modal" id="deleteCourse">删除</button>
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

function teacher(dict) { 
	var content = document.getElementById("teacher-content").getElementsByClassName("table")[0];
	content.innerHTML = "";
	var data = {
		"名称":dict["t_name"],
		"工号":dict["t_id"],
		"院系":dict["t_dp"],
		"职称":dict["t_jobtitle"],
		"薪水":dict["t_salary"],
		"电话号码":dict["t_phonenum"],
		"email":dict["t_email"],
		"办公室":dict["t_office"],
		"状态":dict["t_state"],
		"入职时间":dict["t_entertime"]
	}
	var str = "";
	for (var key in data) {
		str += "<tr><th>" + key + "</th><td>" + data[key] + "</td></tr>";
	}
	content.innerHTML = str;
}

function update(courseID) { 
	var content = document.getElementById("update-content").getElementsByClassName("table")[0];
	content.innerHTML = "";
	//首先获取信息，更新页面
	$.post({
		"url":"${pageContext.request.contextPath }/AdminSearchCourseServlet",
		"data":{
			"search_text": courseID,
			"search_option": "1"
		},
		"dataType":"json",
		"success": function(response, status, xhr) {
			response = response["data"][0];
			var res = {
					"名称": response["c_name"],
				 	"课程号":response["c_id"],
					"院系": response["c_dp"],
				 	"学分": response["c_score"],
				 	"占比": response["c_percentage"]
			};
			for (var key in res) {
				var item = "<div class=\"input-group\"><input type=\"text\" key='" + key + "'class=\"form-control\" aria-describedby=\"basic-addon1\" value=\"" + res[key] + "\"/></div>";
				if (key == "课程号")
					item = res[key];
				content.innerHTML = content.innerHTML +
				"<tr><th>" + key + "</th><td>" + 
				item + 
				"</td></tr>";
			}
			document.getElementById("deleteCourse").onclick = function() {
				//删除学生操作添加到清单
				stor.put("delete", "course", {"courseID": courseID});
				
			}
			document.getElementById("saveUpdate").onclick = function() {
				//根据现在信息添加到清单
				var inputs = content.getElementsByTagName("input");
				for (var i = 0; i < inputs.length; i++)
					res[inputs[i].getAttribute("key")] = inputs[i].value;
				res["id"] = res["课程号"];
				stor.put("update", "course", res);
				alert(JSON.stringify(stor.get("course")));
			}
			
		}
	});
}
</script>
<script>
		var ori = document.getElementById("result").innerHTML;
    	document.getElementById("search_btn").onclick = function() {
			//根据option进行处理……
			$.post({
				"url":"${pageContext.request.contextPath }/AdminSearchCourseServlet",
				"data":{
					"search_option": document.getElementById("option_btn").getAttribute("opt"),
					"search_text": document.getElementById("search_text").value
				},
				"dataType":"json",
				"success": function(response, status, xhr) {
					//response应该是一个json包装的字典的数组
					//{"data":[ {} ... ]}
					//字典结构
					/*
						{
							c_id:
							name:
							dp:
							score:
							percentage:
							t_name:
							t_id:
						}
					
					*/
					var res = response["data"];
					var teac = response["teac"];
					if (res == "err") {
						alert("登录信息错误！");
						location.href="${pageContext.request.contextPath }/index.jsp";
					}
					var result = document.getElementById("result");
					result.innerHTML = ori;
					for (let i = 0; i < res.length; i++) {
						var c_id = res[i]["c_id"];
						var name = res[i]["c_name"];
						var score = res[i]["c_score"];
						var dp = res[i]["c_opendp"];
						var percentage = res[i]["c_percentage"];
						var t_classstate = res[i]["c_classstate"];
						var t_id = res[i]["t_id"];
						console.log(teac);
						console.log(res);
						result.innerHTML = 
							result.innerHTML + "<tr>" + 
							"<td>" + name + "</td>" + 
							"<td>" + c_id + "</td>" + 
							"<td>" + dp + "</td>" + 
							"<td>" + score + "</td>" + 
							"<td>" + percentage + "%</td>" + 
							"<td>" + t_classstate + "</td>" +
							"<td><a href='#' data-toggle=\"modal\" data-target=\"#teacher\" onclick='teacher(" +
							JSON.stringify(teac[i]) + ")'>"+ teac[i]["t_name"] + "</a></td>" +  
							"<td><a href='#' data-toggle=\"modal\" data-target=\"#update\" onclick='update(\"" +
							c_id + "\")'>更新</a></td></tr>";
					}
				}
			});
		}
    </script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>