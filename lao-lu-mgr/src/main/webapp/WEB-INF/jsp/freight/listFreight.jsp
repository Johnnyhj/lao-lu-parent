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
    <title>运费配置</title>
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
                                <form id="frm" class="bs-example form-horizontal" action="${ctx}/core/listFreight" method="post">
                                    <input type="hidden" id="page" name="page" value="1">

                                    <div class="menu_order">
                                        <div class="form-group">
                                            <label class="control-label wrapper-xs">起始城市:</label>

                                            <div class="order_content">
                                                <input type="text" class="form-control col-xs-10" name="tempOriginalAreaName" id="tempOriginalAreaName" value="${param['tempOriginalAreaName']}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="menu_order">
                                        <div class="form-group">
                                            <label class="control-label wrapper-xs">目标城市:</label>

                                            <div class="order_content">
                                                <input type="text" class="form-control col-xs-10" name="tempDestinationAreaName" id="tempDestinationAreaName" value="${param['tempDestinationAreaName']}" />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="menu_order">
                                        <div class="form-group m-b-n-xxs">
                                            <label class="col-xs-4 control-label wrapper-xs"></label>

                                            <div class="col-xs-8">
                                                <button type="search" class="btn btn-primary padder-md">搜索</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-12" style="height: 50px;padding-left: 0px">
                    <a href="${ctx}/core/toAddFreightPage" >
                        <button class="btn btn-info" type="button">
                            <i class="icon-plus bigger-110"></i> 新增运费
                        </button>
                    </a>

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
                                        <th class="wd-md-1 text-C" ${w5}>起始地</th>
                                        <th class="wd-md-1 text-C" ${w10}>目的地</th>
                                        <th class="wd-md-2 text-C" ${w10}>运费</th>
                                        <th class="wd-md-2 text-C" ${w15}>是否默认</th>
                                        <th class="wd-md-2 text-C" ${w5}>状态</th>
                                        <th class="wd-md-2 text-C" ${w10}>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${body.list}" var="object" varStatus="s">
                                        <tr>
                                            <td class="wd-md-1 text-C" ${w5}>
                                                <div title="${object.originalProvinceAearName} ${object.originalCityAearName}" style="width:50px;">
                                                        ${object.originalProvinceAearName} ${object.originalCityAearName}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w10}>
                                                <div title="${object.destinationProvinceAearName} ${object.destinationCityAearName}" style="width:60px;">
                                                    ${object.destinationProvinceAearName} ${object.destinationCityAearName}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w10}>
                                                <div title="${object.money}" style="width:60px;">
                                                    ${object.money}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w5}>
                                                <div title="${object.isDefault}" style="width:50px;">
                                                    <c:if test="${0 eq object.isDefault}">
                                                        非默认
                                                    </c:if>
                                                    <c:if test="${1 eq object.isDefault}">
                                                        默认
                                                    </c:if>
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w5}>
                                                <div title="${object.status}" style="width:50px;">
                                                    <c:if test="${1 eq object.status}">
                                                        启用
                                                    </c:if>
                                                    <c:if test="${0 eq object.status}">
                                                        禁用
                                                    </c:if>
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w10}>
                                                <a href="${ctx}/core/toUpdateFreightPage?freightId=${object.freightId}" role="button">更新</a>
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
