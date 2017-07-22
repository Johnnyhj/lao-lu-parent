<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <title>用户配置</title>

    <%@taglib prefix="ecfn" uri="http://ec/tags/functions" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@include file="/taglib.jsp" %>

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
                                <form id="frm" class="bs-example form-horizontal" action="${ctx}/user" method="post">
                                    <input type="hidden" id="page" name="page" value="1">

                                    <shiro:hasPermission name="user:view">
                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <label class="control-label col-xs-4" for="username">用户名:</label>
                                                <div class="col-xs-8 no-padding-left no-padding-right">
                                                    <input type="text" class="form-control col-xs-10" name="username" id="username" value="${param['username']}" />
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <label class="control-label col-xs-4" for="userType">用户类型:</label>

                                                <div class="col-xs-8 no-padding-left no-padding-right">
                                                    <select class="form-control col-xs-10" name="userType" id="userType" value="${param['userType']}">
                                                        <option value="-1">全部</option>

                                                        <option value="0"
                                                            <c:if test="${0 eq param['userType']}">selected</c:if> >系统管理员</option>

                                                        <option value="1"
                                                                <c:if test="${1 eq param['userType']}">selected</c:if> >省级管理员</option>

                                                        <option value="2"
                                                                <c:if test="${2 eq param['userType']}">selected</c:if> >市级管理员</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <label class="control-label col-xs-4" for="userType">状态:</label>

                                                <div class="col-xs-8 no-padding-left no-padding-right">
                                                    <select class="form-control col-xs-10" name="locked" id="locked" value="${param['locked']}">
                                                        <option value="">全部</option>
                                                        <option value="0"
                                                                <c:if test="${0 eq param['locked']}">selected</c:if> >启用</option>
                                                        <option value="1"
                                                                <c:if test="${1 eq param['locked']}">selected</c:if> >已注销</option>
                                                        <option value="2"
                                                                <c:if test="${2 eq param['locked']}">selected</c:if> >待审核</option>
                                                        <option value="3"
                                                                <c:if test="${3
                                                                 eq param['locked']}">selected</c:if> >审核未通过</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <div>
                                                    <button class="btn btn-info" style="width:100px" id="search" type="submit">
                                                        <i class="icon-magnifier bigger-110"></i> 搜索
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </shiro:hasPermission>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-12" style="height: 50px;padding-left: 0px">
                    <shiro:hasPermission name="user:create">
                        <a href="${ctx}/user/create" >
                            <button class="btn btn-info" type="button">
                                <i class="icon-plus bigger-110"></i> 用户新增
                            </button>
                        </a>
                    </shiro:hasPermission>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                用户列表
                            </div>

                            <div class="table-responsive">
                                <c:set var="w5" value='style="width: 5%;"' />
                                <c:set var="w10" value='style="width: 10%;"' />
                                <c:set var="w15" value='style="width: 15%;"' />
                                <c:set var="w20" value='style="width: 20%;"' />
                                <c:set var="w25" value='style="width: 20%;"' />

                                <table class="table table-striped b-t b-light text-base" id="tree-table">
                                    <thead>
                                    <tr>
                                        <th class="wd-md-1 text-C" ${w5}>用户名</th>
                                        <th class="wd-md-1 text-C" ${w10}>所属组织</th>
                                        <th class="wd-md-2 text-C" ${w15}>菜单权限</th>
                                        <th class="wd-md-2 text-C" ${w5}>状态</th>
                                        <th class="wd-md-2 text-C" ${w5}>用户类型</th>
                                        <th class="wd-md-2 text-C" ${w15}>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tbd_objects">
                                        <c:forEach items="${userList}" var="user">
                                            <tr>
                                                <td>${user.username}</td>
                                                <td>${not empty user.primaryUserOrgaRel ? user.primaryUserOrgaRel.orgaName : ''}</td>
                                                <%--<td>${ecfn:roleNames(user.listRoleIds)}</td>--%>
                                                <td>
                                                    <c:if test="${not empty user.sysUserRoleReleations}">
                                                        <c:forEach items="${user.sysUserRoleReleations}" var="role">
                                                            ${role.sysRoleDesc}
                                                        </c:forEach>
                                                    </c:if>
                                                </td>
                                                <td>
                                                    <c:if test="${0 eq user.locked}">
                                                        启用
                                                    </c:if>
                                                    <c:if test="${0 ne user.locked}">
                                                        已注销
                                                    </c:if>
                                                </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${0 eq user.userType}">
                                                            系统管理员
                                                        </c:when>
                                                        <c:when test="${1 eq user.userType}">
                                                            省级管理员
                                                        </c:when>
                                                        <c:when test="${2 eq user.userType}">
                                                            市级管理员
                                                        </c:when>
                                                    </c:choose>
                                                </td>
                                                <td>
                                                    <shiro:hasPermission name="user:update">
                                                        <a href="${ctx}/user/${user.id}/update">修改</a> |
                                                    </shiro:hasPermission>

                                                    <shiro:hasPermission name="user:delete">
                                                        <a href="javascript:" class="user_delete" user_id="${user.id}">删除</a> |
                                                    </shiro:hasPermission>

                                                    <shiro:hasPermission name="user:update">
                                                        <c:if test="${0 eq user.locked}">
                                                            <a class="user_lock" href="javascript:" user_id="${user.id}" lock="1">注销</a> |
                                                        </c:if>
                                                        <c:if test="${0 ne user.locked}">
                                                            <a class="user_lock" href="javascript:" user_id="${user.id}" lock="0">启用</a> |
                                                        </c:if>
                                                    </shiro:hasPermission>

                                                    <shiro:hasPermission name="user:update">
                                                        <a href="${ctx}/user/${user.id}/changePassword">改密</a>
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

<script type="text/javascript" src="${ctx}/asiaui/js/common/pageination.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        Pageination({
            currentPage: "${page.currentPage}",
            totalPages: "${page.totalPages}"
        });


        $('a.user_lock', '#tbd_objects').click(function () {
            var $this = $(this);
            var lock = $this.attr('lock');

            if(confirm('是否确定' + (1 == lock ? '注销' : '启用') + '?')) {
                $.get('${ctx}/user/{user_id}/lock/{lock}'.render({'user_id' : $this.attr('user_id'), 'lock' : lock}), {}, function(resp){
                    if(1 == resp.result_code) {
                        alert((0 == lock ? '启用' : '注销') + '成功');
                        $this.parents('td').prev().prev().text((1 == lock ? '已注销' : '启用'));
                        $this.attr('lock', (1 == lock ? 0 : 1));
                        $this.html(1 == lock ? '启用' : '注销');
                    } else {
                        alert((1 == lock ? '启用' : '注销') + '失败');
                    }
                }, 'json');
            }
        });

        $('a.user_delete', '#tbd_objects').click(function () {
            var $this = $(this);
            var userId = $this.attr('user_id');

            if(confirm('是否确定删除?')) {
                $.get('${ctx}/user/{user_id}/delete'.render({'user_id' : userId}), {}, function(resp){
                        alert(resp.result_msg);
                        window.location.href = '${ctx}/user';
                }, 'json');
            }
        });
    });
</script>
</body>
</html>