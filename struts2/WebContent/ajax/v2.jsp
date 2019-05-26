<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%><%
request.setCharacterEncoding("gb2312");
response.setContentType("text/plain;charset=gb2312");
response.setCharacterEncoding("gb2312");
//1.收集参数（组织参数）
String province = request.getParameter("province");
//2.调用业务逻辑
if(province == null || "".equals(province)) {
    out.print("null");
}
else {
    if("beijing".equals(province)) {
        out.print("haidian:海淀区,chaoyang:朝阳区");
    }
    if("shandong".equals(province)) {
        out.print("rizhao:日照市,jinan:济南市");
    }
}
%>