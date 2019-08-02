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
	            <li><a href="${pageContext.request.contextPath }/teacher/teacher.jsp">个人信息</a></li>
	            <li class="active"><a href="${pageContext.request.contextPath }/teacher/teacherCourseInfo.jsp">教授课程</a></li>
	           
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他 <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	               <li><a href="${pageContext.request.contextPath }/changePasswd.jsp">更改密码</a></li>
	                <li><a href="${pageContext.request.contextPath }/logout.jsp">登出</a></li>
	              </ul>
	            </li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right">
	            <li id="name"><a href="#"><span id="username"></span>老师,你好</a></li>
	            <li class="active" id="updateList_btn"><a href="${pageContext.request.contextPath }/teacher/commit.jsp">修改清单</a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>
 		<script>
	    	document.getElementById("username").innerHTML = getCookie("username");
	    </script>
	    
	    
	<div class="modal fade" id="grade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document" style="width:1000px">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">学生成绩</h4>
					</div>
					<div class="modal-body" id="grade-content">
						<table class="table">
							<tr>
							 	<th>姓名</th>
							 	<th>学号</th>
							 	<th>成绩</th>
								<th>平时成绩</th>
								<th>考试成绩</th>
							 	<th></th><!-- 成绩 -->
							 	<th></th><!-- 删除 -->
							 	<th></th><!-- 标识 -->
							 </tr>
						</table>
					</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="addGrade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">成绩添加</h4>
					</div>
					<div class="modal-body" id="modify-content">
						<table class="table">
						<tr>
							<th>姓名</th>
							<!--  -->
							<td><div class="input-group">
								  <input type="text" class="item" aria-label="">
							</div></td>
						</tr>
						<tr>
							<th>学号</th>
							<!--  -->
							<td><div class="input-group">
								  <input type="text" class="item" aria-label="">
							</div></td>
						</tr>
						<tr>
							<th>成绩</th>
							<!--  -->
							<td class="item"></td>
						</tr>
						<tr>
							<th>平时成绩</th>
							<!--  -->
							<td>
								<div class="input-group">
								  <input type="text" class="item" aria-label="">
								</div>
							</td>
						</tr>
						<tr>
							<th>考试成绩</th>
							<!--  -->
							<td>
								<div class="input-group">
								  <input type="text" class="item" aria-label="">
								</div>
							</td>
						</tr>
						
					</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary add-btn" data-dismiss="modal">保存</button>
					</div>
				</div>
			</div>
		</div>
		
		<script>
			var ori = document.getElementById("grade").getElementsByClassName("table")[0].innerHTML;
		</script>
		
 	<div class="container" id="main">
	  	<div class="row content">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<table class="table" id="table">
					<tr>
					 	<th>名称</th>
					 	<th>课程号</th>
					 	<th>院系</th>
						<th>学分</th>
						<th>状态</th>
					 	<th>平时分占比</th>
					 	<th></th>
					 	<th></th><!-- 成绩 -->
					 </tr>
				</table>
			</div>
		  </div>
 	</div>
 	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script>
    	var data = [];
    </script>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>
	    function addGrade(courseName, courseID, percentage) {
			//初始化model信息
			var model = document.getElementById("addGrade");
			var res = model.getElementsByClassName("item");
			for (let i = 0; i < res.length; i++)
				res[i].value = "";
			percentage = parseFloat(percentage) / 100;
			for (let i = 3; i < 5; i++) {
				res[i].onchange = function() {
					var reg = parseInt(res[3].value);
					var test = parseInt(res[4].value);
					var grade = "" + parseInt(reg * percentage + test * (1 - percentage));
					if (grade == "NaN")
						grade = "错误的数据";
					res[2].innerHTML = grade;
				}
			}
			model.getElementsByClassName("add-btn")[0].onclick = function() {
				var ori = {
					"c_id": courseID,
					"c_name": courseName,
					"s_id": res[1].value,
					"s_name": res[0].value,
					"reg": parseInt(res[3].value),
					"test": parseInt(res[4].value)
				};
				stor.put("grade", "add", ori, null);
	   	 	}
	    }
	    function deleteGrade(courseID, studentID, courseName, studentName, reg, test) {
	    	var ori = {
	    		"s_id":studentID,
	    		"c_id":courseID,
	    		"s_name":studentName,
	    		"c_name":courseName,
	    		"reg":reg,
	    		"test":test
	    	}
	    	stor.put("grade", "delete", ori, null);
	    }
    	function grade(courseName, courseID, percentage) {
    		// TODO 校验courseID是否隶属于teacherID
    		$.get({
			"url":"${pageContext.request.contextPath }/TeacherSearchStudentGradeServlet",
			"data":{
				"courseID": courseID
			},
			"dataType":"json",
			"success": function(response, status, xhr) {
				var res = response["data"];
				var info = $("#grade")[0].getElementsByClassName("table")[0];
				info.innerHTML = ori;
				for (var i in res) {
					var arr = [
						res[i]["studentName"],
						res[i]["studentId"],
						res[i]["totalMark"],
						res[i]["regularGrade"],
						res[i]["testGrade"]
					]
					var str = "<tr class='disabled'>";
					for (var j in arr) {
						str += "<td>" + arr[j] + "</td>"
					}
					data = arr;
					data.push(percentage);
					data.push(courseName);
					data.push(courseID);
					if (stor.has("grade", {"s_id":arr[1], "c_id":courseID})) {
						//标识
						str += 
							"<td><span class='glyphicon glyphicon-paperclip'></span></td>"
					}
					else {
						str += 
							"<td>" +
							"<a class=\"href\" data-dismiss=\"modal\" href='#' onclick=\"deleteGrade('" + courseID + "','" + arr[1] + "','" + courseName + "','" + arr[0] + "','" + arr[3] + "','" + arr[4] + "')\">删除</a>" + 
							"</td>";
							
						str +=
							"<td>" + 
							"<a class=\"href disabled\" href=\"#\" "+
							"onclick=\"window.open(\'gradeModel.jsp\', '','model=yes,resizable=no,scrollbars=no,width=1000px,height=400px,left=200px,top=200px,location=no,menubar=no,toolbar=no,titlebar=no,status=no')\"" + 
							">编辑</a>" + 
							"</td>";
						
					}
					str += "</tr>";
					info.innerHTML += str;
				}
			}});
    	}
		
    </script>
    <script>
    
	    $.post({
			"url":"${pageContext.request.contextPath }/TeacherSearchCourseServlet",
			"data":{
				"teacherID": getCookie("userID")
			},
			"dataType":"json",
			"success": function(response, status, xhr) {
				console.log(JSON.stringify(response));
				var res = response["data"];
				if (res == "err") {
					alert("登录信息错误！");
					location.href="${pageContext.request.contextPath }/index.jsp";
				}
				var info = $("#table")[0];
				for (var i in res) {
					var arr = [
						res[i]["c_name"],
						res[i]["c_id"],
						res[i]["c_opendp"],
						res[i]["c_score"],
						res[i]["c_classstate"],
						res[i]["c_percentage"]
					]
					var str = "<tr>";
					for (var j in arr) {
						str += "<td>" + arr[j] + "</td>"
					}
					
					str +=
						"<td><a href=\"#\" data-toggle=\"modal\" data-target=\"#addGrade\" "+
						"onclick=\"addGrade('" + arr[0] + "', '" + arr[1] + "','" + arr[5] + "')\"" + 
						">添加成绩</a></td>";
					str +=
						"<td><a href=\"#\" data-toggle=\"modal\" data-target=\"#grade\" "+
						"onclick=\"grade('" + arr[0] + "', \'" + arr[1] + "\', '" + arr[5] + "')\"" + 
						">成绩</a></td></tr>";
						
					//要是已经被编辑过了……
					info.innerHTML += str;
					
				}
			}
		});
    </script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>