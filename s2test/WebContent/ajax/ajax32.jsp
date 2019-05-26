<%@page import="java.util.*"%><%
class City {
    public String key;
    public String value;
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
}
%>

