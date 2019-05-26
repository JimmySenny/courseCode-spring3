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
        //IE�����֮һ
        //1.�½�XMLHttpRequest
        myRequest = new ActiveXObject("Msxml2.XMLHTTP");
        //2.�ռ�����
        var username = document.getElementById("username").value;
        //3.��֯����
        //4.����ص�����(ֻ���ⲽ�봫ͳ��һ��)
        myRequest.onreadystatechange=checkUserNameCallback;
        //5.����ҵ���߼���������֤�ӿڣ�
        myRequest.open("GET","/struts2/ajax/v1.jsp?username="+username,true);

        myRequest.send(null);
    }
    
    
    function checkUserNameCallback() {
    	if(myRequest.readyState != 4) {
    		document.getElementById("checkUsernameResult").innerHTML="��֤��";
    	}
    	if(myRequest.readyState == 4 && myRequest.status==200) {
    	    //6.����Ҫ��ʾ�����ݣ�����ʾ
    		var retVal = myRequest.responseText;
    	    //7.չʾ����
    		document.getElementById("checkUsernameResult").innerHTML=retVal;
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
        myRequest.open("GET","/struts2/ajax/v2.jsp?province="+province,true);

        myRequest.send(null);
    }
    
    function selectCityCallback() {
        if(myRequest.readyState == 4 && myRequest.status==200) {
            //6.����Ҫ��ʾ�����ݣ�����ʾ
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
            <option value="" selected="selected">��ѡ��</option>
            <option value="beijing">����</option>
            <option value="shandong">ɽ��</option>
        </select>

        <select id="city" name="city">
            <option value="" selected="selected">��ѡ��</option>
        </select>
    </form>
</body>
</html>