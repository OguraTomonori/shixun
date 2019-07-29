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
		  		<div class="panel panel-warning">
			  		<div class="panel-heading">
			  			<div class="row">
			  				<div class="col-md-3">
			  					<span class="panel-title">学生信息修改</span>
			  				</div>
			  				<div class="col-md-3"></div>
			  				<div class="col-md-3"></div>
			  				<div class="col-md-1"><span class="panel-title">
			  				<span  class="panel-title" id="selected-num">5</span>/<span class="panel-title" id="all-num">10</span>
			  				</span></div>
			  				<div class="col-md-1">
							     <button type="button" class="btn btn-primary btn-sm">
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
							<table class="table">
								<tr>
								<th>das</th><td>sd</td>
								</tr>
							</table>
						</div>
					</div>
		  		</div>
		  		<div class="panel panel-info">
			  		<div class="panel-heading">
			  			<div class="row">
			  				<div class="col-md-4">
			  					<span class="panel-title">教师信息修改</span>
			  				</div>
			  				<div class="col-md-4"></div>
			  				<div class="col-md-2"></div>
			  				<div class="col-md-1">
							     <button type="button" class="btn btn-primary btn-sm">
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
							<table class="table">
								<tr>
								<th>das</th><td>sd</td>
								</tr>
							</table>
						</div>
					</div>
		  		</div>
		  		<div class="panel panel-success">
			  		<div class="panel-heading">
			  			<div class="row">
			  				<div class="col-md-4">
			  					<span class="panel-title">课程信息修改</span>
			  				</div>
			  				<div class="col-md-4"></div>
			  				<div class="col-md-2"></div>
			  				<div class="col-md-1">
							     <button type="button" class="btn btn-primary btn-sm">
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
							<table class="table">
								<tr>
								<th>das</th><td>sd</td>
								</tr>
							</table>
						</div>
					</div>
					<script><!-- 折叠按钮 -->
						
					</script>
		  		</div>
 			</div>
 		</div>
 	</div>
 	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>