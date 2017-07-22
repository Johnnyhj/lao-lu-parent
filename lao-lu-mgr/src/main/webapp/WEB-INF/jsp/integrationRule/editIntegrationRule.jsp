<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>信用分配置</title>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@include file="/taglib.jsp" %>

    <link rel="stylesheet" href="${asiaui}/css/edit.css">

    <link rel="stylesheet" href="${ctx}/asiaui/js/JQuery zTree v3.5.15/css/demo.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/asiaui/js/JQuery zTree v3.5.15/css/zTreeStyle/zTreeStyle.css" type="text/css">

</head>
<body>
<div class="con-box">
    <div class="container-fluid">
        <div class="col-md-12" style="margin-top: 5px;">
            <button type="button" class="btn btn-primary pull-right" onclick="history.go(-1)">返回</button>
        </div>

            <c:if test="${not empty body.object.integrationRuleId}">
                <form id="deliveryForm" method="post" action="${ctx}/core/updateIntegrationRule">
            </c:if>
            <c:if test="${empty body.deliveryInfo.integrationRuleId}">
                <form id="deliveryForm" method="post" action="${ctx}/core/addIntegrationRule">
            </c:if>

                <input id="integrationRuleId" type="hidden" name="integrationRuleId" value="${body.object.integrationRuleId}" />

            <div class="row">
                <div class="col-md-12">
                    <h3>信用分详情</h3>
                </div>

                <div style="padding: 12px 8px;">
                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                       aria-expanded="true" aria-controls="collapseOne">
                                        芝麻信用分配置
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                <div class="panel-body">

                                    <div class="col-md-12">
                                        <h5>城市：</h5>

                                        <div class="con-area">
                                            <div class="form-group col-md-4">
                                                <div class="input-group">
                                                    <input id="cityAearId" type="hidden" name="cityAearId" value="${body.object.cityAearId}" />
                                                    <input id="provinceAearId" type="hidden" name="provinceAearId" value="${body.object.provinceAearId}" />
                                                    <input id="originalAreaName" type="text" class="form-control" name="originalAreaName" value="${body.object.provinceAearName} ${body.object.cityAearName}" readonly>

                                                    <div class="input-group-addon btn" type="button">
                                                        <a id="originalMenuBtn" href="#" onclick="originalShowMenu(); return false;">选择</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>是否默认</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">

                                                <select class="form-control" name="isDefault">
                                                    <option value="0" ${0 == body.object.isDefault ? "selected" : ""}>非默认</option>
                                                    <option value="1" ${1 == body.object.isDefault ? "selected" : ""}>默认</option>
                                                </select>

                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>状态</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">

                                                <select class="form-control" name="status">
                                                    <option value="1" ${1 == body.object.status ? "selected" : ""}>启用</option>
                                                    <option value="0" ${0 == body.object.status ? "selected" : ""}>禁用</option>
                                                </select>

                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>套餐</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">

                                                <select class="form-control" name="offerSpecId">

                                                    <c:forEach items="${body.offerSpecList}" var="offerSpec" varStatus="s">
                                                        <option value="${offerSpec.offerSpecId}"
                                                                <c:if test="${offerSpec.offerSpecId eq body.object.offerSpecId}">selected</c:if> >${offerSpec.name}</option>
                                                    </c:forEach>

                                                </select>

                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>规则 <small>积分规则，积分必填；履约规则，履约次数必填</small></h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">

                                                <select class="form-control" name="ruleType">
                                                    <option value="1" ${1 == body.object.ruleType ? "selected" : ""}>履约</option>
                                                    <option value="0" ${0 == body.object.ruleType ? "selected" : ""}>积分</option>
                                                </select>

                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>积分</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <input class="form-control" type="text" value="${body.object.integration}" name="integration" />
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>共履约次数</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <input class="form-control" type="text" value="${body.object.performanceTimes}" name="performanceTimes" />
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>


                                </div>
                            </div>
                        </div>

                        

                    </div>
                </div>

            </div>

            <div style="padding: 10px; text-align:center">
                <button class="btn btn-sub">${body.op}</button>
            </div>

        </form>


    </div>
</div>

</body>

<div id="originalMenuContent" class="menuContent" style="display:none; position: absolute;">
    <ul id="treeDemo1" class="ztree" style="margin-top:0; width:362px;"></ul>
</div>

<script type="text/javascript" src="${ctx}/asiaui/js/JQuery zTree v3.5.15/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/asiaui/js/jquery/jquery.ztree.all-3.5.min.js"></script>

<script>

    <%-- 选择起始地   start --%>
    var original_setting = {
        view: {
            dblClickExpand: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeClick: originalBeforeClick,
            onClick: originalOnClick
        }
    };

    var original_zNodes =[
        <c:forEach items="${body.areaList}" var="area">
        { id:${area.areaId}, pId:${area.parAreaId}, name:"${area.areaName}"},
        </c:forEach>
    ];

    function originalBeforeClick(treeId, treeNode) {
        var check = (treeNode && !treeNode.isParent);
//        if (!check) alert("请选择市级区域...");
//        return check;
        return true;
    }

    function originalOnClick(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo1"),
            nodes = zTree.getSelectedNodes();
        nodes.sort(function compare(a, b) {
            return a.id - b.id;
        });

        var object = {
            text : '',
            value : ''
        };

        for (var i = 0, l = nodes.length; i < l; i++) {
            object.text += nodes[i].name + ",";
            object.value += nodes[i].id + ",";
        }
        if (object.text.length > 0) {
            object.text = object.text.substring(0, object.text.length - 1);
            object.value = object.value.substring(0, object.value.length - 1);
        }

        var parentName = $("#" + treeNode.parentTId + "_span").html();

        $("#provinceAearId").val("");
        $("#cityAearId").val("");

        if (parentName) {
            $("#originalAreaName").val(parentName + " " + object.text);

            $("#provinceAearId").val(treeNode.pId);
            $("#cityAearId").val(treeNode.id);

        }else
        {
            $("#originalAreaName").val(object.text);

            $("#provinceAearId").val(treeNode.id);
        }
    }

    function originalShowMenu() {
        var cityObj = $("#originalAreaName");
        var cityOffset = $("#originalAreaName").offset();
        $("#originalMenuContent").css({left: cityOffset.left + "px", top: cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

        $("body").bind("mousedown", originalOnBodyDown);
    }
    function originalHideMenu() {
        $("#originalMenuContent").fadeOut("fast");
        $("body").unbind("mousedown", originalOnBodyDown);
    }
    function originalOnBodyDown(event) {
        if (!(event.target.id == "originalMenuBtn" || event.target.id == "originalMenuContent" || $(event.target).parents("#originalMenuContent").length > 0)) {
            originalHideMenu();
        }
    }
    <%-- 选择起始地  end --%>

    $(document).ready(function(){
        setValidate();

        $.fn.zTree.init($("#treeDemo1"), original_setting, original_zNodes);
    });

    function setValidate() {
        $("#deliveryForm").validate({
            submitHandler : function (form) {

                // 校验积分或者履约期数有没有填写
                if ($("select[name='ruleType']").val() == 0 && $("input[name='integration']").val() == '') {
                    alert("积分规则，积分必填");

                    return;
                }

                if ($("select[name='ruleType']").val() == 1 && $("input[name='performanceTimes']").val() == '') {
                    alert("履约规则，履约次数必填");

                    return;
                }

                form.submit();
            },
            rules: {
                performanceTimes : {
                    maxlength:12,
                    number:true
                },
                integration : {
                    maxlength:12,
                    number:true
                }
            }
        });
    }

</script>
</html>