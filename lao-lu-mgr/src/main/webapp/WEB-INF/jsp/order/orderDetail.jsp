<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>订单详情</title>
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
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"
                             aria-labelledby="headingOne">
                            <div class="panel-body">
                                <div id="customerDiv">
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
                                        <h5>供货商ID</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.providId}</p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <h5>状态</h5>

                                        <%--
                                            订单状态：
                                            0 待支付
                                            1 甩单中
                                            2 待竣工
                                            3 待发货
                                            4 已发货
                                            5 确认收货
                                            6 订单超时
                                            7 未竣工
                                            8 已退款
                                            9 支付失败
                                        --%>

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
                                                <c:if test="${10 eq body.status}">
                                                    <p class="lead">退款中</p>
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
                                        <h5>快递金额</h5>

                                        <div class="con-area">
                                            <div class="col-md-8 ">
                                                <p class="lead">${body.expressMoney}</p>
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
                                            <div class="col-md-8 ">
                                                <p class="lead"><fmt:formatDate value='${body.createTime}' pattern='${df}'/></p>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
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
                                    顾客信息
                                </a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
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
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingThree">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                                   href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                    套餐信息
                                </a>
                            </h4>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse in" role="tabpanel"
                             aria-labelledby="headingThree">
                            <div class="panel-body">

                                <div class="col-md-12">
                                    <h5>套餐名称</h5>
                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <p class="lead">${body.offerSpec.name}</p>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <h5>号码</h5>
                                    <div class="con-area">
                                        <div class="col-md-8 ">
                                            <p class="lead">${body.telPhone}</p>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                    <%--<div class="panel panel-default">--%>
                        <%--<div class="panel-heading" role="tab" id="headingFour">--%>
                            <%--<h4 class="panel-title">--%>
                                <%--<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"--%>
                                   <%--href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">--%>
                                    <%--信用租机信息--%>
                                <%--</a>--%>
                            <%--</h4>--%>
                        <%--</div>--%>
                        <%--<div id="collapseFour" class="panel-collapse collapse in" role="tabpanel"--%>
                             <%--aria-labelledby="headingThree">--%>
                            <%--<div class="panel-body">--%>
                                <%--<div class="col-md-12">--%>

                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                </div>
            </div>
        </div>


    </div>
</div>

</body>
</html>