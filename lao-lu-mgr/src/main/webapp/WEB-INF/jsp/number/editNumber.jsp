<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>号码管理</title>
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




            <c:if test="${not empty body.object.id}">
                <form id="deliveryForm" method="post" action="${ctx}/core/updateNumber">
            </c:if>
            <c:if test="${empty body.object.id}">
                <form id="deliveryForm" method="post" action="${ctx}/core/addNumber">
            </c:if>

            <input type="hidden" name="id" value="${body.object.id}" />

            <div class="row">
                <div class="col-md-12">
                    <%--<h3>号码信息</h3>--%>
                </div>


                <div style="padding: 12px 8px;">
                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                       aria-expanded="true" aria-controls="collapseOne">
                                        号码详情
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                <div class="panel-body">

                                    <div class="col-md-12">
                                        <h5>号码</h5>
                                        <div class="con-area">
                                            <div class="col-md-8">
                                                <input class="form-control" type="text" value="${body.object.number}" name="number" />
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>等级</h5>
                                        <div class="con-area">
                                            <div class="col-md-8">
                                                <input class="form-control" type="text" value="${body.object.level}" name="level" />
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>规则</h5>
                                        <div class="con-area">
                                            <div class="col-md-8">
                                                <input class="form-control" type="text" value="${body.object.proTypeId}" name="proTypeId" />
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>状态</h5>
                                        <div class="con-area">
                                            <div class="col-md-8">
                                                <select class="form-control" name="status">
                                                    <option value="0" ${0 == body.object.status ? "selected" : ""}>初始状态</option>
                                                    <option value="-1" ${-1 == body.object.status ? "selected" : ""}>失效</option>
                                                    <option value="1" ${1 == body.object.status ? "selected" : ""}>预占</option>
                                                    <option value="2" ${2 == body.object.status ? "selected" : ""}>卖出</option>
                                                </select>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>选择地区：</h5>

                                        <div class="con-area">
                                            <div class="form-group col-md-4">
                                                <div class="input-group">
                                                    <input id="cityAreaId" type="hidden" name="cityAearId" value="${body.object.areaId}" />
                                                    <input id="parentAreaId" type="hidden" name="provinceAearId" />
                                                    <input id="areaName" type="text" class="form-control" name="areaName" value="${body.object.areaName}" readonly>

                                                    <div class="input-group-addon btn" type="button">
                                                        <a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>


                                    <div class="col-md-12">
                                        <h5>创建时间</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <input type="text" onclick="WdatePicker({el:'createTime', dateFmt:'yyyy-MM-dd HH:mm:ss', minDate:'#F{$dp.$D(\'createTime\')}'})" class="form-control col-xs-10" name="createTime" id="createTime" value="<fmt:formatDate value='${body.object.createTime}' pattern='${df}'/>" style="width: 60%;" readonly/>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>更新时间</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <input type="text" onclick="WdatePicker({el:'updateTime', dateFmt:'yyyy-MM-dd HH:mm:ss', minDate:'#F{$dp.$D(\'updateTime\')}'})" class="form-control col-xs-10" name="updateTime" id="updateTime" value="<fmt:formatDate value='${body.object.updateTime}' pattern='${df}'/>" style="width: 60%;" readonly/>
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


<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
    <ul id="treeDemo" class="ztree" style="margin-top:0; width:362px;"></ul>
</div>

</body>

<script type="text/javascript" src="${ctx}/asiaui/js/JQuery zTree v3.5.15/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/asiaui/js/jquery/jquery.ztree.all-3.5.min.js"></script>

<script>

    var setting = {
        view: {
            dblClickExpand: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeClick: beforeClick,
            onClick: onClick
        }
    };

    var zNodes =[
        <c:forEach items="${body.areaList}" var="area">
        { id:${area.areaId}, pId:${area.parAreaId}, name:"${area.areaName}"},
        </c:forEach>
    ];

    function beforeClick(treeId, treeNode) {
        var check = (treeNode && !treeNode.isParent);
        if (!check) alert("请选择市级区域...");
        return check;
    }

    function onClick(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
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
        $("#areaName").val(parentName + " " + object.text);
        $("#parentAreaId").val(treeNode.pId);
    }

    function showMenu() {
        var cityObj = $("#areaName");
        var cityOffset = $("#areaName").offset();
        $("#menuContent").css({left: cityOffset.left + "px", top: cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

        $("body").bind("mousedown", onBodyDown);
    }
    function hideMenu() {
        $("#menuContent").fadeOut("fast");
        $("body").unbind("mousedown", onBodyDown);
    }
    function onBodyDown(event) {
        if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length > 0)) {
            hideMenu();
        }
    }

    function setValidate() {
        $("#deliveryForm").validate({
            submitHandler : function (form) {

                if ($("#cityAreaId").val() == "") {
                    alert("请选择地区!");

                    return;
                }
                form.submit();
            },
            rules: {
                number : {
                    required:true,
                    maxlength:16
                },
                proTypeId : {
                    required:true,
                    maxlength:5,
                    number:true
                },
                level : {
                    required:true,
                    maxlength:4,
                    number:true
                }
            }
        });
    }


    $(document).ready(function(){
        setValidate();

        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    });

</script>
</html>