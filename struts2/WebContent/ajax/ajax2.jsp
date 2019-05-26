<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<script type="text/javascript">
	var myRequest; 
    function doGetJSON() {
        //IE浏览器之一
        //1.新建XMLHttpRequest
        myRequest = new ActiveXObject("Msxml2.XMLHTTP");
        //2.收集数据
        //3.组织数据
        //4.定义回调函数(只有这步与传统不一样)
        myRequest.onreadystatechange=getJSONCallback;
        //5.调用业务逻辑（调用验证接口）
        myRequest.open("GET","/struts2/struts2/json.action",true);
        myRequest.send(null);
    }
    
    
    function getJSONCallback() {
    	if(myRequest.readyState != 4) {
    	}
    	if(myRequest.readyState == 4 && myRequest.status==200) {
    	    //6.返回要显示的数据，并显示
    		var retVal = eval("(" +myRequest.responseText + ")");
    	    //7.展示数据
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
        myRequest.open("GET","/struts2/struts2/city.action?province="+province,true);

        myRequest.send(null);
    }
    
    function selectCityCallback() {
        if(myRequest.readyState == 4 && myRequest.status==200) {
            //6.返回要显示的数据，并显示
            var retVal = myRequest.responseText;
            var citys = eval("("+retVal+")");
            var citySelectComp = document.getElementById("city");
            for(i=citySelectComp.options.length -1 ; i>=0;i--) {
            	citySelectComp.options.remove(i);
            }
            for(var index in citys) {
            	var cityOptionComp = document.createElement("option");
            	citySelectComp.options.add(cityOptionComp);
            	cityOptionComp.value = citys[index][0];
            	cityOptionComp.innerText = citys[index][1];
            }
        }
    }
    
</script>
</head>
<body>
    <form action="/struts2/ajax/v1.jsp">
        <select id="province" name="province" onchange="selectCity();">
            <option value="" selected="selected">请选择</option>
            <option value="beijing">北京</option>
            <option value="shandong">山东</option>
        </select>

        <select id="city" name="city">
            <option value="" selected="selected">请选择</option>
        </select>
    </form>
        <button onclick="doGetJSON();return false;">试试JSON</button><br/>
</body>
</html>