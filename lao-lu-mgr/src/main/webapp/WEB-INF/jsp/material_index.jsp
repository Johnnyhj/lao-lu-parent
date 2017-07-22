<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <style type="text/css">
        @charset "UTF-8";
        [ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak, .ng-hide:not(.ng-hide-animate) {
            display: none !important;
        }

        ng\:form {
            display: block;
        }

        .ng-animate-shim {
            visibility: hidden;
        }

        .ng-anchor {
            position: absolute;
        }
    </style>

    <style>
        .navi ul.nav li.active > a.auto {
            background-color: rgba(0, 0, 0, 0.05);
        }

        .md-content .hbox .col .bg-light .nav > li > a {
            width: 100px;
            text-align: center;
            overflow: hidden;
            text-overflow: ellipsis;
            -o-text-overflow: ellipsis;
            white-space: nowrap;
        }
  .closed {
    position: absolute;
    right: -4px;
    top: -6px;
    width: 15px;
    height: 15px;
    line-height: 15px;
    text-align: center;
    cursor: pointer;
    display: none;
    z-index: 1000;
  }

  .active .closed {
  	display:block;
  }

  .columnFlexLeft, .columnFlex {
    float:left;
  }

  .wrapper-md {
    overflow-y:auto;
  }

        .md-navbar {
            height: 58px;
        }

        .columnFlexLeft.md-content {
            width: 16%\0;
        }

        .columnFlex {
            width: 84%\0;
        }
    </style>

    <%@include file="/taglib.jsp" %>
</head>
<body layout="row" class="">
<!-- uiView:  -->
<div layout="column" flex="" ui-view="" style="position:fixed;width:100%"><!-- ngInclude: 'tpl/blocks/material.header.html' -->
    <div class="md-navbar navbar blue md-whiteframe-z1 ">
        <div class="navbar-header ">
            <button class="pull-right visible-xs dk" ui-toggle-class="show" data-target=".navbar-collapse">
                <i class="glyphicon glyphicon-cog"></i>
            </button>
            <button class="pull-right visible-xs" ui-toggle-class="off-screen" data-target=".md-aside" ui-scroll-to="app">
                <i class="glyphicon glyphicon-align-justify"></i>
            </button>
            <!-- brand -->
            <a href="#/" class="navbar-brand text-lt">

                <img src="${ctx}/asiaui/src/img/logo.png" alt="." >
                <span class="hidden-folded m-l-xs">征信平台</span>
            </a>
            <!-- / brand -->
        </div>
        <!-- / navbar header -->

        <!-- navbar collapse -->
        <div class="collapse navbar-collapse box-shadow blue ">

            <!-- link and dropdown -->
            <%--<ul class="nav navbar-nav hidden-sm">
                <li class="dropdown pos-stc open" dropdown-style="">
                    <a class="dropdown-toggle" dropdown-toggle="">
                        <span>组件</span>
                    </a>
                </li>
                <li class="dropdown" dropdown="">
                    <a class="dropdown-toggle" dropdown-toggle="" aria-haspopup="true" aria-expanded="false">
                        <span>模块</span>
                    </a>
                </li>
                <li class="dropdown" dropdown="">
                    <a class="dropdown-toggle" dropdown-toggle="" aria-haspopup="true" aria-expanded="false">
                        <span>页面</span>
                    </a>
                </li>
                <li class="dropdown" dropdown="">
                    <a class="dropdown-toggle" dropdown-toggle="" aria-haspopup="true" aria-expanded="false">
                        <span>文档</span>
                    </a>
                </li>
            </ul>--%>
            <%--<form class="navbar-form navbar-form-sm navbar-left shift" ui-shift="prependTo" target=".navbar-collapse" role="search">
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" class="form-control input-sm bg-light no-border rounded padder" placeholder="搜索关键字...">
                        <ul class="dropdown-menu ng-hide">
                        </ul>
              <span class="input-group-btn">
                <button type="submit" class="btn btn-sm bg-light rounded"><i class="fa fa-search"></i></button>
              </span>
                    </div>
                </div>
            </form>--%>
            <!-- / link and dropdown -->

            <!-- search form -->

            <!-- / search form -->

            <!-- nabar right -->
            <ul class="nav navbar-nav navbar-right">
                <%--<li class="dropdown hidden-sm" is-open="lang.isopen" dropdown="">
                    <a class="dropdown-toggle" dropdown-toggle="" aria-haspopup="true" aria-expanded="false">
                        English <b class="caret"></b>
                    </a>
                    <!-- dropdown -->
                    <ul class="dropdown-menu animated fadeInRight w">
                        <li class="">
                            <a href="">English</a>
                        </li>
                        <li class="">
                            <a href="">German</a>
                        </li>
                        <li class="">
                            <a href="">Italian</a>
                        </li>
                    </ul>
                    <!-- / dropdown -->
                </li>--%>
                <%--<li class="hidden-xs">
                    <a ui-fullscreen="" class=""><i class="fa fa-expand fa-fw text"></i><i class="fa fa-compress fa-fw text-active"></i></a>
                </li>--%>
                <%--<li class="dropdown" dropdown="">
                    <a class="dropdown-toggle" dropdown-toggle="" aria-haspopup="true" aria-expanded="false">
                        <i class="icon-bell fa-fw"></i>
                        <span class="visible-xs-inline">Notifications</span>
                        <span class="badge badge-sm up bg-danger pull-right-xs">2</span>
                    </a>
                    <!-- dropdown -->
                    <div class="dropdown-menu w-xl animated fadeInUp" dropdown-toggle="" aria-haspopup="true" aria-expanded="true">
                        <div class="panel bg-white">
                            <div class="panel-heading b-light bg-light">
                                <strong>You have <span>2</span> notifications</strong>
                            </div>
                            <div class="list-group">
                                <a class="list-group-item">
                    <span class="pull-left m-r thumb-sm">
                      <img src="${ctx}/asiaui/src/img/a0.jpg" alt="..." class="img-circle">
                    </span>
                    <span class="clear block m-b-none">
                      Use awesome animate.css<br>
                      <small class="text-muted">10 minutes ago</small>
                    </span>
                                </a>
                                <a class="list-group-item">
                    <span class="clear block m-b-none">
                      1.0 initial released<br>
                      <small class="text-muted">1 hour ago</small>
                    </span>
                                </a>
                            </div>
                            <div class="panel-footer text-sm">
                                <a href="" class="pull-right"><i class="fa fa-cog"></i></a>
                                <a href="#notes" data-toggle="class:show animated fadeInRight">See all the notifications</a>
                            </div>
                        </div>
                    </div>
                    <!-- / dropdown -->
                </li>--%>
                <li class="dropdown" dropdown="">
                    <a class="dropdown-toggle clear" dropdown-toggle="" aria-haspopup="true" aria-expanded="false">
              <span class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm">
                <img src="${ctx}/asiaui/src/img/a0.jpg" alt="...">
                <i class="on md b-white bottom"></i>
              </span>
                        <span class="hidden-sm hidden-md"><shiro:principal /></span> <b class="caret"></b>
                    </a>
                    <!-- dropdown -->
                    <ul class="dropdown-menu animated fadeInRight w">
                        <%--<li class="wrapper b-b m-b-sm bg-light m-t-n-xs">
                            <div>
                                <p>300mb of 500mb used</p>
                            </div>
                            <div class="progress-xs m-b-none bg-white progress" value="60">
                                <div class="progress-bar" style="width: 60%;"></div>
                            </div>
                        </li>--%>
                        <%--<li>
                            <a href="">
                                <span class="badge bg-danger pull-right">30%</span>
                                <span>Settings</span>
                            </a>
                        </li>--%>
                        <%--<li>
                            <a ui-sref="app.page.profile" href="#/app/page/profile">Profile</a>
                        </li>--%>
                        <%--<li>
                            <a ui-sref="app.docs" href="#/app/docs">
                                <span class="label bg-info pull-right">new</span>
                                Help
                            </a>
                        </li>
                        <li class="divider"></li>--%>
                        <li class="divider"></li>
                        <li>
                            <a ui-sref="access.signin" href="javascript:" onclick="flushall();">刷新缓存</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a ui-sref="access.signin" href="${ctx}/logout">登出</a>
                        </li>
                    </ul>
                    <!-- / dropdown -->
                </li>
            </ul>
            <!-- / navbar right -->

        </div>
        <!-- / navbar collapse -->
    </div>

    <div layout="row" class="">
        <!-- menu -->
        <div flex="" class="columnFlexLeft bg-white md-whiteframe-z0 md-aside md-content hidden-xs ">
            <nav ui-nav="" class="navi clearfix" style="overflow: auto; height: 550px; width: 240px;">
                <ul class="nav ">

                    <c:forEach items="${menus}" var="m">
                        <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                            <span>${m.name}</span>
                        </li>
                        <li>
                            <a md-ink-ripple="" class="auto">
                            <span class="pull-right text-muted">
                                <i class="fa fa-fw fa-angle-right text"></i>
                                <i class="fa fa-fw fa-angle-down text-active"></i>
                              </span>
                                <i class="glyphicon glyphicon-th-large icon"></i>
                                <span class="font-bold">${m.name}</span>
                            </a>
                            <ul class="nav nav-sub dk">
                                <li class="nav-sub-header">
                                    <a href="" md-ink-ripple="">
                                        <span>${m.name}</span>
                                    </a>
                                </li>
                                <c:if test="${0 < fn:length(m.sysResources)}">
                                        <c:forEach var="mm" items="${m.sysResources}">
                                            <li>
                                                <a href="${ctx}${mm.url}" target="navTab" rel="_id_${mm.id}" external="true">
                                                    <span>${mm.name}</span>
                                                </a>
                                            </li>
                                        </c:forEach>
                                </c:if>
                            </ul>
                        </li>
                        <li class="line dk"></li>
                    </c:forEach>


                    <%--<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span>布局</span>
                    </li>
                    <li>
                        <a md-ink-ripple="" class="auto">
                            <span class="pull-right text-muted">
                                <i class="fa fa-fw fa-angle-right text"></i>
                                <i class="fa fa-fw fa-angle-down text-active"></i>
                              </span>
                            <i class="glyphicon glyphicon-th-large icon"></i>
                            <span class="font-bold">组合</span>
                        </a>
                        <ul class="nav nav-sub dk">
                            <li class="nav-sub-header">
                                <a href="" md-ink-ripple="">
                                    <span>组合</span>
                                </a>
                            </li>
                            <li tag="material_index.html">
                                <a>
                                    <span md-ink-ripple="">12</span>
                                </a>
                            </li>
                            <li class="active" tag="index.a.html">
                                <a>
                                    <span md-ink-ripple="">6/6</span>
                                </a>
                            </li>
                            <li class="active" tag="index.rtl.html">
                                <a>
                                    <span md-ink-ripple="">4/4/4</span>
                                </a>
                            </li>
                            <li class="active" tag="material.html">
                                <a>
                                    <span md-ink-ripple="">2/6/4</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="line dk"></li>

                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span>基础</span>
                    </li>
                    <li>
                        <a md-ink-ripple="" class="auto">
			<span class="pull-right text-muted">
        <i class="fa fa-fw fa-angle-right text"></i>
        <i class="fa fa-fw fa-angle-down text-active"></i>
      </span>
                            <i class="glyphicon glyphicon-th icon"></i>
                            <span class="font-normal">文字</span>
                        </a>
                        <ul class="nav nav-sub">
                            <li ui-sref-active="active">
                                <a md-ink-ripple="" ui-sref="app.material.button" href="#/app/material/button">标题栏</a>
                            </li>
                            <li ui-sref-active="active">
                                <a md-ink-ripple="" ui-sref="app.material.icon" href="#/app/material/icon">段落</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a md-ink-ripple="" class="auto">
			<span class="pull-right text-muted">
        <i class="fa fa-fw fa-angle-right text"></i>
        <i class="fa fa-fw fa-angle-down text-active"></i>
      </span>
                            <i class="glyphicon glyphicon-briefcase icon"></i>
                            <span>按钮</span>
                        </a>
                        <ul class="nav nav-sub dk">
                            <li class="nav-sub-header">
                                <a href="">
                                    <span translate="aside.nav.components.ui_kits.UI_KITS" class="">UI Kits</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.ui.buttons" href="#/app/ui/buttons">
                                    <span>常规</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.ui.icons" href="#/app/ui/icons">
                                    <span>圆形</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.ui.grid" href="#/app/ui/grid">
                                    <span>带图标</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a md-ink-ripple="" class="auto">
			<span class="pull-right text-muted">
        <i class="fa fa-fw fa-angle-right text"></i>
        <i class="fa fa-fw fa-angle-down text-active"></i>
      </span>
                            <i class="glyphicon glyphicon-list"></i>
                            <span>列表</span>
                        </a>
                        <ul class="nav nav-sub dk">
                            <li class="nav-sub-header">
                                <a href="">
                                    <span translate="aside.nav.components.table.TABLE" class="">Table</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.table.static" href="#/app/table/static">
                                    <span translate="aside.nav.components.table.TABLE_STATIC" class="">Table static</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.table.datatable" href="#/app/table/datatable">
                                    <span translate="aside.nav.components.table.DATATABLE" class="">Datatable</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.table.footable" href="#/app/table/footable">
                                    <span translate="aside.nav.components.table.FOOTABLE" class="">Footable</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.table.grid" href="#/app/table/grid">
                                    <span>ngGrid</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.table.uigrid" href="#/app/table/uigrid">
                                    <span>uiGrid</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.table.smart" href="#/app/table/smart">
                                    <span>Smart table</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.table.editable" href="#/app/table/editable">
                                    <span>Editable</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a md-ink-ripple="" class="auto">
			<span class="pull-right text-muted">
        <i class="fa fa-fw fa-angle-right text"></i>
        <i class="fa fa-fw fa-angle-down text-active"></i>
      </span>
                            <i class="glyphicon glyphicon-edit"></i>
                            <span>表格</span>
                        </a>
                        <ul class="nav nav-sub dk">
                            <li class="nav-sub-header">
                                <a href="">
                                    <span translate="aside.nav.components.form.FORM" class="">Form</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.form.elements" href="#/app/form/elements">
                                    <span translate="aside.nav.components.form.FORM_ELEMENTS" class="">Form elements</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.form.validation" href="#/app/form/validation">
                                    <span translate="aside.nav.components.form.FORM_VALIDATION" class="">Form validation</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.form.wizard" href="#/app/form/wizard">
                                    <span translate="aside.nav.components.form.FORM_WIZARD" class="">Form wizard</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.form.fileupload" href="#/app/form/fileupload">
                                    <span>File upload</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.form.imagecrop" href="#/app/form/imagecrop">
                                    <span>Image crop</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.form.select" href="#/app/form/select">
                                    <span>Select</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.form.slider" href="#/app/form/slider">
                                    <span>Slider</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.form.editor" href="#/app/form/editor">
                                    <span>Editor</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.form.xeditable" href="#/app/form/xeditable">
                                    <span>Xeditable</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li ui-sref-active="active">
                        <a ui-sref="app.chart" md-ink-ripple="" href="#/app/chart">
                            <i class="glyphicon glyphicon-signal"></i>
                            <span>图片</span>
                        </a>
                    </li>
                    <li>
                        <a md-ink-ripple="" class="auto">
			<span class="pull-right text-muted">
        <i class="fa fa-fw fa-angle-right text"></i>
        <i class="fa fa-fw fa-angle-down text-active"></i>
      </span>
                            <i class="glyphicon glyphicon-file icon"></i>
                            <span>表单</span>
                        </a>
                        <ul class="nav nav-sub dk">
                            <li class="nav-sub-header">
                                <a href="">
                                    <span translate="aside.nav.components.pages.PAGES" class="">Pages</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.page.profile" href="#/app/page/profile">
                                    <span translate="aside.nav.components.pages.PROFILE" class="">Profile</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.page.post" href="#/app/page/post">
                                    <span translate="aside.nav.components.pages.POST" class="">Post</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.page.search" href="#/app/page/search">
                                    <span translate="aside.nav.components.pages.SEARCH" class="">Search</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.page.invoice" href="#/app/page/invoice">
                                    <span translate="aside.nav.components.pages.INVOICE" class="">Invoice</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.page.price" href="#/app/page/price">
                                    <span>Price</span>
                                </a>
                            </li>
                            <li>
                                <a ui-sref="lockme" href="#/lockme">
                                    <span translate="aside.nav.components.pages.LOCK_SCREEN" class="">Lock screen</span>
                                </a>
                            </li>
                            <li>
                                <a ui-sref="access.signin" href="#/access/signin">
                                    <span translate="aside.nav.components.pages.SIGNIN" class="">Signin</span>
                                </a>
                            </li>
                            <li>
                                <a ui-sref="access.signup" href="#/access/signup">
                                    <span translate="aside.nav.components.pages.SIGNUP" class="">Signup</span>
                                </a>
                            </li>
                            <li>
                                <a ui-sref="access.forgotpwd" href="#/access/forgotpwd">
                                    <span translate="aside.nav.components.pages.FORGOT_PASSWORD" class="">Forgot password</span>
                                </a>
                            </li>
                            <li>
                                <a ui-sref="access.404" href="#/access/404">
                                    <span translate="aside.nav.components.pages.404" class="">404</span>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="line dk hidden-folded"></li>

                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span>组件</span>
                    </li>
                    <li>
                        <a md-ink-ripple="" class="auto">
			<span class="pull-right text-muted">
        <i class="fa fa-fw fa-angle-right text"></i>
        <i class="fa fa-fw fa-angle-down text-active"></i>
      </span>
                            <i class="fa fa-location-arrow"></i>
                            <span>导航</span>
                        </a>
                        <ul class="nav nav-sub dk">
                            <li class="nav-sub-header">
                                <a href="">
                                    <span translate="aside.nav.components.ui_kits.UI_KITS" class="">UI Kits</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.ui.buttons" href="#/app/ui/buttons">
                                    <span>常规</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.ui.icons" href="#/app/ui/icons">
                                    <span>圆形</span>
                                </a>
                            </li>
                            <li ui-sref-active="active">
                                <a ui-sref="app.ui.grid" href="#/app/ui/grid">
                                    <span>带图标</span>
                                </a>
                            </li>
                        </ul>
                    </li>--%>
                </ul>
                <!-- / list --></nav>
            <!-- nav --></div>
        <!-- / menu -->

        <!-- view -->
        <div flex="" layout="column" class="columnFlex">
            <div ui-butterbar="" class="butterbar hide"><span class="bar"></span></div>
            <a href="" class="off-screen-toggle hide" ui-toggle-class="off-screen" data-target=".md-aside"></a>
            <!-- uiView:  -->
            <div class="md-content" ui-view="">
                <div class="hbox hbox-auto-xs hbox-auto-sm ">
                    <!-- main -->
                    <div class="col">
                        <!-- / main tab -->
                        <%--<div class="bg-light lter b-b wrapper-sm " style="padding-bottom: 0;">
                            <!-- tab -->
                            <ul class="nav nav-tabs top-tabs tab_menu" style="border-bottom: 0;">
                                <li class="active" tag="${ctx}/mgr/index/dashboard">
                                    <a>首页</a>
					<div class="closed">
						<i class="fa fa-times-circle text-danger"></i>
					</div>
                                </li>
                            </ul>
                            <!-- / tab -->
                        </div>--%>
                        <div id="navTab" class="bg-light lter wrapper-sm tabsPage" style="padding-bottom: 0;">
                            <!-- tab -->
                            <div class="tabsPageHeader">
                                <div class="tabsPageHeaderContent">
                                    <!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
                                    <ul class="navTab-tab">
                                        <li id="main_page" tabid="main" class="main"><a><span><span class="home_icon">首页</span></span></a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="tabsLeft">left</div>
                                <!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
                                <div class="tabsRight">right</div>
                                <!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
                                <div class="tabsMore">more</div>
                            </div>
                            <!-- / tab -->
                            <%--<div class="navTab-panel tabsPageContent layoutBox">
                                <div class="page unitBox">

                                </div>
                            </div>--%>

                            <ul class="tabsMoreList">
                                <li><a href="javascript:">首页</a>
                                </li>
                            </ul>
                            <div class="navTab-panel tabsPageContent layoutBox">
                                <div class="page unitBox">
                                    <iframe src="${ctx}/mgr/index/dashboard" frameborder="0" width="100%" height="100%"></iframe>
                                </div>
                            </div>
                        </div>

                        <!-- / main header -->
                        <div class="wrapper-md">
                            <div class="row">
                                <div class="col-lg-12">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                   <%-- <div class="iframeContainer">
                                        <iframe id="material_index" tag="material_index" onload="iFrameHeight(this)" src="${ctx}/mgr/index/dashboard" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
                                                width="100%"></iframe>
                                    </div>--%>
                                </div>
                            </div>
                            <!-- / tasks -->
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!-- / view -->
    </div>
</div>



<script type="text/javascript">
    $(document).ready(function () {
        $(".navi ul.nav li>a").click(function () {
            if ($(this).parent().hasClass("active")) {
                $(this).parent().removeClass("active");
            } else {
                $(this).parent().addClass("active").siblings("li").removeClass("active");
            }
        });

        $(".dropdown").click(function () {
            if ($(this).hasClass("open")) {
                $(this).removeClass("open");
            } else {
                $(".dropdown").removeClass("open");
                $(this).addClass("open");
            }
        });


        $(".navi>ul>li>ul>li").click(function () {
            $(".wrapper-md").scrollTop(0);
            var tag = $(this).attr("tag");
            var tagName = tag.split(".html")[0];
            tab_menu(tag, tagName, $(this).text(),true);

        });

    });

    function tab_menu(tag, tagName, txt,reload) {
        var flag = false;
        $(".tab_menu").find("li").each(function (index) {
            if ($(this).attr("tag") == tagName) {
                $(this).addClass("active").siblings().removeClass("active");
                flag = true;
            }
        });

        if (flag) {
            $(".iframeContainer").find("iframe").each(function () {
                if ($(this).attr("tag") == tagName) {
                    $(this).show().siblings().hide();
                    if (reload) {
                        $(this).attr("src", $(this).attr("src"));
                    }
                }
            });
        }

        if (!flag) {
            var str = '<li class="active"><a>' + txt + '</a><div class="closed"><i class="fa fa-times-circle text-danger"></i></div></li>';
            var $str = $(str);
            $str.attr("tag", tagName);
            $(".tab_menu").append($str);
            $str.siblings().removeClass("active");
            var iframeStr = '<iframe id="' + tagName + '" onload="iFrameHeight(this)" src="" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%" height="0"></iframe>';
            var $iframe = $(iframeStr);
            $iframe.attr("tag", tagName);
            $iframe.attr("src", tag);
            $(".iframeContainer").append($iframe);
            $iframe.show().siblings().hide();
        }
    }

    $(document).on("click", ".md-content .hbox .col .bg-light .nav>li", function () {
        $(".wrapper-md").scrollTop(0);
        if ($(this).hasClass("active")) {

        } else {
            $(this).addClass("active").siblings().removeClass("active");

            var that = this;
            $(".iframeContainer").find("iframe").each(function () {
                if ($(this).attr("tag") == $(that).attr("tag")) {
                    $(this).show().siblings().hide();
                }
            });

        }
    });

    $(document).on("click", ".md-content .hbox .col .bg-light .nav>li>.closed", function () {
        var $this = $(this).parent();

        var $tag = $this.attr("tag");
        $this.prev().length != 0 ? $this.prev().addClass("active") : $this.next().addClass("active");
        $this.remove();

        var $iframe = null;
        $(".iframeContainer").find("iframe").each(function () {
            if ($(this).attr("tag") == $tag) {
                $iframe = $(this);
                $iframe.prev().length != 0 ? $iframe.prev().show() : $iframe.next().show();

                $iframe.remove();
            }
        });


        initMenu($this.parent());
    });

    initMenu($(".md-content .hbox .col .bg-light .nav"));

    function initMenu($this) {
        if ($this.length == 1) {
            $this.find(".closed").hide();
        }
        $(".wrapper-md").css("height",$(document.body).height() - 122);
    }

    function iFrameHeight(t) {
        $(".wrapper-md").scrollTop(0);
        var ifm = $(t).get(0);
        frameName = $(t).attr("tag");
        try {
            var subWeb = document.frames ? document.frames[frameName].document : ifm.contentDocument;
        } catch (e) {
        console.log(e);
        }
        if (ifm != null && subWeb != null) {
//            ifm.height = subWeb.body.scrollHeight;
            if($(t).attr('tag') == '/flow-market-mgr/mgr/product'){
                ifm.height = $(subWeb).find('body').children().height();
            } else {
                ifm.height = subWeb.body.scrollHeight;
            }

        }
        if ((navigator.userAgent.indexOf('MSIE') >= 0) && (navigator.userAgent.indexOf('Opera') < 0)){
            $(".columnFlex").css("width",$(document.body).width() - 240);
        }
    }


    var flushall = function () {
        $.post('${ctx}/mgr/index/flushall', {}, function (respJson) {
            alert('成功刷新缓存');
        });
    };


</script>
<script src="${ctx}/asiaui/js/ai.core.js"></script>
<div id="cli_dialog"></div>
</body>
</html>