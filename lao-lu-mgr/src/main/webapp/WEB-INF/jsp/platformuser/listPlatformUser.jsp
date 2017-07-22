<%--
  Created by IntelliJ IDEA.
  User: 郭春浩
  Date: 2017/5/18
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>平台用户管理</title>
    <%@include file="/taglib.jsp" %>
    <script src="${asiaui}/js/jquery/bootstrap.min.js"></script>
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
                                <form id="frm" class="bs-example form-horizontal" action="${ctx}/core/platformUser" method="post">
                                    <input type="hidden" id="page" name="page" value="1">

                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label class="col-xs-4 control-label wrapper-xs">真实姓名:</label>

                                            <div class="col-xs-8">
                                                <div class="col-xs-8 no-padding-left no-padding-right">
                                                    <input type="text" class="form-control col-xs-10" name="realName" id="realName" value="${param['realName']}" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label class="col-xs-4 control-label wrapper-xs">手机号码:</label>

                                            <div class="col-xs-8">
                                                <div class="col-xs-8 no-padding-left no-padding-right">
                                                    <input type="text" class="form-control col-xs-10" name="mobile" id="mobile" value="${param['mobile']}" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label class="col-xs-4 control-label wrapper-xs">证件号码:</label>

                                            <div class="col-xs-8">
                                                <div class="col-xs-8 no-padding-left no-padding-right">
                                                    <input type="text" class="form-control col-xs-10" name="certNo" id="certNo" value="${param['certNo']}" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-xs-4">
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
                                        <th class="wd-md-1 text-C" ${w10}>用户ID</th>
                                        <th class="wd-md-1 text-C" ${w15}>用户类型</th>
                                        <th class="wd-md-2 text-C" ${w15}>用户状态</th>
                                        <th class="wd-md-2 text-C" ${w10}>证件类型</th>
                                        <th class="wd-md-2 text-C" ${w15}>证件号</th>
                                        <th class="wd-md-2 text-C" ${w20}>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${body.list}" var="object" varStatus="s">
                                        <tr>
                                            <td class="wd-md-1 text-C" ${w15}>
                                                <div title="${object.userId}" style="width:180px;overflow: hidden;text-overflow:ellipsis; white-space:nowrap;">
                                                        ${object.userId}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w15}>
                                                <div title="${object.userTypeValue}" style="width:180px;overflow: hidden;text-overflow:ellipsis; white-space:nowrap;">
                                                    <c:if test="${1 eq object.userTypeValue}">
                                                        公司
                                                    </c:if>
                                                    <c:if test="${2 eq object.userTypeValue}">
                                                        个人
                                                    </c:if>
                                                </div>
                                            </td>

                                            <%--Q代表快速注册用户
                                                T代表已认证用户
                                                B代表被冻结账户
                                                W代表已注册，未激活的账户
                                                --%>
                                            <td class="wd-md-2 text-C" ${w15}>
                                                <div title="${object.userStatus}" style="width:180px;overflow: hidden;text-overflow:ellipsis; white-space:nowrap;">
                                                    <c:if test="${'Q' eq object.userStatus}">
                                                        快速注册
                                                    </c:if>
                                                    <c:if test="${'T' eq object.userStatus}">
                                                        已认证
                                                    </c:if>
                                                    <c:if test="${'B' eq object.userStatus}">
                                                        被冻结
                                                    </c:if>
                                                    <c:if test="${'W' eq object.userStatus}">
                                                        已注册，未激活
                                                    </c:if>
                                                </div>
                                            </td>

                                            <%--
                                            证件类型:
                                                0:身份证
                                                1:护照
                                                2:军官证
                                                3:士兵证
                                                4:回乡证
                                                5:临时身份证
                                                6:户口簿
                                                7:警官证
                                                8:台胞证
                                                9:营业执照
                                                10其它证件
                                            --%>

                                            <td class="wd-md-2 text-C" ${w15}>
                                                <div title="${object.certTypeValue}" style="width:180px;overflow: hidden;text-overflow:ellipsis; white-space:nowrap;">
                                                    <c:if test="${0 eq object.certTypeValue}">
                                                        身份证
                                                    </c:if>
                                                    <c:if test="${1 eq object.certTypeValue}">
                                                        护照
                                                    </c:if>
                                                    <c:if test="${2 eq object.certTypeValue}">
                                                        军官证
                                                    </c:if>
                                                    <c:if test="${3 eq object.certTypeValue}">
                                                        士兵证
                                                    </c:if>
                                                    <c:if test="${4 eq object.certTypeValue}">
                                                        回乡证
                                                    </c:if>
                                                    <c:if test="${5 eq object.certTypeValue}">
                                                        临时生分证
                                                    </c:if>
                                                    <c:if test="${6 eq object.certTypeValue}">
                                                        户口簿
                                                    </c:if>
                                                    <c:if test="${7 eq object.certTypeValue}">
                                                        警官证
                                                    </c:if>
                                                    <c:if test="${8 eq object.certTypeValue}">
                                                        台胞证
                                                    </c:if>
                                                    <c:if test="${9 eq object.certTypeValue}">
                                                        营业执照
                                                    </c:if>
                                                    <c:if test="${10 eq object.certTypeValue}">
                                                        其他证件
                                                    </c:if>
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w15}>
                                                <div title="${object.certNo}" style="width:180px;overflow: hidden;text-overflow:ellipsis; white-space:nowrap;">
                                                    ${object.certNo}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w15}>
                                                <a href="${ctx}/core/platformUserDetail?id=${object.id}" role="button">详情</a>
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
                                        <span class="pull-right" style="padding: 26px 14px;font-size: 16px;">总共 ${page.totalRows} 条</span>
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
