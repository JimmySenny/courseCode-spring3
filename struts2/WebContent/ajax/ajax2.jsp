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
        //IE�����֮һ
        //1.�½�XMLHttpRequest
        myRequest = new ActiveXObject("Msxml2.XMLHTTP");
        //2.�ռ�����
        //3.��֯����
        //4.����ص�����(ֻ���ⲽ�봫ͳ��һ��)
        myRequest.onreadystatechange=getJSONCallback;
        //5.����ҵ���߼���������֤�ӿڣ�
        myRequest.open("GET","/struts2/struts2/json.action",true);
        myRequest.send(null);
    }
    
    
    function getJSONCallback() {
    	if(myRequest.readyState != 4) {
    	}
    	if(myRequest.readyState == 4 && myRequest.status==200) {
    	    //6.����Ҫ��ʾ�����ݣ�����ʾ
    		var retVal = eval("(" +myRequest.responseText + ")");
    	    //7.չʾ����
    	}
    }
    
    
    function selectCity() {
    	//1.�½�XMLHttpRequest
        myRequest = new ActiveXObject("Msxml2.XMLHTTP");
        //2.�ռ�����
        var provinceComp = document.getElementById("province");
        var province = provinceComp.options(provinceComp.selectedIndex).value;
        if(province == "") {
        	var citySelectComp = document.getElementById("city");
        	for(i=citySelectComp.options.length -1 ; i>=0;i--) {
                citySelectComp.options.remove(i);
            }
            return;
        }
        //3.��֯����
        //4.����ص�����(ֻ���ⲽ�봫ͳ��һ��)
        myRequest.onreadystatechange=selectCityCallback;
        //5.����ҵ���߼���������֤�ӿڣ�
        myRequest.open("GET","/struts2/struts2/city.action?province="+province,true);

        myRequest.send(null);
    }
    
    function selectCityCallback() {
        if(myRequest.readyState == 4 && myRequest.status==200) {
            //6.����Ҫ��ʾ�����ݣ�����ʾ
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
            <option value="" selected="selected">��ѡ��</option>
            <option value="beijing">����</option>
            <option value="shandong">ɽ��</option>
        </select>

        <select id="city" name="city">
            <option value="" selected="selected">��ѡ��</option>
        </select>
    </form>
        <button onclick="doGetJSON();return false;">����JSON</button><br/>
</body>
</html>