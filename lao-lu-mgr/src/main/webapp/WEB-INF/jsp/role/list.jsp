<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>角色管理</title>
    <%@taglib prefix="ecfn" uri="http://ec/tags/functions" %>
    <%@include file="/taglib.jsp" %>

    <%--<link rel="stylesheet" href="${ctx}/asiaui/js/jquery/themes/default/easyui.css" type="text/css">--%>
    <%--<link rel="stylesheet" href="${ctx}/asiaui/js/jquery/themes/icon.css" type="text/css">--%>
    <%--<script src="${ctx}/asiaui/js/jquery/jquery.easyui.min.js"></script>--%>

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

                <div class="col-lg-12" style="height: 50px;padding-left: 0px">
                    <shiro:hasPermission name="role:create">
                        <a href="${ctx}/role/create">
                            <button class="btn btn-info" type="button">
                                <i class="icon-plus bigger-110"></i> 角色新增
                            </button>
                        </a>
                    </shiro:hasPermission>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">

                            <div class="table-responsive">
                                <table class="table table-striped b-t b-light text-base" id="tree-table">
                                    <c:set var="w10" value='style="width: 10%;"' />
                                    <c:set var="w15" value='style="width: 15%;"' />
                                    <c:set var="w60" value='style="width: 60%;"' />

                                    <thead>
                                    <tr>
                                        <th class="wd-md-1 text-C" ${w10}>角色名称</th>
                                        <th class="wd-md-1 text-C" ${w60}>角色描述</th>
                                        <%--<th class="wd-md-1 text-C" ${w60}>拥有的资源</th>--%>
                                        <th class="wd-md-1 text-C" ${w15}>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${roleList}" var="role">
                                        <tr>
                                            <td>${role.role}</td>
                                            <td>${role.description}</td>
                                                <%--<td>
                                                    <ul class="easyui-tree">
                                                        <c:forEach var="res" items="${role.resourceIds}" varStatus="status">
                                                            <c:choose>
                                                                <c:when test="${'{' eq res}">
                                                                    <ul>
                                                                </c:when>
                                                                <c:when test="${'}' eq res}">
                                                                    </ul>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    &lt;%&ndash;<c:if test="${0 ne status.index}">&ndash;%&gt;
                                                                        &lt;%&ndash;</li>&ndash;%&gt;
                                                                    &lt;%&ndash;</c:if>&ndash;%&gt;
                                                                    <li><span>${res}</span></li>
                                                                </c:otherwise>
                                                            </c:choose>

                                                        </c:forEach>

                                                    </ul>

                                                    &lt;%&ndash;<textarea type="text" rows="4" style="width: 100%;white-space: normal" readonly>${ecfn:resourceNames(role.listResourceIds)}</textarea>&ndash;%&gt;
                                                </td>--%>
                                            <td>
                                                <shiro:hasPermission name="role:update">
                                                    <a href="${ctx}/role/${role.id}/update">修改</a>
                                                </shiro:hasPermission>

                                                <shiro:hasPermission name="role:delete">
                                                    <a href="${ctx}/role/${role.id}/delete">删除</a>
                                                </shiro:hasPermission>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>


</body>
</html>