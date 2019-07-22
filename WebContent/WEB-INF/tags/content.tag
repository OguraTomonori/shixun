<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!-- 设置成false，使登录无cookie时不会出现问题 -->
<%@attribute name="permission" type="Integer" required="false" description="标识用户等级" %>

<div class="row">
	<div id="leftbar" class="col-md-12">
		<c:if test="${permission == null }">
			
			<h1>leftbar</h1>
			
			<c:if test="${permission == 0 }">
			
				<h1>adm</h1><!-- 管理员 -->
				
				<c:if test="${permission == 1 }">
				
					<h1>teac</h1><!-- 教师 -->
					
					<c:if test="${permission == 2 }">
					
						<h1>stud</h1> <!-- 学生 -->
						
					</c:if>
				</c:if>
			</c:if>
		</c:if>
		
		
	</div>
</div>