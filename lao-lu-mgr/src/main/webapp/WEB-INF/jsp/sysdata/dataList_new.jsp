<%--
  Created by IntelliJ IDEA.
  User: jinlu
  Date: 2016/6/16
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>数据字典配置</title>
    <%@include file="/taglib.jsp" %>

    <style>
        table tr div {
            width: 200px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            /*width: 200px;*/
        }
    </style>
</head>
<body>
<div flex="" layout="column">
    <div ui-butterbar="" class="butterbar hide"><span class="bar"></span></div>
    <a href="" class="off-screen-toggle hide" ui-toggle-class="off-screen" data-target=".md-aside"></a>

    <div class="md-content ng-scope" ui-view=""><!-- uiView:  -->
        <div ui-view="" class="fade-in-down ">
            <div class="wrapper-md">
                <!--确认消息-->
                <%@include file="../confirmMessage.jsp" %>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel wrapper panel-default">
                            <div class="panel-body">
                                <form id="frm" class="bs-example form-horizontal" action="${ctx}/core/sysData" method="post">
                                    <input type="hidden" id="page" name="page" value="1">

                                    <%--<shiro:hasPermission name="user:view">--%>
                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <label class="control-label col-xs-4" for="key">键值:</label>

                                                <div class="col-xs-8 no-padding-left no-padding-right">
                                                    <input type="text" class="form-control col-xs-10" name="key"
                                                           id="key" value="${param['key']}"/>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <label class="control-label col-xs-4" for="type">类型:</label>

                                                <div class="col-xs-8 no-padding-left no-padding-right">
                                                    <select class="form-control col-xs-10" name="type" id="type">
                                                        <option value=""></option>
                                                        <option value="webApp"
                                                                <c:if test="${'webApp' eq param['type']}">selected</c:if> >
                                                            Web系统
                                                        </option>
                                                        <option value="mgrApp"
                                                                <c:if test="${'mgrApp' eq param['type']}">selected</c:if> >
                                                            管理系统
                                                        </option>
                                                        <option value="qrtzApp"
                                                                <c:if test="${'qrtzApp' eq param['type']}">selected</c:if> >
                                                            定时系统
                                                        </option>
                                                        <option value="monitorApp"
                                                                <c:if test="${'monitorApp' eq param['type']}">selected</c:if> >
                                                            监控系统
                                                        </option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <div>
                                                    <button class="btn btn-info" style="width:100px" id="search"
                                                            type="submit">
                                                        <i class="icon-magnifier bigger-110"></i> 搜索
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    <%--</shiro:hasPermission>--%>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-12" style="height: 50px;padding-left: 0px">
                    <shiro:hasPermission name="sysdata:create">
                        <a href="${ctx}/core/toCreateDataPage">
                            <button class="btn btn-info" type="button">
                                <i class="icon-plus bigger-110"></i> 新增数据
                            </button>
                        </a>
                    </shiro:hasPermission>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                数据列表
                            </div>

                            <div class="table-responsive">
                                <c:set var="w5" value='style="width: 5%;"'/>
                                <c:set var="w10" value='style="width: 10%;"'/>
                                <c:set var="w15" value='style="width: 15%;"'/>
                                <c:set var="w40" value='style="width: 20%;"'/>
                                <c:set var="w35" value='style="width: 20%;"'/>

                                <table class="table table-striped b-t b-light text-base">
                                    <thead>
                                    <tr>
                                        <th class="wd-md-1 text-C" ${w10}>数据键</th>
                                        <th class="wd-md-2 text-C" ${w35}>数据值</th>
                                        <th class="wd-md-2 text-C" ${w10}>数据类型</th>
                                        <th class="wd-md-2 text-C" ${w40}>描述</th>
                                        <th class="wd-md-2 text-C" ${w5}>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${body.dataList}" var="data">
                                            <tr>
                                                <td>${data.key}</td>
                                                <td>
                                                    <div title="${data.value}">${data.value}</div>
                                                </td>
                                                <td>${data.type}</td>
                                                <td>
                                                    <div>${data.describe}</div>
                                                </td>
                                                <td>
                                                    <%--<shiro:hasPermission name="sysdata:view">
                                                        <a href="${ctx}/sysdata/${data.ddId}/detail"> 详情 </a>
                                                    </shiro:hasPermission>--%>
                                                    <shiro:hasPermission name="sysdata:update">
                                                        <a href="${ctx}/core/toUpdateDataPage?ddId=${data.ddId}"> 修改 </a>
                                                    </shiro:hasPermission>
                                                    <shiro:hasPermission name="sysdata:delete">
                                                        <a class="deleteBtn" href="#" data-id="${data.ddId}">删除</a>
                                                    </shiro:hasPermission>
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
                                                <input type="number" class="form-control" id="toPageText"
                                                       placeholder="页"/>
                                    <span class="input-group-btn">
                                        <button id="toPageBtn" class="btn btn-default" type="button"
                                                style="width: 40px;padding:6px;">Go
                                        </button>
                                      </span>
                                            </div>
                                        </div>
                                        <ul id="example" class="pagination" style="float: right;"></ul>
                                        <span class="pull-right"
                                              style="padding: 26px 14px;font-size: 16px;">总共 ${body.page.totalRows} 条</span>
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

<script type="text/javascript" src="${ctx}/asiaui/js/common/pageination.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        Pageination({
            currentPage: "${body.page.currentPage}",
            totalPages: "${body.page.totalPages}"
        });

        $(".deleteBtn").click(function() {
            if(confirm("确认删除吗?")) {
                location.href = "${ctx}/core/deleteData?ddId="+$(this).data("id");
            }
        });
    });
</script>
</body>
</html>
