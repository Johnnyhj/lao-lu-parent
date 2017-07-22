<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>运费维护</title>
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

            <c:if test="${not empty body.object.freightId}">
                <form id="deliveryForm" method="post" action="${ctx}/core/updateFreight">
            </c:if>
            <c:if test="${empty body.deliveryInfo.freightId}">
                <form id="deliveryForm" method="post" action="${ctx}/core/addFreight">
            </c:if>

                <input id="freightId" type="hidden" name="freightId" value="${body.object.freightId}" />

            <div class="row">
                <div class="col-md-12">
                    <h3>运费详情</h3>
                </div>

                <div style="padding: 12px 8px;">
                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                       aria-expanded="true" aria-controls="collapseOne">
                                        运费信息
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                <div class="panel-body">

                                    <div class="col-md-12">
                                        <h5>选择起始地：</h5>

                                        <div class="con-area">
                                            <div class="form-group col-md-4">
                                                <div class="input-group">
                                                    <input id="originalCityAearId" type="hidden" name="originalCityAearId" value="${body.object.originalCityAearId}" />
                                                    <input id="originalProvinceAearId" type="hidden" name="originalProvinceAearId" value="${body.object.originalProvinceAearId}" />
                                                    <input id="originalAreaName" type="text" class="form-control" name="originalAreaName" value="${body.object.originalProvinceAearName} ${body.object.originalCityAearName}" readonly>

                                                    <div class="input-group-addon btn" type="button">
                                                        <a id="originalMenuBtn" href="#" onclick="originalShowMenu(); return false;">选择</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>选择目的地：</h5>

                                        <div class="con-area">
                                            <div class="form-group col-md-4">
                                                <div class="input-group">
                                                    <input id="destinationCityAearId" type="hidden" name="destinationCityAearId" value="${body.object.destinationCityAearId}" />
                                                    <input id="destinationProvinceAearId" type="hidden" name="destinationProvinceAearId" value="${body.object.destinationProvinceAearId}" />
                                                    <input id="destinationAreaName" type="text" class="form-control" name="destinationAreaName" value="${body.object.destinationProvinceAearName} ${body.object.destinationCityAearName}" readonly>

                                                    <div class="input-group-addon btn" type="button">
                                                        <a id="destinationMenuBtn" href="#" onclick="destinationShowMenu(); return false;">选择</a>
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
                                        <h5>运费</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <input class="form-control" type="text" value="${body.object.money}" name="money" />
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

<div id="destinationMenuContent" class="menuContent" style="display:none; position: absolute;">
    <ul id="treeDemo2" class="ztree" style="margin-top:0; width:362px;"></ul>
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

        $("#cityAreaId").val(object.value);

        // 清空
        $("#originalProvinceAearId").val("");
        $("#originalCityAearId").val("");

        var parentName = $("#" + treeNode.parentTId + "_span").html();

        if (parentName) {
            $("#originalAreaName").val(parentName + " " + object.text);

            $("#originalProvinceAearId").val(treeNode.pId);
            $("#originalCityAearId").val(treeNode.id);

        }else
        {
            $("#originalAreaName").val(object.text);

            $("#originalProvinceAearId").val(treeNode.id);
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

    <%-- 选择目的地  start --%>
    var destination_setting = {
        view: {
            dblClickExpand: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeClick: destinationBeforeClick,
            onClick: destinationOnClick
        }
    };

    var destination_zNodes =[
        <c:forEach items="${body.destinationArea}" var="area">
        { id:${area.areaId}, pId:${area.parAreaId}, name:"${area.areaName}"},
        </c:forEach>
    ];

    function destinationBeforeClick(treeId, treeNode) {
        var check = (treeNode && !treeNode.isParent);
//        if (!check) alert("请选择市级区域...");
//        return check;
        return true;
    }

    function destinationOnClick(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo2"),
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

        $("#cityAreaId").val(object.value);

        var parentName = $("#" + treeNode.parentTId + "_span").html();

        // 清空
        $("#destinationProvinceAearId").val("");
        $("#destinationCityAearId").val("");

        if (parentName) {
            $("#destinationAreaName").val(parentName + " " + object.text);

            $("#destinationProvinceAearId").val(treeNode.pId);
            $("#destinationCityAearId").val(treeNode.id);

        }else
        {
            $("#destinationAreaName").val(object.text);

            $("#destinationProvinceAearId").val(treeNode.id);
        }
    }

    function destinationShowMenu() {
        var cityObj = $("#destinationAreaName");
        var cityOffset = $("#destinationAreaName").offset();
        $("#destinationMenuContent").css({left: cityOffset.left + "px", top: cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

        $("body").bind("mousedown", destinationOnBodyDown);
    }
    function destinationHideMenu() {
        $("#destinationMenuContent").fadeOut("fast");
        $("body").unbind("mousedown", destinationOnBodyDown);
    }
    function destinationOnBodyDown(event) {
        if (!(event.target.id == "destinationMenuBtn" || event.target.id == "destinationMenuContent" || $(event.target).parents("#destinationMenuContent").length > 0)) {
            destinationHideMenu();
        }
    }
    <%-- 选择目的地  end --%>


    $(document).ready(function(){
        setValidate();

        $.fn.zTree.init($("#treeDemo1"), original_setting, original_zNodes);

        $.fn.zTree.init($("#treeDemo2"), destination_setting, destination_zNodes);
    });

    function setValidate() {
        $("#deliveryForm").validate({
            submitHandler : function (form) {
                form.submit();
            },
            rules: {
                money : {
                    required:true,
                    maxlength:12,
                    number:true
                }
            }
        });
    }

</script>
</html>