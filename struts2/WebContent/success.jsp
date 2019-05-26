<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
<%System.out.print("jsp"); %>
UserId:${uuid},UserName:${name}
UserId:${um.uuid},UserName:${name}
<s:property value="date"/>
<s:property value="um['uuid']"/>


----------<s:property value="'&gt;:set&lt;标签使用'" escape="false"/><br/>
<s:set var="testVar" value="#request"/>
<s:property value="#testVar"/>
<s:property value="#testVar.uuid"/>
<c:set var="testVar" value="${requestScope}"/>
<c:out value="${testVar }"/>


<s:push value="#request">
    <s:property value="uuid"/>
</s:push>
<jsp:useBean id="bean1" class="xwork.TestBean">
</jsp:useBean>
    　<jsp:setProperty name="bean1" property="*" /> 
<s:bean var="bean2" name="xwork.TestBean" >
    <s:param name="name" value="#parameters.uuid"/>
</s:bean>
<br/>
<c:out value="${bean1 }"></c:out>
<c:out value="${bean1.name }"></c:out>
<s:property value="#bean2"/>
<s:property value="#bean2.name"/>

<s:set var="list" value="{1,2,3,4,5}"></s:set><br/>
<s:iterator value="#list" var="p" status="status">
    <s:property value="#status.index+1"/>.<s:property value="#p"/><br/>
</s:iterator>
<br/>
<s:debug></s:debug>
<br/>
<table border="1">
    <tr><td>标头</td></tr>
	<s:iterator value="#list" var="p" status="status">
    <tr bgcolor='<s:property value="#status.odd?'red':'blue'"/>'>
	    <td><s:property value="#status.count"/>.<s:property value="#p"/><br/></td>
    </tr>
	</s:iterator>
<br/>    
<s:property value="#request"/>
<s:set var="request" value="'aaaaa'"></s:set>
<br/>    
<s:property value="#request"/>
</table>
</body>
</html>