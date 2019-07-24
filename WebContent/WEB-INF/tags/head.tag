<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="css" type="java.lang.String" required="true" description="要包含的css文件，使用,分割"  %>
<%@attribute name="js" type="java.lang.String" required="false" description="首部要包含的js文件，使用,分割" %>
<%
	String[] csses = css.split(",");
	String[] jses = js.split(",");
%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <meta name="description" content="">
    <meta name="author" content="">
    <title>学生信息管理系统</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    
    
    <!-- Custom styles -->
    <%
    	for (String css : csses) {
    		out.println("<link href=\"" + css + "\" rel=\"stylesheet\">");
    	}
    %>
    <%
    	for (String js : jses) {
    		out.println("<script src=\"" + js + "\" ></script>");
    	}
    %>
</head>