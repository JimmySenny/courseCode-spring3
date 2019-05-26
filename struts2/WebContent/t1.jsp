<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
    
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<%System.out.println("jsp in"); %>
<body>
<s:form action="/hello.action" namespace="/struts2" method="post">
    UM.UserId:<s:textfield name="date" label="%{getText('aa')}"/>
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
                              <s:iterator value="@struts.TestEnum@values()" var="role">
                              <option value='<s:property value="#role"/>'><s:property value="#role.desc"/></option>
                              </s:iterator>
                          </select>
    <s:checkbox name="test" value="'eds'" fieldValue="sssddss" label="aa"></s:checkbox>
    <s:checkbox name="test" value="'sdsad'" fieldValue="sssswss" label="aa"></s:checkbox>
    <s:textfield name="um.uuid" value="'um.uuid'"/>
    <input type="submit" value="提交"/>
</s:form>
</body>
</html>