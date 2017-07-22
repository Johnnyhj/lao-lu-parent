<%--
  Created by IntelliJ IDEA.
  User: 郭春浩
  Date: 2017/5/19
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>号码管理</title>
    <%@include file="/taglib.jsp" %>
    <script src="${asiaui}/js/commonCustom/commonConfig.js"></script>

    <script src="${asiaui}/js/jquery/fileUpload/js/vendor/jquery.ui.widget.js"></script>
    <script src="${asiaui}/js/jquery/fileUpload/js/jquery.iframe-transport.js"></script>
    <script src="${asiaui}/js/jquery/fileUpload/js/jquery.fileupload.js"></script>

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
                                <form id="frm" class="bs-example form-horizontal" action="${ctx}/core/listNumber" method="post">
                                    <input type="hidden" id="page" name="page" value="1">

                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label class="col-xs-4 control-label wrapper-xs">号码:</label>

                                            <div class="col-xs-8">
                                                <input type="text" class="form-control col-xs-10" name="tempNumber" id="number" value="${param['tempNumber']}" />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label class="col-xs-4 control-label wrapper-xs">状态:</label>

                                            <%--
                                                -1：失效，
                                                0：初始状态，
                                                1：预占，
                                                2：卖出
                                            --%>
                                            <div class="col-xs-8">
                                                <select id="status" name="tempStatus" class="form-control">
                                                    <option value="-2">全部</option>
                                                    <option value="-1"
                                                            <c:if test="${-1 eq param['tempStatus']}">selected</c:if> >失效</option>
                                                    <option value="0"
                                                            <c:if test="${0 eq param['tempStatus']}">selected</c:if> >初始状态</option>
                                                    <option value="1"
                                                            <c:if test="${1 eq param['tempStatus']}">selected</c:if> >预占</option>
                                                    <option value="2"
                                                            <c:if test="${2 eq param['tempStatus']}">selected</c:if> >卖出</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="col-xs-4">
                                        <div class="form-group m-b-n-xxs">
                                            <label class="col-xs-4 control-label wrapper-xs"></label>

                                            <div class="col-xs-8">
                                                <button id="search" type="search" class="btn btn-primary padder-md">搜索</button>
                                                <%--<button type="reset" class="btn btn-default padder-md" onclick="logConfig.resetOption();">重置</button>--%>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-12" style="height: 50px;padding-left: 0px">
                    <a href="${ctx}/core/toAddNumberPageMain" >
                        <button class="btn btn-info" type="button">
                            <i class="icon-plus bigger-110"></i> 新增号码
                        </button>
                    </a>

                    <a href="${asiaui}/number_template.xls">
                        <button class="btn btn-info" style="width:160px" type="button">
                            <i class="bigger-110"></i> 下载手机号码模板
                        </button>
                    </a>

                    <a href="#" id="btn_uploader">
                        <button class="btn btn-info" style="width:160px" type="button">
                            <i class="bigger-110"></i> 上传
                        </button>
                    </a>

                    &nbsp; &nbsp; &nbsp;
                    <input type="file" name="files" id="fileupload_input" style="display: none;"/>

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
                                        <th class="wd-md-1 text-C" ${w5}>号码</th>
                                        <th class="wd-md-1 text-C" ${w10}>状态</th>
                                        <th class="wd-md-2 text-C" ${w10}>地区</th>
                                        <th class="wd-md-2 text-C" ${w10}>创建时间</th>
                                        <th class="wd-md-2 text-C" ${w10}>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${body.list}" var="object" varStatus="s">
                                        <tr>
                                            <td class="wd-md-1 text-C" ${w5}>
                                                <div title="${object.number}" style="width:50px;">
                                                        ${object.number}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w5}>
                                                <select class="form-control" id="selectStatus">
                                                    <option value="-1"
                                                            <c:if test="${-1 eq object.status}">selected</c:if> >失效</option>
                                                    <option value="0"
                                                            <c:if test="${0 eq object.status}">selected</c:if> >初始状态</option>
                                                    <option value="1"
                                                            <c:if test="${1 eq object.status}">selected</c:if> >预占</option>
                                                    <option value="2"
                                                            <c:if test="${2 eq object.status}">selected</c:if> >卖出</option>
                                                </select>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w10}>
                                                <div title="${object.areaName}" style="width:60px;">
                                                        ${object.areaName}
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w10}>
                                                <div title="${object.createTime}" style="width:100px;">
                                                    <fmt:formatDate value='${object.createTime}' pattern='${df}'/>
                                                </div>
                                            </td>

                                            <td class="wd-md-2 text-C" ${w10}>

                                                <a href="${ctx}/core/toUpdateNumberPage?id=${object.id}" role="button">更新</a>
                                                &nbsp;| &nbsp;
                                                <a class="updateClass" href="#" data-id="${object.id}" role="button">状态更新</a>
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
                                        <span class="pull-right" style="padding: 26px 14px;font-size: 16px;">总共 ${body.page.totalRows} 条</span>
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


        $('#btn_uploader').click(function () {
            $("#fileupload_input").click();
        });

        $("#fileupload_input").fileupload({
            url: "${ctx}/importNumber",//文件上传地址，当然也可以直接写在input的data-url属性内
            formData: {param1: "p1", param2: "p2", param3: "p3", param4: "p4", param5: "p5", param6: "p6"},//如果需要额外添加参数可以在这里添加
            done: function (e, result) {
                //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api
                //注意result要和jquery的ajax的data参数区分，这个对象包含了整个请求信息
                //返回的数据在result.result中，假设我们服务器返回了一个json对象
                //debugger;
                if (0 == result.result.resultCode) {
                    alert(result.result.resultMsg);
                } else {
                    alert(result.result.resultMsg);
                    $("#search").click();
                }
                //console.log(JSON.stringify(result.result));
            }
        });


        $(".updateClass").click(function () {

            if (confirm("确定更新吗?")) {


                $.get(
                    '${ctx}/core/updateNumberStatus?id={object_id}&status={object_status}'.render(
                    {'object_id':$(this).attr("data-id"), "object_status":$("#selectStatus").val()}),
                    {},
                    function (data) {
                        alert(data.msg);

                        if (data.code != 0) {
                            window.location.href = '${ctx}/core/listNumber';
                        }

                    },
                    "json"
                );
            }

        });



    });









</script>
</html>
