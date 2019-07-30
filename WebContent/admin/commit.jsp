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
 <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
 	
 	<div class="container-fluid" id="main">
 		<div class="row content">
 			<div class="col-md-2"></div>
 			<div class="col-md-8">
		  		<div class="panel panel-info" id="stud-panel">
			  		<div class="panel-heading">
			  			<div class="row">
			  				<div class="col-md-3">
			  					<span class="panel-title">学生信息修改</span>
			  				</div>
			  				<div class="col-md-1">
								  <span  class="panel-title sel-num">0</span>
								  /
								  <span  class="panel-title all-num">0</span>
			  				</div>
			  				<div class="col-md-5"></div>
			  				<div class="col-md-1">
			  					<button type="button" class="btn btn-primary btn-sm del-btn">
							        <span class="glyphicon glyphicon-minus"></span>
							     </button>
			  				</div>
			  				<div class="col-md-1">
							     <button type="button" class="btn btn-primary btn-sm add-btn">
							        <span class="glyphicon glyphicon-plus"></span>
							     </button>
			  				</div>
			  				<div class="col-md-1">
								<a class="text-right" data-toggle="collapse" data-parent="#accordion"  href="#collapseStudent">
							         <button type="button" class="collapse-btn btn btn-default btn-sm">
							           <span class="glyphicon glyphicon-th-list"></span>
							          </button>
						         </a>
			  				</div>
			  			</div>
					</div>
					<div id="collapseStudent" class="panel-collapse collapse in">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-11">
									<button type="button" class="btn btn-primary btn-sm selAll-btn" >
							      		  全选
							    	 </button>
							    	 <button type="button" class="btn btn-primary btn-sm selNon-btn">
							        	全不选
							   		  </button>
							   		  <button type="button" class="btn btn-primary btn-sm selRev-btn">
							        	反选
							   		  </button>
								</div>
							</div>
						</div>
							<table class="table" id="student">
								<tr>
									<th>#</th>
									<th>操作</th>
									<th>学号</th>
									<th>姓名</th>
									<th></th><!-- 详情 -->
								</tr>
							</table>
					</div>
		  		</div>
		  		<div class="panel panel-warning" id="teac-panel">
			  		<div class="panel-heading">
			  			<div class="row">
			  				<div class="col-md-3">
			  					<span class="panel-title">教师信息修改</span>
			  				</div>
			  				<div class="col-md-1">
								<span  class="panel-title sel-num">0</span>
								/
								<span  class="panel-title all-num">0</span>
			  				</div>
			  				<div class="col-md-4"></div>
			  				<div class="col-md-1"></div>
			  				<div class="col-md-1">
			  					<button type="button" class="btn btn-primary btn-sm del-btn">
							        <span class="glyphicon glyphicon-minus"></span>
							     </button>
			  				</div>
			  				<div class="col-md-1">
							     <button type="button" class="btn btn-primary btn-sm add-btn">
							        <span class="glyphicon glyphicon-plus"></span>
							     </button>
			  				</div>
			  				<div class="col-md-1">
								<a class="text-right" data-toggle="collapse" data-parent="#accordion"  href="#collapseTeacher">
							         <button type="button" class="collapse-btn btn btn-default btn-sm">
							           <span class="glyphicon glyphicon-th-list"></span>
							          </button>
						         </a>
			  				</div>
			  			</div>
					</div>
					<div id="collapseTeacher" class="panel-collapse collapse in">
						<div class="panel-body">
								<div class="row">
								<div class="col-md-12">
									<button type="button" class="btn btn-primary btn-sm selAll-btn">
							      		 全选
							    	 </button>
							    	 <button type="button" class="btn btn-primary btn-sm selNon-btn">
							        	全不选
							   		  </button>
							   		  <button type="button" class="btn btn-primary btn-sm selRev-btn">
							        	反选
							   		  </button>
								</div>
							</div>				
						</div>
					</div>
							<table class="table" id="teacher">
								<tr>
									<th>#</th>
									<th>操作</th>
									<th>工号</th>
									<th>姓名</th>
									<th></th><!-- 详情  -->
								</tr>
							</table>
		  		</div>
		  		<div class="panel panel-success" id="cour-panel">
			  		<div class="panel-heading">
			  			<div class="row">
			  				<div class="col-md-3">
			  					<span class="panel-title">课程信息修改</span>
			  				</div>
			  				<div class="col-md-1">
								<span  class="panel-title sel-num">0</span>
								/
								<span  class="panel-title all-num">0</span>
			  				</div>
			  				<div class="col-md-4"></div>
			  				<div class="col-md-1"></div>
			  				<div class="col-md-1">
			  					<button type="button" class="btn btn-primary btn-sm del-btn">
							        <span class="glyphicon glyphicon-minus"></span>
							     </button>
			  				</div>
			  				<div class="col-md-1">
							     <button type="button" class="btn btn-primary btn-sm add-btn">
							        <span class="glyphicon glyphicon-plus"></span>
							     </button>
			  				</div>
			  				<div class="col-md-1">
								<a class="text-right" data-toggle="collapse" data-parent="#accordion"  href="#collapseCourse">
							         <button type="button" class="collapse-btn btn btn-default btn-sm">
							           <span class="glyphicon glyphicon-th-list"></span>
							          </button>
						         </a>
			  				</div>
			  			</div>
					</div>
					<div id="collapseCourse" class="panel-collapse collapse in">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12">
									<button type="button" class="btn btn-primary btn-sm selAll-btn" >
										全选
								 </button>
								 <button type="button" class="btn btn-primary btn-sm selNon-btn">
									全不选
									 </button>
									 <button type="button" class="btn btn-primary btn-sm selRev-btn">
									反选
									 </button>
								</div>
							</div>
						</div>
							<table class="table" id="course">
								<tr>
									<th>#</th>
									<th>操作</th>
									<th>课程号</th>
									<th>课程名</th>
									<th></th><!-- 详情 -->
								</tr>
							</table>
					</div>
		  		</div>
		  		<div class="panel panel-danger" id="selC-panel">
			  		<div class="panel-heading">
			  			<div class="row">
			  				<div class="col-md-3">
			  					<span class="panel-title">选课信息修改</span>
			  				</div>
			  				<div class="col-md-1">
								<span  class="panel-title sel-num">0</span>
								/
								<span  class="panel-title all-num">0</span>
			  				</div>
			  				<div class="col-md-4"></div>
			  				<div class="col-md-1"></div>
			  				<div class="col-md-1">
			  					<button type="button" class="btn btn-primary btn-sm del-btn">
							        <span class="glyphicon glyphicon-minus"></span>
							     </button>
			  				</div>
			  				<div class="col-md-1">
							     <button type="button" class="btn btn-primary btn-sm add-btn">
							        <span class="glyphicon glyphicon-plus"></span>
							     </button>
			  				</div>
			  				<div class="col-md-1">
								<a class="text-right" data-toggle="collapse" data-parent="#accordion"  href="#collapseSelectCourse">
							         <button type="button" class="collapse-btn btn btn-default btn-sm">
							           <span class="glyphicon glyphicon-th-list"></span>
							          </button>
						         </a>
			  				</div>
			  			</div>
					</div>
					<div id="collapseSelectCourse" class="panel-collapse collapse in">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12">
									<button type="button" class="btn btn-primary btn-sm selAll-btn" >
										全选
								 </button>
								 <button type="button" class="btn btn-primary btn-sm selNon-btn">
									全不选
									 </button>
									 <button type="button" class="btn btn-primary btn-sm selRev-btn">
									反选
									 </button>
								</div>
							</div>
						</div>
							<table class="table" id="course">
								<tr>
									<th>#</th>
									<th>操作</th>
									<th>姓名</th>
									<th>学号</th>
									<th>课程名称</th>
									<th>课程号</th>
									<th></th><!-- 详情 -->
								</tr>
							</table>
					</div>
		  		</div>
 			</div>
 		</div>
 	</div>
 	
    <script>
    	function init() {
	    	function getInfo(target) {
	    		var sum = stor.getTargetNum(target);
	    		if (sum == 0)
	    			return null;
	    		var data = stor.get(target);
	    		return {
	    			"data":data,
	    			"add":sum[0],
	    			"delete":sum[1],
	    			"update":sum[2],
	    			"sum":function() {return this["add"] + this["delete"] + this["update"];}
	    		};
	    	}
	    	//接受一个panel的对象，初始化其界面
			function panel_init(panel_id, sum) {
				//初始化如下：总数，操作复选框按钮的onclick
				//返回panel
				//假设复选框class为sel-checkbox
				var panel = $("#" + panel_id)[0];
				panel.getElementsByClassName("all-num")[0].innerHTML = "" + sum;
				
				panel.getElementsByClassName("selAll-btn")[0].onclick = function() {
					var checkboxs = panel.getElementsByClassName("sel-checkbox");
					for (var i = 0; i < checkboxs.length; i++)
						checkboxs[i].checked = true;
				}
				panel.getElementsByClassName("selNon-btn")[0].onclick = function() {
					var checkboxs = panel.getElementsByClassName("sel-checkbox");
					for (var i = 0; i < checkboxs.length; i++)
						checkboxs[i].checked = false;
				}
				panel.getElementsByClassName("selRev-btn")[0].onclick = function() {
					var checkboxs = panel.getElementsByClassName("sel-checkbox");
					for (var i = 0; i < checkboxs.length; i++)
						checkboxs[i].checked = !checkboxs[i].checked;
				}
				
				return panel;
			}
			function stud_init() {
				var info = getInfo("student");
				var panel = panel_init("stud-panel", info["sum"]());
				//初始化添加，删除，详情，展示所有选择
			}
			function teac_init() {
				var info = getInfo("teacher");
				var panel = panel_init("teac-panel", info["sum"]());
				
			}
			function cour_init() {
				var info = getInfo("course");
				var panel = panel_init("cour-panel", info["sum"]());
				
			}
			function selC_init() {
				var info = getInfo("selectCourse");
				var panel = panel_init("selC-panel", info["sum"]());
				
			}
    		stud_init();
    		teac_init();
    		cour_init();
    		selC_init();
    	}
    	//更新
    	if (!stor.notEmpty()) {
    		alert("你还没有任何修改！");
    		//location.href="admin.jsp";
		}
    	init();
    	
    	
    </script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>