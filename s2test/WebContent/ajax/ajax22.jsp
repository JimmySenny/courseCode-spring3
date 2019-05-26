<%
String username = request.getParameter("username");
String uuid = request.getParameter("uuid");
System.out.println(uuid);
System.out.println(username);
Thread.sleep(1000);
if("aaa".equals(username)){
    out.println("ok");
}
else {
    out.println("fail");
}
%>