<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<head>
    <title>用户配置</title>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="ecfn" uri="http://ec/tags/functions" %>
    <%@include file="/taglib.jsp" %>


    <link rel="stylesheet" href="${ctx}/asiaui/js/JQuery zTree v3.5.15/css/demo.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/asiaui/js/JQuery zTree v3.5.15/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="${ctx}/asiaui/js/JQuery zTree v3.5.15/js/jquery.ztree.core-3.5.js"></script>
    <script type="text/javascript" src="${ctx}/asiaui/js/jquery/jquery.ztree.all-3.5.min.js"></script>

    <script src="${asiaui}/js/commonCustom/user.js"></script>
    <script src="${asiaui}/js/commonCustom/commonConfig.js"></script>

    <style>
        ul.ztree {
            margin-top: 10px;
            border: 1px solid #617775;
            background: #f0f6e4;
            width: 220px;
            height: 260px;
            overflow-y: scroll;
            overflow-x: auto;
        }
    </style>

</head>
<body>
<div class="con-box">
    <div class="container-fluid">
        <form:form id="frm_object" method="post" commandName="user">
            <div class="row">
                <div class="col-md-12" style="margin-top: 5px;">
                    <button type="button" class="btn btn-primary pull-right" onclick="history.go(-1)">返回</button>
                </div>

                <div class="col-md-12">
                    <h3>${op}用户</h3>
                </div>

                <form:hidden path="id" />
                <form:hidden path="salt" />
                    <%--<form:hidden path="locked"/>--%>

                <c:if test="${op ne '新增'}">
                    <form:hidden path="password" />
                </c:if>

                <div class="col-md-12">
                    <h5>用户名：</h5>

                    <div class="con-area">
                        <div class="form-group col-md-4 ">
                            <input type="text" name="username" class="form-control" value="${user.username}" <c:if test="${not empty user.id}">disabled</c:if>/>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <c:if test="${op eq '新增'}">
                    <div class="col-md-12">
                        <h5>密码：</h5>

                        <div class="con-area">
                            <div class="form-group col-md-4 ">
                                <form:password path="password" class="form-control" />
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <h5>确认密码：</h5>

                        <div class="con-area">
                            <div class="form-group col-md-4 ">
                                <input type="password" id="password2" name="password2" class="form-control">
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </c:if>

                <div class="col-md-12">
                    <h5>电话：</h5>

                    <div class="con-area">
                        <div class="form-group col-md-4 ">
                            <form:input path="telPhone" class="form-control" />
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>


                <div class="col-md-12">
                    <h5>邮箱：</h5>

                    <div class="con-area">
                        <div class="form-group col-md-4 ">
                            <form:input path="email" class="form-control" />
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <div class="col-md-12">
                    <h5>用户类型：</h5>

                    <div class="con-area">
                        <div class="form-group col-md-4 ">
                            <form:select  path="userType" class="form-control">
                                <form:option value="0">系统管理员</form:option>
                                <form:option value="1">省级管理员</form:option>
                                <form:option value="2">市级管理员</form:option>
                            </form:select>

                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <div class="col-md-12">
                    <h5>区域权限列表：</h5>

                    <div class="con-area">
                        <div class="form-group col-md-4">
                            <div class="input-group">
                                <input id="areaId" type="hidden" name="tempAreaId" value="${user.tempAreaId}"/>
                                <input id="areaName" type="text" class="form-control" name="areaName" value="${user.systemArea.areaName}" readonly>

                                <div class="input-group-addon btn" type="button">
                                    <a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <div class="col-md-12">
                    <h5>菜单权限列表：</h5>
                    <input id="btn_add_role" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target=".bs-example-modal-lg" value="新增角色" />

                    <div class="con-area">

                        <table class="table table-striped b-t b-light text-base">
                            <thead>
                            <tr>
                                <th class="wd-md-1 text-C" ${w5}>角色名称</th>
                                <th class="wd-md-1 text-C" ${w5}>角色描述</th>
                                <th class="wd-md-2 text-C" ${w15}>生效时间</th>
                                <th class="wd-md-2 text-C" ${w5}>失效时间</th>
                                <th class="wd-md-2 text-C" ${w15}>操作</th>
                            </tr>
                            </thead>
                            <tbody id="tbd_role">
                            <c:if test="${not empty user.sysUserRoleReleations}">
                                <c:forEach var="rel" items="${user.sysUserRoleReleations}">
                                    <tr>
                                        <input type="hidden" name="sysRoleId" value="${rel.sysRoleId}">
                                        <input type="hidden" name="effectiveTime" value="<fmt:formatDate value="${rel.effectiveTime}" pattern="${df}" />">
                                        <input type="hidden" name="failTime" value="<fmt:formatDate value="${rel.failTime}" pattern="${df}" />">

                                        <td>${rel.sysRoleName}</td>
                                        <td>${rel.sysRoleDesc}</td>
                                        <td><fmt:formatDate value="${rel.effectiveTime}" pattern="${df}" /></td>
                                        <td><fmt:formatDate value="${rel.failTime}" pattern="${df}" /></td>
                                        <td>
                                            <a class="edit" href="javascript:">编辑</a>
                                            <a class="delete" href="javascript:">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>

                            </tbody>
                        </table>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <div class="col-md-12">
                    <h5>状态：</h5>

                    <div class="con-area">
                        <div class="form-group col-md-4 ">
                            <form:select path="locked" class="form-control">
                                <form:option value="0">启用</form:option>
                                <form:option value="1">已注销</form:option>
                            </form:select>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <div style="padding:24px 0;margin: 20px; text-align:center">
                    <button id="btn_form_submit" type="button" class="btn btn-primary">提&nbsp;&nbsp;&nbsp;&nbsp;交</button>
                </div>
            </div>
        </form:form>
    </div>
