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
    <title>退款处理</title>
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
                                <form id="frm" class="bs-example form-horizontal" action="${ctx}/core/listRefund" method="post">
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
                                                    <option value="-1">全部</option>
                                                    <option value="7"
                                                            <c:if test="${7 eq param['status']}">selected</c:if> >未竣工</option>
                                                    <option value="10"
                                                            <c:if test="${10 eq param['status']}">selected</c:if> >退款中</option>
                                                    <option value="8"
                                                            <c:if test="${8 eq param['status']}">selected</c:if> >退款完成</option>
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

                                            <td class="wd-md-2 text-C" ${w5}>
                                                <div title="${object.status}" style="width:50px;">
                                                    <c:if test="${7 eq object.status}">
                                                        未竣工
                                                    </c:if>
                                                    <c:if test="${10 eq object.status}">
                                                        退款中
                                                    </c:if>
                                                    <c:if test="${8 eq object.status}">
                                                        退款完成
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
                                                <a class="updateClass" href="${ctx}/core/refundDetail?orderId=${object.orderId}" role="button">详情</a>
                                                <c:if test="${7 eq object.status}">
                                                    | <a class="updateClass" href="#" data-id="${object.orderId}" data-status="${object.status}" role="button">申请退款</a>
                                                </c:if>
                                                <c:if test="${10 eq object.status}">
                                                    | <a class="updateClass" href="#" data-id="${object.orderId}" data-status="${object.status}" role="button">完成退款</a>
                                                </c:if>
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

        $(".updateClass").click(function () {

            var status = $(this).attr("data-status");
            var message = '';
            if ('7' == status) {
                message = "确定申请退款吗？";
            }
            else if ('10' == status) {
                message = "确定完成退款吗？";
            }
            else {
                return;
            }

            if (confirm(message)) {
                $.get(
                    '${ctx}/core/updateRefundMain?orderId={object_id}&status={object_status}'.render(
                        {'object_id':$(this).attr("data-id"), "object_status":status}),
                    {},
                    function (data) {
                        alert(data.msg);

                        if (data.code == 0) {
                            window.location.href = '${ctx}/core/listRefund';
                        }

                    },
                    "json"
                );
            }

        });

    });


</script>
</html>
