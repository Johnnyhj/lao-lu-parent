<%--
  Created by IntelliJ IDEA.
  User: jinlu
  Date: 2016/6/16
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<head>
    <title>数据字典</title>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@include file="/taglib.jsp" %>
</head>
<body>
<div class="con-box">
    <div class="container-fluid">

        <c:if test="${not empty body.data.ddId}">
            <form method="post" action="${ctx}/core/updateData">
        </c:if>
        <c:if test="${empty body.data.ddId}">
            <form method="post" action="${ctx}/core/addData">
        </c:if>

            <div class="row">
                <div class="col-md-12" style="margin-top: 5px;">
                    <button type="button" class="btn btn-primary pull-right" onclick="history.go(-1)">返回</button>
                </div>

                <div class="col-md-12">
                    <h3>${op}数据字典</h3>
                </div>

                <input type="hidden" name="ddId" value="${body.data.ddId}" />

                <div class="col-md-12">
                    <h5>主键：</h5>
                    <div class="con-area">
                        <div class="form-group col-md-4 ">
                            <input class="form-control" name="key" value="${body.data.key}" />
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <div class="col-md-12">
                    <h5>值：</h5>
                    <div class="con-area">
                        <div class="form-group col-md-6 ">
                            <input class="form-control" name="value" value="${body.data.value}" />
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <div class="col-md-12">
                    <h5>类型：</h5>
                    <div class="con-area">
                        <div class="form-group col-md-4">
                            <select class="form-control col-xs-10" name="type" id="type">
                                <option value=""></option>
                                <option value="webApp"
                                        <c:if test="${'webApp' eq body.data['type']}">selected</c:if> >Web系统
                                </option>
                                <option value="mgrApp"
                                        <c:if test="${'mgrApp' eq body.data['type']}">selected</c:if> >管理系统
                                </option>
                                <option value="qrtzApp"
                                        <c:if test="${'qrtzApp' eq body.data['type']}">selected</c:if> >定时系统
                                </option>
                                <option value="monitorApp"
                                        <c:if test="${'monitorApp' eq body.data['type']}">selected</c:if> >监控系统
                                </option>
                            </select>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <div class="col-md-12">
                    <h5>描述：</h5>
                    <div class="con-area">
                        <div class="form-group col-md-9 ">
                            <input class="form-control" name="describe" value="${body.data.describe}" />
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>

            <div style="padding: 10px; text-align:center">
                <button class="btn btn-sub">${body.op}</button>
            </div>
        </form>
    </div>
</div>

<script>
    $(document).ready(function(){
        setValidate();
    });

    function setValidate() {
        $("#data").validate({
            submitHandler: function(form){
                form.submit();
            },
            rules: {
                key : {
                    required:true,
                    maxlength:256
                },
                value : {
                    required:true,
                    maxlength:4000
                },
                type : {
                    required:true,
                    maxlength:256
                },
                describe : {
                    required:true,
                    maxlength:4000
                }
            }
        });
    }
</script>
</body>
</html>