</div>


<!-- Modal -->
<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">角色关联</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="roleName" class="col-sm-2 control-label">角色名称</label>

                        <div class="col-sm-10">
                            <select id="roleName" class="form-control" style="width: 160px;">
                                <c:forEach var="r" items="${roleList}">
                                    <option value="${r.id}" title="${r.description}">${r.role}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="effectiveTime" class="col-sm-2 control-label">生效时间</label>

                        <div class="col-sm-6">
                            <div class="input-group">
                                <input type="text" class="form-control" name="effectiveTime" id="effectiveTime" />
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="button" onclick="WdatePicker({el:'effectiveTime', dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                                                style="height: 34px;">
                                            <i class="glyphicon glyphicon-calendar"></i>
                                        </button>
                                    </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="failTime" class="col-sm-2 control-label">失效时间</label>

                        <div class="col-sm-6">
                            <div class="input-group">
                                <input type="text" class="form-control" name="failTime" id="failTime" />
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="button" onclick="WdatePicker({el:'failTime', dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                                                style="height: 34px;">
                                            <i class="glyphicon glyphicon-calendar"></i>
                                        </button>
                                    </span>
                            </div>
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="btn_dialog_save" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>


<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
    <ul id="treeDemo" class="ztree" style="margin-top:0; width:388px;"></ul>
</div>


<script>
    var getTemplateText = function (object) {
        var text = '<tr>' +
                '<input type="hidden" name="sysRoleId" value="{sysRoleId}">' +
                '<input type="hidden" name="effectiveTime" value="{effectiveTime}">' +
                '<input type="hidden" name="failTime" value="{failTime}">' +
                '<td>{sysRoleName}</td>' +
                '<td>{sysRoleDesc}</td>' +
                '<td>{effectiveTime}</td>' +
                '<td>{failTime}</td>' +
                '<td><a class="edit" href="javascript:;">编辑</a> <a class="delete" href="javascript:;">删除</a></td>' +
                '</tr>';

        return text.render(object);
    };


    var getTableBody = function () {
        return $('#tbd_role');
    };

    var getModel = function () {
        return $('#myModal');
    };


    var ObjectFun = function () {
        var $this = this;
        this.getFuns = {
            saveDialog: function () {
                var $model = getModel();

                var $roleName = $('#roleName', $model);

                var $option = $("option:selected", $roleName);


                var object = {
                    sysRoleId: $option.val(),
                    sysRoleName: $option.text(),
                    sysRoleDesc: $option.attr('title')
                };

                var effectiveTime = $('#effectiveTime').val();
                if ('' != effectiveTime) {
                    object.effectiveTime = effectiveTime;
                }

                var failTime = $('#failTime').val();
                if ('' != failTime) {
                    object.failTime = failTime;
                }

                if (1 == getModel().data('edit')) {
                    var event = getModel().data('event');
                    $this.getFuns.update(getTableBody(), object, event);

                    getModel().data('edit', '');
                } else {
                    $this.getFuns.append(getTableBody(), object);
                }

                $this.getFuns.hideModel();
                $this.getFuns.cleanModel();
            },
            append: function (renderObject, renderParams) {
                renderObject.append(getTemplateText(renderParams));
            },

            update: function (renderObject, renderParams, event) {
                var $tr = $(event.target).parents('tr');
                var time = $tr.data('t');

                var templateText = getTemplateText(renderParams);
                renderObject.find('tr[t=' + time + ']').replaceWith(templateText);
            },

            getRoleObject: function ($tr) {
                var $roles = $(':hidden', $tr);
                var object = {};
                $.each($roles, function (index, role) {
                    var $role = $(role);
                    object[$role.attr('name')] = $role.val();
                });

                return object;
            },

            edit: function (event) {
                var $target = $(event.target);
                var $tr = $target.parents('tr');
                var role = $this.getFuns.getRoleObject($tr);
                var time = new Date().getTime();
                $tr.attr('t', time);

                $tr.data('t', time);
                $this.getFuns.setModelVal(role, event);
                $this.getFuns.showModel();
            },

            del: function (event) {
                var $target = $(event.target);
                $target.parents('tr').remove();
            },

            setModelVal: function (object, event) {
                var $roles = $(':text', getModel());
                $.each($roles, function (index, role) {
                    var $role = $(role);
                    $role.val(object[$role.attr('name')]);
                });
                $('#roleName option[value=' + object.sysRoleId + ']', getModel()).attr('selected', 'selected');

                getModel().data('edit', 1);
                getModel().data('event', event);
            },

            getUserRoleRel: function () {
                var $trs = $('tr', getTableBody());

                var objects = [];

                $.each($trs, function (index, tr) {
                    var $hidden = $(':hidden', $(tr));
                    var object = [];

                    $.each($hidden, function (j, hid) {
                        var $hid = $(hid);

                        if ('' != $hid.val()) {
                            object.push('<input type="hidden" name="sysUserRoleReleations[' + index + '].' + $hid.attr('name') + '" value="' + $hid.val() + '"/>')

                        }
                    });
                    objects.push(object.join(''));
                });

                return objects.join('');
            },

            formSubmit: function () {
                var $frmObject = $('#frm_object');
                $frmObject.append($this.getFuns.getUserRoleRel());

                $frmObject.submit();
            },

            cleanModel: function () {
                $(':text', getModel()).text('');
            },

            showModel: function () {
                getModel().modal('show');
            },

            hideModel: function () {
                getModel().modal('hide');
            }
        };
    };


    $(function () {
        var objectFun = new ObjectFun();


        //Event Bind
        (function () {
            $('#btn_dialog_save').click(objectFun.getFuns.saveDialog);
            $('#btn_form_submit').click(objectFun.getFuns.formSubmit);


            getTableBody().on('click', 'a.edit', objectFun.getFuns.edit);
            getTableBody().on('click', 'a.delete', objectFun.getFuns.del);


            //Form URL地址
            <c:choose>
            <c:when test="${not empty user.id}">
            $('#frm_object').attr('action', '${ctx}/user/${user.id}/update');
            </c:when>
            <c:otherwise>
            $('#frm_object').attr('action', '${ctx}/user/create');
            </c:otherwise>
            </c:choose>

        })();
    });
