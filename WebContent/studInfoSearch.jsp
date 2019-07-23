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
	            <li><a href="admin.jsp">个人信息</a></li>
	            <li class="active"><a href="studInfoSearch.jsp">学生信息查询</a></li>
	            <li><a href="teacInfoSearch.jsp">教师信息查询</a></li>
	            <li><a href="courInfoSearch.jsp">课程信息查询</a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他 <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	              	<li><a href="addStudent.jsp">添加学生</a></li>
	              	<li><a href="studInfoSearch.jsp">添加老师</a></li>
	              	<li><a href="studInfoSearch.jsp">添加课程</a></li>
	              	<li><a href="studInfoSearch.jsp">添加成绩</a></li>
	              	<li role="separator" class="divider"></li>
	                <li><a href="logout.jsp">登出</a></li>									
	              </ul>
	            </li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right">
	            <li id="name"><a href="#">管理员<span id="username"></span>,你好</a></li>
	            <li class="active" id="updateList_btn"><a href="#">修改清单<span class="caret"></span></a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>
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
			          <li><a href="#">按专业搜索</a></li>
					  <li><a href="#">按系别搜索</a></li>
			        </ul>
			      </div><!-- /btn-group -->
			      <input type="text" class="form-control" aria-label="..." id="search_text">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button" id="search_btn">搜索</button>
			      </span>
			    </div><!-- /input-group -->
			    
			    blablabla
			    
			  </div><!-- /.col-lg-6 -->
		</div><!-- row content -->
		
		<div class="row content">
			<div class="col-md-2"></div>
			<div class="col-md-9">
				<!-- 搜索结果 -->
				<table class="table table-hover" id="result">
				 	<tr>
				 		<th>姓名</th>
				 		<th>学号</th>
				 		<th>班级</th>
				 		<th>性别</th>
				 		<th>院系</th>
				 		<th>专业</th>
				 		<th>入学时间</th>
				 		<th></th>
				 	</tr>
				</table>
			</div>
		</div>
		
 	</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
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
				"url":"SearchStudentServlet",
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
						result.innerHTML = result.innerHTML + "<tr>" + 
						"<td>" + name + "</td>" + 
						"<td>" + id_ + "</td>" + 
						"<td>" + class_ + "</td>" + 
						"<td>" + dp + "</td>" + 
						"<td>" + sex + "</td>" + 
						"<td>" + major + "</td>" + 
						"<td>" + entertime + "</td>" + 
						"<td><a target='_blank' href='updateStudent.jsp?id=" +
						id_ + "'>更新</a></td></tr>";
					}
				}
			});

		}
    </script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>