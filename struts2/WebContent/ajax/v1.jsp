<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%><%
request.setCharacterEncoding("gb2312");
response.setContentType("text/plain;charset=gb2312");
response.setCharacterEncoding("gb2312");
//1.�ռ���������֯������
String username = request.getParameter("username");
//2.����ҵ���߼�
if(username == null || "zhang".equals(username)) {
    out.print("�Ѿ�����");
}
else {
    out.print("ok");
}
%>