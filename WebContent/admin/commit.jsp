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
			  				<div class="col-md-2">
								  <span  class="panel-title sel-num">0</span>
								  /
								  <span  class="panel-title all-num">0</span>
			  				</div>
			  				<div class="col-md-3"></div>
			  				<div class="col-md-1">
			  					<button type="button" class="btn btn-primary btn-sm del-btn">
							        <span class="glyphicon glyphicon-minus"></span>
							     </button>
			  				</div>
			  				<div class="col-md-1">
							     <button type="button" class="btn btn-primary btn-sm add-btn" data-toggle="modal" data-target="#add-model">
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
			  				<div class="col-md-2">
								<span  class="panel-title sel-num">0</span>
								/
								<span  class="panel-title all-num">0</span>
			  				</div>
			  				<div class="col-md-3"></div>
			  				<div class="col-md-1"></div>
			  				<div class="col-md-1">
			  					<button type="button" class="btn btn-primary btn-sm del-btn">
							        <span class="glyphicon glyphicon-minus"></span>
							     </button>
			  				</div>
			  				<div class="col-md-1">
							     <button type="button" class="btn btn-primary btn-sm add-btn" data-toggle="modal" data-target="#add-model">
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
			  				<div class="col-md-2">
								<span  class="panel-title sel-num">0</span>
								/
								<span  class="panel-title all-num">0</span>
			  				</div>
			  				<div class="col-md-3"></div>
			  				<div class="col-md-1"></div>
			  				<div class="col-md-1">
			  					<button type="button" class="btn btn-primary btn-sm del-btn">
							        <span class="glyphicon glyphicon-minus"></span>
							     </button>
			  				</div>
			  				<div class="col-md-1">
							     <button type="button" class="btn btn-primary btn-sm add-btn" data-toggle="modal" data-target="#add-model">
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
			  				<div class="col-md-2">
								<span  class="panel-title sel-num">0</span>
								/
								<span  class="panel-title all-num">0</span>
			  				</div>
			  				<div class="col-md-3"></div>
			  				<div class="col-md-1"></div>
			  				<div class="col-md-1">
			  					<button type="button" class="btn btn-primary btn-sm del-btn">
							        <span class="glyphicon glyphicon-minus"></span>
							     </button>
			  				</div>
			  				<div class="col-md-1">
							     <button type="button" class="btn btn-primary btn-sm add-btn" data-toggle="modal" data-target="#add-model">
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
	<!--  --------------------------------------------------------- -->
	<div class="modal fade" id="add-model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">添加</h4>
				</div>
				<div class="modal-body" id="update-content">

					<table class="table">
						
					</table>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger del-single-btn"  data-dismiss="modal">删除</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary save-btn"  data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="update-model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">更新</h4>
				</div>
				<div class="modal-body" id="update-content">
					<div class="row">
						<div class="col-md-5">
							<table class="table table-left">
						
							</table>
						</div>
						<div class="col-md-2"><span class="glyphicon glyphicon-chevron-right"></span></div>
						<div class="col-md-5">
							<table class="table table-right">
						
							</table>	
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger del-single-btn"  data-dismiss="modal">删除</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary save-btn"  data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="delete-model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">删除</h4>
				</div>
				<div class="modal-body" id="update-content">
					<table class="table">
						
					</table>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger del-single-btn"  data-dismiss="modal">删除</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<script>
		//模态框信息初始化函数，被“详情”的a标签onclick和add按钮onclick调用
		//若dict存在则操作dict，否则操作this的父元素的父元素的attribute(data)
		/*
			dict: {
				ori:{}
				after:{}
			}
		
		*/
		function _(opt, dict, target, keyMap) { //置入数据并返回模态框obj
			//opt:操作
			//dict：初始化模态框所需数据
			//target：目标对象， student，teacher...
			//keyMap：key的映射，因为使用字典key名直接显示……
			model = $("#" + opt + "-model")[0];
			console.log(model);
			if (opt == "add" || opt == "delete") {
				var table = model.getElementsByClassName("table")[0];
				table.innerHTML = "";
				console.log(table);
				for (var key in dict["ori"])  {
					var str = "<div class=\"input-group\">" + 
					"<input type=\"text\" key=\"" + key + "\" value=\"" + dict["ori"][key] + "\" class=\"form-control\" aria-describedby=\"basic-addon1\" >"
					 + "</div>";
					if (opt != "add" && (opt == "delete" || (key == "工号" || key == "学号" || key == "课程号")))
						 str = dict["ori"][key];
					table.innerHTML = table.innerHTML + 
					"<tr><th>" + key + "</th><td>" +
					str + 
				 	"</td></tr>";
					
				}
			}
			else if (opt == "update") {
				var table_l = model.getElementsByClassName("table-left")[0];
				var table_r = model.getElementsByClassName("table-right")[0];
				table_l.innerHTML = "";
				table_r.innerHTML = "";
					for (var key in dict["ori"]) {
						table_l.innerHTML = table_l.innerHTML + 
						"<tr><th>" + key + "</th><td>" + dict["ori"][key] + "</td></tr>";
						
						var str = "<div class=\"input-group\">" + 
						"<input class=\"res-item\" type=\"text\" key=\"" + key + "\" value=\"" + dict["ori"][key] + "\" class=\"form-control\" aria-describedby=\"basic-addon1\" >"
						 + "</div>";
						if (opt != "add" && (opt == "delete" || (key == "工号" || key == "学号" || key == "课程号")))
							 str = dict["ori"][key];
						table_r.innerHTML = table_r.innerHTML + 
						"<tr><th>" + key + "</th><td class=\"res-item\" key=\"" + key + "\">" +
						str + 
					 	"</td></tr>";
					}
			}
			if (opt != "delete") //不是delete的话都有保存操作
				model.getElementsByClassName("save-btn").onclick = function() {
					var rights = model.getElementsByClassName("res-item");
					var res = {}
					for (var i = 0; i < rights.length; i++) {
						var value = rights[i].value;
						if (value == null) key = rights[i].innerHTML;
						var key = rights[i].getAttribute("key");
						res[key] = value;
					}
					dict["after"] = res;
					stor.set(target, dict);
				}
			
			model.getElementsByClassName("del-single-btn").onclick = function() {
				
			}
			
			return model;
		}
		function stud_info(opt, dict) { //stud模态框
			if(!dict) //没有dict说明是点击“详情”执行该函数
				dict = JSON.parse(this.parentElement.parentElement.getAttribute("data"));
			var model = _(opt, dict, "student"); 
		
		}
		function teac_info(opt, dict) { //teac
			if(!dict)
				dict = JSON.parse(this.parentElement.parentElement.getAttribute("data"));
			var model = _(opt, dict, "teacher");
		}
		function cour_info(opt, dict) { //cour
			if(!dict)
				dict = JSON.parse(this.parentElement.parentElement.getAttribute("data"));
			var model = _(opt, dict, "course");
		}
		function selC_info(opt, dict) { //selectCourse
			if(!dict)
				dict = JSON.parse(this.parentElement.parentElement.getAttribute("data"));
			var model = _(opt, dict, "selectCourse");
		}
	</script>
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
				/**
				 * table中每一列的结构
				 * <tr><td><checkbox class="sel-checkbox"/></td>
				 * <th>操作</th>
				 * <th>学号</th>
				 * <th>姓名</th>
				 * <th><a>打开model的a标签</a></th>
				 * </tr>
				 */
				function str(jsonObj, opt) {
					var jsonStr = JSON.stringify(jsonObj);
					return "<tr data=\"" + jsonStr + "\">" + 
						"<td><checkbox class=\"sel-checkbox\"/></td>" + 
						"<td>" + opt + "</td>" + 
						"<td>" + jsonObj["ori"]["s_id"] + "</td><td>" + jsonObj["ori"]["s_name"] + "</td>" + 
						"<td><button type=\"button\" onclick=\"stud-info(\"" + opt + "\")\" data-toggle=\"modal\" data-target=\"#" + opt + "-model\">详情</button></td></tr>";	
				}	
				var allInfo = stor.get("student");
				var table = panel.getElementsByClassName("table")[0];
				for (var key in allInfo) {
					for (var i = 0; i < allInfo[key].length; i++) {
						table.innerHTML = table.innerHTML + 
						str(allInfo[key][i], key);
					}
				}
				//初始化按钮
				//从修改清单里删除复选框里选中的修改
				panel.getElementsByClassName("del-btn")[0].onclick = function() {
					if (!confirm("你确定删除选中修改项吗"))
						return;
					var checkboxs = panel.getElementsByClassName("sel-checkbox");
					for (var i = 0; i < checkboxs.length; i++) {
						if (!checkboxs[i].checked)
							continue;
						var jsonStr = checkboxs[i].parentElement.parentElement.getAttribute("data");
						var jsonObj = JSON.parse(jsonStr);
						stor.delItem("student", jsonObj["ori"]);
					}
				}
				panel.getElementsByClassName("add-btn")[0].onclick = function() {
					//初始化模态框在这里
					var dict = {
						"姓名": "",
						"学号": "",
						"性别": "",
						"班级": "",
						"院系": "",
						"专业": "",
						"状态": "",
						"入学时间": ""
					};
					dict = {
							"ori":dict,
							"after":null
					};
					stud_info("add", dict);
				}
			}
			function teac_init() {
				var info = getInfo("teacher");
				var panel = panel_init("teac-panel", info["sum"]());
				//初始化添加，删除，详情，展示所有选择
				/**
				 * table中每一列的结构
				 * <tr><td><checkbox class="sel-checkbox"/></td>
				 * <th>操作</th>
				 * <th>工号</th>
				 * <th>姓名</th>
				 * <th><a>打开model的a标签</a></th>
				 * </tr>
				 */
				function str(jsonObj, opt) {
					var jsonStr = JSON.stringify(jsonObj);
					return "<tr data=\"" + jsonStr + "\">" + 
						"<td><checkbox class=\"sel-checkbox\"/></td>" + 
						"<td>" + opt + "</td>" + 
						"<td>" + jsonObj["ori"]["t_id"] + "</td><td>" + jsonObj["ori"]["t_name"] + "</td>" + 
						"<td><button type=\"button\" onclick=\"teac-info(\"" + opt + "\")\" data-toggle=\"modal\" data-target=\"#" + opt + "-model\">详情</button></td></tr>";	
				}	
				var allInfo = stor.get("teacher");
				var table = panel.getElementsByClassName("table")[0];
				for (var key in allInfo) {
					for (var i = 0; i < allInfo[key].length; i++) {
						table.innerHTML = table.innerHTML + 
						str(allInfo[key][i], key);
					}
				}
				
				//初始化按钮
				panel.getElementsByClassName("del-btn")[0].onclick = function() {
					if (!confirm("你确定删除选中修改项吗"))
						return;
					var checkboxs = panel.getElementsByClassName("sel-checkbox");
					for (var i = 0; i < checkboxs.length; i++) {
						if (!checkboxs[i].checked)
							continue;
						var jsonStr = checkboxs[i].parentElement.parentElement.getAttribute("data");
						var jsonObj = JSON.parse(jsonStr);
						stor.delItem("teacher", jsonObj["ori"]);
					}
				}
				panel.getElementsByClassName("add-btn")[0].onclick = function() {
					var dict = {
						"姓名": "",
						"工号": "",
						"职位": "",
						"院系": "",
						"性别": "",
						"薪水": "",
						"状态": "",
						"入学时间": "",
						"办公室": "",
						"email": "",
					};
					dict = {
							"ori":dict,
							"after":null
					};
					stud_info("add", dict);
				}
			}
			function cour_init() {
				var info = getInfo("course");
				var panel = panel_init("cour-panel", info["sum"]());
				//初始化添加，删除，详情，展示所有选择
				/**
				 * table中每一列的结构
				 * <tr><td><checkbox class="sel-checkbox"/></td>
				 * <th>操作</th>
				 * <th>课程号</th>
				 * <th>姓名</th>
				 * <th><a>打开model的a标签</a></th>
				 * </tr>
				 */
				 function str(jsonObj, opt) {
					var jsonStr = JSON.stringify(jsonObj);
					return "<tr data=\"" + jsonStr + "\">" + 
						"<td><checkbox class=\"sel-checkbox\"/></td>" + 
						"<td>" + opt + "</td>" + 
						"<td>" + jsonObj["ori"]["c_id"] + "</td><td>" + jsonObj["ori"]["c_name"] + "</td>" + 
						"<td><button type=\"button\" onclick=\"cour-info(\"" + opt + "\")\" data-toggle=\"modal\" data-target=\"#" + opt + "-model\">详情</button></td></tr>";	
				}	
				var allInfo = stor.get("course");
				var table = panel.getElementsByClassName("table")[0];
				for (var key in allInfo) {
					for (var i = 0; i < allInfo[key].length; i++) {
						table.innerHTML = table.innerHTML + 
						str(allInfo[key][i], key);
					}
				}
				
				//初始化按钮
				panel.getElementsByClassName("del-btn")[0].onclick = function() {
					if (!confirm("你确定删除选中修改项吗"))
						return;
					var checkboxs = panel.getElementsByClassName("sel-checkbox");
					for (var i = 0; i < checkboxs.length; i++) {
						if (!checkboxs[i].checked)
							continue;
						var jsonStr = checkboxs[i].parentElement.parentElement.getAttribute("data");
						var jsonObj = JSON.parse(jsonStr);
						stor.delItem("course", jsonObj["ori"]);
					}
				}
				panel.getElementsByClassName("add-btn")[0].onclick = function() {
					//初始化模态框在这里
					var dict = {
						"名称": "",
						"课程号":"",
						"院系": "",
						"学分": "",
						"占比": ""
					};
					dict = {
							"ori":dict,
							"after":null
					};
					stud_info("add", dict);
				}
			}
			function selC_init() {
				var info = getInfo("selectCourse");
				var panel = panel_init("selC-panel", info["sum"]());
				//初始化添加，删除，详情，展示所有选择
				/**
				 * table中每一列的结构
				 * <tr><td><checkbox class="sel-checkbox"/></td>
				 * <th>操作</th>
				 * <th>学号</th>
				 * <th>姓名</th>
				 * <th>课程号</th>
				 * <th>课程名</th>
				 * <th><a>打开model的a标签</a></th>
				 * </tr>
				 */
				 function str(jsonObj, opt) {
					var jsonStr = JSON.stringify(jsonObj);
					return "<tr data=\"" + jsonStr + "\">" + 
						"<td><checkbox class=\"sel-checkbox\"/></td>" + 
						"<td>" + opt + "</td>" + 
						"<td>" + jsonObj["ori"]["s_id"] + "</td><td>" + jsonObj["ori"]["s_name"] + "</td>" + 
						"<td>" + jsonObj["ori"]["c_id"] + "</td><td>" + jsonObj["ori"]["c_name"] + "</td>" + 
						"<td><button type=\"button\" onclick=\"teac-info(\"" + opt + "\")\" data-toggle=\"modal\" data-target=\"#" + opt + "-model\">详情</button></td></tr>";	
				}	
				var allInfo = stor.get("teacher");
				var table = panel.getElementsByClassName("table")[0];
				for (var key in allInfo) {
					for (var i = 0; i < allInfo[key].length; i++) {
						table.innerHTML = table.innerHTML + 
						str(allInfo[key][i], key);
					}
				}
				//初始化按钮
				panel.getElementsByClassName("del-btn")[0].onclick = function() {
					if (!confirm("你确定删除选中修改项吗"))
						return;
					var checkboxs = panel.getElementsByClassName("sel-checkbox");
					for (var i = 0; i < checkboxs.length; i++) {
						if (!checkboxs[i].checked)
							continue;
						var jsonStr = checkboxs[i].parentElement.parentElement.getAttribute("data");
						var jsonObj = JSON.parse(jsonStr);
						stor.delItem("selectCourse", jsonObj["ori"]);
					}
				}
				panel.getElementsByClassName("add-btn")[0].onclick = function() {
					//初始化模态框在这里
					var dict = {
						// TODO
					}
					dict = {
							"ori":dict,
							"after":null
					};
					stud_info("add", dict);
				}
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