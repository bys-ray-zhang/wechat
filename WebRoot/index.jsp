<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>

<form action="/wechat/test.do" method="post">

	<input name="name001" value="111111111111111">
	<button type="submit">submit</button>

</form>