<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%><%
request.setCharacterEncoding("gb2312");
response.setContentType("text/plain;charset=gb2312");
response.setCharacterEncoding("gb2312");
//1.收集参数（组织参数）
String username = request.getParameter("username");
//2.调用业务逻辑
if(username == null || "zhang".equals(username)) {
    out.print("已经存在");
}
else {
    out.print("ok");
}
%>