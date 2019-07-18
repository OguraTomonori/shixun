<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <meta name="description" content="">
    <meta name="author" content="">
    <title>学生信息管理系统</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom styles -->
    <link href="css/index.css" rel="stylesheet">
    <link href="css/navbar.css" rel="stylesheet">
  </head>
  <body>
    <script src="${pageContext.request.contextPath }/js/cookie.js"></script>
    <script src="${pageContext.request.contextPath }/js/login.js"></script>
    <div id="loginer">
    	<div class="container">
    		<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<div id="login">
						<img src="${pageContext.request.contextPath }/content/xiaohui.jpg"/>
						<div class="input-group input-group-lg">
  							<input type="text" id="username" class="form-control login_input" placeholder="用户名" aria-describedby="basic-addon1">
							<input type="password" id="passwd" class="form-control login_input" placeholder="密码" aria-describedby="sizing-addon1">
						</div>
						<div class="btn-group btn-group-lg" role="group" id="login_div">
							<button class="btn btn-default" id="login_btn">继续</button>
						</div>
					</div>
				</div>
			</div>
    	</div>
    </div>
    <nav class="navbar navbar-default navbar-fixed-top" id="titlebar">
	      <div class="container">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="#">Project name</a>
	        </div>
	        <div id="navbar" class="navbar-collapse collapse">
	          <ul class="nav navbar-nav">
	            <li class="active"><a href="#">Home</a></li>
	            <li><a href="#about">About</a></li>
	            <li><a href="#contact">Contact</a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	                <li><a href="#">Action</a></li>
	                <li><a href="#">Another action</a></li>
	                <li><a href="#">Something else here</a></li>
	                <li role="separator" class="divider"></li>
	                <li class="dropdown-header">Nav header</li>
	                <li><a href="#">Separated link</a></li>
	                <li><a href="#">One more separated link</a></li>
	              </ul>
	            </li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right">
	            <li><a href="../navbar/">Default</a></li>
	            <li><a href="../navbar-static-top/">Static top</a></li>
	            <li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>
    <div id="main_page">
		<script type="text/javascript">
	    if (isLogined()) { 
	    	//如果登录，则取消模糊，不再display登录界面
	    	document.getElementById("loginer").style["display"] = "none";
	    	document.getElementById("main_page").style["filter"] = "blur(0px)";
	    	document.getElementById("titlebar").style["filter"] = "blur(0px)";
	    }
    	</script>
	    <div class="container main">
	
	      <!-- Main component for a primary marketing message or call to action -->
	      <div class="jumbotron">
	        <h1>Navbar example</h1>
	        <p>This example is a quick exercise to illustrate how the default, static and fixed to top navbar work. It includes the responsive CSS and HTML, so it also adapts to your viewport and device.</p>
	        <p>To see the difference between static and fixed top navbars, just scroll.</p>
	        <p>
	          <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">View navbar docs &raquo;</a>
	        </p>
	      </div>
	
	    </div> <!-- /container -->
    </div>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/index.js"></script>
  </body>
</html>
