<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>你好</h1>
<p></p>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		alert("ss");
		$.post("${pageContext.request.contextPath}/demoController/test2",function(result){
			$("p").html(result.obj.name);
		})
	});
</script>
</body>
</html>