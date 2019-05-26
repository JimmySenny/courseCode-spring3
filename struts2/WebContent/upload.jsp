<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
    
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<script type="text/javascript">
    function checkIt() {
    	var myFileValue = document.getElementById("myFile").value;
    	var extendsValue = myFileValue.substr(myFileValue.lastIndexOf('.') + 1); 
    	if(extendsValue.toLowerCase() != 'txt') {
    		alert("不允许的类型");
    		return false;
    	}
    	return true;
    }
</script>
</head>
<%System.out.println("jsp in"); %>
<body>
<s:form action="up.action" namespace="/struts2" method="post" enctype="multipart/form-data" onsubmit="return checkIt()">
    <s:hidden name="submitFlag" value="up"/>
    <s:file id="myFile" name="myFile" label="file" disabled="false"> </s:file>
    <s:file id="myFile2" name="myFile" label="file" disabled="false"> </s:file>
    <s:file id="myFile3" name="myFile" label="file" disabled="false"> </s:file>
    <button type="button" name="aaa" value="do" onclick="alert(document.getElementById('myFile').value)">do</button>
    <s:submit value="提交"></s:submit>
</s:form>
</body>
</html>