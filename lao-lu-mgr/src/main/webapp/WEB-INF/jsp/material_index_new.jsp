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

    <div layout="column" flex="" ui-view="" style="position:fixed;width:100%">
        <div class="md-navbar navbar blue md-whiteframe-z1 " style="margin: 0px 20px 0px -20px;">
            <div class="navbar-header ">
                <button class="pull-right visible-xs dk" ui-toggle-class="show" data-target=".navbar-collapse">
                    <i class="glyphicon glyphicon-cog"></i>
                </button>
                <button class="pull-right visible-xs" ui-toggle-class="off-screen" data-target=".md-aside" ui-scroll-to="app">
                    <i class="glyphicon glyphicon-align-justify"></i>
                </button>
                <!-- brand -->
                <a href="#/" class="navbar-brand text-lt" style="line-height: 99px; padding: 0px 40px;">

                    <img src="${ctx}/asiaui/img/logo.png" alt="." style="width: 240px;height: 100px;max-height: 100px;">
                    <span class="hidden-folded m-l-xs"></span>
                </a>
            </div>

            <div class="collapse navbar-collapse box-shadow green-46c8db ">
                <ul class="nav navbar-nav navbar-right">
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

                            <li class="divider"></li>
                            <li>
                                <a ui-sref="access.signin" href="javascript:" onclick="flushall();">刷新缓存</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a ui-sref="access.signin" href="${ctx}/logout">登出</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>

        <div layout="row" style="padding-top: 39px;">
            <div flex="" class="columnFlexLeft bg-white md-whiteframe-z0 md-aside md-content hidden-xs ">
                <nav ui-nav="" class="navi clearfix" style="overflow: auto; height: 550px; width: 240px;">
                    <ul class="nav ">

                        <c:forEach items="${menus}" var="m">
                            <%--<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                                <span>${m.name}</span>
                            </li>--%>
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
                            <%--<li class="line dk"></li>--%>
                        </c:forEach>
                    </ul>
                </nav>
            </div>

            <!-- view -->
            <div flex="" layout="column" class="columnFlex">
                <div ui-butterbar="" class="butterbar hide"><span class="bar"></span></div>
                <a href="" class="off-screen-toggle hide" ui-toggle-class="off-screen" data-target=".md-aside"></a>
                <!-- uiView:  -->
                <div class="md-content" ui-view="">
                    <div class="hbox hbox-auto-xs hbox-auto-sm ">
                        <!-- main -->
                        <div class="col">
                            <div id="navTab" class="bg-light lter wrapper-sm tabsPage" style="padding-bottom: 0;">
                                <!-- tab -->
                                <div class="tabsPageHeader">
                                    <div class="tabsPageHeaderContent">
                                        <ul class="navTab-tab">
                                            <li id="main_page" tabid="main" class="main"><a><span><span class="home_icon">首页</span></span></a>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="tabsLeft">left</div>
                                    <div class="tabsRight">right</div>
                                    <div class="tabsMore">more</div>
                                </div>

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

                            <div class="wrapper-md">
                                <div class="row">
                                    <div class="col-lg-12"></div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="cli_dialog"></div>
</body>



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

</html>