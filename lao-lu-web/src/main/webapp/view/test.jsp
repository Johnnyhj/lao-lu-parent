<%@ page import="com.ai.ge.platform.model.user.PlatformUser" %>
<%@ page import="com.ai.ge.platform.cache.PlatFormUserCache" %>
<%@ page import="com.ai.ge.util.SessionUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    PlatFormUserCache cache = (PlatFormUserCache)SessionUtil.getAttribute(request.getSession(true),"user");
%>
<html>
<head lang=""></head>
<meta charset="UTF-8">
<title>登录成功首页</title>
</head>
<body>
ID:<%=cache.getId()%><BR>
REAL_NAME:<%=cache.getRealName()%><BR>
ALIPAY_ID:<%=cache.getAlipayUserId()%><BR>
USER_ID:<%=cache.getUserId()%><BR>
</body>
</html>