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
<!-- 学生Model -->
<s:set var="smList" value="new java.util.HashSet(#gmList.{sm})"></s:set>
<!-- 课程Model -->
<s:set var="cmList" value="new java.util.HashSet(#gmList.{cm})"></s:set>


<table border="1">
    <tr>
    <td>表头</td>
    <s:iterator value="#cmList">
        <td><s:property value="cname"/></td>
    </s:iterator>
    </tr>
	<s:iterator value="#smList" var="sm">
	<tr>
	    <td><s:property value="#sm.sname"/></td>
	    <s:iterator value="#cmList" var="cm">
         <s:iterator value="#gmList" var="gm">
            <s:if test="%{#sm.sname==#gm.sm.sname and #cm.cname==#gm.cm.cname}">
                <td><s:property value="#gm.score"/></td>
            </s:if>
            
         </s:iterator>    
        </s:iterator>
    </tr>
	</s:iterator>
</table>
<br/>
<br/>
<br/>
<br/>

<table border="1">
    <tr>
    <td>表头</td>
    <s:iterator value="#smList">
        <td><s:property value="sname"/></td>
    </s:iterator>
    </tr>
    <s:iterator value="#cmList" var="cm">
    <tr>
        <td><s:property value="#cm.cname"/></td>
        <s:iterator value="#smList" var="sm">
         <s:iterator value="#gmList" var="gm">
            <s:if test="%{#sm.sname==#gm.sm.sname and #cm.cname==#gm.cm.cname}">
                <td><s:property value="#gm.score"/></td>
            </s:if>
            
         </s:iterator>    
        </s:iterator>
    </tr>
    </s:iterator>
</table>


<br/>
<br/>
<br/>
<br/>
<br/>
<table border="1">
    <tr>
    <td>表头</td>
    <s:iterator value="#cmList">
        <td><s:property value="cname"/></td>
    </s:iterator>
    </tr>
    <s:iterator value="#smList" var="sm">
    <s:set var="count" value="0"></s:set>
    <tr>
        <td rowspan="2"><s:property value="#sm.sname"/></td>
        <s:iterator value="#cmList" var="cm">
         <s:iterator value="#gmList" var="gm">
            <s:if test="%{#sm.sname==#gm.sm.sname and #cm.cname==#gm.cm.cname}">
                <s:set var="count" value="#count + #gm.score"></s:set>
                <td><s:property value="#gm.score"/></td>
            </s:if>
         </s:iterator>
        </s:iterator>
    </tr>
    <tr>
       <td colspan="2" align="right">合计：<s:property value="#count"/></td>
    </tr>
    </s:iterator>
</table>























</body>
</html>