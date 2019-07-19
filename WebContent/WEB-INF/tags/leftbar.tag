<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!-- 设置成false，使登录无cookie时不会出现问题 -->
<%@attribute name="permission" type="int" required="false" description="标识用户等级" %>

<div class="row">
	<div id="leftbar" class="col-md-12">
		<c:if test="${permission == 0 }">
			<tags:adminInterface>
		</c:if>
		<c:if test="${permission == 1 }">
			<tags:teacInterface>
		</c:if>
		<c:if test="${permission == 2 }">
			<tags:studInterface>
		</c:if>
	</div>
</div>