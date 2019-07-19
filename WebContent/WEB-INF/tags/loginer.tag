<%@ tag language="java" pageEncoding="UTF-8"%>
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