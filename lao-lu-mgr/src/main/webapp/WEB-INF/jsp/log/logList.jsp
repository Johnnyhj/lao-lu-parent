<%--
  Created by IntelliJ IDEA.
  User: 郭春浩
  Date: 2016/8/11
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>日志管理</title>
    <%@include file="/taglib.jsp" %>
    <script src="${asiaui}/js/jquery/bootstrap.min.js"></script>
    <script src="${asiaui}/js/commonCustom/log.js"></script>
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
                                <form id="frm" class="bs-example form-horizontal" action="${ctx}/mgr/log" method="post">
                                    <input type="hidden" id="page" name="page" value="1">

                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label class="col-xs-4 control-label wrapper-xs">日志操作用户</label>

                                            <div class="col-xs-8">
                                                <select class="form-control" id="sysUserId" name="sysUserId">
                                                    <option value="">全部</option>
                                                    <c:forEach items="${users}" var="user" varStatus="s">
                                                        <option value="${user.id}"
                                                                <c:if test="${user.id eq param['sysUserId']}">selected</c:if> >${user.username}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label class="col-xs-4 control-label wrapper-xs">授权类型</label>

                                            <div class="col-xs-8">
                                                <select id="authType" name="authType" class="form-control">
                                                    <option value="">全部</option>
                                                    <option value="1"
                                                            <c:if test="${1 eq authTypeTemp}">selected</c:if> >权限</option>
                                                    <option value="2"
                                                            <c:if test="${2 eq authTypeTemp}">selected</c:if> >角色</option>
                                                    <option value="3"
                                                            <c:if test="${3 eq authTypeTemp}">selected</c:if> >授权</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label class="col-xs-4 control-label wrapper-xs">操作类型</label>

                                            <div class="col-xs-8">
                                                <select id="operateType" name="operateType" class="form-control">
                                                    <option value="">全部</option>
                                                    <option value="1"
                                                            <c:if test="${1 eq operateTypeTemp}">selected</c:if> >新增</option>
                                                    <option value="2"
                                                            <c:if test="${2 eq operateTypeTemp}">selected</c:if> >修改</option>
                                                    <option value="3"
                                                            <c:if test="${3 eq operateTypeTemp}">selected</c:if> >删除</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label class="col-xs-4 control-label wrapper-xs">创建时间</label>
                                            <div class="col-xs-8">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" name="createTime" id="createTime" value="${createTimeTemp}">
                                                    <span class="input-group-btn">
                                                                <button class="btn btn-default" type="button" onclick="WdatePicker({el:'createTime', dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="height: 34px;">
                                                                    <i class="glyphicon glyphicon-calendar"></i>
                                                                </button>
                                                        </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-xs-4">
                                        <!--最后一排表单div记得添加'm-b-n-xxs'样式，清除间距-->
                                        <div class="form-group m-b-n-xxs">
                                            <label class="col-xs-4 control-label wrapper-xs"></label>

                                            <div class="col-xs-8">
                                                <button type="search" class="btn btn-primary padder-md">搜索</button>
                                                <button type="reset" class="btn btn-default padder-md" onclick="logConfig.resetOption();">重置</button>
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
                                        <th class="wd-md-1 text-C" ${w10}>序号</th>
                                        <th class="wd-md-1 text-C" ${w15}>日志操作用户</th>
                                        <th class="wd-md-2 text-C" ${w15}>操作时间</th>
                                        <th class="wd-md-2 text-C" ${w10}>授权类型</th>
                                        <th class="wd-md-2 text-C" ${w15}>操作类型</th>
                                        <th class="wd-md-2 text-C" ${w20}>操作明细</th>
                                        <th class="wd-md-2 text-C" ${w20}>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${object}" var="object" varStatus="s">
                                        <tr>
                                            <td class="wd-md-1 text-C" ${w10}>
                                                    ${object.processId}
                                            </td>
                                            <td class="wd-md-1 text-C" ${w15}>
                                                <div title="${object.sysUser.username}" style="width:180px;overflow: hidden;text-overflow:ellipsis; white-space:nowrap;">
                                                        ${object.sysUser.username}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w15}>
                                                <fmt:formatDate value="${object.createTime}" pattern="${df}" />
                                            </td>

                                            <td class="wd-md-2 text-C" ${w15}>
                                                <div title="${object.authType}" style="width:180px;overflow: hidden;text-overflow:ellipsis; white-space:nowrap;">
                                                    <c:if test="${1 eq object.authType}">
                                                        权限
                                                    </c:if>
                                                    <c:if test="${2 eq object.authType}">
                                                        角色
                                                    </c:if>
                                                    <c:if test="${3 eq object.authType}">
                                                        授权
                                                    </c:if>
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w15}>
                                                <div title="${object.operateType}" style="width:180px;overflow: hidden;text-overflow:ellipsis; white-space:nowrap;">
                                                    <c:if test="${1 eq object.operateType}">
                                                        新增
                                                    </c:if>
                                                    <c:if test="${2 eq object.operateType}">
                                                        修改
                                                    </c:if>
                                                    <c:if test="${3 eq object.operateType}">
                                                        删除
                                                    </c:if>
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w15}>
                                                <div title="${object.remark}" style="width:180px;overflow: hidden;text-overflow:ellipsis; white-space:nowrap;">
                                                        ${object.remark}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w15}>
                                                <%--<shiro:hasPermission name="logManage:delete">--%>
                                                    <a href="#" role="button" onclick="logConfig.deleteLog(this);">删除</a>|
                                                    <a href="${ctx}/mgr/log/queryLogDetail/${object.processId}" role="button">详情</a>
                                                <%--</shiro:hasPermission>--%>
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

<!-- 信息删除确认 -->
<div class="modal fade" id="delcfmModel">
    <div class="modal-dialog">
        <div class="modal-content message_align">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title">提示信息</h4>
            </div>
            <div class="modal-body">
                <p>您确认要删除吗？</p>
            </div>
            <div class="modal-footer">
                <input type="hidden" id="deleteId"/>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a onclick="logConfig.deleteLogConfirm()" class="btn btn-success" data-dismiss="modal">确定</a>
            </div>
        </div>
    </div>
</div>

</body>

<script type="text/javascript" src="${ctx}/asiaui/js/common/pageination.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        Pageination({
            currentPage: "${page.currentPage}",
            totalPages: "${page.totalPages}"
        });

    });


</script>
</html>
