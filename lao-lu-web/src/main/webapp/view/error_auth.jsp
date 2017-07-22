<%--
  Created by IntelliJ IDEA.
  User: Zhaocy3
  Date: 2016/3/10
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
%>
<html>
<head lang=""></head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%=path%>/app/page/html/error/css/error.css" />
<link rel="stylesheet" type="text/css" media="only screen and (min-width:650px)" href="<%=path%>/app/page/html/error/css/error_com.css"/>

<title>鉴权失败</title>
</head>
<body>
<div class="error_info">
<div class="error_kind">鉴权失败</div>
<div class="error_code">错误码：${error_msg.resultCode}</div>
<div class="error_desc">错误原因：${error_msg.resultMsg}</div>
</div>
</body>
</html>





