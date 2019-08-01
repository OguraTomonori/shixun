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
	<div class="container" style="padding-top:50px">
		<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<table class="table">
				<tr>
					<th>姓名</th>
					<!--  -->
					<td class="item"></td>
				</tr>
				<tr>
					<th>学号</th>
					<!--  -->
					<td class="item"></td>
				</tr>
				<tr>
					<th>成绩</th>
					<!--  -->
					<td class="item"></td>
				</tr>
				<tr>
					<th>平时分占比</th>
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
		</div>
		<div class="row">
			<div class="col-md-9"></div>
			<div class="col-md-1">
				<div class="btn-group" role="group" aria-label="...">
				  <button type="button" class="btn btn-default exit-btn">关闭</button>
				</div>
			</div>
			<div class="col-md-1">
				<div class="btn-group" role="group" aria-label="...">
				  <button type="button" class="btn btn-primary save-btn">保存</button>
				</div>
			</div>
		</div>
	</div>

 	<script>
 		if (window.opener) {
 			//init
 			var data = window.opener.data;
 			console.log(data);
 			/*
 				data:[s_name, s_id, grade, reg, test, percentage, c_name, courseID]
 			
 			*/
 			var items = document.getElementsByClassName("item");
 			var percentage = parseFloat(data[5]) / 100;
 			for (let i = 0; i < 3; i++) {
 				items[i].innerHTML = data[i];
 			}
 			items[3].innerHTML = "" + percentage;
 			for (let i = 4; i < 6; i++) {
 				items[i].value = data[i - 1];
 			}
			for (let i = 4; i < 6; i++) {
 				//对input添加检测
 				items[i].onchange = function() {
 					var reg = parseInt(items[4].value);
 					var test = parseInt(items[5].value);
 					items[2].innerHTML = "" + parseInt(reg * percentage + test * (1-percentage));
				}
 			}
			
			//按钮
			document.getElementsByClassName("exit-btn")[0].onclick = function() {
				window.close();
			}
			document.getElementsByClassName("save-btn")[0].onclick = function() {
				
				var ori = {
					"c_id":data[7],
					"c_name":data[6],
					"s_id":data[1],
					"s_name":data[0],
					"reg":data[3],
					"test":data[4]
				}
				
				var reg = items[4].value;
				var test = items[5].value;
				
				var after = {
					"c_id":data[7],
					"c_name":data[6],
					"s_id":data[1],
					"s_name":data[0],
					"reg": reg,
					"test": test
				}
				stor.put("grade", "update", ori, after);
				window.close();
			}
 		}
 		
 	</script>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>