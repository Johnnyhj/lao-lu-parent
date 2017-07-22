<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>


<%
    request.setAttribute("ctx", request.getContextPath());
    request.setAttribute("static", request.getContextPath() + "/asiaui");
    request.setAttribute("main", request.getContextPath() + "/static/main");
    request.setAttribute("df", "yyyy-MM-dd HH:mm:ss");
    request.setAttribute("dp", request.getContextPath() + "/asiaui/js/My97DatePicker");
    request.setAttribute("asiaui", request.getContextPath() + "/asiaui");

%>

<link rel="stylesheet" href="${ctx}/asiaui/libs/assets/animate.css/animate.css" type="text/css">
<link rel="stylesheet" href="${ctx}/asiaui/libs/assets/font-awesome/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="${ctx}/asiaui/libs/assets/simple-line-icons/css/simple-line-icons.css" type="text/css">
<link rel="stylesheet" href="${ctx}/asiaui/libs/angular/angular-material/angular-material.css" type="text/css">
<link rel="stylesheet" href="${ctx}/asiaui/libs/jquery/bootstrap/dist/css/bootstrap.css" type="text/css">


<link rel="stylesheet" href="${ctx}/asiaui/src/css/md.css" type="text/css">
<link rel="stylesheet" href="${ctx}/asiaui/src/css/font.css" type="text/css">
<link rel="stylesheet" href="${ctx}/asiaui/src/css/app.css" type="text/css">

<link rel="stylesheet" type="text/css" href="${ctx}/asiaui/src/css/ai-main.css">
<link rel="stylesheet" href="${ctx}/asiaui/src/css/edit.css">

<link rel="stylesheet" href="${ctx}/asiaui/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="${ctx}/asiaui/js/kindeditor/plugins/code/prettify.css" />

<script src='${ctx}/asiaui/js/jquery-2.0.3.min.js'></script>
<script src='${ctx}/asiaui/js/jquery.mobile.custom.min.js'></script>

<script src="${ctx}/asiaui/js/jquery/bootstrap-paginator.min.js"></script>
<script src="${ctx}/asiaui/js/My97DatePicker/WdatePicker.js"></script>

<script src="${ctx}/asiaui/js/jquery/bootstrap.min.js"></script>


<script src="${ctx}/asiaui/js/jquery/jquery.validate.min.js"></script>
<script src="${ctx}/asiaui/js/jquery/jquery.validate.language.js"></script>

<script src="${ctx}/asiaui/js/ec.util.js"></script>
<script src="${ctx}/asiaui/js/common/lodash.min.js"></script>


<script charset="utf-8" src="${ctx}/asiaui/js/kindeditor/plugins/code/prettify.js"></script>
<script charset="utf-8" src="${ctx}/asiaui/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="${ctx}/asiaui/js/kindeditor/lang/zh_CN.js"></script>

<script src="${ctx}/asiaui/js/commonCustom/commonConfig.js"></script>

<script type="text/javascript">
    $(document).ready(function () {

        commonConfig.contentName = "${ctx}";

    });
</script>
