<%--
  Created by IntelliJ IDEA.
  User: guochunhao
  Date: 2016/8/11
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>日志信息详情</title>

    <%@include file="/taglib.jsp" %>
    <link rel="stylesheet" href="${asiaui}/css/edit.css">
    <link rel="stylesheet" href="${asiaui}/css/zTreeStyle/zTreeStyle.css">
    <script src="${asiaui}/js/jquery/jquery.ztree.all-3.5.min.js"></script>
    <script src="${asiaui}/js/jquery/bootstrap.min.js"></script>
    <script src="${asiaui}/js/jquery/jquery.validate.min.js"></script>
    <script src="${asiaui}/js/jquery/jquery.validate.language.js"></script>
    <script src="${asiaui}/js/commonCustom/log.js"></script>
    <script src="${asiaui}/js/commonCustom/commonConfig.js"></script>

    <style>
        ul.ztree {
            margin-top: 10px;
            border: 1px solid #617775;
            background: #f0f6e4;
            width: 200px;
            height: 230px;
            overflow-y: scroll;
            overflow-x: auto;
        }
    </style>
</head>
<body>
<div class="con-box">
    <div class="container-fluid">
        <button type="button" class="btn btn-primary pull-right" onclick="history.go(-1)">返回</button>

            <div class="row">
                <div class="col-md-12">
                        <h3>日志信息详情</h3>
                </div>

                <div style="padding: 12px 8px;">
                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                        日志信息详情
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                <div class="panel-body">
                                    <div id="customerDiv">
                                        <div class="col-md-12">
                                            <h5>日志操作者</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <p class="lead">${object.sysUser.username}</p>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <h5>被授权者姓名</h5>
                                            <div class="con-area">
                                                <div class="col-md-2 ">
                                                    <div class="con-area">
                                                        <div class="col-md-8 ">
                                                            <p class="lead">${object.authUserName}</p>
                                                        </div>
                                                        <div class="clearfix"></div>
                                                    </div>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>角色名称</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <p class="lead">${object.roleName}</p>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>授权角色列表</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <p class="lead">${object.authRoleName}</p>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>资源名称</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <p class="lead">${object.resourceName}</p>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>原值</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <textarea class="form-control" rows="3" name="remark" readonly>${object.oldVal}</textarea>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>新值</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <textarea class="form-control" rows="3" name="remark">${object.newVal}</textarea>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>授权类型</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <c:if test="${1 eq object.authType}">
                                                        <p class="lead">权限</p>
                                                    </c:if>
                                                    <c:if test="${2 eq object.authType}">
                                                        <p class="lead">角色</p>
                                                    </c:if>
                                                    <c:if test="${3 eq object.authType}">
                                                        <p class="lead">授权</p>
                                                    </c:if>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>操作类型</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <c:if test="${1 eq object.operateType}">
                                                        <p class="lead">新增</p>
                                                    </c:if>
                                                    <c:if test="${2 eq object.operateType}">
                                                    <p class="lead">修改</p>
                                                    </c:if>
                                                    <c:if test="${3 eq object.operateType}">
                                                    <p class="lead">删除</p>
                                                    </c:if>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>操作明细</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <p class="lead">${object.remark}</p>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>创建时间</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <p class="lead"><fmt:formatDate value='${object.createTime}' pattern='${df}'/></p>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>生效时间</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <p class="lead"><fmt:formatDate value='${object.effectiveTime}' pattern='${df}'/></p>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>

                                        <div class="col-md-12">
                                            <h5>失效时间</h5>

                                            <div class="con-area">
                                                <div class="col-md-8 ">
                                                    <p class="lead"><fmt:formatDate value='${object.failTime}' pattern='${df}'/></p>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

    </div>
</div>


</body>

<script type="text/javascript">
    $(document).ready(function () {
        customerManagerConfig.setValidate();
    });


</script>


</html>