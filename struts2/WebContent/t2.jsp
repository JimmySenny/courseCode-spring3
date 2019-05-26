<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/struts2/hello.action" method="post">
<!--    <s:token></s:token>-->
    UM.UserId:<input type="text" name="um.uuid"/><br/>
    UM.UserName:<input type="text" name="um.name"/><br/>
    UM2.UserId:<input type="text" name="um2.uuid"/><br/>
    UM2.UserName:<input type="text" name="um2.name"/><br/>
    UserId:<input type="text" name="uuid"/><br/>
    UserName:<input type="text" name="name"/><br/>
    Roles:管理员<input type="checkbox" name="roles" value="admin">
                          普通用户<input type="checkbox" name="roles" value="user"><br/>
<!--    Roles:管理员<input type="checkbox" name="roleList" value="admin">-->
<!--                          普通用户<input type="checkbox" name="roleList" value="user"><br/>-->
                          <select name="roleList" multiple="multiple">
                              <option value="dd">aaa</option>
                              <option value="dd">aaa</option>
                              <option value="dd">aaa</option>
                              <option value="dd">aaa</option>
                              <option value="dd">aaa</option>
                              <option value="dd">aaa</option>
                          </select>
    <input type="submit" value="提交"/>
</form>
</body>
</html>