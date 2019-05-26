<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

    var myRequest;
    function selectCity() {
    	//1收集参数
    	//2组织参数  //url要加web应用上下文
    	var url = "/s2test/hello/json.action";  //可变-------------------
    	//3.调用业务逻辑并返回数据
    	//初始化XMLHTPP对象
    	myRequest = new ActiveXObject("Msxml2.XMLHTTP"); //可变----------------------
    	//3.1定义状态改变后的事件处理函数
    	myRequest.onreadystatechange=selectCityCallback;//可变-----------------------
    	//3.2 打开连接  用GET方式打开
    	myRequest.open("GET", url);
        //3.2.1如果POST方式必须设置ContentType否则后台接收不到，为什么要POST呢？
    	//3.3最后发生数据
    	myRequest.send(null);
    }
    
    function selectCityCallback() {
    	//3.4只有状态为4（完成）时才进行处理
    	if(myRequest.readyState == 4) {
    		//获取响应数据
    		var ret = myRequest.responseText;
    	    //4.展示数据（本页面中的某个地方进行展示）  
    	    //首先清理city下拉列表框的值
    	    //准备数据
    	    var obj = eval("("+ret+")");
    	    alert(obj.array);
    	    
    	}
    }
</script>
</head>
<body>
   <button value="测试" onclick="selectCity();"></button>

    <select id="city" name="city">
    </select>
</body>
</html>