<%@ page language="java" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%

    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("static", request.getContextPath() + "/static");
    request.setAttribute("main", request.getContextPath() + "/static/main");
%>
<!DOCTYPE html>
<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>麦盟管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- 基础样式 -->
    <link href="${asiaui}/css/bootstrap/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${asiaui}/css/bootstrap/font-awesome.min.css" />
    <!-- IE7兼容模式 -->
    <!--[if IE 7]-->
    <link rel="stylesheet" href="${main}/css/font-awesome-ie7.min.css" />
    <!--[end if]-->
    <!-- Ace样式 -->
    <link rel="stylesheet" href="${asiaui}/css/bootstrap/ace.min.css" />
    <link rel="stylesheet" href="${asiaui}/css/bootstrap/ace-rtl.min.css" />
    <link rel="stylesheet" href="${main}/css/ace/ace-skins.min.css" />
    <!-- IE8兼容模式 -->
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${main}/css/ace/ace-ie.min.css" />
    <![endif]-->
    <!-- Ai私有样式 -->
    <link rel="stylesheet" href="${main}/css/ai-main.css" />
    <!-- Ace设置 -->
    <script src="${main}/js/ace-extra.min.js"></script>

    <!--[if lt IE 9]>
    <script src="${main}/js/html5shiv.js"></script>
    <script src="${main}/js/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        .title_inline {
            display: inline;
        }

        .chartstyle {
            display: inline;
        }

        .titleStyle {
            border: 1px solid #ccc;
            padding: 20px;
            margin: 20px 15px;
            background-color: #f2f2f2;
        }

        .titleStyle .col-lg-3 {
            border-right: 1px solid #ccc;
        }

        .titleStyle .col-lg-3.last {
            border-right: none;
        }

        .titleStyle .titleName {
            font-size: 14px;
            color: #666;
        }

        .titleStyle .titleValue {
            font-size: 36px;
            color: #333;
        }

        .highcharts-container {
            border: 1px solid #ccc;
            background-color: #f2f2f2;
        }

        .highcharts-background {
            background-color: #f2f2f2;
        }
    </style>

</head>

<body>
<!-- 顶部导航样式 -->
<div class="navbar navbar-default" id="navbar" style="background: url(${main}/img/top-bg-right.jpg) right top no-repeat #168ec6; ">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container" style="padding: 0;margin: 0">
        <div class="navbar-header pull-left" style="padding: 0;margin: 0">
            <a href="#" class="navbar-brand" style="padding: 0;margin: 0"><img src="${main}/img/top-bg-left.jpg" /> </a>
        </div>
        <div class="navbar-header pull-right">
            <a style="font-size: 14px; padding-top: 20px;" class="navbar-brand" href="javascript:" onclick="flushall()" title="刷新缓存"> <i class="<%--icon-off--%>"></i>刷新缓存</a>
            <a style="font-size: 14px; padding-top: 20px;" class="navbar-brand" href="/mall-mgr/user/initUserInfo.do" title="修改密码" target="navTab" rel="versionDetail" external="true"> <i
                    class="icon-edit"></i></a>
            <a style="font-size: 14px; padding-top: 20px;" class="navbar-brand" href="${ctx}/logout" title="退出登录"> <i class="icon-off"></i> </a>
        </div>
    </div>
</div>
<!-- 顶部导航样式结束 -->
<!-- 页面主体 -->
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }


        var flushall = function() {
            $.post('${ctx}/mgr/index/flushall', {}, function(respJson) {
                alert('成功刷新缓存');
            });
        };
    </script>
    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#"> <span class="menu-text"></span> </a>
        <!-- 左侧菜单 -->
        <div class="sidebar" id="sidebar" style="position:absolute;overflow:auto;height: 101%;">
            <script type="text/javascript">
                try {
                    ace.settings.check('sidebar', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="nav nav-list">

                <c:forEach items="${menus}" var="m">
                <li>
                    <c:if test="${not empty m.url}">
                    <a class="dropdown-toggle" href="${ctx}${m.url}" target="navTab" rel="${m.name}" external="true">
                        <span class="menu-text">${m.name}</span>
                    </a>
                    </c:if>
                    <c:if test="${empty  m.url}">
                    <a class="dropdown-toggle" href="#">
                        <span class="menu-text">${m.name}</span> <b class="arrow icon-angle-down"></b>
                    </a>
                    </c:if>
                    <c:if test="${0 < fn:length(m.sysResources)}">
                    <ul class="submenu">
                        <c:forEach var="mm" items="${m.sysResources}">
                            <li>
                                <a href="${ctx}${mm.url}" target="navTab" rel="${mm.name}" external="true">
                                    <span class="menu-text">${mm.name}</span>
                                </a>
                            </li>
                        </c:forEach>

                    </ul>
                    </c:if>
                    </c:forEach>

            </ul>

            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
            </div>
            <script type="text/javascript">
                try {
                    ace.settings.check('sidebar', 'collapsed')
                } catch (e) {
                }
            </script>
        </div>
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体内容 -->
        <div id="main-content" class="main-content">
            <!--<iframe id="frame-content" name="frame-content" src="index.html" width="100%" height="100%" frameborder="0" ></iframe>-->
            <div id="navTab" class="tabsPage">
                <div class="tabsPageHeader">
                    <div class="tabsPageHeaderContent">
                        <!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
                        <ul class="navTab-tab">
                            <li tabid="main" class="main"><a href="javascript:"><span><span class="home_icon">我的主页</span> </span>
                            </a>
                            </li>
                        </ul>
                    </div>
                    <div class="tabsLeft">left</div>
                    <!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
                    <div class="tabsRight">right</div>
                    <!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
                    <div class="tabsMore">more</div>
                </div>
                <ul class="tabsMoreList">
                    <li><a href="javascript:">我的主页</a>
                    </li>
                </ul>
                <div class="navTab-panel tabsPageContent layoutBox">
                    <div class="page unitBox" style="position:absolute;overflow:auto">
                        <%-- <div class="page unitBox"><img src="<%=path %>/view/main/img/body-bg.jpg"/></div> --%>
                        <div class="text-center titleStyle clearfix">

                        </div>
                        <div class="text-center">
                            <div class="chartValue col-lg-6" id="salesNum" style="height:300px;"></div>
                            <div class="chartValue col-lg-6" id="salesMoney" style="height:300px;"></div>
                        </div>
                        <div class="pagination" style="float:right;"></div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<a id="a_transit" target="navTab" rel="订单详情" title="订单详情" external="true" style="display: none">订单详情</a>
<a id="a_transit2" target="navTab" rel="" title="" external="true" style="display: none"></a>
<!-- 基础Javascript -->

<!--[if !IE]>-->
<script type="text/javascript">
    window.jQuery || document.write("<script src='${main}/js/jquery-2.0.3.min.js'>" + "<" + "script>");
</script>
<!-- <![endif]-->
<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${main}/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->
<script type="text/javascript">
    if ("ontouchend" in document)
        document.write("<script src='${main}/js/jquery.mobile.custom.min.js'>" + "<" + "script>");
</script>
<script src="${asiaui}/js/jquery/bootstrap.min.js"></script>
<!-- 页面私有脚本 -->
<!--[if lte IE 8]>
<script src="${main}/js/excanvas.min.js"></script>
<![endif]-->
<!-- Ace脚本 -->
<script src="${main}/js/ace-elements.min.js"></script>
<script src="${main}/js/ace.min.js"></script>
<script src="${main}/js/ai.core.js"></script>

</body>

</html>