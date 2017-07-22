<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增/修改节点</title>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@include file="/taglib.jsp" %>

    <link rel="stylesheet" href="${asiaui}/css/edit.css">

</head>
<body>
<div class="con-box">
    <div class="container-fluid">
        <div class="col-md-12" style="margin-top: 5px;">
            <button type="button" class="btn btn-primary pull-right" onclick="history.go(-1)">返回</button>
        </div>

            <c:if test="${not empty body.resource.id}">
                <form method="post" action="${ctx}/core/updateResource">
            </c:if>
            <c:if test="${empty body.resource.id}">
                <form method="post" action="${ctx}/core/addResource">
            </c:if>

            <input type="hidden" value="${body.resource.id}" name="id" />
            <input type="hidden" value="${body.resource.available}" name="available" />
            <input type="hidden" value="${body.resource.parentId}" name="parentId" />
            <input type="hidden" value="${body.resource.parentIds}" name="parentIds" />

            <div class="row">

                <c:if test="${not empty body.parent}">
                    <div class="col-md-12">
                        <h5>父节点名称： ${body.parent.name}</h5>
                    </div>
                </c:if>

                <div class="col-md-12">
                    <h5><c:if test="${not empty body.parent}">子</c:if>名称：</h5>
                    <div class="con-area">
                        <div class="col-md-8">
                            <input class="form-control" type="text" value="${body.resource.name}" name="name" />
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <div class="col-md-12">
                    <h5>类型：</h5>
                    <div class="con-area">
                        <div class="col-md-8">
                            <select class="form-control" name="type">
                                <c:forEach items="${body.types}" var="type">
                                    <option value="${type}" ${type == body.resource.type ? "selected" : ""}>${type}</option>

                                </c:forEach>
                            </select>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <div class="col-md-12">
                    <h5>URL路径：</h5>
                    <div class="con-area">
                        <div class="col-md-8">
                            <input  class="form-control" type="text" value="${body.resource.url}" name="url" />
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <div class="col-md-12">
                    <h5>权限字符串：</h5>
                    <div class="con-area">
                        <div class="col-md-8">
                            <input class="form-control" type="text" value="${body.resource.permission}" name="permission" />
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>


            </div>

            <div style="padding: 10px; text-align:center">
                <%--<form:button class="btn btn-sub">${body.op}</form:button>--%>
                <button class="btn btn-sub">${body.op}</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>