</script>


<SCRIPT type="text/javascript">
    var setting = {
        view: {
            dblClickExpand: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeClick: beforeClick,
            onClick: onClick
        }
    };

    <%--var zNodes = $.parseJSON('${sysOrganizationJson}');--%>

    var zNodes =[
        <c:forEach items="${areaList}" var="area">
        { id:${area.areaId}, pId:${area.parAreaId}, name:"${area.areaName}"},
        </c:forEach>
    ];

    function beforeClick(treeId, treeNode) {
        // 如果选择的是省级管理员，只能选择省级区域
        if (1 == $("#userType").val())
        {
            var check = (treeNode && treeNode.isParent);
             if (!check) alert("只能选择省级区域...");
             return check;
        }
        if (2 == $("#userType").val())
        {
            var check = (treeNode && !treeNode.isParent);
             if (!check) alert("只能选择市级区域...");
             return check;
        }
    }

    function onClick(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
                nodes = zTree.getSelectedNodes();
        nodes.sort(function compare(a, b) {
            return a.id - b.id;
        });

        var object = {
            text : '',
            value : ''
        };

        for (var i = 0, l = nodes.length; i < l; i++) {
            object.text += nodes[i].name + ",";
            object.value += nodes[i].id + ",";
        }
        if (object.text.length > 0) {
            object.text = object.text.substring(0, object.text.length - 1);
            object.value = object.value.substring(0, object.value.length - 1);
        }

        $("#areaName").val(object.text);
        $("#areaId").val(object.value);
    }

    function showMenu() {
        var cityObj = $("#areaName");
        var cityOffset = $("#areaName").offset();
        $("#menuContent").css({left: cityOffset.left + "px", top: cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

        $("body").bind("mousedown", onBodyDown);
    }
    function hideMenu() {
        $("#menuContent").fadeOut("fast");
        $("body").unbind("mousedown", onBodyDown);
    }
    function onBodyDown(event) {
        if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length > 0)) {
            hideMenu();
        }
    }

    $(document).ready(function () {
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);

        // 初始化zNodes
        <%--var area_zNodes =[--%>
            <%--<c:forEach items="${areaList}" var="area">--%>
            <%--{ id:${area.areaId}, pId:${area.parAreaId}, name:"${area.areaName}", checked:${ecfn:in(areaIdList, area.areaId)}},--%>
            <%--</c:forEach>--%>
        <%--];--%>
        <%--userConfig.initzTree(area_zNodes, true);--%>

        setValidate();

    });

    function setValidate() {
        $("#frm_object").validate({
            submitHandler : function (form) {
                form.submit();
            },
            rules: {
                telPhone : {
                    required:true
                },
                username : {
                    required:true
                },
                password : {
                    required:true
                },
                password2 : {
                    required:true
                }
            }
        });
    }

</SCRIPT>

</body>
</html>