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
        <form:form method="post" commandName="data">
            <div class="row">
                <div class="col-md-12" style="margin-top: 5px;">
                    <button type="button" class="btn btn-primary pull-right" onclick="history.go(-1)">返回</button>
                </div>

                <div class="col-md-12">
                    <h3><c:if test=" ${not empty op}">${op}数据字典</c:if>
                        <c:if test=" ${empty op}">详情</c:if></h3>
                </div>

                <form:hidden path="ddId"/>

                <div class="col-md-12">
                    <h5>主键：</h5>
                    <div class="con-area">
                        <div class="form-group col-md-4 ">
                            <form:input path="key" class="form-control"/>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <div class="col-md-12">
                    <h5>值：</h5>
                    <div class="con-area">
                        <div class="form-group col-md-6 ">
                            <form:input path="value" class="form-control"/>
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
                                        <c:if test="${'webApp' eq data['type']}">selected</c:if> >Web系统
                                </option>
                                <option value="mgrApp"
                                        <c:if test="${'mgrApp' eq data['type']}">selected</c:if> >管理系统
                                </option>
                                <option value="qrtzApp"
                                        <c:if test="${'qrtzApp' eq data['type']}">selected</c:if> >定时系统
                                </option>
                                <option value="monitorApp"
                                        <c:if test="${'monitorApp' eq data['type']}">selected</c:if> >监控系统
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
                            <form:input path="describe" class="form-control"/>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>

            <div style="padding: 10px; text-align:center">
                <form:button class="btn btn-sub">${op}</form:button>
            </div>
        </form:form>
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
