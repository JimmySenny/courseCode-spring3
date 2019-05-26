<%@page import="java.util.*"%><%
class City {
    public String key;
    public String value;
    
    
    /*
    
    [{"key":"sjz", "value":"shijianzhuang"},{"key":"lf", "value":"langfang"}]
    */
    /*
    
object 
	{}
	{ members } 
members 
	pair
	pair , members 
pair 
    string : value 
array 
    []
    [ elements ] 
elements 
    value 
    value , elements 
value 
    string
    number
    object
    array
    true
    false
    null 

    */
}

String province = request.getParameter("province");
if("hb".equals(province)){
    City city1 = new City();
    city1.key="sjz";
    city1.value="shijiazhuang";

    City city2 = new City();
    city2.key="lf";
    city2.value="langfang";
    
    List list = new ArrayList();
    list.add(city1);
    list.add(city2);
    out.print("[{\"key\":\"sjz\", \"value\":\"shijianzhuang\"},{\"key\":\"lf\", \"value\":\"langfang\"}]");
}
if("sd".equals(province)){
    City city1 = new City();
    city1.key="jn";
    city1.value="jinan";

    City city2 = new City();
    city2.key="qd";
    city2.value="qingdao";
    List list = new ArrayList();
    list.add(city1);
    list.add(city2);
    out.print("[{\"key\":\"jn\", \"value\":\"jinan\"},{\"key\":\"qd\", \"value\":\"qingdao\"}]");
}
%>

