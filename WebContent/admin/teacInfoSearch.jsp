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
			      <input type="text" class="form-control" aria-label="...">
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
							"<td><a target='_blank' href='teacherINFO.jsp?id=" +
							id_ + "'>详情</a></td>" +  
							"<td><a target='_blank' href='teacherCourINFO.jsp?id=" +
							id_ + "'>课程</a></td>" +  
							"<td><a target='_blank' href='updateTeacherINFO.jsp?id=" +
							id_ + "'>更新</a></td></tr>";
					}
				}
			});
		}
    </script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>