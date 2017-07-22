<%--
  Created by IntelliJ IDEA.
  User: 郭春浩
  Date: 2017/5/19
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>发货管理</title>
    <%@include file="/taglib.jsp" %>
    <script src="${asiaui}/js/commonCustom/commonConfig.js"></script>
</head>

<body>

<div flex="" layout="column">

    <div ui-butterbar="" class="butterbar hide"><span class="bar"></span></div>
    <a href="" class="off-screen-toggle hide" ui-toggle-class="off-screen" data-target=".md-aside"></a>

    <div class="md-content ng-scope" ui-view=""><!-- uiView:  -->
        <div ui-view="" class="fade-in-down ">
            <div class="wrapper-md ">
                <!--确认消息-->
                <%@include file="../confirmMessage.jsp" %>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel wrapper panel-default">
                            <div class="panel-body">
                                <form id="frm" class="bs-example form-horizontal" action="${ctx}/core/listDelivery" method="post">
                                    <input type="hidden" id="page" name="page" value="1">

                                    <div class="menu_order">
                                        <div class="form-group">
                                            <label class="control-label wrapper-xs">订单号:</label>

                                            <div class="order_content">
                                                <input type="text" class="form-control col-xs-10" name="orderId" id="orderId" value="${param['orderId']}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="menu_order">
                                        <div class="form-group">
                                            <label class="control-label wrapper-xs">订单流水:</label>

                                            <div class="order_content">
                                                <input type="text" class="form-control col-xs-10" name="orderSeq" id="orderSeq" value="${param['orderSeq']}" />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="menu_order">
                                        <div class="form-group">
                                            <label class="control-label wrapper-xs">顾客姓名:</label>

                                            <div class="order_content">
                                                <input type="text" class="form-control" name="customerName" id="customerName" value="${param['customerName']}" />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="menu_order">
                                        <div class="form-group">
                                            <label class="control-label wrapper-xs">状态:</label>

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
                                            <div class="order_content">
                                                <select id="status" name="status" class="form-control">
                                                    <option value="3"
                                                            <c:if test="${3 eq param['status']}">selected</c:if> >待发货</option>
                                                    <option value="4"
                                                            <c:if test="${4 eq param['status']}">selected</c:if> >已发货</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="menu_order">
                                        <div class="form-group">
                                            <label class="control-label wrapper-xs">价格区间:</label>

                                            <div class="order_content">
                                                <input type="text" name="beginMoney" id="beginMoney" value="${param['beginMoney']}" style="float: left; width: 81px;"/>
                                                <span class="order_line">~</span>
                                                <input type="text" name="endMoney" id="endMoney" value="${param['endMoney']}" style="float: right; width: 82px;"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="menu_order">
                                        <div class="form-group">
                                            <label class="control-label wrapper-xs">订购时间:</label>

                                            <div class="order_content">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" name="beginTime" id="beginTime" value="">
                                                    <span class="input-group-btn">
                                                            <button class="btn btn-default" type="button" onclick="WdatePicker({el:'beginTime', dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="height: 34px;">
                                                                <i class="glyphicon glyphicon-calendar"></i>
                                                            </button>
                                                    </span>
                                                </div>
                                                <span class="order_line">~</span>
                                                <div class="input-group">
                                                    <input type="text" class="form-control" name="endTime" id="endTime" value="">
                                                    <span class="input-group-btn">
                                                            <button class="btn btn-default" type="button" onclick="WdatePicker({el:'endTime', dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="height: 34px;">
                                                                <i class="glyphicon glyphicon-calendar"></i>
                                                            </button>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="menu_order">
                                        <div class="form-group m-b-n-xxs">
                                            <label class="col-xs-4 control-label wrapper-xs"></label>

                                            <div class="col-xs-8">
                                                <button type="search" class="btn btn-primary padder-md">搜索</button>
                                                <%--<button type="reset" class="btn btn-default padder-md" onclick="logConfig.resetOption();">重置</button>--%>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                搜索结果
                            </div>

                            <div class="table-responsive">
                                <c:set var="w5" value='style="width: 5%;"' />
                                <c:set var="w10" value='style="width: 10%;"' />
                                <c:set var="w15" value='style="width: 15%;"' />
                                <c:set var="w20" value='style="width: 20%;"' />

                                <table class="table table-striped b-t b-light text-base">
                                    <thead>
                                    <tr>
                                        <th class="wd-md-1 text-C" ${w5}>订单号</th>
                                        <th class="wd-md-1 text-C" ${w10}>姓名</th>
                                        <th class="wd-md-2 text-C" ${w10}>手机号</th>
                                        <th class="wd-md-2 text-C" ${w15}>订单流水</th>
                                        <%--<th class="wd-md-2 text-C" ${w15}>外部订单号</th>--%>
                                        <th class="wd-md-2 text-C" ${w5}>状态</th>
                                        <th class="wd-md-2 text-C" ${w5}>金额</th>
                                        <th class="wd-md-2 text-C" ${w10}>订购时间</th>
                                        <th class="wd-md-2 text-C" ${w10}>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${body.list}" var="object" varStatus="s">
                                        <tr>
                                            <td class="wd-md-1 text-C" ${w5}>
                                                <div title="${object.orderId}" style="width:50px;">
                                                        ${object.orderId}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w10}>
                                                <div title="${object.customerName}" style="width:60px;">
                                                        ${object.customerName}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w10}>
                                                <div title="${object.customerPhone}" style="width:60px;">
                                                        ${object.customerPhone}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w15}>
                                                <div title="${object.orderSeq}" style="width:180px;overflow: hidden;text-overflow:ellipsis; white-space:nowrap;">
                                                        ${object.orderSeq}
                                                </div>
                                            </td>

                                            <%--<td class="wd-md-2 text-C" ${w15}>
                                                <div title="${object.ordersOutId}" style="width:70px;">
                                                        ${object.ordersOutId}
                                                </div>
                                            </td>--%>

                                            <td class="wd-md-2 text-C" ${w5}>
                                                <div title="${object.status}" style="width:50px;">
                                                    <c:if test="${0 eq object.status}">
                                                        待支付
                                                    </c:if>
                                                    <c:if test="${1 eq object.status}">
                                                        甩单中
                                                    </c:if>
                                                    <c:if test="${2 eq object.status}">
                                                        待竣工
                                                    </c:if>
                                                    <c:if test="${3 eq object.status}">
                                                        待发货
                                                    </c:if>
                                                    <c:if test="${4 eq object.status}">
                                                        已发货
                                                    </c:if>
                                                    <c:if test="${5 eq object.status}">
                                                        确认收货
                                                    </c:if>
                                                    <c:if test="${6 eq object.status}">
                                                        订单超时
                                                    </c:if>
                                                    <c:if test="${7 eq object.status}">
                                                        未竣工
                                                    </c:if>
                                                    <c:if test="${8 eq object.status}">
                                                        已退款
                                                    </c:if>
                                                    <c:if test="${9 eq object.status}">
                                                        支付失败
                                                    </c:if>
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w5}>
                                                <div title="${object.totalMoney}" style="width:50px;">
                                                        ${object.totalMoney}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w10}>
                                                <div title="${object.createTime}" style="width:100px;">
                                                    <fmt:formatDate value='${object.createTime}' pattern='${df}'/>
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w10}>

                                                <c:if test="${1 eq object.status}">
                                                    <a href="${ctx}/core/toAddDeliveryPageMain?orderId=${object.orderId}" role="button">发货</a>
                                                    &nbsp;|&nbsp;
                                                </c:if>

                                                <a href="${ctx}/core/toUpdateDeliveryPage?orderId=${object.orderId}" role="button">更新发货单</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <footer class="panel-footer">
                                <div class="row">
                                    <div>
                                        <div style="float:right;width:100px;margin: 20px 0;padding-left: 10px;">
                                            <div class="input-group">
                                                <input type="number" class="form-control" id="toPageText" placeholder="页"/>
                                                <span class="input-group-btn">
                                        <button id="toPageBtn" class="btn btn-default" type="button" style="width: 40px;padding:6px;">Go</button>
                                      </span>
                                            </div>
                                        </div>
                                        <ul id="example" class="pagination" style="float: right;"></ul>
                                        <span class="pull-right" style="padding: 26px 14px;font-size: 16px;">总共 ${body.page.totalRows} 条</span>
                                    </div>
                                </div>
                            </footer>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

<script type="text/javascript" src="${ctx}/asiaui/js/common/pageination.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        Pageination({
            currentPage: "${body.page.currentPage}",
            totalPages: "${body.page.totalPages}"
        });

    });


</script>
</html>
