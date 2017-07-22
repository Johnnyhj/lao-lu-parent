<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>发货单</title>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@include file="/taglib.jsp" %>

    <link rel="stylesheet" href="${asiaui}/css/edit.css">

</head>
<body>
<div class="con-box">
    <div class="container-fluid">
        <div class="col-md-12" style="margin-top: 5px;">
            <button type="button" class="btn btn-primary pull-right" onclick="history.go(-1)">返回</button>
        </div>

            <c:if test="${not empty body.deliveryInfo.deliveryId}">
                <form id="deliveryForm" method="post" action="${ctx}/core/updateDelivery">
            </c:if>
            <c:if test="${empty body.deliveryInfo.deliveryId}">
                <form id="deliveryForm" method="post" action="${ctx}/core/addDelivery">
            </c:if>

            <div class="row">
                <div class="col-md-12">
                    <h3>订单详情</h3>
                </div>

                <div style="padding: 12px 8px;">
                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                       aria-expanded="true" aria-controls="collapseOne">
                                        订单信息
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                <div class="panel-body">

                                        <div class="col-md-12">
                                            <h5>顾客姓名</h5>
                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <p class="lead">${body.customerName}</p>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>顾客手机号</h5>
                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <p class="lead">${body.customerPhone}</p>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>顾客地址</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <p class="lead">${body.customerAddress}</p>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                    <div class="col-md-12">
                                        <h5>订单号</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.orderId}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>外部订单号</h5>
                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.ordersOutId}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>外部流水</h5>
                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.orderSeq}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>订购套餐</h5>
                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.offerSpec.name}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>套餐号码</h5>
                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.telPhone}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>状态</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">

                                                <c:if test="${0 eq body.status}">
                                                    <p class="lead">待支付</p>
                                                </c:if>
                                                <c:if test="${1 eq body.status}">
                                                    <p class="lead">甩单中</p>
                                                </c:if>
                                                <c:if test="${2 eq body.status}">
                                                    <p class="lead">待竣工</p>
                                                </c:if>
                                                <c:if test="${3 eq body.status}">
                                                    <p class="lead">待发货</p>
                                                </c:if>
                                                <c:if test="${4 eq body.status}">
                                                    <p class="lead">已发货</p>
                                                </c:if>
                                                <c:if test="${5 eq body.status}">
                                                    <p class="lead">确认收货</p>
                                                </c:if>
                                                <c:if test="${6 eq body.status}">
                                                    <p class="lead">订单超时</p>
                                                </c:if>
                                                <c:if test="${7 eq body.status}">
                                                    <p class="lead">未竣工</p>
                                                </c:if>
                                                <c:if test="${8 eq body.status}">
                                                    <p class="lead">已退款</p>
                                                </c:if>
                                                <c:if test="${9 eq body.status}">
                                                    <p class="lead">支付失败</p>
                                                </c:if>

                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>订购数量</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.quantity}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>订单金额</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.ordersMoney}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>总金额</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.totalMoney}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>订购时间</h5>

                                        <div class="con-area">
                                            <div class="col-md-8">
                                                <p class="lead"><fmt:formatDate value='${body.createTime}' pattern='${df}'/></p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingThree">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                        填写发货单
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseThree" class="panel-collapse collapse in" role="tabpanel"
                                 aria-labelledby="headingThree">
                                <div class="panel-body">

                                    <input type="hidden" name="deliveryId" value="${body.deliveryInfo.deliveryId}" />
                                    <input type="hidden" name="orderId" value="${body.orderId}" />
                                    <input type="hidden" name="status" value="1" />

                                    <div class="col-md-12">
                                        <h5>快递名称</h5>
                                        <div class="con-area">
                                            <div class="col-md-8">
                                                <input class="form-control" type="text" value="${body.deliveryInfo.expressName}" name="expressName" />
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>快递单号</h5>
                                        <div class="con-area">
                                            <div class="col-md-8">
                                                <input class="form-control" type="text" value="${body.deliveryInfo.expressSeq}" name="expressSeq" />
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>物流类型</h5>
                                        <div class="con-area">
                                            <div class="col-md-8">
                                                <select class="form-control" name="deliveryType">
                                                    <%-- 1、供货商发货  2、商家发货 --%>
                                                    <option value="1" ${1 == body.deliveryInfo.deliveryType ? "selected" : ""}>供货商发货</option>
                                                    <option value="2" ${2 == body.deliveryInfo.deliveryType ? "selected" : ""}>商家发货</option>
                                                </select>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>快递金额</h5>
                                        <div class="con-area">
                                            <div class="col-md-8">
                                                <input class="form-control" type="text" value="${body.deliveryInfo.expressMoney}" name="expressMoney" />
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>创建时间</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <input type="text" onclick="WdatePicker({el:'createTime', dateFmt:'yyyy-MM-dd HH:mm:ss', minDate:'#F{$dp.$D(\'createTime\')}'})" class="form-control col-xs-10" name="createTime" id="createTime" value="<fmt:formatDate value='${body.deliveryInfo.createTime}' pattern='${df}'/>" style="width: 60%;" readonly/>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>更新时间</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <input type="text" onclick="WdatePicker({el:'updateTime', dateFmt:'yyyy-MM-dd HH:mm:ss', minDate:'#F{$dp.$D(\'updateTime\')}'})" class="form-control col-xs-10" name="updateTime" id="updateTime" value="<fmt:formatDate value='${body.deliveryInfo.updateTime}' pattern='${df}'/>" style="width: 60%;" readonly/>
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
                <button class="btn btn-sub">提交发货单</button>
            </div>

        </form>


    </div>
</div>

</body>

<script>

    $(document).ready(function(){
        setValidate();
    });

    function setValidate() {
        $("#deliveryForm").validate({
            submitHandler : function (form) {
                form.submit();
            },
            rules: {
                expressName : {
                    required:true,
                    maxlength:12
                },
                expressMoney : {
                    required:true,
                    maxlength:5
                },
                expressSeq : {
                    required:true,
                    maxlength:256
                }
            }
        });
    }

</script>
</html>