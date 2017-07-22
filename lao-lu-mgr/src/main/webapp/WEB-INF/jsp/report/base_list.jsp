<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
    <%@ include file="/taglib.jsp" %>
</head>
<body>
<div flex="" layout="column">
    <div ui-butterbar="" class="butterbar hide"><span class="bar"></span></div>
    <a href="" class="off-screen-toggle hide" ui-toggle-class="off-screen" data-target=".md-aside"></a>
    <!-- uiView:  -->
    <div class="md-content ng-scope" ui-view=""><!-- uiView:  -->
        <div ui-view="" class="fade-in-down ">
            <div class="wrapper-md ">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel wrapper panel-default">
                            <div class="panel-body">
                                <form id="frm" class="bs-example form-horizontal" action="${ctx}/mgr/report/baselist" method="post">
                                    <input type="hidden" id="page" name="page" value="1">
                                    <input type="hidden" name="pageName" value="${param.pageName}" />
                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label class="col-xs-4 control-label wrapper-xs">开始时间</label>

                                            <div class="col-xs-8">
                                            		<div class="input-group">
                                            			<input type="text" class="form-control col-xs-10" name="beginDate" id="beginDate" value="${param['beginDate']}">
                                            			<span class="input-group-btn">
	                                                		<button class="btn btn-default" type="button" onclick="WdatePicker({el:'beginDate', dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="height: 34px;">
	                                                			<i class="glyphicon glyphicon-calendar"></i>
	                                                		</button>
                                            			</span>
                                            		</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label class="col-xs-4 control-label wrapper-xs">结束时间</label>
                                            <div class="col-xs-8">
                                            		<div class="input-group">
                                            			<input type="text" class="form-control col-xs-10" name="endDate" id="endDate" value="${param['endDate']}">
                                            			<span class="input-group-btn">
	                                                		<button class="btn btn-default" type="button" onclick="WdatePicker({el:'endDate', dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="height: 34px;">
	                                                			<i class="glyphicon glyphicon-calendar"></i>
	                                                		</button>
                                            			</span>
                                            		</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label class="col-xs-4 control-label wrapper-xs">名称</label>

                                            <div class="col-xs-8">
                                                <select id="unit" name="unit" class="form-control">
                                                    <option value="1" <c:if test="${1 eq param.unit}">selected</c:if> >按小时</option>
                                                    <option value="2" <c:if test="${2 eq param.unit}">selected</c:if>>按天</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <!--最后一排表单div记得添加'm-b-n-xxs'样式，清除间距-->
                                        <div class="form-group m-b-n-xxs">
                                            <label class="col-xs-4 control-label wrapper-xs">渠道</label>

                                            <div class="col-xs-8">
                                                <select name="channel" class="form-control">
                                                    <option value="">所有</option>
                                                    <c:forEach var="sysChannel" items="${sysChannels}">
                                                        <option value="${sysChannel.channelCode}" <c:if test="${sysChannel.channelCode eq param.channel}">selected</c:if> >${sysChannel.channelName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <!--最后一排表单div记得添加'm-b-n-xxs'样式，清除间距-->
                                        <div class="form-group m-b-n-xxs">
                                            <label class="col-xs-4 control-label wrapper-xs"></label>

                                            <div class="col-xs-8">
                                                <button type="search" class="btn btn-primary padder-md">搜索</button>
                                                <button type="search" class="btn btn-default padder-md">重置</button>
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
                                <c:choose>
                                    <c:when test="${'pv' eq param.pageName}">PV 总数 ${empty listObjectsTotal ? 0 : listObjectsTotal}</c:when>
                                    <c:when test="${'uv' eq param.pageName}">UV 总数 ${empty listObjectsTotal ? 0 : listObjectsTotal}</c:when>
                                </c:choose>
                            </div>
                            <%--<div class="row wrapper">
                                <div class="col-sm-5 m-b-xs">
                                    <select class="input-sm form-control w-sm inline v-middle">
                                        <option value="0">批量操作</option>
                                        <option value="1">批量编辑</option>
                                        <option value="2">批量删除</option>
                                    </select>
                                    <button class="btn btn-sm btn-default">应用</button>
                                </div>
                                <div class="col-sm-4">
                                </div>
                                <div class="col-sm-3">
                                    <div class="input-group">
                                        <input type="text" class="input-sm form-control" placeholder="关键词">
							<span class="input-group-btn">
            <button class="btn btn-sm btn-default" type="button">搜索</button>
          </span>
                                    </div>
                                </div>
                            </div>--%>
                            <div class="table-responsive">
                                <table class="table table-striped b-t b-light text-base">
                                    <thead>
                                    <tr>
                                        <%--<th style="width:20px;">
                                            <label class="i-checks m-b-none">
                                                <input type="checkbox"><i></i>
                                            </label>
                                        </th>--%>
                                        <th>
                                            <c:choose>
                                                <c:when test="${'pv' eq param.pageName}">PV</c:when>
                                                <c:when test="${'uv' eq param.pageName}">UV</c:when>
                                                <c:when test="${'buy' eq param.pageName}">转化率</c:when>
                                                <c:when test="${'out' eq param.pageName}">跳出率</c:when>
                                            </c:choose>
                                        </th>
                                        <th>时间</th>
                                        <th>渠道</th>
                                        <%--<th style="width:80px;">操作</th>--%>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach var="object" items="${listObjects}">
                                        <tr>
                                            <%--<td>
                                                <label class="i-checks m-b-none">
                                                    <input type="checkbox" name="post[]"><i></i></label>
                                            </td>--%>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${'pv' eq param.pageName}">${object.pv}</c:when>
                                                    <c:when test="${'uv' eq param.pageName}">${object.uv}</c:when>
                                                    <c:when test="${'buy' eq param.pageName}">${object.buy}%</c:when>
                                                    <c:when test="${'out' eq param.pageName}">${object.out}%</c:when>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${empty param.unit or 1 eq param.unit}">
                                                        <fmt:formatDate value="${object.createDate}" pattern="${df}" />
                                                    </c:when>
                                                    <c:when test="${2 eq param.unit}">
                                                        <fmt:formatDate value="${object.createDate}" pattern="yyyy-MM-dd" />
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${empty object.channel}">
                                                        所有渠道
                                                    </c:when>
                                                    <c:otherwise>${sysChannelMap[object.channel]}</c:otherwise>
                                                </c:choose>

                                            </td>
                                            <%--<td>
                                                <a href="" class="active" ui-toggle-class=""><i class="fa fa-check text-success text-active"></i><i class="fa fa-times text-danger text"></i></a>
                                            </td>--%>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <footer class="panel-footer">
                                <div class="row">
                                    <%--<div class="col-sm-4 hidden-xs">
                                        <select class="input-sm form-control w-sm inline v-middle">
                                            <option value="0">批量操作</option>
                                            <option value="1">批量编辑</option>
                                            <option value="2">批量删除</option>
                                        </select>
                                        <button class="btn btn-sm btn-default">应用</button>
                                    </div>--%>
                                    <%--<div class="col-sm-4 text-center">
                                        <small class="text-muted inline m-t-sm m-b-sm">展示 20-28 条， 共 50 条</small>
                                    </div>
                                    <div class="col-sm-4 text-right text-center-xs">
                                        <ul class="pagination pagination-sm m-t-none m-b-none">
                                            <li><a href=""><i class="fa fa-chevron-left"></i></a></li>
                                            <li><a href="">1</a></li>
                                            <li><a href="">2</a></li>
                                            <li><a href="">3</a></li>
                                            <li><a href="">4</a></li>
                                            <li><a href="">5</a></li>
                                            <li><a href=""><i class="fa fa-chevron-right"></i></a></li>
                                        </ul>
                                    </div>--%>
                                    <div>
                                        <div style="float:right;width:100px;margin: 20px 0;padding-left: 10px;">
                                            <div class="input-group">
                                                <input type="number" class="form-control" id="toPageText" placeholder="页" />
                  <span class="input-group-btn">
                        <button id="toPageBtn" class="btn btn-default" type="button" style="width: 40px;padding:6px;">Go!</button>
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
