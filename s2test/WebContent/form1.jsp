<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<%System.out.println("===============in jsp"); %>
<body>
    <form action="/s2test/hello/hello.action" method="post">
        uuid:<input type="text" name="uuid"/><br/>
        name:<input type="text" name="name"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>