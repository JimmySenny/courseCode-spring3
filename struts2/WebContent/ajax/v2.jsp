<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%><%
request.setCharacterEncoding("gb2312");
response.setContentType("text/plain;charset=gb2312");
response.setCharacterEncoding("gb2312");
//1.�ռ���������֯������
String province = request.getParameter("province");
//2.����ҵ���߼�
if(province == null || "".equals(province)) {
    out.print("null");
}
else {
    if("beijing".equals(province)) {
        out.print("haidian:������,chaoyang:������");
    }
    if("shandong".equals(province)) {
        out.print("rizhao:������,jinan:������");
    }
}
%>