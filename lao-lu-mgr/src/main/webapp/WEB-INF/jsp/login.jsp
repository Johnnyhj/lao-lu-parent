<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx", request.getContextPath());

%>


<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>登录</title>

    <%--<link rel="stylesheet" href="${ctx}/asiaui/libs/jquery/bootstrap/dist/css/bootstrap.css" type="text/css">--%>

    <link rel="stylesheet" href="${ctx}/asiaui/src/css/md.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/asiaui/src/css/font.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/asiaui/src/css/app.css" type="text/css">
    <%@include file="/taglib.jsp" %>

    <style>
        .btn:hover, .btn:focus, .btn.focus {
            color: #fff;
        }

        .bg-pic {
            background-size: cover;
            background: url(${ctx}/asiaui/src/img/bg-pic-02.jpg) center 840px;
        }
    </style>
</head>

<body layout="row" class="bg-pic">
<div>
    <div class="fade-in-right-big smooth">
        <div class="container w-xxl w-auto-xs" style="margin-left: 640px;">
            <a href="" class="navbar-brand block m-t">
                <img src="${pageContext.request.contextPath}/asiaui/src/img/logo_lg.png" width="100" style="max-height:104px;"/>
            </a>

            <div class="m-b-lg">
                <div class="wrapper text-center">
                    <strong>欢迎使用，请先登录</strong>
                </div>
                <form name="form" class="form-validation" method="post">
                    <div class="text-danger wrapper text-center ">
                        ${error}
                    </div>
                    <div class="list-group list-group-sm">
                        <div class="list-group-item">
                            <input type="text" name="username" placeholder="用户名" class="form-control no-border" value="<shiro:principal/>" />
                        </div>
                        <div class="list-group-item">
                            <input type="password" name="password" placeholder="密码" class="form-control no-border" />
                        </div>
                        <c:if test="${jcaptchaEbabled}">
                            <%--<div class="list-group-item">
                                <input type="text" name="jcaptchaCode" placeholder="验证码" class="form-control no-border">
                                <img id="jcaptcha" class="jcaptcha-btn jcaptcha-img"
                                     src="${pageContext.request.contextPath}/jcaptcha.jpg" title="点击更换验证码">
                                <a id="btn_jcaptcha" class="jcaptcha-btn">换一张</a>
                            </div>--%>

                            <div class="list-group-item">
                                <a class="btn  btn-sm pull-right inline m-t-xxs">
                                    <img id="jcaptcha" class="jcaptcha-btn jcaptcha-img"
                                         src="${pageContext.request.contextPath}/jcaptcha.jpg" width="80" title="点击更换验证码">
                                </a>
                                <input type="text" name="jcaptchaCode" placeholder="验证码" class="form-control no-border" style="width: 60%">
                            </div>
                        </c:if>
                    </div>
                    <button type="submit" class="btn btn-lg btn-block blue">登 录</button>
                    <div class="text-center m-t m-b"><a data-toggle="modal" data-target="#myModal">忘记密码？</a></div>
                    <div class="line line-dashed"></div>
                    <%--<p class="text-center">
                        <small>您还没有账户？</small>
                    </p>--%>
                    <%--<a class="btn btn-lg btn-default btn-block">立即注册</a>--%>
                </form>
            </div>
            <div class="text-center">
                <p>
                    <small class="text-muted">中国电信<br>© 2016</small>
                </p>
            </div>
        </div>
    </div>
</div>

<%-- modal --%>
<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">找回密码</h4>
            </div>
            <div class="modal-body">
                <div class="row">

                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="telPhone">手机号</label>
                            <input type="text" class="form-control" id="telPhone" placeholder="请输入手机号">
                        </div>
                        <button id="getCode" class="btn btn-default">获取验证码</button>
                    </div>

                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="validateCode">验证码</label>
                            <input type="text" class="form-control" id="validateCode" placeholder="验证码">
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="password">设置密码</label>
                            <input type="password" class="form-control" id="password" placeholder="密码">
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="con-area">
                            <button id="submitBtn" class="btn btn-sub">提交</button>
                        </div>

                    </div>

                </div>

            </div>
        </div>
    </div>
</div>

</body>

<script>
    (function(){


        if (window.parent.length > 0) {
            window.parent.location = "${ctx}/mgr/index";
        }


        $('#jcaptcha').click(function () {
            $(this).attr('src', '${pageContext.request.contextPath}/jcaptcha.jpg?t=' + new Date());
        });

        // 获取验证码
        $('#getCode').click(function () {
            var phone = $("#telPhone").val();
            if ("" == phone) {
                alert("输入手机号!");
                return;
            }

            $.ajax({
                url: "${ctx}/out/getCode.do",
                type: 'post',
                data: {phone : phone},
                dataType: 'json',
                success: function (data) {
                    alert(data.resultMsg);
                }
            });

        });

        // 校验验证码
        $('#submitBtn').click(function () {
            var phone = $("#telPhone").val();
            var password = $("#password").val();
            var validateCode = $("#validateCode").val();
            if ("" == phone) {
                alert("输入手机号!");
                return;
            }
            if ("" == password) {
                alert("输入密码!");
                return;
            }
            if ("" == validateCode) {
                alert("输入验证码!");
                return;
            }

            $.ajax({
                url: "${ctx}/out/validateCode.do",
                type: 'post',
                data: {telPhone : phone, validateCode: validateCode, password:password},
                dataType: 'json',
                success: function (data) {
                    $("#myModal").modal("hide");
                    $("#password").val("");
                    $("#validateCode").val("");
                    $("#telPhone").val("");

                    alert(data.resultMsg);
                }
            });

        });


    })();

</script>
</html>


<%--
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
</head>
<body>

<div class="error">${error}</div>
<form action="" method="post">
    用户名：<input type="text" name="username" value="<shiro:principal/>"><br/>
    密码：<input type="password" name="password"><br/>
    自动登录：<input type="checkbox" name="rememberMe" value="true"><br/>
    <input type="submit" value="登录">
</form>


</body>
</html>--%>
