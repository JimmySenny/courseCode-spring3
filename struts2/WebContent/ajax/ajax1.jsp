<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<script type="text/javascript">
	var myRequest; 
    function doCheckUsername() {
        //IE浏览器之一
        //1.新建XMLHttpRequest
        myRequest = new ActiveXObject("Msxml2.XMLHTTP");
        //2.收集数据
        var username = document.getElementById("username").value;
        //3.组织数据
        //4.定义回调函数(只有这步与传统不一样)
        myRequest.onreadystatechange=checkUserNameCallback;
        //5.调用业务逻辑（调用验证接口）
        myRequest.open("GET","/struts2/ajax/v1.jsp?username="+username,true);

        myRequest.send(null);
    }
    
    
    function checkUserNameCallback() {
    	if(myRequest.readyState != 4) {
    		document.getElementById("checkUsernameResult").innerHTML="验证中";
    	}
    	if(myRequest.readyState == 4 && myRequest.status==200) {
    	    //6.返回要显示的数据，并显示
    		var retVal = myRequest.responseText;
    	    //7.展示数据
    		document.getElementById("checkUsernameResult").innerHTML=retVal;
    	}
    }
    
    
    function selectCity() {
    	//1.新建XMLHttpRequest
        myRequest = new ActiveXObject("Msxml2.XMLHTTP");
        //2.收集数据
        var provinceComp = document.getElementById("province");
        var province = provinceComp.options(provinceComp.selectedIndex).value;
        if(province == "") {
        	var citySelectComp = document.getElementById("city");
        	for(i=citySelectComp.options.length -1 ; i>=0;i--) {
                citySelectComp.options.remove(i);
            }
            return;
        }
        //3.组织数据
        //4.定义回调函数(只有这步与传统不一样)
        myRequest.onreadystatechange=selectCityCallback;
        //5.调用业务逻辑（调用验证接口）
        myRequest.open("GET","/struts2/ajax/v2.jsp?province="+province,true);

        myRequest.send(null);
    }
    
    function selectCityCallback() {
        if(myRequest.readyState == 4 && myRequest.status==200) {
            //6.返回要显示的数据，并显示
            var retVal = myRequest.responseText;
            var citys = retVal.split(",");
            var citySelectComp = document.getElementById("city");
            for(i=citySelectComp.options.length -1 ; i>=0;i--) {
            	citySelectComp.options.remove(i);
            }
            for(var index in citys) {
            	var cityOptionComp = document.createElement("option");
            	cityOptionComp.value = citys[index].split(":")[0];
            	cityOptionComp.innerText = citys[index].split(":")[1];
            	citySelectComp.insertBefore(cityOptionComp);
            }
        }
    }
    
</script>
</head>
<body>
    <form action="/struts2/ajax.v1.jsp">
        <input type="text" id="username" onblur="doCheckUsername();"/><div id="checkUsernameResult"></div>
        
        <select id="province" name="province" onchange="selectCity();">
            <option value="" selected="selected">请选择</option>
            <option value="beijing">北京</option>
            <option value="shandong">山东</option>
        </select>

        <select id="city" name="city">
            <option value="" selected="selected">请选择</option>
        </select>
    </form>
</body>
</html>