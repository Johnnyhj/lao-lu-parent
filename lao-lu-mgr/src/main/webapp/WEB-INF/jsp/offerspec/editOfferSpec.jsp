<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增/修改节点</title>
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

        <c:if test="${not empty body.object.offerSpecId}">
            <form id="frm" method="post" action="${ctx}/core/updateOfferSpec">
        </c:if>
        <c:if test="${empty body.object.offerSpecId}">
            <form id="frm" method="post" action="${ctx}/core/addOfferSpec">
            <%--<form id="frm" method="post" action="${ctx}/addOfferSpec">--%>
        </c:if>


            <div style="padding: 12px 8px;">
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingOne">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                   aria-expanded="true" aria-controls="collapseOne">
                                    套餐信息
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"
                             aria-labelledby="headingOne">
                            <div class="panel-body">
                                <div class="col-md-12">
                                    <h5>销售品规格ID：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" value="${body.object.offerSpecId}" name="offerSpecId" id="offerSpecId" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>名称：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" value="${body.object.name}" name="name" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>编码：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" value="${body.object.code}" name="code" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>管理编码：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" value="${body.object.manageCode}" name="manageCode" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>简拼：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" value="${body.object.simpleSpell}" name="simpleSpell" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>协议种类CD：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" value="${body.object.agreementTypeCd}" name="agreementTypeCd" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>销售品类型CD：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" value="${body.object.offerTypeCd}" name="offerTypeCd" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <%--<div class="col-md-12">
                                    <h5>所属地区：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" value="${body.object.areaId}" name="areaId" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>--%>

                                <div class="col-md-12">
                                    <h5>摘要：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" value="${body.object.summary}" name="summary" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>状态编码：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" value="${body.object.statusCd}" name="statusCd" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>选择地区：</h5>

                                    <div class="con-area">
                                        <div class="form-group col-md-4">
                                            <div class="input-group">
                                                <input id="areaId" type="hidden" name="cityAearId" value="${body.object.systemArea.areaId}"/>
                                                <input id="parentAreaId" type="hidden" name="provinceAearId" value="${body.object.systemArea.parentAreaId}"/>
                                                <input id="areaName" type="text" class="form-control" name="areaName" value="${body.object.systemArea.parentAreaName}  ${body.object.systemArea.areaName}" readonly>

                                                <div class="input-group-addon btn" type="button">
                                                    <a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>生效时间</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input type="text" onclick="WdatePicker({el:'startDt', dateFmt:'yyyy-MM-dd HH:mm:ss', minDate:'#F{$dp.$D(\'startDt\')}'})" class="form-control col-xs-10" name="startDt" id="startDt" value="<fmt:formatDate value='${body.object.startDt}' pattern='${df}'/>" style="width: 60%;" readonly/>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>失效时间</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input type="text" onclick="WdatePicker({el:'endDt', dateFmt:'yyyy-MM-dd HH:mm:ss', minDate:'#F{$dp.$D(\'endDt\')}'})" class="form-control col-xs-10" name="endDt" id="endDt" value="<fmt:formatDate value='${body.object.endDt}' pattern='${df}'/>" style="width: 60%;" readonly/>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>创建时间</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input type="text" onclick="WdatePicker({el:'createDt', dateFmt:'yyyy-MM-dd HH:mm:ss', minDate:'#F{$dp.$D(\'createDt\')}'})" class="form-control col-xs-10" name="endDt" id="createDt" value="<fmt:formatDate value='${body.object.createDt}' pattern='${df}'/>" style="width: 60%;" readonly/>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingTwo">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                                   href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                    套餐规格信息
                                </a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
                            <div class="panel-body">
                                <div class="col-md-12">
                                    <h5>销售品规格ID：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">
                                            <input class="form-control" type="text" value="${body.object.offerSpecInfo.offerSpecId}" id="offerSpecId_temp" readonly />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>是否多产品销售品：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">

                                            <select id="compOffer" class="form-control" style="width: 160px;" name="compOffer">
                                                <option value="N" ${('N' eq body.object.offerSpecInfo.compOffer) ? "selected" : ""}>否</option>
                                                <option value="Y" ${('Y' eq body.object.offerSpecInfo.compOffer) ? "selected" : ""}>是</option>
                                            </select>

                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>业务分类编码：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">

                                            <select id="busiTypeCd" class="form-control" style="width: 160px;" name="busiTypeCd">
                                                <option value="1" ${('1' eq body.object.offerSpecInfo.busiTypeCd) ? "selected" : ""}>销售类销售品</option>
                                                <option value="2" ${('2' eq body.object.offerSpecInfo.busiTypeCd) ? "selected" : ""}>促销类销售品</option>
                                            </select>

                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>付费方式：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">

                                            <select id="feeType" class="form-control" style="width: 160px;" name="feeType">
                                                <option value="0" ${('0' eq body.object.offerSpecInfo.feeType) ? "selected" : ""}>不限</option>
                                                <option value="1" ${('1' eq body.object.offerSpecInfo.feeType) ? "selected" : ""}>后付费</option>
                                                <option value="2" ${('2' eq body.object.offerSpecInfo.feeType) ? "selected" : ""}>预付费</option>
                                            </select>

                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>生效规则CD：</h5>
                                    <div class="con-area">
                                        <div class="col-md-8">

                                            <select id="lifecycleRuleCd" class="form-control" style="width: 160px;" name="lifecycleRuleCd">
                                                <option value="0" ${('0' eq body.object.offerSpecInfo.lifecycleRuleCd) ? "selected" : ""}>立即</option>
                                                <option value="1" ${('1' eq body.object.offerSpecInfo.lifecycleRuleCd) ? "selected" : ""}>次月</option>
                                            </select>

                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>指定生效时间：</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input type="text" onclick="WdatePicker({el:'appStartDt', dateFmt:'yyyy-MM-dd HH:mm:ss', minDate:'#F{$dp.$D(\'appStartDt\')}'})" class="form-control col-xs-10" name="appStartDt" id="appStartDt" value="<fmt:formatDate value='${body.object.offerSpecInfo.appStartDt}' pattern='${df}'/>" style="width: 60%;" readonly/>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>指定失效时间：</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input type="text" onclick="WdatePicker({el:'appEndDt', dateFmt:'yyyy-MM-dd HH:mm:ss', minDate:'#F{$dp.$D(\'endDt\')}'})" class="form-control col-xs-10" name="appEndDt" id="appEndDt" value="<fmt:formatDate value='${body.object.offerSpecInfo.appEndDt}' pattern='${df}'/>" style="width: 60%;" readonly/>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>时长单位编码：</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">

                                            <select id="timeUnitCd" class="form-control" style="width: 160px;" name="timeUnitCd">
                                                <option value="1" ${('1' eq body.object.offerSpecInfo.timeUnitCd) ? "selected" : ""}>天</option>
                                                <option value="2" ${('2' eq body.object.offerSpecInfo.timeUnitCd) ? "selected" : ""}>月</option>
                                                <option value="3" ${('3' eq body.object.offerSpecInfo.timeUnitCd) ? "selected" : ""}>季度</option>
                                                <option value="4" ${('4' eq body.object.offerSpecInfo.timeUnitCd) ? "selected" : ""}>年</option>
                                            </select>

                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>有效时长：</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input class="form-control" type="text" value="${body.object.offerSpecInfo.effTime}" name="effTime" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>变更有效时长：</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input class="form-control" type="text" value="${body.object.offerSpecInfo.changeEffTime}" name="changeEffTime" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>最大提前受理时间：</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input class="form-control" type="text" value="${body.object.offerSpecInfo.preSaleTime}" name="preSaleTime" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>要求在网时长：</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input class="form-control" type="text" value="${body.object.offerSpecInfo.inUseTime}" name="inUseTime" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>月消费金额：</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input class="form-control" type="text" value="${body.object.offerSpecInfo.rpmonth}" name="rpmonth" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>套餐月费描述(首页展示)：</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input class="form-control" type="text" value="${body.object.offerSpecInfo.costDesc}" name="costDesc" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>流量描述(首页展示)：</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input class="form-control" type="text" value="${body.object.offerSpecInfo.flowDesc}" name="flowDesc" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>语音通话描述(首页展示)：</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input class="form-control" type="text" value="${body.object.offerSpecInfo.callDesc}" name="callDesc" />
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>套餐赠送描述(首页展示)：</h5>

                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <input class="form-control" type="text" value="${body.object.offerSpecInfo.saleDesc}" name="saleDesc" />
                                        </div>
                                        <div class="clearfix"></div>
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

        $("#areaId").val(object.value);

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



    $(document).ready(function () {
        setValidate();

        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    });

    function setValidate() {
        $("#frm").validate({
            submitHandler : function (form) {
                $("#offerSpecId_temp").val($("#offerSpecId").val());

                form.submit();
            },
            rules: {
                offerSpecId : {
                    required:true,
                    maxlength:12,
                    number:true
                },
                name : {
                    required:true,
                    maxlength:200
                },
                manageCode : {
                    required:true,
                    maxlength:256
                },
                agreementTypeCd : {
                    required:true,
                    maxlength:2,
                    digits:true
                },
                offerTypeCd : {
                    required:true,
                    maxlength:2,
                    digits:true
                },
                areaId : {
                    required:true,
                    maxlength:5,
                    digits:true
                },
                statusCd : {
                    required:true,
                    maxlength:2,
                    digits:true
                },
                compOffer : {
                    required:true,
                    maxlength:1
                },
                busiTypeCd : {
                    required:true,
                    maxlength:2,
                    number:true
                },
                feeType : {
                    required:true,
                    maxlength:2,
                    digits:true
                },
                timeUnitCd : {
                    required:true,
                    maxlength:2,
                    digits:true
                },
                saleDesc : {
                    required:true,
                    maxlength:4000
                },
                callDesc : {
                    required:true,
                    maxlength:4000
                },
                flowDesc : {
                    required:true,
                    maxlength:4000
                },
                costDesc : {
                    required:true,
                    maxlength:4000
                }
            }



        });

    }

</script>

</html>