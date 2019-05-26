<%
String username = request.getParameter("username");
Thread.sleep(20000);
if("aaa".equals(username)){
    out.println("ok");
}
else {
    out.println("fail");
}
%>