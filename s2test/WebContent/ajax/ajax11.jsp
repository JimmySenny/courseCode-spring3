<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

    var myRequest;
    function validateUsername() {
    	//1收集参数
    	var username = document.getElementById("username").value; //可变----------------
    	//2组织参数  //url要加web应用上下文
    	var url = "/s2test/ajax/ajax12.jsp?username="+username;  //可变-------------------
    	//3.调用业务逻辑并返回数据
    	//初始化XMLHTPP对象
    	myRequest = new ActiveXObject("Msxml2.XMLHTTP"); //可变----------------------
    	//3.1定义状态改变后的事件处理函数
    	myRequest.onreadystatechange=validateUsernameCallback;//可变-----------------------
    	//3.2 打开连接  用GET方式打开
    	myRequest.open("GET", url);
    	//3.3最后发生数据
    	myRequest.send(null);
    }
    
    function validateUsernameCallback() {
    	//3.4只有状态为4（完成）时才进行处理
    	if(myRequest.readyState == 4) {
    		//获取响应数据
    		var ret = myRequest.responseText;
    	    //4.展示数据（本页面中的某个地方进行展示）  
    		document.getElementById("msg").innerHTML = ret;//可变-------------------
    	}
    }
</script>
</head>
<body>
    <form action="" method="post">
    <div id="msg"></div><br/>
    用户注册：<br/>
    用户名:<input type="text" name="username" id="username" onblur="validateUsername();"/>
   密码:<input type="text" name="password"/>
    <input type="submit" value="注册"/>
    </form>
</body>
</html>